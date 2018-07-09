package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.service.AlmacenaCompartiProdService;
import gob.osinergmin.sibad.service.AlmacenamientoService;
import gob.osinergmin.sibad.service.CompartimientoService;
import gob.osinergmin.sibad.service.DocumentoAdjuntoService;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.InformeIndiceRiesgoService;
import gob.osinergmin.sibad.service.InformePersonaNaturalService;
import gob.osinergmin.sibad.service.InformeSolicitudPruebaService;
import gob.osinergmin.sibad.service.MaestroColumnaTipoService;
import gob.osinergmin.sibad.service.PersonaJuridicaService;
import gob.osinergmin.sibad.service.PersonaNaturalVService;
import gob.osinergmin.sibad.service.ResultadoPersonaNaturalService;
import gob.osinergmin.sibad.service.ResultadoPruebaDocumentoService;
import gob.osinergmin.sibad.service.ResultadoPruebaRepruebaService;
import gob.osinergmin.sibad.service.SolicitudPruebaRepruebaService;
import gob.osinergmin.sibad.service.SolicitudXInformeRiesgoService;
import gob.osinergmin.sibad.service.TrazSolicitudService;
import gob.osinergmin.sibad.service.UnidadSupervisadaService;
import gob.osinergmin.sibad.domain.dto.AlmacenaCompartiProdDTO;
import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.InformeIndiceRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.InformeSolicitudPruebaDTO;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;
import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoVDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudXInformeRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.domain.dto.TrazSolicitudDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlmacenaCompartiProdFilter;
import gob.osinergmin.sibad.filter.DocumentoAdjuntoFilter;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.InformeIndiceRiesgoFilter;
import gob.osinergmin.sibad.filter.InformePersonaNaturalFilter;
import gob.osinergmin.sibad.filter.InformeSolicitudPruebaFilter;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.filter.PersonaNaturalVFilter;
import gob.osinergmin.sibad.filter.ResultadoPersonaNaturalFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaDocumentoFilter;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;
import gob.osinergmin.sibad.filter.SolicitudXInformeRiesgoFilter;
import gob.osinergmin.sibad.filter.TrazAlcanceAcredFilter;
import gob.osinergmin.sibad.filter.TrazSolicitudFilter;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.util.ConstantesWeb;

