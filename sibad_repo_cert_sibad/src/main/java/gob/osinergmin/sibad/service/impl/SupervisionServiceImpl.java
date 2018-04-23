package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.mdicommon.domain.base.BaseConstantesOutBean;
import gob.osinergmin.mdicommon.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.mdicommon.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.mdicommon.domain.in.ObtenerMaestrosColumnaInRO;
import gob.osinergmin.mdicommon.domain.in.ObtenerPersonalInRO;
import gob.osinergmin.mdicommon.domain.out.ObtenerMaestrosColumnaOutRO;
import gob.osinergmin.mdicommon.domain.out.ObtenerPersonalOutRO;
import gob.osinergmin.mdicommon.domain.pvo.dto.FiltroSupervisionDTO;
import gob.osinergmin.mdicommon.domain.pvo.in.DescargarArchivoInRO;
import gob.osinergmin.mdicommon.domain.pvo.in.ObtenerDetalleSupervisionDsrInRO;
import gob.osinergmin.mdicommon.domain.pvo.in.ObtenerDetalleSupervisionesDshlInRO;
import gob.osinergmin.mdicommon.domain.pvo.in.ObtenerDocumentosSupervisionDsrInRO;
import gob.osinergmin.mdicommon.domain.pvo.in.ObtenerMediosProbatoriosInRO;
import gob.osinergmin.mdicommon.domain.pvo.in.ObtenerSupervisionInRO;
import gob.osinergmin.mdicommon.domain.pvo.out.DescargarArchivoOutRO;
import gob.osinergmin.mdicommon.domain.pvo.out.ObtenerDetalleSupervisionDsrOutRO;
import gob.osinergmin.mdicommon.domain.pvo.out.ObtenerDetalleSupervisionesDshlOutRO;
import gob.osinergmin.mdicommon.domain.pvo.out.ObtenerDocumentosSupervisionDsrOutRO;
import gob.osinergmin.mdicommon.domain.pvo.out.ObtenerMediosProbatoriosOutRO;
import gob.osinergmin.mdicommon.domain.pvo.out.ObtenerSupervisionesOutRO;
import gob.osinergmin.mdicommon.domain.ui.DetalleSupervisionFilter;
import gob.osinergmin.mdicommon.domain.ui.DocumentoAdjuntoFilter;
import gob.osinergmin.mdicommon.domain.ui.PersonalFilter;
import gob.osinergmin.mdicommon.remote.MaestroColumnaEndpoint;
import gob.osinergmin.mdicommon.remote.PVOSupervisionEndpoint;
import gob.osinergmin.sibad.domain.MdiActividad;
import gob.osinergmin.sibad.domain.MdiUnidadSupervisada;
import gob.osinergmin.sibad.domain.PghConfiguracionActividadUnidadOrganica;
import gob.osinergmin.sibad.domain.builder.PersonalSupervisionBuilder;
import gob.osinergmin.sibad.domain.builder.SupervisionBuilder;
import gob.osinergmin.sibad.domain.dto.ArchivoSupervisionDTO;
import gob.osinergmin.sibad.domain.dto.CabeceraNpsDsrDshlDTO;
import gob.osinergmin.sibad.domain.dto.DetalleNpsDshlDTO;
import gob.osinergmin.sibad.domain.dto.DetalleNpsDsrDTO;
import gob.osinergmin.sibad.domain.dto.FiltroArchivoNpsDTO;
import gob.osinergmin.sibad.domain.dto.FiltroDetalleNpsDshlDTO;
import gob.osinergmin.sibad.domain.dto.FiltroDetalleNpsDsrDTO;
import gob.osinergmin.sibad.domain.dto.FiltroNpsDsrDshlDTO;
import gob.osinergmin.sibad.domain.dto.FiltroPersonalSupervisionDTO;
import gob.osinergmin.sibad.domain.dto.PersonalSupervisionDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.service.SupervisionService;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.NpsException;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.QueryParameter;
import gob.osinergmin.siged.remote.enums.InvocationResult;
import gob.osinergmin.siged.remote.rest.ro.out.list.ListDocumentoOutRO;
import gob.osinergmin.siged.rest.util.ArchivoInvoker;
import gob.osinergmin.siged.rest.util.ExpedienteInvoker;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("supervisionService")
@Transactional(rollbackFor = Exception.class)
public class SupervisionServiceImpl implements SupervisionService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SupervisionServiceImpl.class);

	@Inject
    private CrudDAO crudDAO;
	@Inject
	private PVOSupervisionEndpoint pvoSupervisionEndpoint;
	@Inject
	private MaestroColumnaEndpoint maestroColumnaEndpoint;
	@Value("${siged.ws.url}")
    private String URL_SIGED_WS;
	@Value("${siged.ws.relativeUrl.listarDocumentosExpediente}")
    private String RELATIVE_URL_SIGED_WS_LISTAR_DOCUMENTOS_EXPEDIENTE;
	@Value("${siged.ws.relativeUrl.descargarArchivo}")
    private String RELATIVE_URL_SIGED_WS_DESCARGAR_ARCHIVO;
	
	@Override
    public UnidadSupervisadaDTO obtenerUnidadSupervisada(Long idUnidadSupervisada) throws Exception{
		UnidadSupervisadaDTO unidadSupervisadaDTO = null;
        if(idUnidadSupervisada != null){
        	MdiUnidadSupervisada unidadSupervisada = crudDAO.find(idUnidadSupervisada, MdiUnidadSupervisada.class);
        	unidadSupervisadaDTO = unidadSupervisada.getUnidadSupervisadaDTO();
        	this.completarDatosAdicionalesActividad(unidadSupervisadaDTO);
        }
    	return unidadSupervisadaDTO;
    }
	
	@Override
    public UnidadSupervisadaDTO obtenerUnidadSupervisadaByRuc(String rucUnidadSupervisada) throws Exception{
		UnidadSupervisadaDTO unidadSupervisadaDTO = null;
        if(rucUnidadSupervisada != null){
        	List<MdiUnidadSupervisada> results = (List<MdiUnidadSupervisada>)crudDAO.findByNamedQuery("MdiUnidadSupervisada.findByRuc",
        			QueryParameter.with("ruc", rucUnidadSupervisada).parameters(), 
        			null, null, null, null);
        	if(results != null && results.size() > 0){
        		unidadSupervisadaDTO = results.get(0).getUnidadSupervisadaDTO();
        		this.completarDatosAdicionalesActividad(unidadSupervisadaDTO);
        	}
        }
    	return unidadSupervisadaDTO;
    }
	
	@Override
    public UnidadSupervisadaDTO obtenerUnidadSupervisadaByCodigoOsinergmin(String codigoOsinergminUnidadSupervisada) throws Exception{
		UnidadSupervisadaDTO unidadSupervisadaDTO = null;
        if(codigoOsinergminUnidadSupervisada != null){
        	List<MdiUnidadSupervisada> results = (List<MdiUnidadSupervisada>)crudDAO.findByNamedQuery("MdiUnidadSupervisada.findByCodigoOsinergmin",
        			QueryParameter.with("codigoOsinergmin", codigoOsinergminUnidadSupervisada).parameters(), 
        			null, null, null, null);
        	if(results != null && results.size() > 0){
        		unidadSupervisadaDTO = results.get(0).getUnidadSupervisadaDTO();
        		this.completarDatosAdicionalesActividad(unidadSupervisadaDTO);
        	}
        }
    	return unidadSupervisadaDTO;
    }
	
	private void completarDatosAdicionalesActividad(UnidadSupervisadaDTO unidadSupervisadaDTO){
		try{
			//para obtener el árbol de actividad (sector, subsector y actividad)
			if(unidadSupervisadaDTO.getIdActividad() != null){
				MdiActividad actividad = crudDAO.find(unidadSupervisadaDTO.getIdActividad(), MdiActividad.class);
				if(actividad != null){
					unidadSupervisadaDTO.setCodigoActividad(actividad.getCodigo());
					unidadSupervisadaDTO.setNombreActividad(actividad.getNombre());
					if(actividad.getIdActividadPadre() != null){
						MdiActividad subsector = crudDAO.find(actividad.getIdActividadPadre(), MdiActividad.class);
						if(subsector != null){
							unidadSupervisadaDTO.setIdSubsector(subsector.getIdActividad());
							unidadSupervisadaDTO.setCodigoSubsector(subsector.getCodigo());
							unidadSupervisadaDTO.setNombreSubsector(subsector.getNombre());
							if(subsector.getIdActividadPadre() != null){
								MdiActividad sector = crudDAO.find(subsector.getIdActividadPadre(), MdiActividad.class);
								if(sector != null){
									unidadSupervisadaDTO.setIdSector(sector.getIdActividad());
									unidadSupervisadaDTO.setCodigoSector(sector.getCodigo());
									unidadSupervisadaDTO.setNombreSector(sector.getNombre());
								}
							}
						}
					}
				}
			}
			//para obtener la unidad orgánica correspondiente al tipo de agente
			if(unidadSupervisadaDTO.getIdTipoAgente() != null){
				List<PghConfiguracionActividadUnidadOrganica> results = (List<PghConfiguracionActividadUnidadOrganica>)crudDAO.findByNamedQuery("PghConfiguracionActividadUnidadOrganica.findByTipoAgente",
	        			QueryParameter.with("idTipoAgente", unidadSupervisadaDTO.getIdTipoAgente()).parameters(), 
	        			null, null, null, null);
	        	if(results != null && results.size() > 0){
	        		unidadSupervisadaDTO.setIdUnidadOrganica(results.get(0).getIdUnidadOrganica());
	        	}
			}
		}catch(Exception ex){}
	}
	
	@Override
	public List<CabeceraNpsDsrDshlDTO> listaCabeceraNpsDsr(FiltroNpsDsrDshlDTO filtro) throws NpsException {
		List<CabeceraNpsDsrDshlDTO> result = null;
		try{						
			FiltroSupervisionDTO filtroDto = new FiltroSupervisionDTO();
			if(filtro!=null){
				filtroDto.setCodigosOsi(filtro.getCodigosOsinergminPermitidos());
				filtroDto.setCodigoOsinergmin(filtro.getCodigoOsinergmin());					
				filtroDto.setRho(filtro.getRegistroHidrocarburos());
				filtroDto.setPeriodoSupervision(filtro.getPeriodoSupervision());
				filtroDto.setNumeroExpediente(filtro.getNumeroExpediente());
				filtroDto.setNumeroOrdenServicio(filtro.getNumeroOrdenServicio());
			}
			ObtenerSupervisionInRO p = new ObtenerSupervisionInRO();
			p.setFiltroSupervision(filtroDto);
			ObtenerSupervisionesOutRO r = pvoSupervisionEndpoint.obtenerSupervisionesDsr(p);
			if(BaseConstantesOutBean.SUCCESS.equals(r.getCodigoResultado())){
				result = SupervisionBuilder.toListCabeceraNpsDsrDTO(r.getSupervisiones());
			}else{
				LOG.error("Error al invocar servicio mdiws listaCabeceraNpsDsr: " + r.getMensaje());
				throw new NpsException(r.getMensaje());
			}			
		}catch(NpsException ex){
			throw ex;
		}catch(Exception ex){
			LOG.error("Error generico al invocar servicio listaCabeceraNpsDsr", ex);
			throw new NpsException("Error al obtener listado nps dsr");
		}
		return result;
	}

	@Override
	public List<DetalleNpsDsrDTO> listaDetalleNpsDsr(FiltroDetalleNpsDsrDTO filtro1) throws NpsException {
		List<DetalleNpsDsrDTO> result = new ArrayList<DetalleNpsDsrDTO>();
		try{									
			DetalleSupervisionFilter filtro = new DetalleSupervisionFilter();
			filtro.setIdSupervision(filtro1.getIdSupervision());
			filtro.setCodigoResultadoSupervision(filtro1.getCodigoResultado());
			ObtenerDetalleSupervisionDsrInRO p = new ObtenerDetalleSupervisionDsrInRO();
			p.setFiltro(filtro);
			ObtenerDetalleSupervisionDsrOutRO r = pvoSupervisionEndpoint.obtenerDetalleSupervisionDsr(p);
			if(BaseConstantesOutBean.SUCCESS.equals(r.getCodigoResultado())){
				result = SupervisionBuilder.toListDetalleNpsDsrDTO(r.getDetalleSupervision());
			}else{
				LOG.error("Error al invocar servicio mdiws listaDetalleNpsDsr: " + r.getMensaje());
				throw new NpsException(r.getMensaje());
			}			
		}catch(NpsException ex){
			throw ex;
		}catch(Exception ex){
			LOG.error("Error generico al invocar servicio listaDetalleNpsDsr", ex);
			throw new NpsException("Error al obtener listado detalle nps dsr");
		}
		return result;
	}
	
	@Override
	public List<CabeceraNpsDsrDshlDTO> listaCabeceraNpsDshl(FiltroNpsDsrDshlDTO filtro) throws NpsException {
		List<CabeceraNpsDsrDshlDTO> result = null;
		try{						
			FiltroSupervisionDTO filtroDto = new FiltroSupervisionDTO();
			if(filtro!=null){
				filtroDto.setCodigosOsi(filtro.getCodigosOsinergminPermitidos());
				filtroDto.setCodigoOsinergmin(filtro.getCodigoOsinergmin());					
				filtroDto.setRho(filtro.getRegistroHidrocarburos());
				filtroDto.setPeriodoSupervision(filtro.getPeriodoSupervision());
				filtroDto.setNumeroExpediente(filtro.getNumeroExpediente());
				filtroDto.setNumeroOrdenServicio(filtro.getNumeroOrdenServicio());
			}
			ObtenerSupervisionInRO p = new ObtenerSupervisionInRO();
			p.setFiltroSupervision(filtroDto);
			ObtenerSupervisionesOutRO r = pvoSupervisionEndpoint.obtenerSupervisionesDshl(p);
			if(BaseConstantesOutBean.SUCCESS.equals(r.getCodigoResultado())){
				result = SupervisionBuilder.toListCabeceraNpsDsrDTO(r.getSupervisiones());
			}else{
				LOG.error("Error al invocar servicio mdiws listaCabeceraNpsDshl: " + r.getMensaje());
				throw new NpsException(r.getMensaje());
			}			
		}catch(NpsException ex){
			throw ex;
		}catch(Exception ex){
			LOG.error("Error generico al invocar servicio listaCabeceraNpsDshl", ex);
			throw new NpsException("Error al obtener listado nps dshl");
		}
		return result;
	}

	@Override
	public List<DetalleNpsDshlDTO> listaDetalleNpsDshl(FiltroDetalleNpsDshlDTO filtro1) throws NpsException {
		List<DetalleNpsDshlDTO> result = null;
		try{									
			DetalleSupervisionFilter filtro = new DetalleSupervisionFilter();
			filtro.setIdSupervision(filtro1.getIdSupervision());
			filtro.setIdCriticidad(-1L);
			filtro.setIdTemaObligacion(-1L);
			ObtenerDetalleSupervisionesDshlInRO p = new ObtenerDetalleSupervisionesDshlInRO();
			p.setFiltro(filtro);
			ObtenerDetalleSupervisionesDshlOutRO r = pvoSupervisionEndpoint.obtenerDetalleSupervisionesDshl(p);
			if(BaseConstantesOutBean.SUCCESS.equals(r.getCodigoResultado())){	            
				result = SupervisionBuilder.toListDetalleNpsDshlDTO(r.getListaDetalleDshl());
			}else{
				LOG.error("Error al invocar servicio mdiws listaDetalleNpsDsr: " + r.getMensaje());
				throw new NpsException(r.getMensaje());
			}			
		}catch(NpsException ex){
			throw ex;
		}catch(Exception ex){
			LOG.error("Error generico al invocar servicio listaDetalleNpsDsr", ex);
			throw new NpsException("Error al obtener listado detalle nps dsr");
		}
		return result;
	}
	
	@Override
	public List<ArchivoSupervisionDTO> listaArchivosDetalleSup(Long idDetalleSup) throws NpsException {
		List<ArchivoSupervisionDTO> result = null;
		try{															
			ObtenerMediosProbatoriosInRO p = new ObtenerMediosProbatoriosInRO();
			DocumentoAdjuntoFilter filtro = new DocumentoAdjuntoFilter();
			filtro.setIdDetalleSupervision(idDetalleSup);
			p.setFiltro(filtro);	
			ObtenerMediosProbatoriosOutRO r = pvoSupervisionEndpoint.obtenerMediosProbatorios(p);
			if(BaseConstantesOutBean.SUCCESS.equals(r.getCodigoResultado())){
				result = SupervisionBuilder.toListArchivoSupervisionDTO(r.getDocumentos());
			}else{
				LOG.error("Error al invocar servicio mdiws listaArchivosDetalleSupDsr: " + r.getMensaje());
				throw new NpsException(r.getMensaje());
			}			
		}catch(NpsException ex){
			throw ex;
		}catch(Exception ex){
			LOG.error("Error generico al invocar servicio listaArchivosDetalleSupDsr", ex);
			throw new NpsException("Error al obtener listado medios probatorios nps dsr");
		}
		return result;
	}

	@Override
	public List<ArchivoSupervisionDTO> listaArchivos(FiltroArchivoNpsDTO filtro) throws NpsException {
		List<ArchivoSupervisionDTO> result = new ArrayList<ArchivoSupervisionDTO>();
		try{															
			ObtenerDocumentosSupervisionDsrInRO p = new ObtenerDocumentosSupervisionDsrInRO();
			p.setIdSupervision(filtro.getIdSupervision());			
			ObtenerDocumentosSupervisionDsrOutRO r = pvoSupervisionEndpoint.obtenerDocumentosSupervisionDsr(p);
			if(BaseConstantesOutBean.SUCCESS.equals(r.getCodigoResultado())){
				result = SupervisionBuilder.toListArchivoSupervisionDTO(r.getDocumentos());
			}else{
				LOG.error("Error al invocar servicio mdiws listaArchivosDsr: " + r.getMensaje());
				throw new NpsException(r.getMensaje());
			}			
		}catch(NpsException ex){
			throw ex;
		}catch(Exception ex){
			LOG.error("error generico al invocar servicio listaArchivosDsr", ex);
			throw new NpsException("error al obtener listado archivos nps dsr");
		}
		return result;
	}

	@Override
	public ArchivoSupervisionDTO descargarArchivo(Long idArchivo) throws NpsException {
		ArchivoSupervisionDTO result = null;
		try{															
			DescargarArchivoInRO p = new DescargarArchivoInRO();
			p.setIdDocumentoAdjunto(idArchivo);			
			DescargarArchivoOutRO r = pvoSupervisionEndpoint.descargarArchivo(p);
			if(BaseConstantesOutBean.SUCCESS.equals(r.getCodigoResultado())){
				result = SupervisionBuilder.toArchivoSupervisionDTO(r.getDocumento());
			}else{
				LOG.error("Error al invocar servicio mdiws descargaArchivoSupervision: " + r.getMensaje());
				throw new NpsException(r.getMensaje());
			}
		}catch(NpsException ex){
			throw ex;
		}catch(Exception ex){
			LOG.error("Error generico al invocar servicio descargarArchivo", ex);
			throw new NpsException("Error al obtener descargarArchivo nps dsr");
		}
		return result;
	}
	
	@Override
    public List<DocumentoAdjuntoDTO> listarDocumentosSiged(String numeroExpediente) throws NpsException {
       LOG.info("listarDocumentosSiged");
       List<DocumentoAdjuntoDTO> retorno=new ArrayList<DocumentoAdjuntoDTO>();
       try{
    	   boolean incluirArchivos = true;
           ListDocumentoOutRO listDocumentoOutRO = ExpedienteInvoker.documentos(URL_SIGED_WS + RELATIVE_URL_SIGED_WS_LISTAR_DOCUMENTOS_EXPEDIENTE, numeroExpediente, incluirArchivos);
           LOG.info("listDocumentoOutRO.getResultCode()-->"+listDocumentoOutRO.getResultCode());
           if(listDocumentoOutRO.getResultCode().equals(InvocationResult.SUCCESS.getCode())){
               retorno = SupervisionBuilder.toListDocumentoAdjuntoDto(listDocumentoOutRO.getDocumento());
               Collections.reverse(retorno);
           }else{
        	   LOG.error("Error al invocar servicio SIGED listarDocumentosSiged: " + listDocumentoOutRO.getMessage());
        	   throw new NpsException(listDocumentoOutRO.getMessage());
           }
       }catch(NpsException ex){
			throw ex;
       }catch(Exception e){
           LOG.error("Error listarDocumentosSiged",e);
           throw new NpsException("Error al obtener documentos del expediente SIGED");
       }
       return retorno;
	}
	 
	@Override
    public File descargarArchivoSiged(DocumentoAdjuntoDTO archivo){
        File retorno = null;
        try{
        	retorno = new File(archivo.getNombreArchivo());
        	retorno = ArchivoInvoker.download(URL_SIGED_WS + RELATIVE_URL_SIGED_WS_DESCARGAR_ARCHIVO, Integer.valueOf(archivo.getIdArchivo().intValue()), retorno);
        }catch(Exception e){
            LOG.error("Error en descargarArchivoSiged",e);
        }
        return retorno;
    }
	
	@Override
	public List<String> obtenerTiposDocumentoSupervisionSigedAdministrado() throws NpsException{
		List<String> tiposDocumento = null;
        try{
        	ObtenerMaestrosColumnaInRO paramObtenerMaestrosColumnaInRO = new ObtenerMaestrosColumnaInRO();
			paramObtenerMaestrosColumnaInRO.setAplicacion(Constantes.APLICACION_INPS);
			paramObtenerMaestrosColumnaInRO.setDominio(Constantes.DOMINIO_TIPO_DOCUMENTO_SUPERVISION_SIGED_ADMINISTRADO);
			ObtenerMaestrosColumnaOutRO obtenerColumnasOutRO = maestroColumnaEndpoint.obtenerMaestrosColumna(paramObtenerMaestrosColumnaInRO);
			if(BaseConstantesOutBean.SUCCESS.equals(obtenerColumnasOutRO.getCodigoResultado())){
				if(obtenerColumnasOutRO.getListaColumnas() != null){
					tiposDocumento = new ArrayList<String>();
					for(MaestroColumnaDTO maestroColumnaDTO : obtenerColumnasOutRO.getListaColumnas()){
						tiposDocumento.add(maestroColumnaDTO.getCodigo());
					}
				}
			}else{
				LOG.error("Error al invocar servicio mdiws obtenerMaestrocColumna: " + obtenerColumnasOutRO.getMensaje());
				throw new NpsException(obtenerColumnasOutRO.getMensaje());
			}
        }catch(NpsException ex){
			throw ex;
        }catch(Exception e){
        	LOG.error("Error obtenerTiposDocumentoSupervisionSigedAdministrado", e);
            throw new NpsException("Error al obtener tipos de documento de supervisión SIGED para el administrado");
        }
        return tiposDocumento;
    }
    
	@Override
	public List<PersonalSupervisionDTO> listadoPersonalSupervision(FiltroPersonalSupervisionDTO filtroPersonal) throws NpsException {
		List<PersonalSupervisionDTO> result = new ArrayList<PersonalSupervisionDTO>();
		try{									
			PersonalFilter filtro = new PersonalFilter();
			if(filtroPersonal != null){
				filtro.setIdActividad(filtroPersonal.getIdActividad());
			}
			ObtenerPersonalInRO p = new ObtenerPersonalInRO();
			p.setFiltro(filtro);
			ObtenerPersonalOutRO r = pvoSupervisionEndpoint.obtenerDirectorioPersonalSupervision(p);
			if(BaseConstantesOutBean.SUCCESS.equals(r.getCodigoResultado())){
				result = PersonalSupervisionBuilder.toListPersonalSupervisionDTO(r.getListado());
			}else{
				LOG.error("Error al invocar servicio mdiws obtenerDirectorioPersonalSupervision: " + r.getMensaje());
				throw new NpsException(r.getMensaje());
			}			
		}catch(NpsException ex){
			throw ex;
		}catch(Exception ex){
			LOG.error("Error generico al invocar servicio obtenerDirectorioPersonalSupervision", ex);
			throw new NpsException("Error al obtener listado listadoPersonalSupervision");
		}
		return result;
	}
	
	@Override
	public File generarDirectorioDescarga(List<PersonalSupervisionDTO> listado) throws Exception {

		Workbook wb = new XSSFWorkbook();

		Font font = wb.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName(Constantes.NOMBRE_FUENTE_REPORTE_DIRECTORIO);

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFont(font);

		String tituloExcel = Constantes.NOMBRE_REPORTE_DIRECTORIO;
		String hojaNombre = Constantes.NOMBRE_HOJA_REPORTE_DIRECTORIO;
		Sheet sheet = null;

		String[] columnas = getColumnasExcel();
		
		sheet = wb.createSheet(hojaNombre);
		int currentRow = 0;
		int startCol = 0;
		Row row = sheet.createRow(currentRow);
		Cell cell = null;
		for(int i = 0; i < columnas.length; i++){
			cell = row.createCell(startCol + i);
			cell.setCellValue(columnas[i]);
			cell.setCellStyle(cellStyle);
		}
        
		for(PersonalSupervisionDTO personalSupervisionDTO : listado){
			currentRow++;
			row = sheet.createRow(currentRow);
            
			cell = row.createCell(startCol);
			cell.setCellValue(personalSupervisionDTO.getNombre());
			cell.setCellStyle(cellStyle);

			cell = row.createCell(startCol + 1);
			cell.setCellValue(personalSupervisionDTO.getApellidoPaterno());
			cell.setCellStyle(cellStyle);
			
			cell = row.createCell(startCol + 2);
			cell.setCellValue(personalSupervisionDTO.getApellidoMaterno());
			cell.setCellStyle(cellStyle);
			
			cell = row.createCell(startCol + 3);
			cell.setCellValue(personalSupervisionDTO.getCorreoElectronico());
			cell.setCellStyle(cellStyle);
		}

		File tempFile = File.createTempFile(tituloExcel + System.currentTimeMillis(), Constantes.EXTENSION_ARCHIVO_EXCEL_XLSX);
		FileOutputStream fos = new FileOutputStream(tempFile);
		wb.write(fos);
		fos.close();
		return tempFile;
	}
	
	@Override
	public File generarDirectorioDescargaVacio() throws Exception {
		
		Workbook wb = new XSSFWorkbook();

		Font font = wb.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName(Constantes.NOMBRE_FUENTE_REPORTE_DIRECTORIO);

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFont(font);

		String tituloExcel = Constantes.NOMBRE_REPORTE_DIRECTORIO;
		String hojaNombre = Constantes.NOMBRE_HOJA_REPORTE_DIRECTORIO;
		Sheet sheet = null;

		String[] columnas = getColumnasExcel();
		
		sheet = wb.createSheet(hojaNombre);
		int currentRow = 0;
		int startCol = 0;
		Row row = sheet.createRow(currentRow);
		Cell cell = null;
		for(int i = 0; i < columnas.length; i++){
			cell = row.createCell(startCol + i);
			cell.setCellValue(columnas[i]);
			cell.setCellStyle(cellStyle);
		}
		
		File tempFile = File.createTempFile(tituloExcel + System.currentTimeMillis(), Constantes.EXTENSION_ARCHIVO_EXCEL_XLSX);
		FileOutputStream fos = new FileOutputStream(tempFile);
		wb.write(fos);
		fos.close();
		return tempFile;
		
	}
	
	private String[] getColumnasExcel(){
		String[]  columnas = {
				Constantes.COLUMNA_NOMBRE_REPORTE_DIRECTORIO,
				Constantes.COLUMNA_APELLIDO_PATERNO_REPORTE_DIRECTORIO,
				Constantes.COLUMNA_APELLIDO_MATERNO_REPORTE_DIRECTORIO,
				Constantes.COLUMNA_CORREO_ELECTRONICO_REPORTE_DIRECTORIO
		};
		 
		return columnas; 
	}
}
