package gob.osinergmin.sibad.controller;

import gob.osinergmin.mdicommon.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.ArchivoSupervisionDTO;
import gob.osinergmin.sibad.domain.dto.CabeceraNpsDsrDshlDTO;
import gob.osinergmin.sibad.domain.dto.DetalleNpsDshlDTO;
import gob.osinergmin.sibad.domain.dto.DetalleNpsDsrDTO;
import gob.osinergmin.sibad.domain.dto.FiltroArchivoNpsDTO;
import gob.osinergmin.sibad.domain.dto.FiltroArchivoPdfNpsDTO;
import gob.osinergmin.sibad.domain.dto.FiltroDetalleNpsDshlDTO;
import gob.osinergmin.sibad.domain.dto.FiltroDetalleNpsDsrDTO;
import gob.osinergmin.sibad.domain.dto.FiltroNpsDsrDshlDTO;
import gob.osinergmin.sibad.domain.dto.FiltroPersonalSupervisionDTO;
import gob.osinergmin.sibad.domain.dto.PersonalSupervisionDTO;
import gob.osinergmin.sibad.domain.dto.UnidadOperativaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.SupervisionService;
import gob.osinergmin.sibad.service.exception.NpsException;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.ConstantesWeb;
import gob.osinergmin.sibad.util.FechaUtil;
import gob.osinergmin.sibad.util.PropertyUtils;
import gob.osinergmin.sibad.util.ResponseUtil;
import gob.osinergmin.sibad.util.StringUtil;
import gob.osinergmin.sibad.util.ZipUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping("/bandejaSupervision")
public class BandejaSupervisionController extends SibadController{
    
    private static final Logger LOG = LoggerFactory.getLogger(BandejaSupervisionController.class);

    @Inject
    private SupervisionService supervisionService;
    
    @Value("${ruta_archivos_temporales}")
    private String rutaTemporales;

    @RequestMapping(method = RequestMethod.POST)
    public String inicio(Model model, HttpServletRequest request, HttpSession session) {
        LOG.info("BandejaSupervisionController - inicio");
        String path = "";
        UsuarioDTO usuarioSesion = (UsuarioDTO)session.getAttribute(Constantes.SESION_USUARIO);
        UnidadOperativaDTO unidadOperativa = (UnidadOperativaDTO)session.getAttribute(Constantes.SESION_UNIDAD_OPERATIVA);
        if((usuarioSesion != null) && !usuarioSesion.getLogin().equals("")){
    		model.addAttribute("unidad", unidadOperativa);
    		model.addAttribute("usuario", usuarioSesion.getNombre());
	        model.addAttribute("fecha", ConstantesWeb.getFECHA());
	        session.setAttribute("TOKEN", resetCSRFToken());
	        path = ConstantesWeb.Navegacion.PAGE_BANDEJA_SUPERVISION;
    	}else{
    		LOG.info("La sesión ha expirado");
    		path = "error";
    	}
        return path;
    }
    
    @SuppressWarnings("unchecked")
	protected void afterStart(){	    			    			    					
    	getMap().put("fecha", ConstantesWeb.getFECHA());
        setPath(ConstantesWeb.Navegacion.PAGE_BANDEJA_SUPERVISION);
    }
    
    private FiltroNpsDsrDshlDTO formatFilter(FiltroNpsDsrDshlDTO filtro){
		if(filtro!=null){
			if(!StringUtil.isEmpty(filtro.getCodigoOsinergmin())){
				filtro.setCodigoOsinergmin(StringUtil.fixer(filtro.getCodigoOsinergmin()));
			}
			if(!StringUtil.isEmpty(filtro.getRegistroHidrocarburos())){
				filtro.setRegistroHidrocarburos(StringUtil.fixer(filtro.getRegistroHidrocarburos()));
			}
			if(!StringUtil.isEmpty(filtro.getPeriodoSupervision())){
				filtro.setPeriodoSupervision(StringUtil.fixer(filtro.getPeriodoSupervision()));
			}
			if(!StringUtil.isEmpty(filtro.getNumeroExpediente())){
				filtro.setNumeroExpediente(StringUtil.fixer(filtro.getNumeroExpediente()));
			}
			if(!StringUtil.isEmpty(filtro.getNumeroOrdenServicio())){
				filtro.setNumeroOrdenServicio(StringUtil.fixer(filtro.getNumeroOrdenServicio()));
			}
		}
		return filtro;
	}

