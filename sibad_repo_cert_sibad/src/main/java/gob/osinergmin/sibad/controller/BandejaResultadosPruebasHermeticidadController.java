package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.service.AlmacenaCompartiProdService;
import gob.osinergmin.sibad.service.DocumentoAdjuntoService;
import gob.osinergmin.sibad.service.EquipoCertificadoService;
import gob.osinergmin.sibad.service.EquipoComponenteService;
import gob.osinergmin.sibad.service.MaestroColumnaTipoService;
import gob.osinergmin.sibad.service.PersAutPorTipoPruebaService;
import gob.osinergmin.sibad.service.ResultadoPruebaDocumentoService;
import gob.osinergmin.sibad.service.ResultadoPruebaEquipoCompService;
import gob.osinergmin.sibad.service.ResultadoPruebaPersonalService;
import gob.osinergmin.sibad.service.ResultadoPruebaRepruebaService;
import gob.osinergmin.sibad.service.SedePersonalAutorizadoService;
import gob.osinergmin.sibad.service.SolicitudPruebaRepruebaService;
import gob.osinergmin.sibad.service.TipoEquipoService;
import gob.osinergmin.sibad.service.TrazSolicitudService;
import gob.osinergmin.sibad.service.UnidadSupervisadaService;
import gob.osinergmin.sibad.service.UnidadSupervisadaVService;
import gob.osinergmin.sibad.domain.dto.AlmacenaCompartiProdDTO;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.EquipoCertificadoDTO;
import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.domain.dto.PersAutPorTipoPruebaDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoVDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaEquipoCompDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.TipoEquipoDTO;
import gob.osinergmin.sibad.domain.dto.TrazSolicitudDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlmacenaCompartiProdFilter;
import gob.osinergmin.sibad.filter.DocumentoAdjuntoFilter;
import gob.osinergmin.sibad.filter.EquipoCertificadoFilter;
import gob.osinergmin.sibad.filter.EquipoComponenteFilter;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.filter.PersAutPorTipoPruebaFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaDocumentoFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaEquipoCompFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaPersonalFilter;
import gob.osinergmin.sibad.filter.ResultadoPruebaRepruebaFilter;
import gob.osinergmin.sibad.filter.SedePersonalAutorizadoFilter;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;
import gob.osinergmin.sibad.filter.TipoEquipoFilter;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/resultadosPruebasHermeticidad")
public class BandejaResultadosPruebasHermeticidadController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BandejaResultadosPruebasHermeticidadController.class);
	
	@Inject
	private UnidadSupervisadaService unidadsupervisadaService;
	@Inject
	private SolicitudPruebaRepruebaService solicitudPruebaRepruebaService;
	@Inject
	private ResultadoPruebaRepruebaService resultadoPruebaRepruebaService;
	@Inject
	private DocumentoAdjuntoService documentoadjuntoService;
	@Inject
	private MaestroColumnaTipoService maestroColumnaTipoService;
	@Inject
	private TrazSolicitudService trazsolicitudservice;
	@Inject
	private PersAutPorTipoPruebaService persAutPorTipoPruebaService;
	@Inject
	private AlmacenaCompartiProdService almacenaCompartiProdService;
	@Inject
	private SedePersonalAutorizadoService SedepersonalautorizadoService;
	@Inject
	private TipoEquipoService tipoEquipoService;
	@Inject
	private EquipoComponenteService equipoComponenteService;
	@Inject
	private EquipoCertificadoService equipoCertificadoService;
	@Inject
	private ResultadoPruebaPersonalService resultadoPruebaPersonalService;
	@Inject
	private UnidadSupervisadaVService unidadSupervisadaVService;
	@Inject
	private ResultadoPruebaDocumentoService resultadoPruebaDocumentoService;
	@Inject
	private DocumentoAdjuntoService documentoAdjuntoService;
	@Inject
	private ResultadoPruebaEquipoCompService resultadoPruebaEquipoCompService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model, HttpSession session, HttpServletRequest request){
		
		String j_username = "JHIDALGOM";
        session.setAttribute("j_username", j_username);
        //----------------------------------------------------
        //----------------------------------------------------

        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_BANDEJA_RESULTADOS_PRUEBA_HERMETICIDAD;
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
	
	@RequestMapping(value="/listarCompartimientosXResultado",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarCompartimientosXResultado(AlmacenaCompartiProdFilter filtro, int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarCompartimientosXResultado");
    	
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
	
	//--------------------------------------------------------------------------
	
	@RequestMapping(value = "/abrirFrmResultadoPruebaHermeticidad", method = RequestMethod.GET)
    public String abrirFrmResultadoPruebaHermeticidad (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_RESULTADO_PRUEBA_HERMETICIDAD;
    }
	
	@RequestMapping(value = "/abrirEstadoReprogCancel", method = RequestMethod.GET)
    public String abrirEstadoReprogCancel (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_ESTADO_REPROG_CANCEL;
    }
		
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
		
	//-------------------------- ENCONTRAR ULTIMO RESULTADO DE UNA EMPRESA -----------------------------
		@RequestMapping(value="/encontrarUltimoResultadoPH",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> encontrarUltimoResultadoPH(SolicitudPruebaRepruebaFilter filtro){
	        LOG.info("procesando encontrar Ultimo Resultado");
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
	//------------------------ FIN ENCONTRAR ULTIMO RESULTADO DE UNA EMPRESA -----------------------------
		
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
			
	//-------------------------- FIN CARGAR COMBOS TIPOS -----------------------------
			
	//-------------------------- CARGAR COMBOS INSPECTOR -----------------------------
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
			
	//-------------------------- FIN CARGAR COMBOS INSPECTOR -----------------------------
	
	//-------------------------- CARGAR TIPO EQUIPO -----------------------------
		@RequestMapping(value="/cargarTipoEquipo",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarTipoEquipo(TipoEquipoFilter filtro){
	        LOG.info("procesando cargarTipoEquipo");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<TipoEquipoDTO> listado;
	            listado= tipoEquipoService.listarTipoEquipo(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		
	//-------------------------- FIN CARGAR TIPO EQUIPO -----------------------------
		
	//-------------------------- CARGAR EQUIPO -----------------------------
		@RequestMapping(value="/cargarEquipo",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarEquipo(EquipoCertificadoFilter filtro){
	        LOG.info("procesando cargarEquipoCertificado");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<EquipoCertificadoDTO> listado;
	            listado= equipoCertificadoService.listarEquipoCertificado(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		
	//-------------------------- FIN CARGAR EQUIPO -----------------------------
		
	//-------------------------- CARGAR EQUIPO COMPONENTE -----------------------------
		@RequestMapping(value="/cargarEquipoComponente",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarEquipoComponente(EquipoComponenteFilter filtro){
	        LOG.info("procesando cargarEquipoComponente");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<EquipoComponenteDTO> listado;
	            listado= equipoComponenteService.listarEquipoComponente(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		
	//-------------------------- FIN CARGAR EQUIPO COMPONENTE -----------------------------
		
	//-------------------------- CONSULTAR RESULTADO PRUEBA REPRUEBA -----------------------------
		@RequestMapping(value="/consultarResultadoPruebaReprueba",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> consultarResultadoPruebaReprueba(ResultadoPruebaRepruebaFilter filtro){
	        LOG.info("procesando consultarResultadoPersonal");
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
		
	//-------------------------- FIN CONSULTAR RESULTADO PRUEBA REPRUEBA -----------------------------
		
	//-------------------------- CONSULTAR RESULTADO PERSONAL -----------------------------
		@RequestMapping(value="/consultarResultadoPersonal",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> consultarResultadoPersonal(ResultadoPruebaPersonalFilter filtro){
	        LOG.info("procesando consultarResultadoPersonal");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<ResultadoPruebaPersonalDTO> listado;
	            listado= resultadoPruebaPersonalService.consultarResultadoPruebaPersonalV(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		
	//-------------------------- FIN CONSULTAR RESULTADO PERSONAL -----------------------------
		
	//-------------------------- CONSULTAR RESULTADO DOCUMENTO -----------------------------
		
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
		
	//-------------------------- FIN CONSULTAR RESULTADO DOCUMENTO -----------------------------
		
	//-------------------------- CONSULTAR RESULTADO EQUIPO COMPONENTE -----------------------------
		
		@RequestMapping(value="/consultarResultadoEquipoComp",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> consultarResultadoEquipoComp(ResultadoPruebaEquipoCompFilter filtro){
	        LOG.info("procesando...");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<ResultadoPruebaEquipoCompDTO> listado;
	            listado= resultadoPruebaEquipoCompService.consultarResultadoPruebaEquipoComp(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	//-------------------------- FIN CONSULTAR RESULTADO EQUIPO COMPARTIMIENTO -----------------------------
		
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
	                    
	            trazOrganismo = trazsolicitudservice.RegistrarTrazSolicitud(trazOrganismo);
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
		
		//-------------------------- CARGAR SEDE PERSONAL AUTORIZADO -----------------------------
				@RequestMapping(value="/cargarSedePersonalAutorizado",method=RequestMethod.POST)
			    public @ResponseBody Map<String,Object> cargarSedePersonalAutorizado(SedePersonalAutorizadoFilter filtro){
			        LOG.info("procesando cargar Sede Personal Autorizado");
			        Map<String,Object> retorno=new HashMap<String,Object>();
			        try{
			            List<SedePersonalAutorizadoDTO> listado;
			            listado= SedepersonalautorizadoService.listarSedePersonalAutorizado(filtro);
			            retorno.put("filas", listado);
			        }catch(Exception ex){
			            LOG.error("",ex);
			        }
			        return retorno;
			    }
		//--------------------------- FIN CARGAR SEDE PERSONAL AUTORIZADO ----------------------------
				
		//--------------------------- CARGAR DATOS DE UNIDAD / EMPRESA SUPERVISADA --------------------------

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
			
		//--------------------------- FIN CARGAR DATOS DE UNIDAD / EMPRESA SUPERVISADA --------------------------
			
		//----------------------------------- REGISTRAR RESULTADO PRUEBA REPRUEBA ---------------------------------
			
			@RequestMapping(value="/registrarResultadoPruebaReprueba", method= RequestMethod.POST)
		    public @ResponseBody Map<String,Object> registrarResultadoPruebaReprueba(@RequestParam Long idResultadoPR, Long idSolicitudPR , String flagResultadoFinal,
		    		                                                                   String resultadoPrueba,Date fechaInicio,String horaInicio,Date fechaFin, String horaFin, String estadoResultadoC,
		    		                                                                   String estadoResultadoT,String numCertificado, String numInforme, String observacion, 
		                                                                               HttpSession session,HttpServletRequest request){
		                                 
		        Map<String,Object> retorno = new HashMap<String,Object>();
		         
	       
		        	LOG.info(" Datos ANTES DE TRY: ");

		        try{ 
		            
		            LOG.info(" Datos DESPUES DE TRY:");
		            
		            UsuarioDTO usuarioDTO = new UsuarioDTO();
		            ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO = new ResultadoPruebaRepruebaDTO();          
		            
		            resultadoPruebaRepruebaDTO.setIdResultadoPruebaReprueba(idResultadoPR);
		            resultadoPruebaRepruebaDTO.setIdSolicitudPruebaReprueba(idSolicitudPR);
		            resultadoPruebaRepruebaDTO.setFechaInicio(fechaInicio);
		            resultadoPruebaRepruebaDTO.setHoraInicio(horaInicio);
		            resultadoPruebaRepruebaDTO.setFechaFin(fechaFin);
		            resultadoPruebaRepruebaDTO.setHoraFin(horaFin);
		            resultadoPruebaRepruebaDTO.setNumeroCertificado(numCertificado);
		            resultadoPruebaRepruebaDTO.setNumeroInforme(numInforme);
		            resultadoPruebaRepruebaDTO.setFlagResultadoCompartimiento(estadoResultadoC);
		            resultadoPruebaRepruebaDTO.setFlagResutadoTuberia(estadoResultadoT);
		            resultadoPruebaRepruebaDTO.setFlagResultadoFinal(flagResultadoFinal);
		            resultadoPruebaRepruebaDTO.setResultadoPrueba(resultadoPrueba);
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
			
		//----------------------------------- FIN REGISTRAR RESULTADO PRUEBA REPRUEBA ---------------------------------	
			
		//----------------------------------- ACTUALIZAR ESTADO - SOLICITUD PRUEBA REPRUEBA ---------------------------------
			
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
			            
			            solicitudPruebaRepruebaService.RegistrarSolicitudPruebaReprueba(solicitudPruebaRpbaDTO, usuarioDTO);
			         
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
			
		//----------------------------------- FIN ACTUALIZAR ESTADO - SOLICITUD PRUEBA REPRUEBA ---------------------------------
			
		//----------------------------------- REGISTRAR TRAZABILIDAD SOLICITUD PRUEBA REPRUEBA ---------------------------------
			
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
		            solicitudPruebaRpbaDTO.setEstado(estado);
		            
		            LOG.info(trazOrganismo.getEstado()+" - "+trazOrganismo.getIdTipoMotivo()+" - "+ trazOrganismo.getObservacion());
		                    
		            trazOrganismo = trazsolicitudservice.RegistrarTrazSolicitud(trazOrganismo);
		            solicitudPruebaRepruebaService.RegistrarSolicitudPruebaReprueba(solicitudPruebaRpbaDTO, usuarioDTO);
		            
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
	//----------------------------------- FIN REGISTRAR TRAZABILIDAD SOLICITUD PRUEBA REPRUEBA ---------------------------------
			
	//-------------------------------------- REGISTRAR DOCUMENTO ADJUNTO ------------------------------------
			
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
	                    documentoAdjuntoDTO.setEstadoDocumento("1");
	                    
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
		 
	//-------------------------------------- FIN REGISTRAR DOCUMENTO ADJUNTO ------------------------------------
		 
	//-------------------------------------- REGISTRAR RESULTADO DOCUMENTO ------------------------------------
			   
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
		
	//-------------------------------------- FIN REGISTRAR RESULTADO DOCUMENTO ------------------------------------
		
	//-------------------------------------- REGISTRAR RESULTADO PERSONAL AUTORIZADO ------------------------------------
	   
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
		
	//-------------------------------------- FIN REGISTRAR RESULTADO PERSONAL AUTORIZADO ------------------------------------
		
	//-------------------------------------- REGISTRAR RESULTADO EQUIPO COMPONENTE ------------------------------------
		
		@RequestMapping(value="/registrarResultadoPruebaEquipo", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarResultadoPruebaEquipo(@RequestParam Long idResultadoPE,Long idResultadoPR, Long idEquipoComponente, HttpSession session,HttpServletRequest request){
	                                 
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        LOG.info(" Datos ANTES DE TRY: ");

	        try{ 
	            
	            LOG.info(" Datos DESPUES DE TRY:");
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO = new ResultadoPruebaEquipoCompDTO();
	            
	            resultadoPruebaEquipoCompDTO.setIdResultadoPruebaEquipoComp(idResultadoPE);
	            resultadoPruebaEquipoCompDTO.setIdEquipoComponente(idEquipoComponente);
	            resultadoPruebaEquipoCompDTO.setIdResultadoPruebaReprueba(idResultadoPR);
	             
	            usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    
	           		           
	            	 
	            resultadoPruebaEquipoCompDTO =  resultadoPruebaEquipoCompService.RegistrarResultadoPruebaEquipoComp(resultadoPruebaEquipoCompDTO, usuarioDTO);			            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

	            
	        }catch(Exception e){ 
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	   }
		
	//-------------------------------------- FIN REGISTRAR RESULTADO EQUIPO COMPONENTE ------------------------------------
		
	//-------------------------------------- ELIMINAR DOCUMENTO ADJUNTO ------------------------------------
		
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
	
	//-------------------------------------- FIN ELIMINAR DOCUMENTO ADJUNTO ------------------------------------
		
	//-------------------------------------- ELIMINAR RESULTADO DOCUMENTO ------------------------------------
		
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
	   
	 //-------------------------------------- FIN ELIMINAR RESULTADO DOCUMENTO ------------------------------------
	   
	 //-------------------------------------- ELIMINAR RESULTADO PERSONAL ------------------------------------
	   
	   @RequestMapping(value="/eliminarResultadoPruebaPersonal", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> eliminarResultadoPruebaPersonal(@RequestParam Long idResultadoPruebaPersonal, HttpSession session,HttpServletRequest request){
	                                 
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        LOG.info(" Datos ANTES DE TRY: ");

	        try{ 
	            
	            LOG.info(" Datos DESPUES DE TRY:");
	            
	           
	            ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO = new ResultadoPruebaPersonalDTO();
	            
	            resultadoPruebaPersonalDTO.setIdResultadoPruebaPersonal(idResultadoPruebaPersonal);
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            
	            usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    

	            resultadoPruebaPersonalDTO = resultadoPruebaPersonalService.EliminarResultadoPruebaPersonal(resultadoPruebaPersonalDTO, usuarioDTO);

	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

	            
	        }catch(Exception e){ 
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	   }
	   
	 //-------------------------------------- FIN ELIMINAR RESULTADO PERSONAL ------------------------------------

	 //-------------------------------------- ELIMINAR RESULTADO EQUIPO COMPONENTE ------------------------------------
	   
	   @RequestMapping(value="/eliminarResultadoPruebaEquipo", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> eliminarResultadoPruebaEquipo(@RequestParam Long idResultadoPruebaEquipo, HttpSession session,HttpServletRequest request){
	                                 
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        LOG.info(" Datos ANTES DE TRY: ");

	        try{ 
	            
	            LOG.info(" Datos DESPUES DE TRY:");
	            
	           
	            ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO = new ResultadoPruebaEquipoCompDTO();
	            
	            resultadoPruebaEquipoCompDTO.setIdResultadoPruebaEquipoComp(idResultadoPruebaEquipo);
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            
	            usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());    

	            resultadoPruebaEquipoCompDTO = resultadoPruebaEquipoCompService.EliminarResultadoPruebaEquipoComp(resultadoPruebaEquipoCompDTO, usuarioDTO);

	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

	            
	        }catch(Exception e){ 
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	   }
	   
	 //-------------------------------------- FIN ELIMINAR RESULTADO EQUIPO COMPONENTE ------------------------------------

}




