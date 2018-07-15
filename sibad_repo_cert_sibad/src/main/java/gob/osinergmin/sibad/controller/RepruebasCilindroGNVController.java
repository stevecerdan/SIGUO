package gob.osinergmin.sibad.controller;

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

import gob.osinergmin.sibad.domain.dto.CilindroGNVDTO;
import gob.osinergmin.sibad.domain.dto.DestinatarioCorreoDTO;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.domain.dto.PersAutPorTipoPruebaDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosModuloDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoVDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.TrazSolicitudDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.DestinatarioCorreoFilter;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.filter.PersAutPorTipoPruebaFilter;
import gob.osinergmin.sibad.filter.RepruebasCilindrosFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaDocumentoFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaPersonalFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaRepruebaFilter;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;
import gob.osinergmin.sibad.filter.TrazSolicitudFilter;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.CilindroService;
import gob.osinergmin.sibad.service.DestinatarioCorreoService;
import gob.osinergmin.sibad.service.DocumentoAdjuntoService;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.MaestroColumnaTipoService;
import gob.osinergmin.sibad.service.PersAutPorTipoPruebaService;
import gob.osinergmin.sibad.service.RepruebasCilindrosService;
import gob.osinergmin.sibad.service.ResultadoPruebaDocumentoService;
import gob.osinergmin.sibad.service.ResultadoPruebaPersonalService;
import gob.osinergmin.sibad.service.ResultadoPruebaRepruebaService;
import gob.osinergmin.sibad.service.SolicitudPruebaRepruebaService;
import gob.osinergmin.sibad.service.TrazSolicitudService;
import gob.osinergmin.sibad.service.UnidadSupervisadaService;
import gob.osinergmin.sibad.service.UnidadSupervisadaVService;
import gob.osinergmin.sibad.util.ConstantesWeb;

@Controller
@RequestMapping("/repruebasCilindroGNV")
public class RepruebasCilindroGNVController {
	private static final Logger LOG = LoggerFactory.getLogger(RepruebasCilindroGNVController.class);
	
