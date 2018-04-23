package gob.osinergmin.sibad.common.security;


import gob.osinergmin.sibad.util.ConstantesWeb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.reference.DefaultEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Esta clase permite verificar que el token que ha sido enviado por la URL
 * es la misma que esta en sesión.
 * 
 * @author jasparrin
 * @version 1.0
 * @see
 */
public class VerificarToken {
	
	private static final Logger LOG = LoggerFactory
		    .getLogger(VerificarToken.class);
	
	/**
	 * Metodo que verifica que ambos tokens: sesion y request sean iguales
	 * @param sessionToken
	 * @param requestToken
	 * @return
	 * @throws IntrusionException
	 */
	public static boolean verifyCSRFToken(HttpSession sesion, HttpServletRequest request) {
		LOG.info("method verifyCSRFToken : VerificarToken(Clase)"); 
		
		String sessionToken = (String)sesion.getAttribute("TOKEN");
		
		String requestToken = "";
		try {
			requestToken = (String)request.getParameter(ConstantesWeb.CSRF_TOKEN_NAME);
		} catch (Exception e) {
			LOG.error("Se produjo un error al obtener el token del request, error controlado"); 
			requestToken = "";
		}
		
		if ( !sessionToken.equals(requestToken) ) {
			//"Authentication failed", "Possibly forged HTTP request without proper CSRF token detected"
			return false;

		}
		else{			
			sesion.setAttribute(
					"TOKEN",
					ESAPI.randomizer().getRandomString(8,
							DefaultEncoder.CHAR_ALPHANUMERICS));
			return true;
		}
	}
	

}
