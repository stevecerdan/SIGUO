package gob.osinergmin.sibad.service.impl;


import gob.osinergmin.sibad.domain.dto.CamposDelDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudEstadoCuentaDTO;
import gob.osinergmin.sibad.service.GenerarDocumentoSigedService;
import gob.osinergmin.sibad.service.LugarService;
import gob.osinergmin.sibad.service.dao.GenerarDocumentoSigedDAO;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.JasperUtil;
import gob.osinergmin.siged.remote.enums.InvocationResult;
import gob.osinergmin.siged.remote.rest.ro.in.ClienteInRO;
import gob.osinergmin.siged.remote.rest.ro.in.DireccionxClienteInRO;
import gob.osinergmin.siged.remote.rest.ro.in.DocumentoInRO;
import gob.osinergmin.siged.remote.rest.ro.in.ExpedienteInRO;
import gob.osinergmin.siged.remote.rest.ro.in.list.ClienteListInRO;
import gob.osinergmin.siged.remote.rest.ro.in.list.DireccionxClienteListInRO;
import gob.osinergmin.siged.remote.rest.ro.out.ClienteOutRO;
import gob.osinergmin.siged.remote.rest.ro.out.DocumentoOutRO;
import gob.osinergmin.siged.remote.rest.ro.out.ExpedienteOutRO;
import gob.osinergmin.siged.rest.util.ExpedienteInvoker;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@SuppressWarnings("rawtypes")
@Service("GenerarDocumentoSigedService")
public class GenerarDocumentoSigedServiceImpl implements GenerarDocumentoSigedService{
	
	private static final Logger LOG = LoggerFactory.getLogger(GenerarDocumentoSigedServiceImpl.class);
	
	@Inject
	private GenerarDocumentoSigedDAO generarDocumentoSigedDAO;
	
	@Inject
	private LugarService lugarService;
	
