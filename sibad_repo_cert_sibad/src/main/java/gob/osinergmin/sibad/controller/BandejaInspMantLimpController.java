package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.service.AlcanceAcreditacionService;
import gob.osinergmin.sibad.service.AlmacenaCompartiProdService;
import gob.osinergmin.sibad.service.AlmacenamientoService;
import gob.osinergmin.sibad.service.CompartAlmacenamientoService;
import gob.osinergmin.sibad.service.CompartimientoService;
import gob.osinergmin.sibad.service.DocumentoAdjuntoService;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.MaestroColumnaTipoService;
import gob.osinergmin.sibad.service.PersonaJuridicaService;
import gob.osinergmin.sibad.service.PersonaNaturalVService;
import gob.osinergmin.sibad.service.ProductoxCompartimientoService;
import gob.osinergmin.sibad.service.ProgramacionService;
import gob.osinergmin.sibad.service.ResultadoDocumentoService;
import gob.osinergmin.sibad.service.ResultadoPersonaNaturalService;
import gob.osinergmin.sibad.service.ResultadoRevisionService;
import gob.osinergmin.sibad.service.SedeAcreditacionService;
import gob.osinergmin.sibad.service.SedePersonalAutorizadoService;
import gob.osinergmin.sibad.service.TrazAlcanceAcredService;
import gob.osinergmin.sibad.service.TrazProgramacionService;
import gob.osinergmin.sibad.service.UbigeoDPDService;
import gob.osinergmin.sibad.service.UnidadSupervisadaService;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;
import gob.osinergmin.sibad.domain.dto.ProductoxCompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.ProgramacionVDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoRevisionDTO;
import gob.osinergmin.sibad.filter.PersonaNaturalVFilter;
import gob.osinergmin.sibad.filter.ProductoxCompartimientoFilter;
import gob.osinergmin.sibad.filter.ProgramacionFilter;
import gob.osinergmin.sibad.filter.ResultadoDocumentoFilter;
import gob.osinergmin.sibad.filter.ResultadoPersonaNaturalFilter;
import gob.osinergmin.sibad.filter.ResultadoRevisionFilter;
import gob.osinergmin.sibad.domain.dto.AlmacenaCompartiProdDTO;
import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;
import gob.osinergmin.sibad.domain.dto.CompartAlmacenamientoDTO;
import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.TrazProgramacionDTO;
import gob.osinergmin.sibad.filter.AlmacenaCompartiProdFilter;
import gob.osinergmin.sibad.filter.AlmacenamientoFilter;
import gob.osinergmin.sibad.filter.CompartAlmacenamientoFilter;
import gob.osinergmin.sibad.filter.CompartimientoFilter;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.filter.TrazProgramacionFilter;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.util.ConstantesWeb;