	@Inject
	private RepruebasCilindrosService repCilindrosService;
	@Inject
	private MaestroColumnaTipoService maestroColumnaTipoService;
	@Inject
	private TrazSolicitudService trazsolicitudservice;
	@Inject
	private SolicitudPruebaRepruebaService solicitudPruebaRpbaservice;
	@Inject
	private EmpresaAcreditadaService empAcredService;
	@Inject
	private UnidadSupervisadaService unidadsupervisadaService;
	@Inject
	private UnidadSupervisadaVService unidadSupervisadaVService;
	@Inject
	private PersAutPorTipoPruebaService persAutPorTipoPruebaService;
	@Inject
	private ResultadoPruebaRepruebaService resultadoPruebaRepruebaService;
	@Inject
	private ResultadoPruebaPersonalService resultadoPruebaPersonalService;
	@Inject
	private ResultadoPruebaDocumentoService resultadoPruebaDocumentoService;
	@Inject
	private DocumentoAdjuntoService documentoAdjuntoService;
	@Inject
	private CilindroService cilindroService;
	@Inject
	private DestinatarioCorreoService destinatarioCorreoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model, HttpSession session, HttpServletRequest request){
		
		String j_username = "JHIDALGOM";
        session.setAttribute("j_username", j_username);	
        //----------------------------------------------------
        //----------------------------------------------------

        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_BANDEJA_REPRUEBA_CILINDRO_GNV;
	} //frmReprogramacionCancelacion
	
	@RequestMapping(value = "/abrirFrmReprogramacionCancelacion", method = RequestMethod.GET)
    public String abrirFrmReprogramacionCancelacion(HttpSession sesion, Model model){
        try{        	     	
            
        }catch(Exception e){
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_REPROGRAMACION_CANCELACION;
    }
	
	@RequestMapping(value = "/abrirFrmRegistroSolicitudRepruebaGNV", method = RequestMethod.GET)
    public String abrirFrmRegistroSolicitudRepruebaGNV(HttpSession sesion, Model model){
        try{        	     	
            
        }catch(Exception e){
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_REGISTRO_SOLICITUD_REPRUEBA;
    }
	
	@RequestMapping(value = "/abrirConfirmarSolicitudGNV", method = RequestMethod.GET)
    public String abrirConfirmarSolicitudGNV(HttpSession sesion, Model model){
        try{        	     	
            
        }catch(Exception e){
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_CONFIRMAR_SOLICITUD_GNV;
    }
	
	@RequestMapping(value="/listarRepruebasCilindros",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarRepruebasCilindros(RepruebasCilindrosFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarRepruebasCilindros");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<RepruebasCilindrosDTO> listado = repCilindrosService.listarRepruebasCilindros(filtro);
    
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<RepruebasCilindrosDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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
	
	@RequestMapping(value="/listarSolicitudPruebaReprueba",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarSolicitudPruebaReprueba(SolicitudPruebaRepruebaFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarSolicitudPruebaReprueba");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<SolicitudPruebaRepruebaDTO> listado = solicitudPruebaRpbaservice.listarSolicitudPruebaReprueba(filtro);
    
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
	
	@RequestMapping(value="/cargarRepruebasCilindros",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarRepruebasCilindros(RepruebasCilindrosFilter filtro){
        //LOG.info("procesando cargarRepruebasCilindros: " + CodigoOsinergmin + " - " + idModulo);
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<RepruebasCilindrosModuloDTO> listado;
            listado = repCilindrosService.listarCilindroxModulo(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
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
	
	@RequestMapping(value="/encontrarSolicitudUltimaEmpresa",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> encontrarSolicitudUltimaEmpresa(SolicitudPruebaRepruebaFilter filtro){
        LOG.info("procesando encontrar Solicitud");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<SolicitudPruebaRepruebaDTO> listado;
            listado= solicitudPruebaRpbaservice.listarSolicitudPruebaReprueba(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	//-------------------------- CARGAR COMBOS TIPOS -----------------------------
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
		
		@RequestMapping(value="/registrarPhgTrazSolicitud", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarPhgTrazSolicitud(@RequestParam  Long idSolicitudTraz, Long idTipoMotivo, Long idSolicitudPruebaRp,  String observacion ,String estado, Date fecha, HttpSession session,HttpServletRequest request){
	        LOG.info("procesando registrarPhgTrazOrganismo");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        LOG.info(" Antes del try catch "+idSolicitudTraz+" - "+idSolicitudPruebaRp+" - "+observacion);
	        try{ 
		        LOG.info(" Despues del try catch "+idSolicitudTraz+" - "+idSolicitudPruebaRp+" - "+observacion);
	            
		        TrazSolicitudDTO trazOrganismo = new TrazSolicitudDTO();
	            SolicitudPruebaRepruebaDTO solicitudPruebaRpbaDTO = new SolicitudPruebaRepruebaDTO();
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	        	usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            
	            trazOrganismo.setIdTrazSolicitud(idSolicitudTraz);
	            trazOrganismo.setIdSolicitudPruebaReprueba(idSolicitudPruebaRp);
	            trazOrganismo.setIdTipoMotivo(idTipoMotivo);
	            trazOrganismo.setObservacion(observacion);
	            trazOrganismo.setFechaUltimoEstado(fecha);
	            trazOrganismo.setEstado(estado);
	            solicitudPruebaRpbaDTO.setIdSolicitudPruebaReprueba(idSolicitudPruebaRp);
	            solicitudPruebaRpbaDTO.setFechaSolicitud(fecha);
	            solicitudPruebaRpbaDTO.setEstado(estado);
	            
	            LOG.info(trazOrganismo.getEstado()+" - "+trazOrganismo.getIdTipoMotivo()+" - "+ trazOrganismo.getObservacion());
	                    
	            trazOrganismo = trazsolicitudservice.RegistrarTrazSolicitud(trazOrganismo);
	            solicitudPruebaRpbaservice.RegistrarSolicitudPruebaReprueba(solicitudPruebaRpbaDTO, usuarioDTO);
	            
	            LOG.info(trazOrganismo.getEstado()+" - "+trazOrganismo.getIdTipoMotivo()+" - "+ trazOrganismo.getObservacion());
	         
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
	            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
	            
	        }catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error en guardar TRAZORGANISMO: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	    }	
		
		@RequestMapping(value="/cargarInforme",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarInforme(TrazSolicitudFilter filtro){
	        LOG.info("procesando cargarInforme");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<TrazSolicitudDTO> listado;
	            listado= trazsolicitudservice.listarTrazSolicitud(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		
		@RequestMapping(value="/registrarSolicitud", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarSolicitud(@RequestParam Long idSolicitud, Long idEmpresaAcred, String nroSolicitud, Long idTipoPrueba,  Date FechaSolicitud ,String estado, Long idCilindroGnv, HttpSession session,HttpServletRequest request){
	        LOG.info("procesando registrarSolicitud");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        LOG.info(" Antes del try catch "+idSolicitud+" - "+nroSolicitud+" - "+idTipoPrueba);
	        
	        try{ 
	        	LOG.info(" Despues del try catch "+idSolicitud+" - "+nroSolicitud+" - "+idTipoPrueba);
	            
	        	SolicitudPruebaRepruebaDTO solicitudPruebaRpbaDTO = new SolicitudPruebaRepruebaDTO();
	        	
	        	solicitudPruebaRpbaDTO.setEstado(estado);
	        	solicitudPruebaRpbaDTO.setFechaSolicitud(FechaSolicitud);
	        	solicitudPruebaRpbaDTO.setIdCilindroGNV(idCilindroGnv);
	        	solicitudPruebaRpbaDTO.setIdEmpresaAcreditada(idEmpresaAcred);
	        	solicitudPruebaRpbaDTO.setIdSolicitudPruebaReprueba(idSolicitud);
	        	solicitudPruebaRpbaDTO.setIdTipoPrueba(idTipoPrueba);
	        	solicitudPruebaRpbaDTO.setNroSolicitudUnidadSupervisa(nroSolicitud);
	        	
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	        	usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            solicitudPruebaRpbaDTO = solicitudPruebaRpbaservice.RegistrarSolicitudPruebaReprueba(solicitudPruebaRpbaDTO, usuarioDTO);
	            retorno.put("IdSolicitud", solicitudPruebaRpbaDTO.getIdSolicitudPruebaReprueba());
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
	            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
	            
	        }catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error en guardar registrarSolicitud: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	    }
		
		@RequestMapping(value="/verificarUsuarioOsinergmin",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> verificarUsuarioOsinergmin(UnidadSupervisadaFilter filtro){
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
	   //---------------------------------------- ANDERSON ---------------------------------------------------
		
	   @RequestMapping(value = "/abrirFrmRepruebaCilindrosGNV", method = RequestMethod.GET)
	    public String abrirFrmRepruebaCilindrosGNV (HttpSession sesion, Model model) {
	     
	        try{        	     	
	            
	        }catch(Exception e){
	            LOG.error("Error, "+e.getMessage());
		        }                   
		        return ConstantesWeb.Navegacion.PAGE_FRM_REPRUEBA_CILINDROS_GNV;
		}
		
	   @RequestMapping(value="/cargarOperador",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarOperador(UnidadSupervisadaFilter filtro){
	        LOG.info("procesando...");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<UnidadSupervisadaVDTO> listado;
	            listado= unidadSupervisadaVService.ListarUnidadSupervisada(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	   
	   @RequestMapping(value="/cargarInspector",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarInspector(PersAutPorTipoPruebaFilter filtro){
	        LOG.info("procesando...");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<PersAutPorTipoPruebaDTO> listado;
	            listado= persAutPorTipoPruebaService.ListarPersonalAutorizado(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	   
	   @RequestMapping(value="/consultarTablaResultadoPruebaPersonal",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> ConsultarTablaResultadoPruebaPersonal(ResultadoPruebaPersonalFilter filtro){
	        LOG.info("procesando...");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<ResultadoPruebaPersonalDTO> listado;
	            listado= resultadoPruebaPersonalService.consultarResultadoPruebaPersonal(filtro);
	            
	            Long contador = (long) listado.size();
	            
	            retorno.put("filas", listado);
	            retorno.put("registros", contador);
	            
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	   
	   
	   @RequestMapping(value="/registrarResultadoPruebaReprueba", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarResultadoPruebaReprueba(@RequestParam Long idResultadoPR, Long idSolicitudPR , Date fechaInicio,
	    		                                                                   String horaInicio,Date fechaFin, String horaFin,String codCertificado, 
	                                                                               Date fechaEmision , String resultadoRep, Date fechaGNV, Date fechaInforme,
	                                                                               String observacion,String numeroInforme, 
	                                                                               HttpSession session,HttpServletRequest request){
	                                 
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        LOG.info(" Datos ANTES DE TRY: ");
	        LOG.info(" IdResultadoPruebaReprueba:"+idResultadoPR+" - "+"idSolicitudPruebaReprueba:" +idSolicitudPR
			 +" - "+"Fecha Inicio:" +fechaInicio+" - "+"Hora Inicio:" +horaInicio+" - "+"Fecha Fin:" +fechaFin
			 +" - "+"Hora Fin:" +horaFin+" - "+"codCertificado:" +codCertificado+" - "+"Fecha Emision:" +fechaEmision
			 +" - "+"resultado Reprueba:" +resultadoRep+" - "+"Fecha GNV:" +fechaGNV+" - "+"Observacion:" +observacion+" - ");

	        try{ 
	            
	            LOG.info(" Datos DESPUES DE TRY:");
	            LOG.info(" IdResultadoPruebaReprueba:"+idResultadoPR+" - "+"idSolicitudPruebaReprueba:" +idSolicitudPR
	       			 +" - "+"Fecha Inicio:" +fechaInicio+" - "+"Hora Inicio:" +horaInicio+" - "+"Fecha Fin:" +fechaFin
	       			 +" - "+"Hora Fin:" +horaFin+" - "+"codCertificado:" +codCertificado+" - "+"Fecha Emision:" +fechaEmision
	       			 +" - "+"resultado Reprueba:" +resultadoRep+" - "+"Fecha GNV:" +fechaGNV+" - "+"Observacion:" +observacion+" - ");
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO = new ResultadoPruebaRepruebaDTO();          
	            
	            resultadoPruebaRepruebaDTO.setIdResultadoPruebaReprueba(idResultadoPR);
	            resultadoPruebaRepruebaDTO.setIdSolicitudPruebaReprueba(idSolicitudPR);
	            resultadoPruebaRepruebaDTO.setFechaInicio(fechaInicio);
	            resultadoPruebaRepruebaDTO.setHoraInicio(horaInicio);
	            resultadoPruebaRepruebaDTO.setFechaFin(fechaFin);
	            resultadoPruebaRepruebaDTO.setHoraFin(horaFin);
	            resultadoPruebaRepruebaDTO.setNumeroCertificado(codCertificado);
	            resultadoPruebaRepruebaDTO.setFechaEmisionCertificado(fechaEmision);
	            resultadoPruebaRepruebaDTO.setResultadoPrueba(resultadoRep);
	            resultadoPruebaRepruebaDTO.setFechaProximaPrueba(fechaGNV);
	            resultadoPruebaRepruebaDTO.setFechaInforme(fechaInforme);
	            resultadoPruebaRepruebaDTO.setNumeroInforme(numeroInforme);
	            resultadoPruebaRepruebaDTO.setObservacion(observacion);
	             
	            usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    
	            
               if(idResultadoPR != null) {
   	              
		            resultadoPruebaRepruebaDTO = resultadoPruebaRepruebaService.EditarResultadoPruebaReprueba(resultadoPruebaRepruebaDTO, usuarioDTO);

	            } else {
	            	 
	            	resultadoPruebaRepruebaDTO = resultadoPruebaRepruebaService.RegistrarResultadoPruebaReprueba(resultadoPruebaRepruebaDTO, usuarioDTO);
	            }
	            
	            retorno.put("idResultadoPruebaReprueba",resultadoPruebaRepruebaDTO.getIdResultadoPruebaReprueba());
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

	            
	        }catch(Exception e){ 
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar RESULTADO PRUEBA REPRUEBA: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	    }
	   
	   @RequestMapping(value="/registrarResultadoPruebaPersonal", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarResultadoPruebaPersonal(@RequestParam Long idResultadoPP,Long idResultadoPR, Long idSedePersonal, HttpSession session,HttpServletRequest request){
	                                 
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        LOG.info(" Datos ANTES DE TRY: ");

	        try{ 
	            
	            LOG.info(" Datos DESPUES DE TRY:");
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO = new ResultadoPruebaPersonalDTO();
	            
	            resultadoPruebaPersonalDTO.setIdResultadoPruebaPersonal(idResultadoPP);
	            resultadoPruebaPersonalDTO.setIdResultadoPruebaReprueba(idResultadoPR);
	            resultadoPruebaPersonalDTO.setIdSedePersonalAutorizado(idSedePersonal);
	            	             
	            usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    
	            
              if(idResultadoPP != null) {
  	              
            	    resultadoPruebaPersonalDTO = resultadoPruebaPersonalService.EditarResultadoPruebaPersonal(resultadoPruebaPersonalDTO, usuarioDTO);

	            } else {
	            	 
	            	resultadoPruebaPersonalDTO = resultadoPruebaPersonalService.RegistrarResultadoPruebaPersonal(resultadoPruebaPersonalDTO, usuarioDTO);
	            }
	            
	            retorno.put("idResultadoPruebaPersonal",resultadoPruebaPersonalDTO.getIdResultadoPruebaPersonal());
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
	   
	   @RequestMapping(value="/registrarDocumento", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarDocumento(@RequestParam("uploadfile") MultipartFile file, HttpSession session,HttpServletRequest request){
	                            
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
	   
	   @RequestMapping(value="/actualizarEstadoSolicitudPruebaReprueba", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> actualizarEstadoSolicitudPruebaReprueba(@RequestParam Long idSolicitudPruebaRp,String estado, HttpSession session,HttpServletRequest request){
	        
		    LOG.info("procesando actualizarEstadoSolicitudPruebaReprueba");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        try{ 
	            
	        	SolicitudPruebaRepruebaDTO solicitudPruebaRpbaDTO = new SolicitudPruebaRepruebaDTO();
	        	
	        	solicitudPruebaRpbaDTO.setIdSolicitudPruebaReprueba(idSolicitudPruebaRp);
	        	solicitudPruebaRpbaDTO.setEstado(estado);
	        	
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            
	        	usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            solicitudPruebaRpbaservice.RegistrarSolicitudPruebaReprueba(solicitudPruebaRpbaDTO, usuarioDTO);
	         
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
	            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
	            
	        }catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error en guardar registrarSolicitud: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	    }
	   
	   @RequestMapping(value="/actualizarEstadoCilindro", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> actualizarEstadoCilindro(@RequestParam Long idCilindro,String estado, HttpSession session,HttpServletRequest request){
	        
		    LOG.info("procesando actualizarEstadoCilindro");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        try{ 
	            
	        	CilindroGNVDTO cilindroGnvDTO = new CilindroGNVDTO();
	        	
	        	cilindroGnvDTO.setIdCilindro(idCilindro);
	        	cilindroGnvDTO.setEstado(estado);
	        	
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            
	        	usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            cilindroService.RegistrarCilindro(cilindroGnvDTO, usuarioDTO);
	         
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
	   
	   @RequestMapping(value="/listarResultadoPruebaReprueba",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> listarResultadoPruebaReprueba(ResultadoPruebaRepruebaFilter filtro){
	        LOG.info("procesando...");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<ResultadoPruebaRepruebaDTO> listado;
	            listado= resultadoPruebaRepruebaService.listarResultadoPruebaReprueba(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	   
	   
	   @RequestMapping(value="/listarDocumentosArray",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> listarDocumentosArray(ResultadoPruebaDocumentoFilter filtro){
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
		
	   @RequestMapping(value="/eliminarResultadoPruebaDocumento", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> eliminarResultadoPruebaDocumento(@RequestParam Long idResultadoPruebaDocumento, HttpSession session,HttpServletRequest request){
	                                 
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        LOG.info(" Datos ANTES DE TRY: ");

	        try{ 
	            
	            LOG.info(" Datos DESPUES DE TRY:");
	            
	           
	            ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO = new ResultadoPruebaDocumentoDTO();
	            
	            resultadoPruebaDocumentoDTO.setIdResultadoPruebaDocumento(idResultadoPruebaDocumento);
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            
	            usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    

	            resultadoPruebaDocumentoDTO = resultadoPruebaDocumentoService.EliminarResultadoPruebaDocumento(resultadoPruebaDocumentoDTO, usuarioDTO);

	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

	            
	        }catch(Exception e){ 
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
	            e.printStackTrace();
	            
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
		
  //-------------------------- ENCONTRAR PLANTILLA DE CORREO + PERSONAL DESTINATARIO -----------------------------
		@RequestMapping(value="/traerPlantillaPersonal",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> traerPlantillaPersonal(DestinatarioCorreoFilter filtro){
	        LOG.info("procesando traerPlantillaPersonal");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<DestinatarioCorreoDTO> listado;
	            listado= destinatarioCorreoService.listarDestinatarioCorreo(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
   //------------------------ FIN ENCONTRAR PLANTILLA DE CORREO + PERSONAL DESTINATARIO -----------------------------
    
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