	@Override
	public String crearExpediente(CamposDelDocumentoDTO camposDTO, SolicitudEstadoCuentaDTO solicitudDTO,HttpServletRequest request,HttpServletResponse response,HttpSession sesion) throws ClassNotFoundException{
		LOG.info("Entrando al método callWebServiceCreateExp - registrarSolicitud");
	    try{
	    	ExpedienteInRO expedienteInRO = new ExpedienteInRO();
	    	DocumentoInRO documentoInRO = new DocumentoInRO(); 
		    expedienteInRO.setProceso(Integer.parseInt(generarDocumentoSigedDAO.buscarDatosSiged("PROCESO").getNombreLargo()));
		    expedienteInRO.setHistorico(generarDocumentoSigedDAO.buscarDatosSiged("HISTORICO").getNombreLargo().charAt(0));
		    expedienteInRO.setAppNameInvokes(generarDocumentoSigedDAO.buscarDatosSiged("APP_NAME").getNombreLargo());
		    expedienteInRO.setExpedienteFisico(generarDocumentoSigedDAO.buscarDatosSiged("EXPEDIENTE_FISICO").getNombreLargo().charAt(0));
		    expedienteInRO.setDestinatario(camposDTO.getUsuarioIDDestinatario());
		    documentoInRO.setCodTipoDocumento(Integer.parseInt(generarDocumentoSigedDAO.buscarDatosSiged("COD_TIPO_DOCUMENTO").getNombreLargo()));
	    
		    documentoInRO.setNumeroDocumento("S/N");
		    documentoInRO.setAsunto(generarDocumentoSigedDAO.buscarDatosSiged("ASUNTO_EECC").getNombreLargo());//("SISTEMA DE SUPERVISION REMOTA");
		    documentoInRO.setAppNameInvokes(generarDocumentoSigedDAO.buscarDatosSiged("APP_NAME").getNombreLargo());//("RHO-AUTOMATICO");
		    documentoInRO.setPublico(generarDocumentoSigedDAO.buscarDatosSiged("PUBLICO").getNombreLargo().charAt(0));//('S');
		    documentoInRO.setEnumerado(generarDocumentoSigedDAO.buscarDatosSiged("ENUMERADO").getNombreLargo().charAt(0));//('S');
		    documentoInRO.setEstaEnFlujo(generarDocumentoSigedDAO.buscarDatosSiged("ESTAENFLUJO").getNombreLargo().charAt(0));//('S');
		    documentoInRO.setFirmado(generarDocumentoSigedDAO.buscarDatosSiged("FIRMADO").getNombreLargo().charAt(0));//('S');
		    documentoInRO.setDelExpediente(generarDocumentoSigedDAO.buscarDatosSiged("DEL_EXPEDIENTE").getNombreLargo().charAt(0));//('S');
		    documentoInRO.setNroFolios(Integer.parseInt(generarDocumentoSigedDAO.buscarDatosSiged("NRO_FOLIO").getNombreLargo()));//(1);
		    documentoInRO.setCreaExpediente(generarDocumentoSigedDAO.buscarDatosSiged("CREAR_EXPEDIENTE").getNombreLargo().charAt(0));//('S');
		    documentoInRO.setUsuarioCreador(Integer.parseInt(generarDocumentoSigedDAO.buscarDatosSiged("USUARIO_CREADOR").getNombreLargo()));//derivacionDocumentoService.obtenerIdUsuario(nombreCortoUsuario));	//usuarioID  O 4320      
		        
		    Integer tipoIdentificacion = null; 
			String nroidentificacion = "";
			String razonsocial = "";
			String direccionprincipal = "";
			Integer ubigeoprincipal = null;
			Character estado = null;
		      
			List<ClienteInRO> listaClientes=new ArrayList<ClienteInRO>();	/**NUEVO**/
			Map mapCliente = generarDocumentoSigedDAO.obtenerCliente(camposDTO.getRuc());
								
		    if(mapCliente!=null){
	        	tipoIdentificacion = (Integer)mapCliente.get("tipoIdentificacion");
				nroidentificacion = (String)mapCliente.get("nroidentificacion");
				razonsocial = (String)mapCliente.get("razonsocial");
				direccionprincipal = (String)mapCliente.get("direccionprincipal");
				ubigeoprincipal = (Integer)mapCliente.get("ubigeoprincipal");
				estado = (Character)mapCliente.get("estado");
	        }else{
	        	return "0";
	        }
		        
		    //CLIENTE
		    ClienteInRO cliente1 = new ClienteInRO();
		    cliente1.setCodigoTipoIdentificacion(tipoIdentificacion);
		    cliente1.setNroIdentificacion(nroidentificacion);
		    cliente1.setTipoCliente(3);
		    cliente1.setRazonSocial(razonsocial);//Obligatorio si codigoTipoIdentificacion es 1.         

			DireccionxClienteInRO direccion1 = new DireccionxClienteInRO();
		    direccion1.setDireccion(direccionprincipal);
		    direccion1.setDireccionPrincipal(true);
		    direccion1.setUbigeo(ubigeoprincipal);
		    direccion1.setEstado(estado);

		    List<DireccionxClienteInRO> listaDirCliente1 = new ArrayList<DireccionxClienteInRO>();
		    listaDirCliente1.add(direccion1);
		    DireccionxClienteListInRO direccionesCliente1 = new DireccionxClienteListInRO();
		    direccionesCliente1.setDireccion(listaDirCliente1);
		    cliente1.setDirecciones(direccionesCliente1);

		    listaClientes.add(cliente1);
		        
		    ClienteListInRO clientes = new ClienteListInRO();
		    clientes.setCliente(listaClientes);
		    documentoInRO.setClientes(clientes);

		    expedienteInRO.setDocumento(documentoInRO);
		        
		    List<File> files = new ArrayList<File>();	

		    files.add(archivoParaSiged(solicitudDTO, request, response, sesion));
		            
		    System.out.println("URL: CREAR_EXPEDIENTE::: "+generarDocumentoSigedDAO.buscarDatosSiged("CREAR_EXPEDIENTE_NUEVO").getNombreLargo());
		    ExpedienteOutRO expedienteOutRO = ExpedienteInvoker.create(generarDocumentoSigedDAO.buscarDatosSiged("CREAR_EXPEDIENTE_NUEVO").getNombreLargo(), expedienteInRO, files);//files
		    System.out.println(expedienteOutRO.getMessage()+" "+expedienteOutRO.getResultCode()+"  "+(InvocationResult.SUCCESS.getCode()));
	        if (expedienteOutRO.getResultCode().equals(InvocationResult.SUCCESS.getCode())) {
	            System.out.println("Expediente: " + expedienteOutRO.getCodigoExpediente());
	            System.out.println("Documento: " + expedienteOutRO.getIdDocumento());
	           /* campos.setNuevoExpedienteGeneradoParaDocumento(expedienteOutRO.getCodigoExpediente());
	            String addDocumento=agregarDocumento(campos, request,sesion);*/
	            for (ClienteOutRO cliente : expedienteOutRO.getClientes().getCliente()) {
	                System.out.println(cliente.getCodigoCliente());
	                System.out.println(cliente.getCodigoTipoIdentificacion());
	                System.out.println(cliente.getNumeroIdentificacion());
	            }
	            return expedienteOutRO.getCodigoExpediente();/**retorna numero de expediente generado**/
	        } else {
	            LOG.debug("Ocurrio un error: " + expedienteOutRO.getMessage());
//		            return "0".concat(expedienteOutRO.getMessage());
	            return "0";
	        }
	    }catch(Exception e){
    		e.printStackTrace();
    		LOG.error("Ocurrio un error en el método callWebServiceCreateExp - registrarSolicitud: " + e.getMessage());
    		Log.error("Ocurrio un error en el método registrarSolicitud - AlertaSuspencionInfraccionController: " + e.getMessage());
    		return "0";
    	}	    
	}
	

