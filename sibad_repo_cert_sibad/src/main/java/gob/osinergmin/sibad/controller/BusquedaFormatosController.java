/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.domain.dto.BandejaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadOperativaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.BandejaService;
import gob.osinergmin.sibad.service.UtilidadesService;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.ConstantesWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DSR
 */
@Controller
@RequestMapping("/busquedaFormatos")
public class BusquedaFormatosController extends SibadController{
    
    private static final Logger LOG = LoggerFactory.getLogger(BusquedaFormatosController.class);
   
    @Autowired
    BandejaService bandejaService;
    @Autowired
    UtilidadesService utilidadesSFHService;    
         
    /**
     * 
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String inicio (Model model,HttpServletRequest request, HttpSession session) {
        LOG.info("-- BusquedaFormatosController - inicio --");
        String path = "";
        UsuarioDTO usuarioSesion = (UsuarioDTO)session.getAttribute(Constantes.SESION_USUARIO);
        UnidadOperativaDTO unidadOperativa = (UnidadOperativaDTO)session.getAttribute(Constantes.SESION_UNIDAD_OPERATIVA);
        if((usuarioSesion!=null) && !usuarioSesion.getLogin().equals("")){
        	model.addAttribute("listaEstado", bandejaService.listaEstados(Constantes.TABLA_GENERAL_ESTADOS));
    		model.addAttribute("unidad",unidadOperativa);
    		model.addAttribute("usuario", usuarioSesion.getNombre());
	        model.addAttribute("fecha", ConstantesWeb.getFECHA());
	        session.setAttribute("TOKEN", resetCSRFToken());
	        path = ConstantesWeb.Navegacion.PAGE_BUSQUEDA_FORMATOS;
    	}else{
    		LOG.info("La sesión ha expirado");
    		path = "error";
    	}	        
        return path;
        
    }
            
    ///////////////////////////////////GRID LISTADO DE FORMATOS REGISTRADOS///////////////////////////////////////////////////////  
    @RequestMapping(value = "/formatoBandeja", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> formatoBandeja(Long varLista,BandejaDTO bandeja,int rows, int page, HttpSession session ) {//Long idTipoFormulario,Long idTipoFormato,Long estadoRegistro,String numeroFormulario, String codigoOsinergmin,
		
		Map<String, Object> listaResultado = new HashMap<String, Object>();
		List<BandejaDTO> listaBandeja = new ArrayList<BandejaDTO>();
	
        try{
            if(varLista==1){
            	UnidadOperativaDTO unidadOperativa = (UnidadOperativaDTO) session.getAttribute(Constantes.SESION_UNIDAD_OPERATIVA);
            	bandeja.setIdUnidadOperativa(unidadOperativa.getIdUnidad());
            	listaBandeja = bandejaService.listaSolicitud(bandeja);
            	
            	
		        Long contador = new Long(listaBandeja.size());
				int indiceInicial = (page - 1) * rows;
				int indiceFinal = indiceInicial + rows;
				List<BandejaDTO> listaObligacionesPaginada = listaBandeja
						.subList(
								indiceInicial,
								indiceFinal > listaBandeja.size() ? listaBandeja
										.size() : indiceFinal);
				Long numeroFilas = (contador / rows);
				if ((contador % rows) > 0) {
					numeroFilas = numeroFilas + 1L;
				}
	        	listaResultado.put("total", numeroFilas);
	        	listaResultado.put("pagina", page);
	        	listaResultado.put("registros",contador );
	        	listaResultado.put("filas", listaObligacionesPaginada);
            }
            
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    
    @RequestMapping(value = "/abrirFormatoReporte", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> abrirFormatoReporte(Long idFormulario, Model model, HttpSession sesion) {
    	LOG.info("abrirFormatoReporte: Parameter: idFormulario: "+idFormulario );
    	
    	Map<String, Object> retorno = new HashMap<String, Object>();
    	
		String ruta = Constantes.CONSTANTE_CODIGO_RUTA_FORMATO;	
    	retorno.put("identificador", idFormulario);
		retorno.put("ruta", ruta);
    	LOG.info("ruta: "+ruta);
    	return retorno;
    	
    }
    
    @SuppressWarnings("unchecked")
	protected void afterStart(){
    	getMap().put("listaEstado", bandejaService.listaEstados(Constantes.TABLA_GENERAL_ESTADOS));		    			    			    					
    	getMap().put("fecha", ConstantesWeb.getFECHA());
        setPath(ConstantesWeb.Navegacion.PAGE_BUSQUEDA_FORMATOS);
    }
 
}
