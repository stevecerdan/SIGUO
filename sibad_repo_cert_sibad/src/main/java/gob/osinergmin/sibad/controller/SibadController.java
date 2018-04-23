/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.controller;

import gob.osinergmin.pvo.security.EncryptParameters;
import gob.osinergmin.pvo.security.util.Constants;
import gob.osinergmin.sibad.domain.dto.UnidadOperativaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.SupervisionService;
import gob.osinergmin.sibad.service.UtilidadesService;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.ConstantesWeb;
import gob.osinergmin.sibad.util.SibadUtil;
import gob.osinergmin.sibad.util.StringUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.EncoderConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DSR
 */
@Controller
@SuppressWarnings("rawtypes")
public class SibadController{
    
    private static final Logger LOG = LoggerFactory.getLogger(SibadController.class);
                 
    @Autowired
    UtilidadesService utilidadesService;
    @Autowired
    SupervisionService supervisionService;
        
	private Map map = new HashMap();    
    private String path = "";
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/start", method = RequestMethod.POST)    
    public String start (Model model,HttpServletRequest request, HttpSession session) throws ServletException, IOException {
       LOG.info("-- ValidacionUserController - start --");
                
        String p_user = "";
		String p_pagina = "";
		
		try{	
			String codApp = ESAPI.encoder().decodeForHTML(request.getParameter("taotlus"));
			if (codApp != null){
	        	if (StringUtil.isNumeric(codApp)){            		            	    			
	    			String encript = utilidadesService.encryptedParameters(codApp);
	            	if (encript.equals("S")){
	            		String key=utilidadesService.getKey();
	            		EncryptParameters encrypt = new EncryptParameters(key);
	                    p_user = encrypt.decryptLevel02((String)request.getParameter("kasutaja"));
	                    p_pagina = encrypt.decryptLevel02((String)request.getParameter("lehele"));	                    
	            	}else{
	            		p_user = ESAPI.encoder().encodeForHTML((String)request.getParameter("p_usuario"));
	            		p_pagina = ESAPI.encoder().encodeForHTML((String)request.getParameter("p_pagina"));
	            	}
	        	}
	        	if (p_user != null && !p_user.equals("")) {
	        		String login = (String) session.getAttribute("p_usuario");
	        		if (StringUtils.isEmpty(login)) {
	        			session.setAttribute("p_usuario", p_user);
						session.setAttribute("j_pagina", p_pagina);
	        		}else{
	        			if (!p_user.equals(login)){
	        				session.removeAttribute(Constantes.SESION_USUARIO);
	        				session.setAttribute("p_usuario", p_user);
	    					session.setAttribute("j_pagina", p_pagina);
	        			}
	        		}
				}else{
					return ConstantesWeb.Navegacion.PAGE_ERROR_403;
				}
	        	String[] permisos = request.getParameterValues("p_permisos");
	        	session.setAttribute(Constants.ACCESO_PERMISO,permisos);
	        }
			
			String login = (String) session.getAttribute("p_usuario");
        	if (StringUtils.isNotEmpty(login)) {
        		UsuarioDTO usuario = (UsuarioDTO)session.getAttribute(Constantes.SESION_USUARIO);
        		if(usuario == null){		
					try{
						usuario = utilidadesService.getUsuario(login);
						if (usuario!=null && usuario.getLogin()!=null && !usuario.getLogin().equals("")){
							String tipousuario = usuario.getTipo();
							if (!tipousuario.equals("A") && !tipousuario.equals("X")){
								UnidadOperativaDTO unidadOperativa =  utilidadesService.obtenerUnidadOperativa(login);
								if(unidadOperativa != null){
									session.setAttribute(Constantes.SESION_UNIDAD_OPERATIVA, unidadOperativa);
									UnidadSupervisadaDTO unidadSupervisada = supervisionService.obtenerUnidadSupervisadaByCodigoOsinergmin(unidadOperativa.getCodigoOsinergmin());
									if(unidadSupervisada != null){
										unidadSupervisada.setCodigosOsinergminPermitidos(utilidadesService.obtenerCodigosOsinergminPermitidosUsuario(login));
										session.setAttribute(Constantes.SESION_UNIDAD_SUPERVISADA, unidadSupervisada);
									}
								}else{
									return ConstantesWeb.Navegacion.PAGE_ERROR_ACCESS;
								}								
							}
						}else{
							return ConstantesWeb.Navegacion.PAGE_ERROR_ACCESS;
						}
					}catch(Exception e){
						LOG.error(e.getMessage());
						return ConstantesWeb.Navegacion.PAGE_ERROR;
					}
					usuario.setTerminal(SibadUtil.obtenerTerminal());
					session.setAttribute(Constantes.SESION_USUARIO, usuario);
					session.setAttribute("TOKEN", resetCSRFToken());
				}
        		model.addAttribute("usuario", usuario.getNombre());
				model.addAttribute("unidad", (UnidadOperativaDTO)session.getAttribute(Constantes.SESION_UNIDAD_OPERATIVA));
        	}else{
        		return ConstantesWeb.Navegacion.PAGE_ERROR_EXPIRED;
        	}
		}catch(Exception e){
			e.printStackTrace();
			return ConstantesWeb.Navegacion.PAGE_ERROR;
		}
		afterStart();
        model.addAllAttributes(getMap());
        return getPath();
    }

    public String resetCSRFToken() {    	
    	return ESAPI.randomizer().getRandomString(8, EncoderConstants.CHAR_ALPHANUMERICS);
    }
    
    protected void afterStart(){}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Map getMap() {
		return map;
	}
}