import java.net.Inet4Address;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/InspMantLimp")
public class BandejaInspMantLimpController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BandejaInspMantLimpController.class);
	
	@Inject
	private UnidadSupervisadaService unidadSupervisadaService;
	
	@Inject
	private AlmacenamientoService almacenamientoService;
	
	@Inject
	private CompartimientoService compartimientoService;
	
	@Inject
	private DocumentoAdjuntoService documentoAdjuntoService;
	
	@Inject
	private ProgramacionService programacionService;
	
	@Inject
	private TrazProgramacionService trazProgramacionService;
	
	@Inject
	private MaestroColumnaTipoService maestroColumnaTipoService;
	
	@Inject
	private EmpresaAcreditadaService empAcredService;
	
	@Inject
	private SedePersonalAutorizadoService SedepersonalautorizadoService;
	
	@Inject
	private PersonaJuridicaService personajuridicaService;  
	
	@Inject
	private UbigeoDPDService ubigeoDPDService;
	
	@Inject
	private PersonaNaturalVService personanaturalService;
	
	@Inject
	private SedeAcreditacionService sedeacreditacionService;
	
	@Inject
	private AlcanceAcreditacionService alcanceAcreditacionService;
	
	@Inject
	private TrazAlcanceAcredService trazAlcanceAcredService;
	
	@Inject
	private ResultadoPersonaNaturalService resultadoPersonalService;
	
	@Inject
	private ProductoxCompartimientoService productoCompartimientoService; 
	
	@Inject
	private ResultadoDocumentoService resultadoDocService;
	
	@Inject
	private ResultadoRevisionService resultadoRevService;
    
	@Inject
	private CompartAlmacenamientoService compAlmService;
	
	@Inject
	private AlmacenaCompartiProdService almacenaCompartiProdService;

	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model, HttpSession session, HttpServletRequest request){
		
		String j_username = "JHIDALGOM";
        session.setAttribute("j_username", j_username);
        //----------------------------------------------------
        //----------------------------------------------------

        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_BANDEJA_TANQUE_CL;
	}
	
	// ANDERSON 
	
	@RequestMapping(value = "/abrirFrmIndivualMasiva", method = RequestMethod.GET)
    public String abrirFrmIndivualMasiva (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_NUEVA_PROGRAMACION_INSPECCION_MANTENIMIENTO_LIMPIEZA;
    }
	
	@RequestMapping(value = "/abrirFrmCancelar", method = RequestMethod.GET)
    public String abrirFrmCancelar (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_CANCELAR_PROGRAMACION;
    }
	
	 
	@RequestMapping(value = "/abrirFrmReprogramar", method = RequestMethod.GET)
    public String abrirFrmReprogramar (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_REPROGRAMAR;
    }
	
	@RequestMapping(value = "/abrirFrmDocumentoAdjunto", method = RequestMethod.GET)
    public String abrirFrmDocumentoAdjunto (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_PRUEBA;
    }
	
	
	// FIN CODIGO
	@RequestMapping(value="/verificarProgramacionesVencidas",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> verificarProgramacionesVencidas(ProgramacionFilter filtro){
        
		LOG.info("Inicia...");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ProgramacionVDTO> listado = programacionService.ProgramacionesVencidas(filtro);
            retorno.put("filas", listado);
    
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;

    }	
	
	@RequestMapping(value="/listarProgramacion",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarProgramacion(ProgramacionFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Iniciando.....");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ProgramacionVDTO> listado = programacionService.ListarProgramacion(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<ProgramacionVDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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
	
	@RequestMapping(value="/listarCompartimiento",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarCompartimiento(AlmacenaCompartiProdFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Iniciando.....");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            //List<CompartimientoDTO> listado = compartimientoService.ListarCompartimiento(filtro);
            List<AlmacenaCompartiProdDTO> listado = almacenaCompartiProdService.listarAlmacenaCompartiProd(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<AlmacenaCompartiProdDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("rows", rows);
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/listarCompartimientoPorId",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarCompartimientoPorId(AlmacenaCompartiProdFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Iniciando.....");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            //List<CompartimientoDTO> listado = compartimientoService.ListarCompartimientoPorId(filtro);
            List<AlmacenaCompartiProdDTO> listado = almacenaCompartiProdService.listarAlmacenaCompartiProd(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<AlmacenaCompartiProdDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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

	@RequestMapping(value="/retornarUltimoNumProgramacion",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> retornarUltimoNumProgramacion(CompartimientoFilter filtro){
        
		LOG.info("Inicia...");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<CompartimientoDTO> listado = compartimientoService.ListarCompartimientoV(filtro);
            retorno.put("filas", listado);
    
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;

    }	
		
	@RequestMapping(value="/cargarComboTipo",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarComboTipo(MaestroColumnaTipoFilter filtro){
        LOG.info("procesando cargarComboTipo");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<MaestroColumnaTipoDTO> listado;
            listado= maestroColumnaTipoService.listarMaestroColumnaTipo(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/BuscarCompartimientoAlm",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> BuscarCompartimientoAlm(CompartAlmacenamientoFilter filtro){
        LOG.info("procesando...");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<CompartAlmacenamientoDTO> listado;
            listado= compAlmService.Listar(filtro);
            int tamanio = listado.size();
            retorno.put("tamanio", tamanio);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/listarUnidadAlmacenamiento",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarUnidadAlmacenamiento(AlmacenamientoFilter filtro){
        LOG.info("procesando...");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<AlmacenamientoDTO> listado;
            listado= almacenamientoService.ListarAlmacenamiento(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	
	@RequestMapping(value="/verificarUsuarioOsinergmin",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> verificarUsuarioOsinergmin(UnidadSupervisadaFilter filtro){
        LOG.info("procesando.....");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<UnidadSupervisadaDTO> listado;
            listado= unidadSupervisadaService.ListarUnidadSupervisada(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/ConsultarTrazProgramacion",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> ConsultarTrazProgramacion(TrazProgramacionFilter filtro){
        LOG.info("procesando.....");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<TrazProgramacionDTO> listado;
            listado= trazProgramacionService.ConsultarTrazProgramacion(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

	@RequestMapping(value="/ConsultarResultadoRevision",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> ConsultarResultadoRevision(ResultadoRevisionFilter filtro){
        LOG.info("procesando.....");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ResultadoRevisionDTO> listado;
            listado= resultadoRevService.listarResultadoRevision(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/verificarTanqueCL",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> verificarTanqueCL(AlmacenamientoFilter filtro){
	        LOG.info("procesando....");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<AlmacenamientoDTO> listado;
	            listado= almacenamientoService.ListarAlmacenamiento(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	/*	
	@RequestMapping(value="/RegistrarProgramacionIndividual", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarProgramacionIndividual(@RequestParam Long idCompartimiento, String cmbUnidadAlmacenamiento, Date fechaProgramacion,String tipoRevision, String tipoProgramacion, String numeroProgramacion, String estado, HttpSession session,HttpServletRequest request){
	
		LOG.info(" IdComp :"+ idCompartimiento+" Nprogramacion :"+ numeroProgramacion+" Unid :"+ cmbUnidadAlmacenamiento);
		
		Map<String,Object> retorno = new HashMap<String,Object>();
		

		try{ 
			
			ProgramacionDTO programacionDTO = new ProgramacionDTO(); 
			UsuarioDTO usuarioDTO = new UsuarioDTO();

			
			programacionDTO.setIdCompartimiento(idCompartimiento);
			programacionDTO.setTipoProgramacion(tipoProgramacion);
			programacionDTO.setNumeroProgramacion(numeroProgramacion);
			programacionDTO.setTipoRevision(tipoRevision);
			programacionDTO.setFechaProgramacion(fechaProgramacion);			
			programacionDTO.setIdCompartimiento(idCompartimiento);
			if ( estado == "P" ) {
			    programacionDTO.setEstado(estado);
			}else{
				programacionDTO.setEstado(estado);
			}
			
			
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
			
            
            programacionDTO = programacionService.RegistrarProgramacion(programacionDTO, usuarioDTO);
            
            retorno.put("idProgramacion",programacionDTO.getIdProgramacion());
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
           
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}*/
	
	@RequestMapping(value="/RegistrarProgramacionIndividual", method= RequestMethod.POST)
	   public @ResponseBody Map<String,Object> RegistrarProgramacionIndividual(@RequestParam Long idCompartimiento, String cmbUnidadAlmacenamiento, Date fechaProgramacion,String tipoRevision, String tipoProgramacion, String numeroProgramacion, String estado, HttpSession session,HttpServletRequest request){

	LOG.info(" IdComp :"+ idCompartimiento+" Nprogramacion :"+ numeroProgramacion+" Unid :"+ cmbUnidadAlmacenamiento);

			Map<String,Object> retorno = new HashMap<String,Object>();
		
		
			try{ 
		
			ProgramacionDTO programacionDTO = new ProgramacionDTO(); 
			UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		
			programacionDTO.setIdCompartimiento(idCompartimiento);
			programacionDTO.setTipoProgramacion(tipoProgramacion);
			programacionDTO.setNumeroProgramacion(numeroProgramacion);
			programacionDTO.setTipoRevision(tipoRevision);
			programacionDTO.setFechaProgramacion(fechaProgramacion);
			//programacionDTO.setEstado("P");
			if ( estado == "P" ) {
			    programacionDTO.setEstado(estado);
			}else{
				programacionDTO.setEstado(estado);
			}
			programacionDTO.setIdCompartimiento(idCompartimiento);
		
			usuarioDTO.setLogin("USU01");
	        usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	
	           programacionDTO = programacionService.RegistrarProgramacion(programacionDTO, usuarioDTO);
	           
	           retorno.put("idProgramacion",programacionDTO.getIdProgramacion());
	           
	           retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
			           
			}catch(Exception e){ 
			       	
			           retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
			           retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
			          
			           LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
			           e.printStackTrace();
			           
			       }        
			       return retorno;

	}
	
	@RequestMapping(value="/reprogramarCancelar", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> reprogramarCancelar(@RequestParam Long idProgramacion, Date fecha,String estado, HttpSession session,HttpServletRequest request){
	
		LOG.info(" IdProg :"+ idProgramacion+" FecProg :"+ fecha+" Estado :"+ estado);
		
		Map<String,Object> retorno = new HashMap<String,Object>();
		

		try{ 
			
			ProgramacionDTO programacionDTO = new ProgramacionDTO(); 
			UsuarioDTO usuarioDTO = new UsuarioDTO();


			programacionDTO.setIdProgramacion(idProgramacion);
			if ( fecha != null )
				programacionDTO.setFechaProgramacion(fecha);
			if ( estado != null )
				programacionDTO.setEstado(estado);

			
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
			
            
            programacionDTO = programacionService.EditarProgramacion(programacionDTO, usuarioDTO);
            
            retorno.put("idProgramacion",programacionDTO.getIdProgramacion());
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
           
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	

	@RequestMapping(value="/RegistrarTrazProgramacion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarTrazProgramacion(@RequestParam Long idProgramacion, String estado, Date fechaUltimoEstado,Long motivo, String observacion, HttpSession session,HttpServletRequest request){
	
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY:"+idProgramacion+" - " +estado+" - " +fechaUltimoEstado);

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY :"+idProgramacion+" - " +estado+" - " +fechaUltimoEstado);
			
			
			TrazProgramacionDTO trazProgramacionDTO = new TrazProgramacionDTO();
			
			trazProgramacionDTO.setIdTrazProgramacion(null);
			trazProgramacionDTO.setIdProgramacion(idProgramacion);
			trazProgramacionDTO.setFechaUltimoEstado(fechaUltimoEstado);
			trazProgramacionDTO.setEstado(estado);
			trazProgramacionDTO.setIdTipoMotivo(motivo);
			trazProgramacionDTO.setObservacion(observacion);
			
			trazProgramacionDTO = trazProgramacionService.RegistrarTrazProgramacion(trazProgramacionDTO);
          
            retorno.put("idTrazProgramacion",trazProgramacionDTO.getIdTrazProgramacion());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}	
    
	@RequestMapping(value="/EliminarProgramacion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> EliminarProgramacion(@RequestParam Long idProgramacion, HttpSession session,HttpServletRequest request){
	
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		try{ 
						
			ProgramacionDTO programacionDTO = new ProgramacionDTO(); 
			UsuarioDTO usuarioDTO = new UsuarioDTO();

			programacionDTO.setIdProgramacion(idProgramacion);
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
			
            
            programacionDTO = programacionService.EliminarProgramacion(programacionDTO, usuarioDTO);
            
            retorno.put("idProgramacion",programacionDTO.getIdProgramacion());
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al eliminar: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}	
	
	@RequestMapping(value="/registrar", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrar(@RequestParam("uploadfile") MultipartFile file, HttpSession session,HttpServletRequest request){
                            
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		
		LOG.info(" Datos ANTES DE TRY UPLOAD:");

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY UPLOAD:");

			DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			   
            if (file != null) {
                      
                    System.out.println("Saving file: " + file.getOriginalFilename());
                    
                    documentoAdjuntoDTO.setIdDocumentoAdjunto(null);
                    documentoAdjuntoDTO.setNombreDocumento(file.getOriginalFilename());
                    documentoAdjuntoDTO.setArchivoAdjunto(file.getBytes());
                    
                    usuarioDTO.setLogin("USU01");
                    usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
                   
                    documentoAdjuntoDTO = documentoAdjuntoService.RegistrarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);
                    
                    retorno.put("idDocumento", documentoAdjuntoDTO.getIdDocumentoAdjunto());
                    retorno.put("nombreDocumento", documentoAdjuntoDTO.getNombreDocumento());
                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                
            }

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	// --------------------------- CODIGO FABIAN ---------------------

    @RequestMapping(value="/registrarResultadoRevision", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarResultadoRevision(@RequestParam Long idResultadoRevision, Long idProgramacion,
                                                                                     Date fechaInicio, String horaInicio, 
                                                                                     Date fechaFin, String horaFin,String tipoPersonal, 
                                                                                     String flagPersona , Long idPersonaJuridica, 
                                                                                     String resultadoRevision, String observacion, 
                                                                                     String estadoResultado, HttpSession session,HttpServletRequest request){
                                 
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        LOG.info(" Datos ANTES DE TRY: "+resultadoRevision);

        try{ 
            
            LOG.info(" Datos DESPUES DE TRY:"+idResultadoRevision);
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            ResultadoRevisionDTO resultadoRevDTO = new ResultadoRevisionDTO();          
            
            resultadoRevDTO.setIdResultadoRevision(idResultadoRevision);
            resultadoRevDTO.setEstadoResultado(estadoResultado);
            resultadoRevDTO.setFechaFin(fechaFin);
            resultadoRevDTO.setFechaInicio(fechaInicio);
            resultadoRevDTO.setFlagPersona(flagPersona);
            resultadoRevDTO.setHoraFin(horaFin);
            resultadoRevDTO.setHoraInicio(horaInicio);
            resultadoRevDTO.setIdPersonaJuridica(idPersonaJuridica);
            resultadoRevDTO.setIdProgramacion(idProgramacion);
            resultadoRevDTO.setObservacion(observacion);
            resultadoRevDTO.setResultadoRevision(resultadoRevision);
            resultadoRevDTO.setTipoPersonal(tipoPersonal);
            
            
            usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    
                      
            resultadoRevDTO = resultadoRevService.RegistrarResultadoRevision(resultadoRevDTO, usuarioDTO);
            
            LOG.info("ID resultadoRev :"+resultadoRevDTO.getIdResultadoRevision() +  resultadoRevDTO.getEstadoResultado());

            retorno.put("idResultadoRev",resultadoRevDTO.getIdResultadoRevision());
            retorno.put("estaResultado",resultadoRevDTO.getEstadoResultado());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

            
        }catch(Exception e){ 
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
    }
    
    @RequestMapping(value="/registrarResultadoDocumento", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarResultadoDocumento(@RequestParam Long idResultadoRevision, Long idDocumentoAdjunto, HttpSession session,HttpServletRequest request){
                                 
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        LOG.info(" Datos ANTES DE TRY:"+idResultadoRevision+" - " +idDocumentoAdjunto);

        try{ 
            
            LOG.info(" Datos DESPUES DE TRY:"+idResultadoRevision+" - " +idDocumentoAdjunto);
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            ResultadoDocumentoDTO resultadoDocDTO = new ResultadoDocumentoDTO();            
            
            //resultadoDocDTO.setIdResultadoDocumento(null);
            resultadoDocDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
            resultadoDocDTO.setIdResultadoRevision(idResultadoRevision);
            
            usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    
                      
            resultadoDocDTO = resultadoDocService.RegistrarResultadoDocumento(resultadoDocDTO, usuarioDTO);
            
            LOG.info("ID resultadoDoc :"+resultadoDocDTO.getIdResultadoDocumento());

            retorno.put("idResultadoDoc",resultadoDocDTO.getIdResultadoDocumento());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

            
        }catch(Exception e){ 
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
    }
    
    @RequestMapping(value="/listarDocumentosArray",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarDocumentosArray(ResultadoDocumentoFilter filtro){
        LOG.info("procesando...");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ResultadoDocumentoDTO> listado;
            listado= resultadoDocService.listarResultadoDocumento(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @RequestMapping(value="/listarDocumentos",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> listarDocumentos(ResultadoDocumentoFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarDocumentos");
        
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ResultadoDocumentoDTO> listado = resultadoDocService.listarResultadoDocumento(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<ResultadoDocumentoDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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

    @RequestMapping(value = "/eliminarRPersonaAutorizado", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarResultadoPersonaNatural(Long idRPersonaN){
        LOG.info("procesando eliminarPersonal");
        LOG.info("ID: " + idRPersonaN);
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ResultadoPersonaNaturalDTO resultadoPersonaDTO = new ResultadoPersonaNaturalDTO();
            resultadoPersonaDTO.setIdResultadoPersonaNatural(idRPersonaN);
            
            resultadoPersonaDTO = resultadoPersonalService.eliminarPersonal(resultadoPersonaDTO);
            
            //concursoDTO = concursoServiceNeg.eliminarConcurso(concursoDTO);
            LOG.info("ELIMINADO!!!");
            retorno.put("concurso",resultadoPersonaDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en SedepersonalautorizadoService",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value = "/eliminarRDoc", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarRDoc(Long idResultadoDocumento){
        LOG.info("procesando eliminarRDoc");
        LOG.info("ID: " + idResultadoDocumento);
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ResultadoDocumentoDTO resultadoDocumentoDTO = new ResultadoDocumentoDTO();
            resultadoDocumentoDTO.setIdResultadoDocumento(idResultadoDocumento);
            
            resultadoDocumentoDTO = resultadoDocService.eliminarDocumento(resultadoDocumentoDTO);
            
            //concursoDTO = concursoServiceNeg.eliminarConcurso(concursoDTO);
            LOG.info("ELIMINADO!!!");
            retorno.put("concurso",resultadoDocumentoDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en SedepersonalautorizadoService",ex);
        }
        return retorno;
    }

    @RequestMapping(value = "/abrirFrmRevision", method = RequestMethod.GET)
    public String abrirFrmRevision (HttpSession sesion, Model model) {
     
        try{                    
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_REVISION;
    }
    
    @RequestMapping(value="/listarPersonasArray",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarPersonasArray(ResultadoPersonaNaturalFilter filtro){
        LOG.info("procesando...");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ResultadoPersonaNaturalDTO> listado;
            listado= resultadoPersonalService.listarResultadoPersonaNatural(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/listarPersonas",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> listarPersonas(ResultadoPersonaNaturalFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarSedePersonalAutorizado");
        
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ResultadoPersonaNaturalDTO> listado = resultadoPersonalService.listarResultadoPersonaNatural(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<ResultadoPersonaNaturalDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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

    //@RequestMapping(value="/datosTablaPersonaNatural", method= RequestMethod.GET)
    ///public @ResponseBody  Map<String,Object> datosTablaPersonaNatural(@RequestParam Long idPersonaNatural, String numeroDoc, String apellidoPaterno, String apellidoMaterno,String nombre,int rows, int page,HttpSession session,HttpServletRequest request){
        
    
    	
    	//Map<String,Object> retorno=new HashMap<String,Object>();
    	
    	 //JSONArray jsonArray = new JSONArray();
		// List<PersonaNaturalVDTO> listado =  new ArrayList<PersonaNaturalVDTO>();
		
		//try{
            
        	/*PersonaNaturalVDTO personaNaturalVDTO = new PersonaNaturalVDTO();
        	
        	personaNaturalVDTO.setIdPersonaNatural(idPersonaNatural);
        	personaNaturalVDTO.setNumeroDoc(numeroDoc);
        	personaNaturalVDTO.setApellidoMaterno(apellidoMaterno);
        	personaNaturalVDTO.setApellidoPaterno(apellidoPaterno);
        	personaNaturalVDTO.setNombre(nombre);*/
 
			//List<PersonaNaturalVDTO> listado = personanaturalService.listarTablaPersonaNatural(idPersonaNatural, numeroDoc, apellidoPaterno, apellidoMaterno, nombre);
        	
        	//jsonArray = jsonArray.put(personaNaturalVDTO.asJSONObject());
        	//listado.add(jsonArray.put(personaNaturalVDTO.asJSONObject()));
        	
       
        	
        	//List<PersonaNaturalVDTO> listado = personaNaturalVDTO;
            
            //Long contador = (long) listado.size();
            //int indiceInicial = (page - 1) * rows;
            //int indiceFinal = indiceInicial + rows;
            //List<PersonaNaturalVDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            ///Long numeroFilas = (contador / rows);
            //if ((contador % rows) > 0) {
              //numeroFilas = numeroFilas + 1L;
            //}
              
			//retorno.put("filas", listado);
            
			
            //retorno.put("total", numeroFilas);
            //retorno.put("pagina", page);
            //retorno.put("registros", contador);
            //retorno.put("filas", listado);
            
            /*for (PersonaNaturalVDTO personaNaturalVDTO : listado) {
				jsonArray.put(personaNaturalVDTO.asJSONObject());
			}*/
            
            /*PrintWriter pw = response.getWriter();
		    pw.write(jsonArray.toString());
		    pw.flush();
		    pw.close();*/
            
        //}catch(Exception ex){
            //LOG.error("",ex);
        //}
       // return retorno;
    //}
    
    @RequestMapping(value = "/abrirFrmResultadoPersonal", method = RequestMethod.GET)
    public String abrirFrmResultadoPersonal (HttpSession sesion, Model model) {
        //abrirFrmInspectorAutorizado(null, model);
        try{                    
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_RESUTADO_PERSONAL_AUTORIZADO;
    }

     @RequestMapping(value="/listarProductoCompartimiento",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> listarProductoCompartimiento(ProductoxCompartimientoFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Iniciando.....");
        
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ProductoxCompartimientoDTO> listado = productoCompartimientoService.ListarProductoCompartimiento(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<ProductoxCompartimientoDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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

      //---------------------------CONSULTAR RESULTADO PERSONA NATURAL ---------------------------------
    @RequestMapping(value="/cargarDatosResultadoPN",method=RequestMethod.POST)
        public @ResponseBody Map<String,Object> cargarDatosResultadoPN(ResultadoPersonaNaturalFilter filtro){
            LOG.info("procesando cargarDatos");
            Map<String,Object> retorno=new HashMap<String,Object>();
            try{
                List<ResultadoPersonaNaturalDTO> listado;
                listado = resultadoPersonalService.listarResultadoPersonaNatural(filtro);
                retorno.put("tamanio",listado.size());
                retorno.put("filas", listado);
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
            retorno.put("tamanio", listado.size());
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/registrarResultadoPersonaNatural", method= RequestMethod.POST)
        public @ResponseBody Map<String,Object> registrarResultadoPersonaNatural(@RequestParam Long idRPersonaNatural,  Long idResultadoRevision, Long idPersonaNatural,HttpSession session,HttpServletRequest request){
            
    	
            LOG.info("procesando registrarResultadoPersonaNatural");
            Map<String,Object> retorno = new HashMap<String,Object>();
            try{        
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setLogin("USU01");
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
                
                ResultadoPersonaNaturalDTO rpersonaNaturalDTO = new ResultadoPersonaNaturalDTO();            
                
                rpersonaNaturalDTO.setIdResultadoPersonaNatural(idRPersonaNatural);
                rpersonaNaturalDTO.setIdResultadoRevision(idResultadoRevision);
                rpersonaNaturalDTO.setIdPersonaNatural(idPersonaNatural);
                
                LOG.info(rpersonaNaturalDTO.getIdResultadoPersonaNatural() +" - "+rpersonaNaturalDTO.getIdResultadoRevision()
                         +" - "+rpersonaNaturalDTO.getIdPersonaNatural());
                LOG.info(usuarioDTO.getLogin()+" - "+usuarioDTO.getTerminal());
                
                rpersonaNaturalDTO = resultadoPersonalService.guardarResultadoPersonaNatural(rpersonaNaturalDTO, usuarioDTO);
             
                LOG.info("Controller ID PN: " + rpersonaNaturalDTO.getIdResultadoPersonaNatural() +" - " + rpersonaNaturalDTO.getIdResultadoRevision() +" - " + rpersonaNaturalDTO.getIdPersonaNatural());
                
                retorno.put("idRPN", rpersonaNaturalDTO.getIdResultadoPersonaNatural());
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
                retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
                
            }catch(Exception e){ 
                
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
                LOG.error("Error en guardar Personal: "+e.getMessage());
                e.printStackTrace();
                
            }        
            return retorno;
    }

        //----------------- VALIDAR PERSONA NATURAL -----------------------------------
    @RequestMapping(value="/validarPersonal",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> validarPersonal(PersonaNaturalVFilter filtro){
        LOG.info("procesando validarPersonal");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<PersonaNaturalVDTO> listado;
            listado= personanaturalService.listarPersonaNatural(filtro);
            
            Long contador = (long) listado.size();
            
            if(contador == 0) {
                
                 retorno.put("filas", "REGISTRO NO ENCONTRADO");
             
            } else {
                
                 retorno.put("filas", listado);
                
            }
           
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    //------------ FIN VALIDAR PERSONAL---------------------------

    

    @RequestMapping(value="/registrarPersonaNatural", method= RequestMethod.POST)
        public @ResponseBody Map<String,Object> registrarPersonaNatural(@RequestParam Long idPersonaNatural, Long idTipoDoc, String nroDoc, String ApPaterno, String ApMaterno, String nombre, Long cip, String telefono,HttpSession session,HttpServletRequest request){
            
            LOG.info("procesando registrarPersonaNatural");
            Map<String,Object> retorno = new HashMap<String,Object>();
            try{        
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                //usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
                usuarioDTO.setLogin("USU01");
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
                
                PersonaNaturalVDTO personaNaturalDTO = new PersonaNaturalVDTO();            
                
                personaNaturalDTO.setIdPersonaNatural(idPersonaNatural);
                personaNaturalDTO.setIdTipoDocumento(idTipoDoc);
                personaNaturalDTO.setNumeroDoc(nroDoc);
                personaNaturalDTO.setNombre(nombre);
                personaNaturalDTO.setApellidoPaterno(ApPaterno);
                personaNaturalDTO.setApellidoMaterno(ApMaterno);
                personaNaturalDTO.setCip(cip);
                personaNaturalDTO.setTelefono(telefono);
                
                LOG.info(personaNaturalDTO.getIdPersonaNatural()+" - "+ personaNaturalDTO.getNumeroDoc() +" - "+ personaNaturalDTO.getApellidoMaterno()+" - "+personaNaturalDTO.getApellidoPaterno()
                         +" - "+personaNaturalDTO.getNombre() +" - "+personaNaturalDTO.getIdTipoDocumento()+" - "+personaNaturalDTO.getCip());
                LOG.info(usuarioDTO.getLogin()+" - "+usuarioDTO.getTerminal());
                
                if(personaNaturalDTO.getIdPersonaNatural() != null) {
                	
                	personaNaturalDTO =personanaturalService.editarPersonaNatural(personaNaturalDTO, usuarioDTO);
                	
                } else {               	
                    personaNaturalDTO = personanaturalService.guardarPersonaNatural(personaNaturalDTO, usuarioDTO);
                }
             
                LOG.info("Controller ID PN: " + personaNaturalDTO.getIdPersonaNatural() +" - " + personaNaturalDTO.getIdTipoDocumento() +" - " + personaNaturalDTO.getNumeroDoc());
                
                retorno.put("idPN", personaNaturalDTO.getIdPersonaNatural());
                retorno.put("NroDoc", personaNaturalDTO.getNumeroDoc());
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
                retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
                
            }catch(Exception e){ 
                
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
                LOG.error("Error en guardar Personal: "+e.getMessage());
                e.printStackTrace();
                
            }        
            return retorno;
        }


    @RequestMapping(value = "/abrirFrmRepruebaCilindrosGNV", method = RequestMethod.GET)
    public String abrirFrmRepruebaCilindrosGNV (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_REPRUEBA_CILINDROS_GNV;
    }
    
    
    // LISTAR PARA EL EXPORTAR EXCEL
    
    @RequestMapping(value="/listarDatosProgramacionExcel",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarDatosProgramacionExcel(ProgramacionFilter filtro, HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el Listar Datos Programacion");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ProgramacionVDTO> listado = programacionService.ListarProgramacion(filtro);
    
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    //--------------------------------------
      
    @RequestMapping(value = "/abrirConfirmarSolicitudGNV", method = RequestMethod.GET)
    public String abrirConfirmarSolicitudGNV(HttpSession sesion, Model model){
        try{        	     	
            
        }catch(Exception e){
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_INFORMACION_ESTADO_IML;
    }
	
    //---------------------------------------------------
    
    @RequestMapping(value="/actualizarEstadoAlmacenamiento", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> actualizarEstadoAlmacenamiento(@RequestParam Long idAlmacenamiento,String estado, HttpSession session,HttpServletRequest request){
        
	    LOG.info("procesando actualizarEstadoAlmacenamiento");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{ 
            
        	AlmacenamientoDTO almacenamientoDTO = new AlmacenamientoDTO();
        	
        	almacenamientoDTO.setIdAlmacenamiento(idAlmacenamiento);
        	almacenamientoDTO.setEstado(estado);
        	
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            
        	usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            almacenamientoService.RegistrarAlmacenamiento(almacenamientoDTO, usuarioDTO);
         
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
            
        }catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en guardar RegistrarCilindro: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
    }
	
	@RequestMapping(value="/actualizarEstadoCompartimiento", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> actualizarEstadoCompartimiento(@RequestParam Long idCompartimiento,String estado, HttpSession session,HttpServletRequest request){
        
	    LOG.info("procesando actualizarEstadoCompartimiento");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{ 
            
        	CompartimientoDTO compartimientoDTO = new CompartimientoDTO();
        	
        	compartimientoDTO.setIdCompartimiento(idCompartimiento);
        	compartimientoDTO.setEstado(estado);
        	
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            
        	usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            compartimientoService.RegistrarCompartimiento(compartimientoDTO, usuarioDTO);
         
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
            
        }catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en guardar RegistrarCilindro: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
    }
}




