package gob.osinergmin.sibad.common.security;


import gob.osinergmin.sibad.common.util.ControllerUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.util.StringUtils;

/**
 * 
 * @author cflorian
 * @version 1.0
 * @see
 */
public abstract class AbstractTokenBasedRememberMeServices extends
	AbstractRememberMeServices {

    private static final Logger log = LoggerFactory
	    .getLogger(AbstractTokenBasedRememberMeServices.class);

    public Authentication customAutoLogin(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	log.debug("customAutoLogin");
	Authentication auth = doCustomAutoLogin(request, response);
	log.debug("default customAutoLogin return " + auth);
	return auth;
    }

    protected abstract Authentication doCustomAutoLogin(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception;

    @Override
    protected UserDetails processAutoLoginCookie(String[] cookieTokens,
	    HttpServletRequest request, HttpServletResponse response) {

	if ( cookieTokens.length != 3 ) {
	    throw new InvalidCookieException("Cookie token did not contain 3"
		    + " tokens, but contained '" + Arrays.asList(cookieTokens)
		    + "'");
	}

	long tokenExpiryTime;

	try {
	    tokenExpiryTime = new Long(cookieTokens[1]).longValue();
	} catch ( NumberFormatException nfe ) {
	    throw new InvalidCookieException(
		    "Cookie token[1] did not contain a valid number (contained '"
			    + cookieTokens[1] + "')");
	}

	if ( isTokenExpired(tokenExpiryTime) ) {
	    throw new InvalidCookieException(
		    "Cookie token[1] has expired (expired on '"
			    + new Date(tokenExpiryTime)
			    + "'; current time is '" + new Date() + "')");
	}

	// Check the user exists.
	// Defer lookup until after expiry time checked, to possibly avoid
	// expensive database call.

	UserDetails userDetails = getUserDetailsService().loadUserByUsername(
		cookieTokens[0]);

	// Check signature of token matches remaining details.
	// Must do this after user lookup, as we need the DAO-derived password.
	// If efficiency was a major issue, just add in a UserCache
	// implementation,
	// but recall that this method is usually only called once per
	// HttpSession - if the token is valid,
	// it will cause SecurityContextHolder population, whilst if invalid,
	// will cause the cookie to be cancelled.
	String expectedTokenSignature = makeTokenSignature(tokenExpiryTime,
		userDetails.getUsername(), userDetails.getPassword());

	if ( !expectedTokenSignature.equals(cookieTokens[2]) ) {
	    throw new InvalidCookieException(
		    "Cookie token[2] contained signature '" + cookieTokens[2]
			    + "' but expected '" + expectedTokenSignature + "'");
	}

	return userDetails;
    }

    /**
     * Verifica el password: su tiempo de vida.
     */
    @Override
    public void onLoginSuccess(HttpServletRequest request,
	    HttpServletResponse response,
	    Authentication successfulAuthentication) {
	log.debug("onLoginSuccess");
	String username = ControllerUtil
		.retrieveUserName(successfulAuthentication);
	String password = ControllerUtil
		.retrievePassword(successfulAuthentication);

	// Si no esta disponible buscar un usuario y password, salir del metodo.
	if ( !StringUtils.hasLength(username)
		|| !StringUtils.hasLength(password) ) {
	    return;
	}

	int tokenLifetime = calculateLoginLifetime(request,
		successfulAuthentication);
	long expiryTime = System.currentTimeMillis();

	// SEC-949
	expiryTime += 1000L * (tokenLifetime < 0 ? TWO_WEEKS_S : tokenLifetime);

	String signatureValue = makeTokenSignature(expiryTime, username,
		password);

	setCookie(new String[] { username, Long.toString(expiryTime),
		signatureValue }, tokenLifetime, request, response);

	if ( logger.isDebugEnabled() ) {
	    logger.debug("Added remember-me cookie for user '" + username
		    + "', expiry: '" + new Date(expiryTime) + "'");
	}
    }

    /**
     * Calculates the validity period in seconds for a newly generated
     * remember-me login. After this period (from the current time) the
     * remember-me login will be considered expired. This method allows
     * customization based on request parameters supplied with the login or
     * information in the <tt>Authentication</tt> object. The default value is
     * just the token validity period property, <tt>tokenValiditySeconds</tt>.
     * <p>
     * The returned value will be used to work out the expiry time of the token
     * and will also be used to set the <tt>maxAge</tt> property of the cookie.
     * 
     * See SEC-485.
     * 
     * @param request
     *            the request passed to onLoginSuccess
     * @param authentication
     *            the successful authentication object.
     * @return the lifetime in seconds.
     */
    protected int calculateLoginLifetime(HttpServletRequest request,
	    Authentication authentication) {
	return getTokenValiditySeconds();
    }

    /**
     * Calculates the digital signature to be put in the cookie. Default value
     * is MD5 ("username:tokenExpiryTime:password:key")
     */
    protected String makeTokenSignature(long tokenExpiryTime, String username,
	    String password) {
	String data = username + ":" + tokenExpiryTime + ":" + password + ":"
		+ getKey();
	MessageDigest digest;
	try {
	    digest = MessageDigest.getInstance("MD5");
	} catch ( NoSuchAlgorithmException e ) {
	    throw new IllegalStateException("No MD5 algorithm available!");
	}

	return new String(Hex.encode(digest.digest(data.getBytes())));
    }

    protected boolean isTokenExpired(long tokenExpiryTime) {
	return tokenExpiryTime < System.currentTimeMillis();
    }

}
