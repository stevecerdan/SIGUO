package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.service.AlcanceAcreditacionService;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.PersonaJuridicaService;
import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
//import gob.osinergmin.sibad.service.MaestroColumnaServiceNeg;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.ConstantesWeb;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
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

@Controller
@RequestMapping("/mantenimientoEmpresasAcreditadas")
public class BandejaEmpresasAcreditadasController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BandejaEmpresasAcreditadasController.class);
	
	@Inject
	private EmpresaAcreditadaService empAcredService;
	@Inject
	private PersonaJuridicaService personajuridicaService;  
	@Inject
	private AlcanceAcreditacionService alcanceacreditacionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model, HttpSession session, HttpServletRequest request){
		
		String j_username = "JHIDALGOM";
        session.setAttribute("j_username", j_username);
        //session.setAttribute("xxp", "IN/MO/EL/CO");
        //session.setAttribute("listarParametros", "true");
        //session.setAttribute("modificarParametros", "true");
        //session.setAttribute("subirArchivos", "true");
        //----------------------------------------------------
        //----------------------------------------------------

        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_BANDEJA_EMPRESAS_ACREDITADAS;
	}
	
	@RequestMapping(value="/listarEmpresasAcreditadas",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarEmpresaAcreditada(EmpresaAcreditadaFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarEmpresaAcreditada");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            //List<PersonaJuridicaDTO> listado=personajuridicaService.listarPersonaJuridica(filtro);
            List<EmpresaAcreditadaDTO> listado = empAcredService.listarEmpAcred(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            //List<PersonaJuridicaDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            List<EmpresaAcreditadaDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value = "/abrirNuevaEmpresaAcreditada", method = RequestMethod.GET)
    public String abrirFrmNuevoEmpresaAcreditada (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_NUEVA_EMPRESA_ACREDITADA;
    }
	
	@RequestMapping(value="/listarProcesosAcreditacion",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarProcesosAcreditacion(AlcanceAcreditacionFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarProcesosAcreditacion");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<AlcanceAcreditacionDTO> listado=alcanceacreditacionService.listarAlcanceAcreditacion(filtro);
            //List<EmpAcredDTO> listado = empAcredService.listarEmpAcred(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<AlcanceAcreditacionDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            //List<EmpAcredDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/cargarDatos",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarDatos(PersonaJuridicaFilter filtro){
        LOG.info("procesando cargarDatos");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<PersonaJuridicaDTO> listado;
            listado= personajuridicaService.listarPersonaJuridica(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
}




