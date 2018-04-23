package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.util.ConstantesWeb;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/AtachToken")
/**
 * Clase controladora que permite atachar el token a la URL
 * @author jasparrin
 * @version 1.0
 * @see
 */
public class AtachTokenController {
	
	private static final Logger LOG = LoggerFactory
		    .getLogger(AtachTokenController.class);
	
	
	/**
     * Metodo atachTokenToURL, permite concatenar el token a la URL
     * 
     * @param segPagina
     * @param request
     * @param sesion
     * @return
     */
    @RequestMapping(value = "/atachTokenToURL", method = RequestMethod.POST)
    public @ResponseBody
	Map<String, Object> atachTokenToURL(
			HttpServletRequest request,
			HttpSession sesion,
			@RequestParam(value = "href", required = true) String href) {
    	
    	LOG.info("procesando POST para RequestMapping /atachTokenToURL");    	
    	LOG.info("Parameter: href = " + href);
    	
    	Map<String, Object> salida = new HashMap<String, Object>();
    	try {

    		String token = (String)sesion.getAttribute("TOKEN");
    		String tokenParam = ConstantesWeb.CSRF_TOKEN_NAME + "=" + token;    		
    		salida.put("href", href.indexOf('?') != -1 ? href + "&" + tokenParam : href + "?" + tokenParam);
    		salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
    		
    	}catch(Exception e){
    		LOG.error("Error en el atachTokenToURL" + e);
    	    salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
    	}
    	
    	return salida;
    }
    
}
