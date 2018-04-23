package gob.osinergmin.sibad.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author jasparrin
 */
public class ControllerUtil {

    public static String retrieveUserName(Authentication authentication) {
	if ( isInstanceOfUserDetails(authentication) ) {
	    return ((UserDetails) authentication.getPrincipal()).getUsername();
	} else {
	    return authentication.getPrincipal().toString();
	}
    }

    public static String retrievePassword(Authentication authentication) {
	if ( isInstanceOfUserDetails(authentication) ) {
	    return ((UserDetails) authentication.getPrincipal()).getPassword();
	} else {
	    if ( authentication.getCredentials() == null ) {
		return null;
	    }
	    return authentication.getCredentials().toString();
	}
    }

    private static boolean isInstanceOfUserDetails(Authentication authentication) {
	return authentication.getPrincipal() instanceof UserDetails;
    }

    public static <T> T obtainSessionAttribute(HttpSession sesion,
	    String attribute, Class<T> aClass) {
		try {
		    return (T) sesion.getAttribute(attribute);
		} catch ( Exception e ) {
		    return null;
		}
    }

    public static String obtainSigedUrlBase(HttpServletRequest req) {
	return req.getRequestURL().toString()
		.replace(req.getRequestURI(), "/seguridad/");
    }
}