    @RequestMapping(value = "/findNpsListado", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> findNpsListado(Long varLista, FiltroNpsDsrDshlDTO filtro, int rows, int page, HttpSession session) throws Exception {
    	LOG.info("BandejaSupervisionController - findNpsListado");
    	Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
            if(varLista == 1){
            	UnidadSupervisadaDTO unidadSupervisada = (UnidadSupervisadaDTO)session.getAttribute(Constantes.SESION_UNIDAD_SUPERVISADA);
            	
            	List<CabeceraNpsDsrDshlDTO> listaCabecera = new ArrayList<CabeceraNpsDsrDshlDTO>();
            	if(unidadSupervisada != null && unidadSupervisada.getCodigosOsinergminPermitidos() != null && unidadSupervisada.getCodigosOsinergminPermitidos().size() > 0){
            		filtro = this.formatFilter(filtro);
            		filtro.setCodigosOsinergminPermitidos(unidadSupervisada.getCodigosOsinergminPermitidos());
    				if(unidadSupervisada.getIdUnidadOrganica() != null){
    					if(unidadSupervisada.getIdUnidadOrganica().toString().equals(Constantes.ID_UNIDAD_ORGANICA_DSHL)){
            				listaCabecera = supervisionService.listaCabeceraNpsDshl(filtro);
            			}else if(unidadSupervisada.getIdUnidadOrganica().toString().equals(Constantes.ID_UNIDAD_ORGANICA_DSR)){
            				listaCabecera = supervisionService.listaCabeceraNpsDsr(filtro);
            			}
    				}
    			}
    			
		        Long contador = new Long(listaCabecera.size());
				int indiceInicial = (page - 1) * rows;
				int indiceFinal = indiceInicial + rows;
				List<CabeceraNpsDsrDshlDTO> listaPaginada = listaCabecera
						.subList(
								indiceInicial,
								indiceFinal > listaCabecera.size() ? listaCabecera
										.size() : indiceFinal);
				Long numeroPaginas = (contador / rows);
				if ((contador % rows) > 0) {
					numeroPaginas = numeroPaginas + 1L;
				}
	        	listaResultado.put("total", numeroPaginas);
	        	listaResultado.put("pagina", page);
	        	listaResultado.put("registros", contador);
	        	listaResultado.put("filas", listaPaginada);
            }
        }catch(NpsException ex){
        	LOG.error("Error al obtener supervisiones.", ex);
        	throw ex;
        }catch(Exception ex){
        	LOG.error("Error al obtener supervisiones.", ex);
        	throw new Exception("Ocurrió un error al obtener las supervisiones");
        }
        return listaResultado;
    }
    
