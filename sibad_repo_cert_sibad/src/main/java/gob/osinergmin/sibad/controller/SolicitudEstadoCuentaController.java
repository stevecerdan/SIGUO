/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.common.security.VerificarToken;
import gob.osinergmin.sibad.domain.dto.LugarDTO;
import gob.osinergmin.sibad.domain.dto.SibadNotaDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudEstadoCuentaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadOperativaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.LugarService;
import gob.osinergmin.sibad.service.SolicitudEstadoCuentaService;
import gob.osinergmin.sibad.service.exception.BaseException;
import gob.osinergmin.sibad.service.exception.SigedException;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.ConstantesWeb;
import gob.osinergmin.sibad.util.FechaUtil;
import gob.osinergmin.sibad.util.JasperUtil;
import gob.osinergmin.sibad.util.MensajeUtil;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/estadoCuenta")
@SuppressWarnings({"rawtypes","unchecked"})
public class SolicitudEstadoCuentaController {

    private static final Logger LOG = LoggerFactory.getLogger(SolicitudEstadoCuentaController.class);
    @Inject
    private SolicitudEstadoCuentaService solicitudEstadoCuentaService;
    @Inject
    private LugarService lugarService;

    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model,HttpServletRequest request, HttpSession session) throws BaseException {
    	LOG.info("-- SolicituEstadoCuentaController --> nuevo --");
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        UsuarioDTO usuario = (UsuarioDTO)session.getAttribute(Constantes.SESION_USUARIO);
        model.addAttribute("usuario", usuario.getNombre());
        UnidadOperativaDTO unidad = (UnidadOperativaDTO)session.getAttribute(Constantes.SESION_UNIDAD_OPERATIVA);
        model.addAttribute("unidad",unidad);
	   return ConstantesWeb.Navegacion.PAGE_FORMATO_NUEVO;
    }

    @RequestMapping(value = "/buscarDepartamentos", method = RequestMethod.POST)
    public @ResponseBody
    List<LugarDTO> buscarDepartamentos() {
        List<LugarDTO> lstDepartamento = lugarService.obtenerDepartamentos();
        return lstDepartamento;
    }
    
    @RequestMapping(value = "/buscarProvincias", method = RequestMethod.POST)
    public @ResponseBody
    List<LugarDTO> buscarProvincias(String idDepartamento) {
        LOG.info("idDepartamento = " + idDepartamento);
        List<LugarDTO> lstProvincia = lugarService.obtenerProvincias(idDepartamento);
        return lstProvincia;
    }

    @RequestMapping(value = "/buscarDistritos", method = RequestMethod.POST)
    public @ResponseBody
    List<LugarDTO> buscarDistritos(String idProvincia) {
        List<LugarDTO> lstDistrito = lugarService.obtenerDistritos(idProvincia);
        return lstDistrito;
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> guardar(SolicitudEstadoCuentaDTO solicitudDTO, HttpServletRequest request, HttpServletResponse response,HttpSession session, Model model) {
    
        String mensaje = "";
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> lista = new HashMap<String, Object>();
        
        if(VerificarToken.verifyCSRFToken(session, request)==false){
        	lista.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_URL_INSECURE);
            return lista;
        }

        try {
        	
        	UsuarioDTO usuario = (UsuarioDTO)session.getAttribute(Constantes.SESION_USUARIO);
            UnidadOperativaDTO unidadOperativa = (UnidadOperativaDTO) session.getAttribute(Constantes.SESION_UNIDAD_OPERATIVA);
            
            LOG.info("Datos de Usuario: "+usuario);
            solicitudDTO.setIdUnidadOperativa(unidadOperativa.getIdUnidad());
            solicitudDTO.setCodigoActividad(unidadOperativa.getCodigo());
            solicitudDTO.setActividad(unidadOperativa.getActividad());
            solicitudDTO.setDependenciaId(Long.parseLong(unidadOperativa.getIdDependencia()));
            if (!(Constantes.TIPO_DEPENDENCIA_DSE == solicitudDTO.getDependenciaId() ||
            	Constantes.TIPO_DEPENDENCIA_GSM == solicitudDTO.getDependenciaId())){            	
            	solicitudDTO.setCodigoOsinergmin(unidadOperativa.getCodigoOsinergmin()); 
            }else{
            	solicitudDTO.setCodigoOsinergmin(""); 
            }
                           
            solicitudDTO.setRuc(unidadOperativa.getRuc());
            solicitudDTO.setRazonSocial(unidadOperativa.getRazonSocial());                
            solicitudDTO.setDireccion(unidadOperativa.getDireccion());
            solicitudDTO.setIdDistrito(Long.valueOf(unidadOperativa.getIddistrito()).longValue());
            solicitudDTO.setIdProvincia(Long.valueOf(unidadOperativa.getIdprovincia()).longValue());
            solicitudDTO.setCmbDepartamento(Long.valueOf(unidadOperativa.getIddepartamento()).longValue());
            
            solicitudDTO.setDistrito(unidadOperativa.getDistrito());
            solicitudDTO.setProvincia(unidadOperativa.getProvincia());
            solicitudDTO.setDepartamento(unidadOperativa.getDepartamento());
            solicitudDTO.setDescDep(unidadOperativa.getDependencia());
            
            if (solicitudDTO.getTelefono() == null){            	                
                solicitudDTO.setTelefono(unidadOperativa.getTelefono());
                solicitudDTO.setCorreo(unidadOperativa.getCorreo());
            }
                                  
            //if(solicitudDTO.getIdTipoPeriodo()== 1){    
            if(solicitudDTO.getIdTipoPeriodo().equals("AF")){
            	Date date = new Date();
            	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        		solicitudDTO.setFechaInicio(dateFormat.format(date));
        		solicitudDTO.setFechaFin(dateFormat.format(date)); 
        		solicitudDTO.setTipoPrdo("AF");
            }else{
            	solicitudDTO.setTipoPrdo("PE");
            	
            }
            
            
            solicitudDTO.setFechaPresentacion(FechaUtil.DateToString(new Date(), FechaUtil.FORMATO_FECHA_LARGE));
            solicitudDTO.setCorreoEle(solicitudDTO.getCorreo());
                                    
        	SolicitudEstadoCuentaDTO solicitudLocal = solicitudEstadoCuentaService.guardar(solicitudDTO, usuario, request, response,  session);
        	map.put("numeroSolicitud", solicitudLocal.getNumeroSolicitud());    
        	map.put("numeroExpediente", solicitudLocal.getNumeroExpediente());
        	map.put("fechaPresentacion", solicitudLocal.getFechaPresentacion());
            mensaje = MensajeUtil.controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_FRM, ConstantesWeb.mensajes.MSG_ENTITY_SOLICITUD_EEC);
            map.put(ConstantesWeb.VV_MENSAJE, mensaje);
            map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	
          }
        	catch (SigedException e) {
    			map.put(ConstantesWeb.VV_MENSAJE, "ERRO_SIGED");
                map.put(ConstantesWeb.VV_RESULTADO, "ERROR SIGED");   
    			e.printStackTrace();     
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                map.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
                map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            }
        
        return map;
    }       
    
    @RequestMapping(value = "/imprimirReporteFinalizar", method = RequestMethod.POST)
    public void imprimirReporteFinalizar(HttpServletRequest request, HttpSession sesion,
            HttpServletResponse response, Long identificador) throws Exception {
            LOG.info("-- identificador = " + identificador);
            
            try {
            	
            	String tipo = "PDF";               
                SolicitudEstadoCuentaDTO solicitudReporte = solicitudEstadoCuentaService.consultarReporte(identificador);               
                
                LOG.info("la dependencia es "+solicitudReporte.getIdListadoDependencias());
                LOG.info("la direccion es "+solicitudReporte.getDireccion());
                
                solicitudReporte = solicitudEstadoCuentaService.obtenerEstadoCuenta(solicitudReporte);
                Long idNota = solicitudReporte.getNotaId();
                
                LOG.info("idNota--> "+solicitudReporte.getNotaId());
                //idNota=(long) 1;
                SibadNotaDTO nota = solicitudEstadoCuentaService.obtenerNota(idNota);
                LOG.info("nota descripcion  "+nota.getDetalle());
//                UnidadOperativaDTO unidadOperativa = utilidadesSFHService.obtenerUnidadOperativaByCodigoOsinerg(formatoUnoReporte.getCodigoOsinergmin());                
//                formatoUnoReporte.setDistrito(unidadOperativa.getDistrito());
//                formatoUnoReporte.setProvincia(unidadOperativa.getProvincia());
//                formatoUnoReporte.setDepartamento(unidadOperativa.getDepartamento());
//                formatoUnoReporte.setDescDep(unidadOperativa.getDependencia());
                                                
                Collection reportData = new ArrayList();
                reportData.add(solicitudReporte);

                String rutaImagen = "/images/logo_home.jpg";
                String rutaReportePrincipal = Constantes.CONSTANTE_REPORTE_SOLICITUD;
                String tipoPrdo = (String)solicitudReporte.getTipoPrdo();
                
                LOG.info("tipoPrdo "+tipoPrdo);

                ServletContext context = sesion.getServletContext();
                InputStream reportStreamImage = context.getResourceAsStream(rutaImagen);
                InputStream reportJasper = context.getResourceAsStream(rutaReportePrincipal);

                HashMap reportParams = new HashMap();
                reportParams.put("ruta_imagen", reportStreamImage);
                reportParams.put("tipoPrdo", tipoPrdo);
                reportParams.put("descripcion", nota.getDetalle());
                
            
            	JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(reportData);
                /////////////////////////////////////////////////////////////////////////
                String strNombre = "Solicitud-"+solicitudReporte.getNumeroSolicitud();
                if (tipo.equals("pdf")) {
                    JasperUtil.exportarPDF(reportJasper, reportParams, ds, response,
                            strNombre);
                } else {
                    JasperUtil.exportarPDF(reportJasper, reportParams, ds, response,
                            strNombre);
                }
            
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        
    }
 
}