	@Override
	public String agregarDocumento(CamposDelDocumentoDTO camposDelDocumentoDTO, HttpServletRequest request,HttpSession sesion) throws Exception{
		
		ExpedienteInRO expedienteInRO = new ExpedienteInRO();
    	DocumentoInRO documentoInRO = new DocumentoInRO(); 
    	expedienteInRO.setProceso(Integer.parseInt(generarDocumentoSigedDAO.buscarDatosSiged("PROCESO").getNombreLargo()));//(954);//Integer.parseInt(tablaDetalleService.buscarTablaDetallePorNombreCorto(Constantes.PROCESO_INFRACCION).getCodigo()));//(954);
    	expedienteInRO.setNroExpediente(camposDelDocumentoDTO.getNumeroExpediente());
    	expedienteInRO.setHistorico(generarDocumentoSigedDAO.buscarDatosSiged("HISTORICO").getNombreLargo().charAt(0));//('N');
    	expedienteInRO.setAppNameInvokes(generarDocumentoSigedDAO.buscarDatosSiged("APP_NAME").getNombreLargo());//("SFH");
    	expedienteInRO.setExpedienteFisico(generarDocumentoSigedDAO.buscarDatosSiged("EXPEDIENTE_FISICO").getNombreLargo().charAt(0));//('S');
    	expedienteInRO.setDestinatario(camposDelDocumentoDTO.getUsuarioIDDestinatario());
    	documentoInRO.setCodTipoDocumento(Integer.parseInt(generarDocumentoSigedDAO.buscarDatosSiged("COD_TIPO_DOCUMENTO").getNombreLargo()));//(220);//campos.getTipoDocumento().intValue());//220
  
        documentoInRO.setAsunto(generarDocumentoSigedDAO.buscarDatosSiged("ASUNTO_EECC").getNombreLargo());//("SISTEMA DE SUPERVISION REMOTA");
	    documentoInRO.setAppNameInvokes(generarDocumentoSigedDAO.buscarDatosSiged("APP_NAME").getNombreLargo());//("RHO-AUTOMATICO");//1
	    documentoInRO.setPublico(generarDocumentoSigedDAO.buscarDatosSiged("PUBLICO").getNombreLargo().charAt(0));//('S');
	    documentoInRO.setEnumerado(generarDocumentoSigedDAO.buscarDatosSiged("ENUMERADO").getNombreLargo().charAt(0));//('S');
	    documentoInRO.setEstaEnFlujo(generarDocumentoSigedDAO.buscarDatosSiged("ESTAENFLUJO").getNombreLargo().charAt(0));//('S');
	    documentoInRO.setFirmado(generarDocumentoSigedDAO.buscarDatosSiged("FIRMADO").getNombreLargo().charAt(0));//('S');
	    documentoInRO.setDelExpediente(generarDocumentoSigedDAO.buscarDatosSiged("DEL_EXPEDIENTE").getNombreLargo().charAt(0));//('S');
	    documentoInRO.setNroFolios(Integer.parseInt(generarDocumentoSigedDAO.buscarDatosSiged("NRO_FOLIO").getNombreLargo()));//(1);
	    documentoInRO.setCreaExpediente(generarDocumentoSigedDAO.buscarDatosSiged("CREAR_EXPEDIENTE").getNombreLargo().charAt(0));//('S');
	    documentoInRO.setUsuarioCreador(Integer.parseInt(generarDocumentoSigedDAO.buscarDatosSiged("USUARIO_CREADOR").getNombreLargo()));//formatoTres.getUsuarioID());//derivacionDocumentoService.obtenerIdUsuario(nombreCortoUsuario));//DESASIGED11
	    documentoInRO.setNumeroDocumento("S/N");
    
    
	    Integer tipoIdentificacion = null; 
		String nroidentificacion = "";
		String razonsocial = "";
		String direccionprincipal = "";
		Integer ubigeoprincipal = null;
		Character estado = null;
      
		Map mapCliente = generarDocumentoSigedDAO.obtenerCliente(camposDelDocumentoDTO.getRuc());//objCamposDocumento.getRucCliente());//10239428008			
			
	    if(mapCliente!=null){
	    	tipoIdentificacion = (Integer)mapCliente.get("tipoIdentificacion"); //1;//
			nroidentificacion = (String)mapCliente.get("nroidentificacion");//"20486184648";//
			razonsocial = (String)mapCliente.get("razonsocial");//"RAZON SOCIAL 0790";//
			direccionprincipal = (String)mapCliente.get("direccionprincipal");//"COMUNIDAD DE ACCOERA";//
			ubigeoprincipal = (Integer)mapCliente.get("ubigeoprincipal");//240101;//
			estado = (Character)mapCliente.get("estado");//'A';
	    }
		    
	    ClienteInRO cliente1 = new ClienteInRO();
	    cliente1.setCodigoTipoIdentificacion(tipoIdentificacion);
	    cliente1.setNroIdentificacion(nroidentificacion);
	    cliente1.setTipoCliente(3);
	    cliente1.setRazonSocial(razonsocial);//Obligatorio si codigoTipoIdentificacion es 1.         

        DireccionxClienteInRO direccion1 = new DireccionxClienteInRO();
        direccion1.setDireccion(direccionprincipal);
        direccion1.setDireccionPrincipal(true);
        direccion1.setUbigeo(ubigeoprincipal);
        direccion1.setEstado(estado);

        List<DireccionxClienteInRO> listaDirCliente1 = new ArrayList<DireccionxClienteInRO>();
        listaDirCliente1.add(direccion1);
        DireccionxClienteListInRO direccionesCliente1 = new DireccionxClienteListInRO();
        direccionesCliente1.setDireccion(listaDirCliente1);
        cliente1.setDirecciones(direccionesCliente1);

	    List<ClienteInRO> listaClientes = new ArrayList<ClienteInRO>();
	    listaClientes.add(cliente1);

	    ClienteListInRO clientes = new ClienteListInRO();
	    clientes.setCliente(listaClientes);
	    documentoInRO.setClientes(clientes);
	
	    expedienteInRO.setDocumento(documentoInRO);

	    List<File> files = new ArrayList<File>();	
	    System.out.println("LISTADO ARCHIVO:::: "+camposDelDocumentoDTO.getListaArchivosSiged().size());
	    if(camposDelDocumentoDTO.getListaArchivosSiged().size()>1){
	    	files=camposDelDocumentoDTO.getListaArchivosSiged();
	    }else{
	    	files=camposDelDocumentoDTO.getListaArchivosSiged();//getArchivoEmergencia());
	    }

        System.out.println("URL: ADD_DOCUMENTO::: "+generarDocumentoSigedDAO.buscarDatosSiged("ADD_DOCUMENTO_EXPEDINTE").getNombreLargo());
	    DocumentoOutRO documentoOutRO = ExpedienteInvoker.addDocument(generarDocumentoSigedDAO.buscarDatosSiged("ADD_DOCUMENTO_EXPEDINTE").getNombreLargo(), expedienteInRO, files, true);//FALSE PARA ADJUNTAR TRUE PARA VERSIONAR
	    if (documentoOutRO.getResultCode() == InvocationResult.SUCCESS.getCode()) {
	        //System.out.println(documentoOutRO.getCodigoDocumento());
	        return "";//documentoOutRO.getCodigoDocumento().toString();
	    } else {
	        System.out.println("Ocurrio un error: " + documentoOutRO.getMessage());
	        return documentoOutRO.getMessage();
	    }
	    
  }
	
	
	public File archivoParaSiged(SolicitudEstadoCuentaDTO solicitudDTO,HttpServletRequest request,HttpServletResponse response,HttpSession sesion){
	            
		if (solicitudDTO.getNumeroSolicitud() == 0){
			solicitudDTO.setNombreDocumento("Solicitud");
	   	}else{
	   		solicitudDTO.setNombreDocumento("Solicitud-"+solicitudDTO.getNumeroSolicitud());
	   	}
		 
		Collection<SolicitudEstadoCuentaDTO> reportData = new ArrayList<SolicitudEstadoCuentaDTO>();
		reportData.add(solicitudDTO);
		
		String rutaImagen = "/images/logo_home.jpg";	
		String rutaReportePrincipal = request.getSession().getServletContext().getRealPath(Constantes.CONSTANTE_REPORTE_SOLICITUD);
		
		ServletContext context = sesion.getServletContext();
		InputStream reportStreamImage = context.getResourceAsStream(rutaImagen);
		
		HashMap<String,Object> reportParams = new HashMap<String,Object>();
		reportParams.put("ruta_imagen", reportStreamImage);
		reportParams.put("tipoPrdo", solicitudDTO.getTipoPrdo());
        reportParams.put("descripcion", solicitudDTO.getNotaDetalle());
		
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(reportData);
		String strNombre = solicitudDTO.getNombreDocumento();
		File archivoFile= JasperUtil.exportarPDFStream(rutaReportePrincipal, reportParams, ds, response,strNombre);
	            
	           
       return archivoFile;
       
	}

}