    @RequestMapping(value = "/openNpsDetalle", method = RequestMethod.POST)
    public String openNpsDetalle(Model model, CabeceraNpsDsrDshlDTO cabecera, HttpSession session) {
    	LOG.info("BandejaSupervisionController - openNpsDetalle");
    	String path = "";
    	try{
    		UsuarioDTO usuarioSesion = (UsuarioDTO)session.getAttribute(Constantes.SESION_USUARIO);
            UnidadOperativaDTO unidadOperativa = (UnidadOperativaDTO)session.getAttribute(Constantes.SESION_UNIDAD_OPERATIVA);
            if((usuarioSesion != null) && !usuarioSesion.getLogin().equals("")){
        		model.addAttribute("unidad", unidadOperativa);
        		model.addAttribute("usuario", usuarioSesion.getNombre());
    	        model.addAttribute("fecha", ConstantesWeb.getFECHA());
    	        session.setAttribute("TOKEN", resetCSRFToken());
    	        path = ConstantesWeb.Navegacion.PAGE_DETALLE_SUPERVISION;
    	        //datos de cabecera de la supervisión
    	        model.addAttribute("idSupervision", cabecera.getIdSupervision());
        		model.addAttribute("codigoOsinergmin", cabecera.getCodigoOsinergmin());
        		model.addAttribute("registroHidrocarburos", cabecera.getRho());
        		model.addAttribute("numeroExpediente", cabecera.getNroExpediente());
        		model.addAttribute("numeroOrdenServicio", cabecera.getNroOrdenServicio());
        		model.addAttribute("codigoActividad", cabecera.getCodigoActividad());
        		model.addAttribute("nombreActividad", cabecera.getNombreActividad());
        		model.addAttribute("fechaInicioSupervision", cabecera.getFechaInicioSupervisionString());
        		model.addAttribute("fechaFinSupervision", cabecera.getFechaFinSupervisionString());
        		model.addAttribute("tipoSupervision", cabecera.getTipoSupervision());
        		model.addAttribute("codigoResultado", cabecera.getCodigoResultado());
        		model.addAttribute("nombreResultado", cabecera.getResultado());
        		model.addAttribute("codigoMedidaSeguridadEjecutada", cabecera.getCodigoMedidaSeguridadEjecutada());
        		model.addAttribute("nombreMedidaSeguridadEjecutada", cabecera.getNombreMedidaSeguridadEjecutada());
        		model.addAttribute("productosScopSuspendidos", cabecera.getProductosScopSuspendidos());
        		model.addAttribute("nombreEmpresaSupervisora", cabecera.getNombreEmpresaSupervisora());
        		model.addAttribute("nombreSupervisor", cabecera.getNombreSupervisor());
        		model.addAttribute("nombreEspecialistaOsinergmin", cabecera.getNombreEspecialistaOsinergmin());
        		model.addAttribute("nombreUnidadOrganicaOsinergmin", cabecera.getNombreUnidadOrganicaOsinergmin());
        		model.addAttribute("fechaLimiteMedidaSeguridadEjecutada", cabecera.getFechaLimiteMedidaSeguridadEjecutadaString());
        		//para validar carga de detalle para DSHL
        		String esSupervisionDshl = "";
        		String mostrarGrilla = "0";
    			String mensajeNoResultado = "";
        		UnidadSupervisadaDTO unidadSupervisada = (UnidadSupervisadaDTO)session.getAttribute(Constantes.SESION_UNIDAD_SUPERVISADA);
            	if(unidadSupervisada != null && unidadSupervisada.getIdUnidadOrganica() != null){
            		if(unidadSupervisada.getIdUnidadOrganica().toString().equals(Constantes.ID_UNIDAD_ORGANICA_DSHL)){
            			esSupervisionDshl = "1";
            			try {
                			if(cabecera.getResultado() != null && cabecera.getResultado().trim().toUpperCase().equals(Constantes.PVO_SUPERVISION_CON_INCUMPLIMIENTOS)){
                				List<DocumentoAdjuntoDTO> listado = supervisionService.listarDocumentosSiged(cabecera.getNroExpediente());	            	            
                	            if(!CollectionUtils.isEmpty(listado)){            	
                	            	for(DocumentoAdjuntoDTO dadto2 : listado){
                	            		if(dadto2.getFirmado() != null && dadto2.getFirmado().equals('S') && 
                	            				dadto2.getIdTipoDocumento() != null && (Constantes.SIGED_PVO_DOCUMENTO_OFICIO_INICIO_PAS).equals(dadto2.getIdTipoDocumento().getIdMaestroColumna())){
                	            			mostrarGrilla = "1";
                	            			break;
                	            		}            		
                	            	}            	
                	            } 
                	            if("0".equals(mostrarGrilla)){
                					mensajeNoResultado = PropertyUtils.getProperty("dshl.detalle.mensaje1");
                				}
                			}else if(cabecera.getResultado() != null && cabecera.getResultado().trim().toUpperCase().equals(Constantes.PVO_SUPERVISION_SIN_INCUMPLIMIENTOS)){
                				List<DocumentoAdjuntoDTO> listado = supervisionService.listarDocumentosSiged(cabecera.getNroExpediente());	            	            
                	            if(!CollectionUtils.isEmpty(listado)){            	
                	            	for(DocumentoAdjuntoDTO dadto2 : listado){
                	            		if(dadto2.getFirmado() != null && dadto2.getFirmado().equals('S') && 
                	            				dadto2.getIdTipoDocumento() != null && (Constantes.SIGED_PVO_DOCUMENTO_ARCHIVO_INSTRUCCION_PRELIMINAR).equals(dadto2.getIdTipoDocumento().getIdMaestroColumna())){
                	            			mensajeNoResultado = PropertyUtils.getProperty("dshl.detalle.mensaje2");	            			
                	            		}            		
                	            	}    
                	            	if(mensajeNoResultado.equals("")){
                	            		mensajeNoResultado = PropertyUtils.getProperty("dshl.detalle.mensaje1");
                	            	}
                	            }else{
                	            	mensajeNoResultado = PropertyUtils.getProperty("dshl.detalle.mensaje1");
                	            }
                			}
                			model.addAttribute(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                			model.addAttribute("esSupervisionDshl", esSupervisionDshl);
                			model.addAttribute("mostrarGrilla", mostrarGrilla);
                			model.addAttribute("mensajeNoResultado", mensajeNoResultado);
                		}catch(NpsException ex){
                			model.addAttribute(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                			model.addAttribute(ConstantesWeb.VV_MENSAJE, ex.getMessage());
                		}catch(Exception ex){
                			LOG.error("Error al cargar archivos de supervisión.", ex);
                			model.addAttribute(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                			model.addAttribute(ConstantesWeb.VV_MENSAJE, "Ocurrió un error al traer los resultados");		    		    
                		}
            		}else{
            			esSupervisionDshl = "0";
            			mostrarGrilla = "1";
            			model.addAttribute(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        				model.addAttribute("esSupervisionDshl", esSupervisionDshl);
        				model.addAttribute("mostrarGrilla", mostrarGrilla);
            			model.addAttribute("mensajeNoResultado", mensajeNoResultado);
            		}
    			}else{
    				model.addAttribute(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
    				model.addAttribute("esSupervisionDshl", esSupervisionDshl);
    				model.addAttribute("mostrarGrilla", mostrarGrilla);
        			model.addAttribute("mensajeNoResultado", mensajeNoResultado);
    			}
        	}else{
        		LOG.info("La sesión ha expirado");
        		path = "error";
        	}
        }catch(Exception ex){
        	LOG.error("Error al obtener el detalle de la supervisión", ex);
        	path = "error";
        }
    	model.addAttribute("estiloResultado", estiloResultado(cabecera));
        return path;
    }
    
    @RequestMapping(value = "/filasDetalleDshl", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> filasDetalleDshl(Long varLista, FiltroDetalleNpsDshlDTO filtro, int rows, int page, HttpSession session) throws Exception {
    	LOG.info("BandejaSupervisionController - filasDetalleDshl");
    	Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
            if(varLista == 1){
            	List<DetalleNpsDshlDTO> detalles = supervisionService.listaDetalleNpsDshl(filtro);
            	if(detalles == null){
            		detalles = new ArrayList<DetalleNpsDshlDTO>();
            	}
    			
		        Long contador = new Long(detalles.size());
				int indiceInicial = (page - 1) * rows;
				int indiceFinal = indiceInicial + rows;
				List<DetalleNpsDshlDTO> listaPaginada = detalles
						.subList(
								indiceInicial,
								indiceFinal > detalles.size() ? detalles
										.size() : indiceFinal);
				Long numeroPaginas = (contador / rows);
				if ((contador % rows) > 0) {
					numeroPaginas = numeroPaginas + 1L;
				}
	        	listaResultado.put("total", numeroPaginas);
	        	listaResultado.put("pagina", page);
	        	listaResultado.put("registros", contador);
	        	listaResultado.put("filas", listaPaginada);
            }
        }catch(NpsException ex){
        	LOG.error("Error al obtener detalle de la supervisión.", ex);
        	throw ex;
        }catch(Exception ex){
        	LOG.error("Error al obtener detalle de la supervisión.", ex);
        	throw new Exception("Ocurrió un error al obtener el detalle de la supervisión");
        }
        return listaResultado;
    }
    
    @RequestMapping(value = "/filasDetalleDsr", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> filasDetalleDsr(Long varLista, FiltroDetalleNpsDsrDTO filtro, int rows, int page, HttpSession session) throws Exception {
    	LOG.info("BandejaSupervisionController - filasDetalleDsr");
    	Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
            if(varLista == 1){
            	List<DetalleNpsDsrDTO> detalles = supervisionService.listaDetalleNpsDsr(filtro);
            	if(detalles == null){
            		detalles = new ArrayList<DetalleNpsDsrDTO>();
            	}
            	
		        Long contador = new Long(detalles.size());
				int indiceInicial = (page - 1) * rows;
				int indiceFinal = indiceInicial + rows;
				List<DetalleNpsDsrDTO> listaPaginada = detalles
						.subList(
								indiceInicial,
								indiceFinal > detalles.size() ? detalles
										.size() : indiceFinal);
				Long numeroPaginas = (contador / rows);
				if ((contador % rows) > 0) {
					numeroPaginas = numeroPaginas + 1L;
				}
	        	listaResultado.put("total", numeroPaginas);
	        	listaResultado.put("pagina", page);
	        	listaResultado.put("registros", contador);
	        	listaResultado.put("filas", listaPaginada);
            }
        }catch(NpsException ex){
        	LOG.error("Error al obtener detalle de la supervisión.", ex);
        	throw ex;
        }catch(Exception ex){
        	LOG.error("Error al obtener detalle de la supervisión.", ex);
        	throw new Exception("Ocurrió un error al obtener el detalle de la supervisión");
        }
        return listaResultado;
    }
    
    @RequestMapping(value = "/viewDocumentosSupervision", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> viewDocumentosSupervision(Long idSupervision, String numeroExpediente, int rows, int page, HttpSession session){
		LOG.info("BandejaSupervisionController - viewDocumentosSupervision");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UnidadSupervisadaDTO unidadSupervisada = (UnidadSupervisadaDTO)session.getAttribute(Constantes.SESION_UNIDAD_SUPERVISADA);
        	if(unidadSupervisada != null && unidadSupervisada.getIdUnidadOrganica() != null 
        			&& (unidadSupervisada.getIdUnidadOrganica().toString().equals(Constantes.ID_UNIDAD_ORGANICA_DSHL) || unidadSupervisada.getIdUnidadOrganica().toString().equals(Constantes.ID_UNIDAD_ORGANICA_DSR))){
        		List<ArchivoSupervisionDTO> archivos = null;
        		if(unidadSupervisada.getIdUnidadOrganica().toString().equals(Constantes.ID_UNIDAD_ORGANICA_DSHL)){
        			//documentos de supervisión para DSHL
        			FiltroArchivoNpsDTO filtro = new FiltroArchivoNpsDTO();
        			filtro.setIdSupervision(idSupervision);
        			archivos = supervisionService.listaArchivos(filtro);	
        			for(ArchivoSupervisionDTO archivoSupervisionDTO : archivos) {
        				if(archivoSupervisionDTO.getTipoDocumento() == null){
        					archivoSupervisionDTO.setTipoDocumento(Constantes.TIPO_ARCHIVO_ACTA);
        				}
        			}
        		}
        		//documentos de supervisión del SIGED para DSHL y DSR
        		if(archivos == null){
        			archivos = new ArrayList<ArchivoSupervisionDTO>();
        		}
    			List<DocumentoAdjuntoDTO> archivosSiged = supervisionService.listarDocumentosSiged(numeroExpediente);
    			if(archivosSiged != null && archivosSiged.size() > 0){
    				//para obtener el listado de documentos que puede visualizar el administrado
    				List<String> tiposDocumentoSupervisionSigedAdministrado = supervisionService.obtenerTiposDocumentoSupervisionSigedAdministrado();
    				if(tiposDocumentoSupervisionSigedAdministrado == null){
    					tiposDocumentoSupervisionSigedAdministrado = new ArrayList<String>();
    				}
    				//para filtrar el listado de documentos
    				ArchivoSupervisionDTO archivo = null;
    				for(DocumentoAdjuntoDTO archivoSiged : archivosSiged){
    					archivo = new ArchivoSupervisionDTO();
    					archivo.setIdArchivo(archivoSiged.getIdArchivo());
    					archivo.setNombreArchivo(archivoSiged.getNombreArchivo());
    					archivo.setTipoDocumento(archivoSiged.getIdTipoDocumento().getDescripcion());
    					archivo.setDescripcion(archivoSiged.getAsunto());
    					archivo.setProvieneSiged("S");
    					if(tiposDocumentoSupervisionSigedAdministrado.contains(archivoSiged.getIdTipoDocumento().getCodigo())){
    						if(unidadSupervisada.getIdUnidadOrganica().toString().equals(Constantes.ID_UNIDAD_ORGANICA_DSHL)){
        						
    	    					//if(archivoSiged.getFirmado() != null && archivoSiged.getFirmado().equals('S')){
    	    					//	archivos.add(archivo);
    	    		    		//}
    	    		    		  
    	    		    		 
        						archivos.add(archivo);
        					}else{
        						archivos.add(archivo);
        					}
    					}
                    }                
                }    
                List<ArchivoSupervisionDTO> listadoArchivos = new ArrayList<ArchivoSupervisionDTO>();
                if(!CollectionUtils.isEmpty(archivos)){            	
                	for(ArchivoSupervisionDTO archivo : archivos){
                		listadoArchivos.add(archivo); 		
                	}            	
                }
                retorno.put("total", 1);
				retorno.put("pagina", page);
				retorno.put("registros", listadoArchivos.size());
				retorno.put("filas", listadoArchivos);
        	}
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(NpsException ex){
        	LOG.error("Error al obtener documentos de la supervisión.", ex);
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
        }catch(Exception ex){
        	LOG.error("Error al obtener documentos de la supervisión.", ex);
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, "Ocurrió un error al obtener los documentos de la supervisión");
        }
        return retorno;
    }
    
    @RequestMapping(value = "/viewDocumentosAdjuntosDetalleSupervision", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> viewDocumentosAdjuntosDetalleSupervision(Long idDetalleSupervision, int rows, int page, HttpSession sesion) {
    	LOG.info("BandejaSupervisionController - viewDocumentosAdjuntosDetalleSupervision");
    	Map<String, Object> retorno = new HashMap<String, Object>();
		try{
			List<ArchivoSupervisionDTO> archivos = supervisionService.listaArchivosDetalleSup(idDetalleSupervision);
			if(archivos == null){
				archivos = new ArrayList<ArchivoSupervisionDTO>();
			}
			retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
			retorno.put("total", 1);
			retorno.put("pagina", page);
			retorno.put("registros", archivos.size());
			retorno.put("filas", archivos);
		}catch(NpsException ex){
        	LOG.error("Error al obtener documentos adjuntos.", ex);
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
        }catch(Exception ex){
        	LOG.error("Error al obtener documentos adjuntos.", ex);
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, "Ocurrió un error al obtener los documentos adjuntos");
        }
		return retorno;
    }
    
    @RequestMapping(value = "/descargaArchivo", method = RequestMethod.GET)
    public void descargaArchivo(Long idArchivo, HttpServletResponse response) {	
    	LOG.info("BandejaSupervisionController - descargaArchivo: " + idArchivo);
    	ArchivoSupervisionDTO archivo = null;
    	try{
			try{
				archivo = supervisionService.descargarArchivo(idArchivo);								     
			}catch(Exception ex){}
        	if(archivo == null){
        		response.getWriter().write("Error al descargar archivo.");
        		return;
        	}
        	String nombreFichero = archivo.getNombreArchivo();        	
        	response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreFichero+ "\"");
        	ByteArrayInputStream bis = new ByteArrayInputStream(archivo.getArchivo());
        	IOUtils.copy(bis, response.getOutputStream());
        	response.flushBuffer();
        }catch(Exception ex){
        	LOG.info("Error descargaArchivo--->" + ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + archivo.getNombreArchivo()+ "'");
            throw new RuntimeException("IOError writing file to output stream");
        }   	
    }
    
    @RequestMapping(value = "/descargaArchivoSiged", method = RequestMethod.GET)
    public void descargaArchivoSiged(DocumentoAdjuntoDTO filtro, HttpServletResponse response) {
    	LOG.info("BandejaSupervisionController - descargaArchivoSiged: " + filtro.getIdArchivo());
    	LOG.info("BandejaSupervisionController - descargaArchivoSiged: " + filtro.getNombreArchivo());
        try{
            File archivo = supervisionService.descargarArchivoSiged(filtro);
            InputStream is = FileUtils.openInputStream(archivo);
            if(is == null){
    	        response.getWriter().write("Error al descargar archivo.");
                return;
            }
            String nombreFichero = filtro.getNombreArchivo();        	
            response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreFichero+ "\"");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        }catch(Exception ex){
            LOG.info("Error descargaArchivoSiged--->" + ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + filtro.getNombreArchivo()+ "'");
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
    
    @RequestMapping(value = "/descargaPdfArchivo", method = RequestMethod.GET)
    public void descargaPdfArchivo(FiltroArchivoPdfNpsDTO filtro, HttpServletResponse response) {								      
    	LOG.info("BandejaSupervisionController - descargaPdfArchivo");
    	try {     
        	ByteArrayOutputStream byteArrayOutputStream = this.descargaPdfImagenes(filtro);
        	if(byteArrayOutputStream == null || filtro == null || filtro.getIdArchivoImagen().size()==0){
        		response.getWriter().write("Error al descargar archivo.");
        		return;
        	}
        	String nombreFichero = "Imagenes.pdf";        	
        	response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreFichero+ "\"");
        	ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        	IOUtils.copy(bis, response.getOutputStream());
        	response.flushBuffer();
        }catch(Exception ex){
        	LOG.info("Error descargaPdfArchivo--->" + ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was 'Imagenes.pdf'");
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
    
    private ByteArrayOutputStream descargaPdfImagenes(FiltroArchivoPdfNpsDTO filtro){
		List<ArchivoSupervisionDTO> archivos = new ArrayList<ArchivoSupervisionDTO>();
		Document document = null;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try{
			archivos = new ArrayList<ArchivoSupervisionDTO>();
			if(!CollectionUtils.isEmpty(filtro.getIdArchivoImagen())){			
				for(Long idArchivo : filtro.getIdArchivoImagen()){				
					archivos.add(supervisionService.descargarArchivo(idArchivo));						
				}
				document = new Document(PageSize.A4, 30, 30, 30, 30);		        
				PdfWriter.getInstance(document, byteArrayOutputStream);	            
				document.open();
				int indentation = 0;    	            
				for(ArchivoSupervisionDTO archivo1 : archivos){
					Image image = Image.getInstance(archivo1.getArchivo());
					float scaler = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - indentation) / image.getWidth()) * 100;                        
					image.scalePercent(scaler);
					image.setAbsolutePosition((PageSize.A4.getWidth() - image.getScaledWidth()) / 2, (PageSize.A4.getHeight() - image.getScaledHeight()) / 2);
					document.add(image);            
					document.newPage();		            
	            }
				document.close();		        
			}
		}catch(Exception ex){
			LOG.info("Error descargaPdfImagenes--->" + ex.getMessage());
		}
		return byteArrayOutputStream;
	}
    
    @RequestMapping(value = "/descargaMultipleZipDocumentosSupervision", method = {RequestMethod.GET, RequestMethod.POST})
    public void descargaMultipleZipDocumentosSupervision(FiltroArchivoPdfNpsDTO filtro, HttpServletResponse response) {
    	LOG.info("BandejaSupervisionController - descargaMultipleZipDocumentosSupervision");
    	String carpetaProceso = rutaTemporales + "ProcesoInformacion_" + FechaUtil.DateToString(new Date(), "yyyyMMdd_HHmmss_SSS") + "_" + UUID.randomUUID().toString() + File.separator;
		String OUTPUT_ZIP_FILE = carpetaProceso + "comprimido.zip";
    	String SOURCE_FOLDER = carpetaProceso + "archivos"; 
    	File carpeta = new File(carpetaProceso);
    	File directorio= new File(SOURCE_FOLDER);
    	if(!carpeta.exists()){
    		if(carpeta.mkdir()){
    			directorio.mkdir();
            }
        }
        try {    
        	if(filtro != null){
        		//para descargar archivos del SIGED
        		if(!CollectionUtils.isEmpty(filtro.getArchivosSiged())){        			
        			DocumentoAdjuntoDTO filtroDocumentoAdjunto = null;
        			File file = null;
        			InputStream fis = null;
        			FileOutputStream fos = null;
        			for(ArchivoSupervisionDTO archivo : filtro.getArchivosSiged()){
        				filtroDocumentoAdjunto = new DocumentoAdjuntoDTO();
        				filtroDocumentoAdjunto.setIdArchivo(archivo.getIdArchivo());
        				filtroDocumentoAdjunto.setNombreArchivo(archivo.getNombreArchivo());
        				file = supervisionService.descargarArchivoSiged(filtroDocumentoAdjunto);	
        				fis = new FileInputStream(file);
        				fos = new FileOutputStream(SOURCE_FOLDER + File.separator + ZipUtil.generateFileName(SOURCE_FOLDER, archivo.getNombreArchivo()));
        				fos.write(org.apache.commons.io.IOUtils.toByteArray(fis));
        				fos.close();
        				fis.close();
        			}
        		}    
        		//para descargar archivos del INPS
        		if(!CollectionUtils.isEmpty(filtro.getIdArchivo())){  
        			ArchivoSupervisionDTO archivo = null;
        			FileOutputStream fos = null;
        			for(Long idArchivo : filtro.getIdArchivo()){
        				archivo = supervisionService.descargarArchivo(idArchivo);
        				fos = new FileOutputStream(SOURCE_FOLDER + File.separator + ZipUtil.generateFileName(SOURCE_FOLDER, archivo.getNombreArchivo()));
        				fos.write(archivo.getArchivo());
        				fos.close();
        			}
        		}
        	}        	        	        	
        	try{
    			ZipUtil.addAllFilesFromDirectoryToZip(SOURCE_FOLDER, OUTPUT_ZIP_FILE);
    		}catch(Exception e){
    			LOG.error("Error al generar zip", e);
    		}
        	if(filtro == null){
        		response.getWriter().write("Error al descargar archivo.");
        		return;
        	}
        	String nombreFichero = "descargaMultiple.zip";        	
            response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreFichero + "\"");
            InputStream bis = new FileInputStream(OUTPUT_ZIP_FILE);
            IOUtils.copy(bis, response.getOutputStream());
            response.flushBuffer();
        }catch(Exception ex){
        	LOG.info("Error descargaMultipleZipDocumentosSupervision--->" + ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was 'descargaMultiple.zip'");
            throw new RuntimeException("IOError writing file to output stream");
        }  	
    }
    
    @RequestMapping(value = "/descargaMultipleZipDocumentosAdjuntosDetalleSupervision", method = {RequestMethod.GET, RequestMethod.POST})
    public void descargaMultipleZipDocumentosAdjuntosDetalleSupervision(FiltroArchivoPdfNpsDTO filtro, HttpServletResponse response) {
    	LOG.info("BandejaSupervisionController - descargaMultipleZipDocumentosAdjuntosDetalleSupervision");
    	String carpetaProceso = rutaTemporales + "ProcesoInformacion_" +  FechaUtil.DateToString(new Date(), "yyyyMMdd_HHmmss_SSS") + "_" + UUID.randomUUID().toString() + File.separator;
		String OUTPUT_ZIP_FILE = carpetaProceso + "comprimido.zip";
    	String SOURCE_FOLDER = carpetaProceso + "archivos";
    	File carpeta = new File(carpetaProceso);
    	File directorio = new File(SOURCE_FOLDER);
    	if(!carpeta.exists()){
    		if(carpeta.mkdir()){
            	directorio.mkdir();
            }
        }
        try{
        	if(filtro != null){
        		if(!CollectionUtils.isEmpty(filtro.getIdArchivo())){
        			ArchivoSupervisionDTO archivo = null;
        			FileOutputStream fos = null;
        			for(Long idArchivo : filtro.getIdArchivo()){
        				archivo = supervisionService.descargarArchivo(idArchivo);
        				fos = new FileOutputStream(SOURCE_FOLDER + File.separator + ZipUtil.generateFileName(SOURCE_FOLDER, archivo.getNombreArchivo()));
        				fos.write(archivo.getArchivo());
        				fos.close();
        			}
        		}
        		if(!CollectionUtils.isEmpty(filtro.getIdArchivoImagen())){
        			ByteArrayOutputStream byteArrayOutputStream = this.descargaPdfImagenes(filtro);
        			if(byteArrayOutputStream != null){
        				FileOutputStream fos = new FileOutputStream(SOURCE_FOLDER + File.separator + ZipUtil.generateFileName(SOURCE_FOLDER, "Imagenes.pdf"));
        				fos.write(byteArrayOutputStream.toByteArray());
        				fos.close();
        			}
        		}
        	}
        	try{
    			ZipUtil.addAllFilesFromDirectoryToZip(SOURCE_FOLDER, OUTPUT_ZIP_FILE);
    		}catch(Exception e){
    			LOG.error("Error al generar zip", e);
    		}
        	if(filtro == null){
        		response.getWriter().write("Error al descargar archivo.");
        		return;
        	}
        	String nombreFichero = "descargaMultiple.zip";
            response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreFichero+ "\"");
            InputStream bis = new FileInputStream(OUTPUT_ZIP_FILE);
            IOUtils.copy(bis, response.getOutputStream());
            response.flushBuffer();
        }catch(Exception ex){
        	LOG.info("Error descargaMultipleZipDocumentosAdjuntosDetalleSupervision--->" + ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was 'descargaMultiple.zip'");
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
    
    @RequestMapping(value = "/descargaDirectorio", method = RequestMethod.GET)
    public void descargaDirectorio(HttpServletResponse response, HttpSession session) {
    	List<PersonalSupervisionDTO> listado = null;
    	File archivo = null;
    	try{
    		UnidadSupervisadaDTO unidadSupervisada = (UnidadSupervisadaDTO)session.getAttribute(Constantes.SESION_UNIDAD_SUPERVISADA);
    		FiltroPersonalSupervisionDTO filtroPersonal = null;
    		if(unidadSupervisada != null && unidadSupervisada.getIdActividad() != null){
    			filtroPersonal = new FiltroPersonalSupervisionDTO();
        		filtroPersonal.setIdActividad(unidadSupervisada.getIdActividad());
    		}
    		listado = supervisionService.listadoPersonalSupervision(filtroPersonal);
    		if(listado != null){
    			archivo = supervisionService.generarDirectorioDescarga(listado);
        	}else{
        		archivo = supervisionService.generarDirectorioDescargaVacio();
        	}
        	String nombreArchivo = Constantes.NOMBRE_REPORTE_DIRECTORIO + Constantes.EXTENSION_ARCHIVO_EXCEL_XLSX;
        	ResponseUtil.escribirArchivoEnResponse(response, archivo, nombreArchivo);
        }catch(Exception ex){
        	LOG.info("Error descargaDirectorio--->" + ex.getMessage());
            throw new RuntimeException("IOError writing file to output stream");
        }  	
    }
    
    private String estiloResultado(CabeceraNpsDsrDshlDTO cabecera){
    	String estilo = "";
    	if(cabecera.getResultado() != null && cabecera.getResultado().trim().toUpperCase().equals(Constantes.PVO_SUPERVISION_CON_INCUMPLIMIENTOS)){
    		estilo = "con-obs";
    	}else{
    		estilo = "sin-obs";
    	}
    	return estilo;
    }
    
}