import java.net.Inet4Address;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/solicitudPruebasHermeticidad")
public class BandejaSolicitudesPruebasHermeticidadController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BandejaSolicitudesPruebasHermeticidadController.class);
	
	@Inject
	private UnidadSupervisadaService unidadsupervisadaService;
	@Inject
	private CompartimientoService compartimientoService;
	@Inject
	private DocumentoAdjuntoService documentoAdjuntoService;
	@Inject
	private SolicitudPruebaRepruebaService solicitudPruebaRepruebaService;
	@Inject
	private TrazSolicitudService trazSolicitudService;
	@Inject
	private EmpresaAcreditadaService empAcredService;
	@Inject
	private AlmacenaCompartiProdService almacenaCompartiProdService;
	@Inject
	private DocumentoAdjuntoService documentoadjuntoService;
	@Inject
	private MaestroColumnaTipoService maestroColumnaTipoService;
	@Inject
	private ResultadoPruebaRepruebaService resultadoPruebaRepruebaService;
	@Inject
	private ResultadoPruebaDocumentoService resultadoPruebaDocumentoService;
	@Inject
	private SolicitudXInformeRiesgoService solicitudxInformeRiesgoService;
	@Inject
	private InformeIndiceRiesgoService informeIndiceRiesgoService;
	@Inject
	private InformePersonaNaturalService informePersonaNaturalService;
	@Inject
	private InformeSolicitudPruebaService informeSolicitudPruebaService;
	@Inject
	private PersonaNaturalVService personanaturalService;
	@Inject
	private PersonaJuridicaService personajuridicaService; 
	@Inject
	private ResultadoPersonaNaturalService resultadoPersonalService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model, HttpSession session, HttpServletRequest request){
		
		String j_username = "JHIDALGOM";
        session.setAttribute("j_username", j_username);
        //----------------------------------------------------
        //----------------------------------------------------

        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_BANDEJA_PRUEBA_HERMETICIDAD;
	}
	
	@RequestMapping(value="/listarSolicitudPruebaReprueba",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarSolicitudPruebaReprueba(SolicitudPruebaRepruebaFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarSolicitudPruebaReprueba");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<SolicitudPruebaRepruebaDTO> listado = solicitudPruebaRepruebaService.listarSolicitudPruebaReprueba(filtro);
    
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<SolicitudPruebaRepruebaDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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
	
	@RequestMapping(value="/listarAlmacenamientoCompartimientoProducto",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarAlmacenamientoCompartimientoProducto(AlmacenaCompartiProdFilter filtro, int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarAlmacenamientoCompartimientoProducto");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
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
	
	//Listar Documento Adjunto
	
	@RequestMapping(value="/listarDocumentoAdjunto",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarDocumentoAdjunto(DocumentoAdjuntoFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarDocumentoAdjunto");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<DocumentoAdjuntoDTO> listado = documentoadjuntoService.listarDocumentoAdjunto(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<DocumentoAdjuntoDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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
	
	@RequestMapping(value="/listarSolicitudXInformeRiesgo",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarSolicitudXInformeRiesgo(SolicitudXInformeRiesgoFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el Listar Solicitud X Informe de Riesgo");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<SolicitudXInformeRiesgoDTO> listado = solicitudxInformeRiesgoService.consultarSolicitudXInformeRiesgo(filtro);
    
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<SolicitudXInformeRiesgoDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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
	
	//--------------------------------------------------------------------------
	
	@RequestMapping(value = "/abrirNuevaPruebaHermeticidad", method = RequestMethod.GET)
    public String abrirNuevaPruebaHermeticidad (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_PRUEBA_HERMETICIDAD;
    }
	
	@RequestMapping(value = "/abrirEstReprogramarCancelar", method = RequestMethod.GET)
    public String abrirEstReprogramarCancelar (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_EST_REPROGRAMAR_CANCELAR;
    }
	
	@RequestMapping(value = "/abrirConfirmarSolicitud", method = RequestMethod.GET)
    public String abrirConfirmarSolicitud (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_CONFIRMAR_SOLICITUD;
    }
	
	@RequestMapping(value = "/abrirInformacionEstado", method = RequestMethod.GET)
    public String abrirInformacionEstado (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_INFORMACION_ESTADO;
    }
	
		@RequestMapping(value="/empresasXtipoPrueba",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> empresasXtipoPrueba(EmpresaAcreditadaFilter filtro){
	        LOG.info("procesando Empresas X Tipo de Prueba");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<EmpresaAcreditadaDTO> listado;
	            listado= empAcredService.listarEmpAcred(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	//--------------------------- FIN ENCONTRAR EMPRESA ACREDITADA ----------------------------
		
	//-------------------------- ENCONTRAR UNIDAD SUPERVISADA -----------------------------
			@RequestMapping(value="/encontrarUnidadSupervisada",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> encontrarUnidadSupervisada(UnidadSupervisadaFilter filtro){
		        LOG.info("procesando encontrar Unidad Supervisada");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<UnidadSupervisadaDTO> listado;
		            listado= unidadsupervisadaService.ListarUnidadSupervisada(filtro);
		            retorno.put("filas", listado);
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		    }
		//--------------------------- FIN ENCONTRAR UNIDAD SUPERVISADA ----------------------------
		
	//-------------------------- ENCONTRAR ULTIMA SOLICITUD DE UNA EMPRESA -----------------------------
			@RequestMapping(value="/encontrarSolicitudUltimaEmpresa",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> encontrarSolicitudUltimaEmpresa(SolicitudPruebaRepruebaFilter filtro){
		        LOG.info("procesando encontrar Solicitud");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<SolicitudPruebaRepruebaDTO> listado;
		            listado= solicitudPruebaRepruebaService.listarSolicitudPruebaReprueba(filtro);
		            retorno.put("filas", listado);
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		    }
		//------------------------ FIN ENCONTRAR ULTIMA SOLICITUD DE UNA EMPRESA -----------------------------
			
	//-------------------------- ENCONTRAR DATOS DE INFORMACION ESTADO -----------------------------
	@RequestMapping(value="/cargarInformeEstadoSolicitud",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarInforme(TrazSolicitudFilter filtro){
        LOG.info("procesando cargarInformeEstado");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<TrazSolicitudDTO> listado;
            listado= trazSolicitudService.listarTrazSolicitud(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	//------------------------ FIN ENCONTRAR DATOS DE INFORMACION ESTADO -----------------------------
	
	//-------------------------- CARGAR DATOS MAESTRO COLUMNA -----------------------------
	@RequestMapping(value="/cargarDatosMaestroColumna",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarDatosMaestroColumna(MaestroColumnaTipoFilter filtro){
        LOG.info("procesando cargarDatosMaestroColumna");
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
	//------------------------ FIN CARGAR DATOS MAESTRO COLUMNA --------------------------------
	
	//---------------------- REGISTRAR SOLICITUD PRUEBA REPRUEBA --------------------------
		
		@RequestMapping(value="/RegistrarSolicitudPruebaReprueba", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> RegistrarSolicitudPruebaReprueba(@RequestParam Long idSolicitudPruebaReprueba, String nroSolicitudUnidadSupervisa, Long idTipoPrueba, Long idEmpresaAcreditada, Date fechaSolicitud, Long idCompartimiento, String estado, HttpSession session,HttpServletRequest request){
		
			LOG.info(" IdSolicitud :"+ idSolicitudPruebaReprueba+" NroSolicitud :"+ nroSolicitudUnidadSupervisa+" IdTipoPrueba :"+ idTipoPrueba+" IdCompartimiento :"+ idCompartimiento);
			
			Map<String,Object> retorno = new HashMap<String,Object>();
			
			try{ 
				
				SolicitudPruebaRepruebaDTO solicitudPruebaRepruebaDTO = new SolicitudPruebaRepruebaDTO(); 
				UsuarioDTO usuarioDTO = new UsuarioDTO();

				
				solicitudPruebaRepruebaDTO.setIdSolicitudPruebaReprueba(idSolicitudPruebaReprueba);
				solicitudPruebaRepruebaDTO.setNroSolicitudUnidadSupervisa(nroSolicitudUnidadSupervisa);
				solicitudPruebaRepruebaDTO.setIdTipoPrueba(idTipoPrueba);
				solicitudPruebaRepruebaDTO.setIdEmpresaAcreditada(idEmpresaAcreditada);
				solicitudPruebaRepruebaDTO.setFechaSolicitud(fechaSolicitud);
				solicitudPruebaRepruebaDTO.setIdCompartimiento(idCompartimiento);
				solicitudPruebaRepruebaDTO.setEstado("P");
				solicitudPruebaRepruebaDTO.setFlagInformeIndiceRiesgo("N");
				
				usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
				
	            
	            solicitudPruebaRepruebaDTO = solicitudPruebaRepruebaService.RegistrarSolicitudPruebaReprueba(solicitudPruebaRepruebaDTO, usuarioDTO);
	            
	            retorno.put("idSolicitudPruebaReprueba",solicitudPruebaRepruebaDTO.getIdSolicitudPruebaReprueba());
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
	            
			}catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	           
	            LOG.error("Error al guardar Solicitud Prueba Reprueba: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
			
		}
		
	//---------------------- FIN REGISTRAR SOLICITUD PRUEBA REPRUEBA -------------------------------------------------
		
	//---------------------- REGISTRAR TRAZABILIDAD SOLICITUD --------------------------
	
		@RequestMapping(value="/RegistrarTrazSolicitud", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> RegistrarTrazSolicitud(@RequestParam Long idSolicitudPruebaReprueba, Long idTipoMotivo, String observacion, Date fechaUltimoEstado, String estado, HttpSession session,HttpServletRequest request){
		
			LOG.info(" IdSolicitud :"+ idSolicitudPruebaReprueba+" idMotivo : "+ idTipoMotivo+"/ observacion : "+ observacion+"/ FechaUltEstado : "+ fechaUltimoEstado);
			
			Map<String,Object> retorno = new HashMap<String,Object>();
			
			try{ 
				
				TrazSolicitudDTO trazSolicitudDTO = new TrazSolicitudDTO(); 
				UsuarioDTO usuarioDTO = new UsuarioDTO();
	
				trazSolicitudDTO.setIdTrazSolicitud(null);
				trazSolicitudDTO.setIdSolicitudPruebaReprueba(idSolicitudPruebaReprueba);
				trazSolicitudDTO.setFechaUltimoEstado(fechaUltimoEstado);
				trazSolicitudDTO.setEstado(estado);
				trazSolicitudDTO.setIdTipoMotivo(idTipoMotivo);
				trazSolicitudDTO.setObservacion(observacion);
				
				usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
				
	            
	            trazSolicitudDTO = trazSolicitudService.RegistrarTrazSolicitud (trazSolicitudDTO);
	            
	            retorno.put("idTrazSolicitud",trazSolicitudDTO.getIdTrazSolicitud());
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
	            
			}catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	           
	            LOG.error("Error al guardar Solicitud Prueba Reprueba: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
			
		}
		
	//---------------------- FIN REGISTRAR TRAZABILIDAD SOLICITUD -------------------------------------------------
		
	//-------------------------- MODIFICAR ESTADO DE LA SOLICITUD Y GUARDAR TRAZABILIDAD --------------------------------
	
		@RequestMapping(value="/registrarTrazabilidadYcambioEstado", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarTrazabilidadYcambioEstado(@RequestParam  Long idSolicitudTraz, Long idTipoMotivo, Long idSolicitudPruebaReprueba,  String observacion ,String estado, Date fecha, HttpSession session,HttpServletRequest request){
	        LOG.info("procesando registrar Trazabilidad Y cambio Estado");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        LOG.info(" Antes del try catch "+idSolicitudTraz+" - "+idSolicitudPruebaReprueba+" - "+observacion);
	        try{ 
		        LOG.info(" Despues del try catch "+idSolicitudTraz+" - "+idSolicitudPruebaReprueba+" - "+observacion);
	            
		        TrazSolicitudDTO trazOrganismo = new TrazSolicitudDTO();
	            SolicitudPruebaRepruebaDTO solicitudPruebaRpbaDTO = new SolicitudPruebaRepruebaDTO();
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	        	usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            trazOrganismo.setIdTrazSolicitud(idSolicitudTraz);
	            trazOrganismo.setIdSolicitudPruebaReprueba(idSolicitudPruebaReprueba);
	            trazOrganismo.setIdTipoMotivo(idTipoMotivo);
	            trazOrganismo.setObservacion(observacion);
	            trazOrganismo.setFechaUltimoEstado(fecha);
	            trazOrganismo.setEstado(estado);
	            solicitudPruebaRpbaDTO.setIdSolicitudPruebaReprueba(idSolicitudPruebaReprueba);
	            solicitudPruebaRpbaDTO.setEstado(estado);
	            
	            if(estado.equals("R")) {
	            	solicitudPruebaRpbaDTO.setFechaSolicitud(fecha);
	            }
	            
	            LOG.info(trazOrganismo.getEstado()+" - "+trazOrganismo.getIdTipoMotivo()+" - "+ trazOrganismo.getObservacion());
	                    
	            trazOrganismo = trazSolicitudService.RegistrarTrazSolicitud(trazOrganismo);
	            solicitudPruebaRepruebaService.RegistrarSolicitudPruebaReprueba(solicitudPruebaRpbaDTO, usuarioDTO);
	            
	            LOG.info(trazOrganismo.getEstado()+" - "+trazOrganismo.getIdTipoMotivo()+" - "+ trazOrganismo.getObservacion());
	         
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
	            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
	            
	        }catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error en guardar Trazabilidad Y Cambio Estado: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	    }
	//-------------------------- FIN MODIFICAR ESTADO DE LA SOLICITUD Y GUARDAR TRAZABILIDAD --------------------------------
		
	// ----------------------- REGISTRAR DOCUMENTO ADJUNTO - INFORME ---------------------------------------
		
		@RequestMapping(value="/registrarInformeAdjunto", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarInformeAdjunto(@RequestParam("uploadfileI") MultipartFile file, HttpSession session,HttpServletRequest request){
	    //public String registrar(HttpServletRequest request,@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
	                            
			Map<String,Object> retorno = new HashMap<String,Object>();
			
			LOG.info(" Datos ANTES DE TRY UPLOAD:");

			try{ 
				
				LOG.info(" Datos DESPUES DE TRY UPLOAD:");

				DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				   
	            if (file != null) {
	            	
	            	//for (CommonsMultipartFile aFile : fileUpload){
	                      
	                    System.out.println("Saving file C: " + file.getOriginalFilename());
	                    
	                    documentoAdjuntoDTO.setIdDocumentoAdjunto(null);
	                    documentoAdjuntoDTO.setNombreDocumento(file.getOriginalFilename());
	                    documentoAdjuntoDTO.setDescripcionDocumento("INFORME DE INDICE DE RIESGOS");
	                    documentoAdjuntoDTO.setArchivoAdjunto(file.getBytes());
	                    documentoAdjuntoDTO.setEstadoDocumento("1");
	                    
	                    usuarioDTO.setLogin("USU01");
	                    usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	                   
	                    documentoAdjuntoDTO = documentoadjuntoService.RegistrarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);
	          
	                    retorno.put("idDocumentoAdjunto",documentoAdjuntoDTO.getIdDocumentoAdjunto());
	                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
	                //}
	            }

			}catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar Documento Alcance: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
			
		}
		
		//-------------------------- MODIFICAR ESTADO DOCUMENTO AL ELIMINAR --------------------------------
		
			@RequestMapping(value="/modificarEstadoEliminarDocumento", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> modificarEstadoEliminarDocumento(@RequestParam Long idDocumentoAdjunto, String estadoDocumento ,HttpSession session,HttpServletRequest request){
			
				Map<String,Object> retorno = new HashMap<String,Object>();
				
				LOG.info(" Datos antes del TRY CATCH:"+idDocumentoAdjunto+" - " +estadoDocumento);

				try{ 
					
					LOG.info(" Datos despues del TRY CATCH :"+idDocumentoAdjunto+" - " +estadoDocumento);
					
					DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
					
					UsuarioDTO usuarioDTO = new UsuarioDTO();
		           
					usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
		            
		            documentoAdjuntoDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
		            documentoAdjuntoDTO.setEstadoDocumento(estadoDocumento);
		            
		            documentoadjuntoService.EditarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);
		           
		            
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
				}catch(Exception e){ 
		        	
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
		            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
		            LOG.error("Error al guardar LA MODIFICACION DEL ESTADO: "+e.getMessage());
		            e.printStackTrace();
		            
		        }        
		        return retorno;
				
			}
			
			//-------------------------- FIN MODIFICAR ESTADO DOCUMENTO AL ELIMINAR -----------------------------
			
		//--------------------------- LISTAR DATOS - SOLICITUD PRUEBA DE HERMETICIDAD ---------------------------
			
			@RequestMapping(value="/listarPruebaHermeticidad",method= RequestMethod.GET)
			public @ResponseBody Map<String,Object> listarPruebaHermeticidad(SolicitudPruebaRepruebaFilter filtro, HttpSession session,HttpServletRequest request){
		        LOG.info("Inicia el Listar Prueba Hermeticidad");
		    	
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<SolicitudPruebaRepruebaDTO> listado = solicitudPruebaRepruebaService.listarSolicitudPruebaReprueba(filtro);
		    
		            retorno.put("filas", listado);
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		    }
			
	    //---------------------------- FIN LISTAR DATOS - SOLICITUD PRUEBA DE HERMETICIDAD ---------------------------------------
			
		//-------------------------- MODIFICAR FECHA PROX PRUEBA DE RESULTADO PRUEBA REPRUEBA --------------------------------
			
			@RequestMapping(value="/modificarFechaProxPruebaResultadoPR", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> modificarFechaProxPruebaResultadoPR(@RequestParam Long idResultadoPruebaReprueba, Date fechaProximaPrueba, HttpSession session,HttpServletRequest request){
			
				Map<String,Object> retorno = new HashMap<String,Object>();
				
				LOG.info(" Datos antes del TRY CATCH:"+idResultadoPruebaReprueba+" - " +fechaProximaPrueba);

				try{ 
					
					LOG.info(" Datos despues del TRY CATCH :"+idResultadoPruebaReprueba+" - " +fechaProximaPrueba);
					
					ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO = new ResultadoPruebaRepruebaDTO();
					
					UsuarioDTO usuarioDTO = new UsuarioDTO();
		           
					usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
		            
		            resultadoPruebaRepruebaDTO.setIdResultadoPruebaReprueba(idResultadoPruebaReprueba);
		            resultadoPruebaRepruebaDTO.setFechaProximaPrueba(fechaProximaPrueba);
		            
		            resultadoPruebaRepruebaService.EditarFechaProxPruebaResultadoPruebaReprueba(resultadoPruebaRepruebaDTO, usuarioDTO);
		           
		            
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
				}catch(Exception e){ 
		        	
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
		            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
		            LOG.error("Error al guardar LA MODIFICACION FECHA PROX PRUEBA DE RESULTADO PRUEBA R: "+e.getMessage());
		            e.printStackTrace();
		            
		        }        
		        return retorno;
				
			}
			
			//-------------------------- FIN MODIFICAR FECHA PROX PRUEBA DE RESULTADO PRUEBA REPRUEBA -----------------------------
			
			//-------------------------- BUSCAR DATOS DE RESULTADO PRUEBA DOCUMENTO -----------------------------
			
			@RequestMapping(value="/buscarResultadoDocumento",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> buscarResultadoDocumento(ResultadoPruebaDocumentoFilter filtro){
		        LOG.info("procesando...");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<ResultadoPruebaDocumentoVDTO> listado;
		            listado= resultadoPruebaDocumentoService.listarResultadoPruebaDocumento(filtro);
		            retorno.put("filas", listado);
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		    }
			//-------------------------- FIN BUSCAR DATOS DE RESULTADO PRUEBA DOCUMENTO -----------------------------
			
			//-------------------------------- REGISTRAR RESULTADO PRUEBA DOCUMENTO ---------------------------------------
			
			@RequestMapping(value="/registrarResultadoDocumento", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> registrarResultadoDocumento(@RequestParam Long idResultadoPruebaReprueba ,Long idDocumentoAdjunto, HttpSession session,HttpServletRequest request){
		                                 
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        
		        LOG.info(" Datos ANTES DE TRY: ");
	
		        try{ 
		            
		            LOG.info(" Datos DESPUES DE TRY:");
		            
		            UsuarioDTO usuarioDTO = new UsuarioDTO();
		            ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO = new ResultadoPruebaDocumentoDTO();
		            
		            resultadoPruebaDocumentoDTO.setIdResutadoPruebaReprueba(idResultadoPruebaReprueba);
		            resultadoPruebaDocumentoDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
		           	             
		            usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    
	
		            resultadoPruebaDocumentoDTO = resultadoPruebaDocumentoService.RegistrarResultadoPruebaDocumento(resultadoPruebaDocumentoDTO, usuarioDTO);
		           
		            retorno.put("idResultadoPruebaDocumento",resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento());
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
		            
		        }catch(Exception e){ 
		            
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
		            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
		            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
		            e.printStackTrace();
		            
		        }        
		        return retorno;
		   }
			//-------------------------------- FIN REGISTRAR RESULTADO PRUEBA DOCUMENTO ---------------------------------------
			
			//-------------------------------- MODIFICAR RESULTADO PRUEBA DOCUMENTO ---------------------------------------
			
			@RequestMapping(value="/modificarResultadoDocumento", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> modificarResultadoDocumento(@RequestParam Long idResultadoPruebaDocumento, Long idResultadoPruebaReprueba ,Long idDocumentoAdjunto, HttpSession session,HttpServletRequest request){
		                                 
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        
		        LOG.info(" Datos ANTES DE TRY: ");
	
		        try{ 
		            
		            LOG.info(" Datos DESPUES DE TRY:");
		            
		            ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO = new ResultadoPruebaDocumentoDTO();
		            
		            UsuarioDTO usuarioDTO = new UsuarioDTO();
		            
		            usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString()); 
		            
		            resultadoPruebaDocumentoDTO.setIdResultadoPruebaDocumento(idResultadoPruebaDocumento);
		            resultadoPruebaDocumentoDTO.setIdResutadoPruebaReprueba(idResultadoPruebaReprueba);
		            resultadoPruebaDocumentoDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
		           	             
		            usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    
	
		            resultadoPruebaDocumentoService.EditarResultadoPruebaDocumento(resultadoPruebaDocumentoDTO, usuarioDTO);
		           
		            //retorno.put("idResultadoPruebaDocumento",resultadoPruebaDocumentoDTO.getIdResultadoPruebaDocumento());	            
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
		            
		        }catch(Exception e){ 
		            
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
		            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
		            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
		            e.printStackTrace();
		            
		        }        
		        return retorno;
		   }
			//-------------------------------- FIN MODIFICAR RESULTADO PRUEBA DOCUMENTO ---------------------------------------
			
			//-- Formulario Informe Indice de Riesgo
		    @RequestMapping(value = "/abrirFrmIndiceRiesgo", method = RequestMethod.GET)
		    public String abrirFrmIndiceRiesgo(HttpSession sesion, Model model){
		        try{        	     	
		            
		        }catch(Exception e){
		        }                   
		        return ConstantesWeb.Navegacion.PAGE_FRM_INFORME_RIESGO;
		    }
		    
		    @RequestMapping(value = "/abrirProxPruebaHermeticidad", method = RequestMethod.GET)
		    public String abrirProxPruebaHermeticidad(HttpSession sesion, Model model){
		        try{        	     	
		            
		        }catch(Exception e){
		        }                   
		        return ConstantesWeb.Navegacion.PAGE_FRM_PROXIMA_PRUEBA_HERMETICIDAD;
		    }

			@RequestMapping(value="/listarSolicitudes",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> listarDocumentosArray(SolicitudPruebaRepruebaFilter filtro){
		        LOG.info("procesando...");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<SolicitudPruebaRepruebaDTO> listado;
		            listado= solicitudPruebaRepruebaService.listarSolicitudPruebaReprueba(filtro);
		            retorno.put("filas", listado);
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		    }
			
			@RequestMapping(value="/informeIndiceRiesgos", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> informeIndiceRiesgos(@RequestParam Long idInformeIndiceRiesgo, String numInforme, Date fechaInforme, Long idPersonaJuridica, Long idDocumento, String flagPersona,HttpSession session,HttpServletRequest request){

		        LOG.info("procesando informeIndiceRiesgos");
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        try{       
		        	
		            UsuarioDTO usuarioDTO = new UsuarioDTO();
		           
		            usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
		            
		            InformeIndiceRiesgoDTO informeIndiceRiesgoDTO = new InformeIndiceRiesgoDTO();            
		            
		            informeIndiceRiesgoDTO.setIdInformeIndiceRiesgo(idInformeIndiceRiesgo);
		            informeIndiceRiesgoDTO.setNumeroInformeIndiceRiesgo(numInforme);
		            informeIndiceRiesgoDTO.setFechaInformeIniceRiesgo(fechaInforme);
		            informeIndiceRiesgoDTO.setIdPersonaJuridica(idPersonaJuridica);
		            informeIndiceRiesgoDTO.setIdDocumentoAdjunto(idDocumento);
		            informeIndiceRiesgoDTO.setFlagPersona(flagPersona);
		                                  	
		            informeIndiceRiesgoDTO = informeIndiceRiesgoService.RegistrarInformeIndiceRiesgo(informeIndiceRiesgoDTO, usuarioDTO);
		                
		            retorno.put("idInformeIndiceRiesgo",informeIndiceRiesgoDTO.getIdInformeIndiceRiesgo());
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
			
			@RequestMapping(value="/informePersonaNatural", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> informePersonaNatural(@RequestParam Long idInformePersonaNatural, Long idInformeIndiceRiesgo, Long idPersonaNatural,HttpSession session,HttpServletRequest request){

		        LOG.info("procesando informePersonaNatural");
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        try{       
		        	
		            InformePersonaNaturalDTO informePersonaNaturalDTO = new InformePersonaNaturalDTO();            
		            
		            informePersonaNaturalDTO.setIdInformeIndiceRiesgo(idInformeIndiceRiesgo);
		            informePersonaNaturalDTO.setIdInformePersonaNatural(idInformePersonaNatural);
		            informePersonaNaturalDTO.setIdPersonaNatural(idPersonaNatural);
		            
		            informePersonaNaturalDTO = informePersonaNaturalService.RegistrarInformePersonaNatural(informePersonaNaturalDTO);
		                
		            retorno.put("idInformePersonaNatural",informePersonaNaturalDTO.getIdInformePersonaNatural());
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
			
			@RequestMapping(value="/informeSolicitudPrueba", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> informeSolicitudPrueba(@RequestParam Long idInformeSolicitudPrueba, Long idSolicitudPruebaReprueba, Date fechaProxPrueba,Long idInformeIndiceRiesgo,HttpSession session,HttpServletRequest request){

		        LOG.info("procesando informeSolicitudPrueba");
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        try{       
		        	
		            InformeSolicitudPruebaDTO informeSolicitudPruebaDTO = new InformeSolicitudPruebaDTO();            
		      
		            informeSolicitudPruebaDTO.setIdInformeIndiceRiesgo(idInformeIndiceRiesgo);
		            informeSolicitudPruebaDTO.setIdInformeSolicitudPrueba(idInformeSolicitudPrueba);
		            informeSolicitudPruebaDTO.setIdSolicitudPruebaReprueba(idSolicitudPruebaReprueba);
		            informeSolicitudPruebaDTO.setFechaProximaPrueba(fechaProxPrueba);
		          
		            informeSolicitudPruebaDTO = informeSolicitudPruebaService.RegistrarInformeSolicitudPrueba(informeSolicitudPruebaDTO);
		                
		            retorno.put("idInformeSolicitudPrueba",informeSolicitudPruebaDTO.getIdInformeSolicitudPrueba());
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

			@RequestMapping(value="/resultadoPruebaReprueba", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> resultadoPruebaReprueba(@RequestParam Long idResultadoPruebaReprueba, Date fechaProxPrueba,HttpSession session,HttpServletRequest request){

		        LOG.info("procesando resultadoPruebaReprueba");
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        try{       
		        	
		            UsuarioDTO usuarioDTO = new UsuarioDTO();
		           
		            usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
		            
		            ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO = new ResultadoPruebaRepruebaDTO();            
		            
		            resultadoPruebaRepruebaDTO.setIdResultadoPruebaReprueba(idResultadoPruebaReprueba);
		            resultadoPruebaRepruebaDTO.setFechaProximaPrueba(fechaProxPrueba);
		            
		                                  	
		            resultadoPruebaRepruebaDTO = resultadoPruebaRepruebaService.EditarFechaProxPruebaResultadoPruebaReprueba(resultadoPruebaRepruebaDTO, usuarioDTO);
		                
		            retorno.put("idResultadoPruebaReprueba",resultadoPruebaRepruebaDTO.getIdResultadoPruebaReprueba());
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
			
			@RequestMapping(value="/solicitudPruebaReprueba", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> solicitudPruebaReprueba(@RequestParam Long idSolicitudPruebaReprueba, String estado,String flagInformeIndiceRiesgo, HttpSession session,HttpServletRequest request){

		        LOG.info("procesando solicitudPruebaReprueba");
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        try{       
		        	
		            UsuarioDTO usuarioDTO = new UsuarioDTO();
		           
		            usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
		            
		            SolicitudPruebaRepruebaDTO solicitudPruebaRepruebaDTO = new SolicitudPruebaRepruebaDTO();            
		            
		            solicitudPruebaRepruebaDTO.setIdSolicitudPruebaReprueba(idSolicitudPruebaReprueba);
		            solicitudPruebaRepruebaDTO.setEstado(estado);
		            solicitudPruebaRepruebaDTO.setFlagInformeIndiceRiesgo(flagInformeIndiceRiesgo);
		            
		                                  	
		            solicitudPruebaRepruebaDTO = solicitudPruebaRepruebaService.EditarSolicitudPruebaReprueba(solicitudPruebaRepruebaDTO, usuarioDTO);
		                
		            retorno.put("idSolicitudPruebaReprueba",solicitudPruebaRepruebaDTO.getIdSolicitudPruebaReprueba());
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

			@RequestMapping(value="/compartimiento", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> compartimiento(@RequestParam Long idCompartimiento, Date fechaProxPrueba, HttpSession session,HttpServletRequest request){

		        LOG.info("procesando compartimiento");
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        try{       
		        	
		            UsuarioDTO usuarioDTO = new UsuarioDTO();
		           
		            usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
		            
		            CompartimientoDTO compartimientoDTO = new CompartimientoDTO();            
		            
		            compartimientoDTO.setIdCompartimiento(idCompartimiento);
		            compartimientoDTO.setFechaProximaPrueba(fechaProxPrueba);
		                                  	
		            compartimientoDTO = compartimientoService.EditarCompartimiento(compartimientoDTO, usuarioDTO);
		                
		            retorno.put("idCompartimiento",compartimientoDTO.getIdCompartimiento());
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
			
			@RequestMapping(value="/eliminarDocumentoAdjunto", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> eliminarDocumentoAdjunto(@RequestParam Long idDocumentoAdjunto, HttpSession session,HttpServletRequest request){
		                                 
		        Map<String,Object> retorno = new HashMap<String,Object>();
		        
		        LOG.info(" Datos ANTES DE TRY: ");

		        try{ 
		            
		            LOG.info(" Datos DESPUES DE TRY:");
		            
		           
		            DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
		            
		            documentoAdjuntoDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
		            
		            UsuarioDTO usuarioDTO = new UsuarioDTO();
		            
		            usuarioDTO.setLogin("USU01");
		            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    

		            documentoAdjuntoDTO = documentoAdjuntoService.EliminarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);

		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

		            
		        }catch(Exception e){ 
		            
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
		            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
		            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
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
	         
	     //GUARDAR DOCUMENTO ADJUNTO
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
	     
	     @RequestMapping(value = "/abrirFrmResultadoPersonal", method = RequestMethod.GET)
	     public String abrirFrmResultadoPersonal (HttpSession sesion, Model model) {
	         //abrirFrmInspectorAutorizado(null, model);
	         try{                    
	             
	         }catch(Exception e){
	             LOG.error("Error, "+e.getMessage());
	         }                   
	         return ConstantesWeb.Navegacion.PAGE_FRM_RESULTADO_PERSONA_AUT;
	     }
	     
//-------------------------------CONSULTAR REGISTRO INDICE RIESGO----------------------------------
	     
	     @RequestMapping(value="/listarInformeIndiceRiesgo",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> listarInformeIndiceRiesgo(InformeIndiceRiesgoFilter filtro){
		        LOG.info("procesando InformeIndiceRiesgo");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<InformeIndiceRiesgoDTO> listado;
		            listado= informeIndiceRiesgoService.ListarInformeIndiceRiesgo(filtro);
		            Long contador = (long) listado.size();
		            retorno.put("filas", listado);
		            retorno.put("registros", contador);

		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		 }
	     
	     @RequestMapping(value="/consultarDocumentoAdjunto",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> consultarDocumentoAdjunto(DocumentoAdjuntoFilter filtro){
		        LOG.info("procesando InformeIndiceRiesgo");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<DocumentoAdjuntoDTO> listado;
		            listado= documentoAdjuntoService.listarDocumentoAdjunto(filtro);
		            Long contador = (long) listado.size();
		            retorno.put("filas", listado);
		            retorno.put("registros", contador);
		            
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		 }

	     @RequestMapping(value="/listarPersonasArray",method=RequestMethod.POST)
	     public @ResponseBody Map<String,Object> listarPersonasArray(InformePersonaNaturalFilter filtro){
	         LOG.info("procesando...");
	         Map<String,Object> retorno=new HashMap<String,Object>();
	         try{
	             List<InformePersonaNaturalDTO> listado;
	             listado= informePersonaNaturalService.ListarInformePersonaNatural(filtro);
	             Long contador = (long) listado.size();
		         retorno.put("filas", listado);
		         retorno.put("registros", contador);
		         
	         }catch(Exception ex){
	             LOG.error("",ex);
	         }
	         return retorno;
	     }
	     
	     @RequestMapping(value="/consultarSolicitudes",method=RequestMethod.POST)
	     public @ResponseBody Map<String,Object> consultarSolicitudes(InformeSolicitudPruebaFilter filtro){
	         LOG.info("procesando...");
	         Map<String,Object> retorno=new HashMap<String,Object>();
	         try{
	             List<InformeSolicitudPruebaDTO> listado;
	             listado= informeSolicitudPruebaService.ListarInformeSolicitudPrueba(filtro);
	             Long contador = (long) listado.size();
		         retorno.put("filas", listado);
		         retorno.put("registros", contador);
		         
	         }catch(Exception ex){
	             LOG.error("",ex);
	         }
	         return retorno;
	     }
	     
	   //-------------------------- ENCONTRAR EMPRESA ACREDITADA -----------------------------
			@RequestMapping(value="/traerDatosEmpresa",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> traerDatosEmpresa(EmpresaAcreditadaFilter filtro){
		        LOG.info("procesando traerDatosEmpresa");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<EmpresaAcreditadaDTO> listado;
		            listado= empAcredService.listarEmpAcred(filtro);
		            retorno.put("filas", listado);
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		    }
	   //------------------------ FIN ENCONTRAR EMPRESA ACREDITADA -----------------------------
	     
	   //--------------------------
			
		@Autowired
		private JavaMailSender mailSenderObj;
		
		@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
		public @ResponseBody Map<String,Object> sendEmailToClient(final @RequestParam String destino, final String mensaje, final String asunto, HttpServletRequest request) {
			
			Map<String,Object> retorno = new HashMap<String,Object>();

			mailSenderObj.send(new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {

					MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
					mimeMsgHelperObj.setTo(destino);
					mimeMsgHelperObj.setFrom("asenjochristian@gmail.com");				
					mimeMsgHelperObj.setText(mensaje);
					mimeMsgHelperObj.setSubject(asunto);
				}
			});
			System.out.println("\nMensaje de Confirmacion.... Llego con exito!\n");
			
			retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
			
			return  retorno;	
		}
		
		//-----------------------------
	     
}




