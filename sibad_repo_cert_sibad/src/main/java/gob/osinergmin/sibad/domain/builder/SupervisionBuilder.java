package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.mdicommon.domain.dto.DetalleSupervisionDshlDTO;
import gob.osinergmin.mdicommon.domain.dto.DetalleSupervisionDsrDTO;
import gob.osinergmin.mdicommon.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.mdicommon.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.mdicommon.domain.pvo.dto.CabeceraSupervisionDTO;
import gob.osinergmin.mdicommon.domain.pvo.dto.DocumentoSupervisionDTO;
import gob.osinergmin.sibad.domain.dto.ArchivoSupervisionDTO;
import gob.osinergmin.sibad.domain.dto.CabeceraNpsDsrDshlDTO;
import gob.osinergmin.sibad.domain.dto.DetalleNpsDshlDTO;
import gob.osinergmin.sibad.domain.dto.DetalleNpsDsrDTO;
import gob.osinergmin.siged.remote.rest.ro.out.ArchivoOutRO;
import gob.osinergmin.siged.remote.rest.ro.out.VersionArchivoOutRO;
import gob.osinergmin.siged.remote.rest.ro.out.list.ListArchivoOutRO;
import gob.osinergmin.siged.remote.rest.ro.out.query.DocumentoConsultaOutRO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class SupervisionBuilder {

	public static List<CabeceraNpsDsrDshlDTO> toListCabeceraNpsDsrDTO(List<CabeceraSupervisionDTO> supervisiones) {
		List<CabeceraNpsDsrDshlDTO> listaCabDto = new ArrayList<CabeceraNpsDsrDshlDTO>();
		if(!CollectionUtils.isEmpty(supervisiones)){
			listaCabDto = new ArrayList<CabeceraNpsDsrDshlDTO>();
			CabeceraNpsDsrDshlDTO itemdto = null;
			for(CabeceraSupervisionDTO dbdto : supervisiones){
				itemdto = toCabeceraNpsDsrDTO(dbdto);
				listaCabDto.add(itemdto);
			}
		}
		return listaCabDto;
	}

	private static CabeceraNpsDsrDshlDTO toCabeceraNpsDsrDTO(CabeceraSupervisionDTO dbdto) {
		CabeceraNpsDsrDshlDTO item = null;
		if(dbdto!=null){
			item = new CabeceraNpsDsrDshlDTO();
			item.setCodigoActividad(dbdto.getCodigoActividad());
			item.setCodigoOsinergmin(dbdto.getCodigoOsinergmin());
			item.setFechaInicioSupervision(dbdto.getFechaSupervisionInicio());			
			item.setFechaFinSupervision(dbdto.getFechaSupervisionFin());
			item.setNroOrdenServicio(dbdto.getNroOrdenServicio());
			item.setNombreActividad(dbdto.getNombreActividad());
			item.setNroExpediente(dbdto.getNroExpediente());
			item.setResultado(dbdto.getResultado());
			item.setTipoSupervision(dbdto.getTipoSupervision());
			item.setIdSupervision(dbdto.getIdSupervision());
			item.setCodigoResultado(dbdto.getCodigoResultado());
			item.setRho(dbdto.getNroRho());
			item.setCodigoMedidaSeguridadEjecutada(dbdto.getCodigoMedidaSeguridadEjecutada());
			item.setNombreMedidaSeguridadEjecutada(dbdto.getNombreMedidaSeguridadEjecutada());
			item.setProductosScopSuspendidos(dbdto.getProductosScopSuspendidos());
			item.setNombreEmpresaSupervisora(dbdto.getNombreEmpresaSupervisora());
			item.setNombreSupervisor(dbdto.getNombreSupervisor());
			item.setNombreEspecialistaOsinergmin(dbdto.getNombreEspecialistaOsinergmin());
			item.setNombreUnidadOrganicaOsinergmin(dbdto.getNombreUnidadOrganicaOsinergmin());
			item.setFechaLimiteMedidaSeguridadEjecutada(dbdto.getFechaLimiteMedidaSeguridadEjecutada());
			item.setIdActividad(dbdto.getIdActividad());
		}
		return item;
	}

	public static List<DetalleNpsDsrDTO> toListDetalleNpsDsrDTO(List<DetalleSupervisionDsrDTO> detalleSupervision) {
		List<DetalleNpsDsrDTO> listaDetDto = new ArrayList<DetalleNpsDsrDTO>();
		if(!CollectionUtils.isEmpty(detalleSupervision)){
			listaDetDto = new ArrayList<DetalleNpsDsrDTO>();
			DetalleNpsDsrDTO itemdto = null;
			for(DetalleSupervisionDsrDTO dbdto : detalleSupervision){
				itemdto = toDetalleNpsDsrDTO(dbdto);
				listaDetDto.add(itemdto);
			}
		}
		return listaDetDto;
	}

	private static DetalleNpsDsrDTO toDetalleNpsDsrDTO(DetalleSupervisionDsrDTO dbdto) {
		DetalleNpsDsrDTO item = null;
		if(dbdto!=null){
			item = new DetalleNpsDsrDTO();
			item.setEscenario(dbdto.getEscenario());
			item.setInfraccion(dbdto.getInfraccion());
			item.setItem(dbdto.getItem());
			item.setPrioridad(dbdto.getPrioridad());
			item.setIdDetalleSupervision(dbdto.getIdDetalleSupervision());
			item.setTieneMediosProbatorios(dbdto.isTieneMediosProbatorios());
			item.setCondicionVerificada(dbdto.getCondicionVerificada());
			if(!CollectionUtils.isEmpty(dbdto.getComentarios())){
				List<String> comentarios = new ArrayList<String>();
				for(String cmt : dbdto.getComentarios()){
					comentarios.add(cmt);
				}
				item.setComentarios(comentarios);
			}
		}
		return item;
	}
	
	public static List<ArchivoSupervisionDTO> toListArchivoSupervisionDTO(List<DocumentoSupervisionDTO> documentos) {
		List<ArchivoSupervisionDTO> listaDetDto = null;
		if(!CollectionUtils.isEmpty(documentos)){
			listaDetDto = new ArrayList<ArchivoSupervisionDTO>();
			ArchivoSupervisionDTO itemdto = null;
			for(DocumentoSupervisionDTO dbdto : documentos){
				itemdto = toArchivoSupervisionDTO(dbdto);
				listaDetDto.add(itemdto);
			}
		}
		return listaDetDto;
	}
	
	public static ArchivoSupervisionDTO toArchivoSupervisionDTO(DocumentoSupervisionDTO dbdto) {
		ArchivoSupervisionDTO archivo = null;
		if(dbdto!=null){
			archivo = new ArchivoSupervisionDTO();
			archivo.setIdArchivo(dbdto.getIdDocumento());
			archivo.setDescripcion(dbdto.getDescripcion());
			archivo.setTipoDocumento(dbdto.getTipoDocumento());
			archivo.setArchivo(dbdto.getArchivo());
			archivo.setNombreArchivo(dbdto.getNombreArchivo());
			if(!CollectionUtils.isEmpty(dbdto.getIdsImagenes())){
				archivo.setIdImagenes(new ArrayList<Long>());
				for(Long idImagen : dbdto.getIdsImagenes()){
					archivo.getIdImagenes().add(idImagen);
				}
			}
		}
		return archivo;
	}
	
	public static List<DetalleNpsDshlDTO> toListDetalleNpsDshlDTO(List<DetalleSupervisionDshlDTO> listaDetalleDshl) {
		List<DetalleNpsDshlDTO> listaDetDto = null;
		if(!CollectionUtils.isEmpty(listaDetalleDshl)){
			listaDetDto = new ArrayList<DetalleNpsDshlDTO>();
			DetalleNpsDshlDTO itemdto = null;
			for(DetalleSupervisionDshlDTO dbdto : listaDetalleDshl){
				itemdto = toDetalleNpsDshlDTO(dbdto);
				listaDetDto.add(itemdto);
			}
		}
		return listaDetDto;
	}

	private static DetalleNpsDshlDTO toDetalleNpsDshlDTO(DetalleSupervisionDshlDTO dbdto) {
		DetalleNpsDshlDTO res = null;
		if(dbdto!=null){
			res = new DetalleNpsDshlDTO();
			res.setBaseLegal(dbdto.getBaseLegal());
			res.setIdDetalleSupervision(dbdto.getIdDetalleSupervision());
			res.setIncumplimiento(dbdto.getIncumplimiento());
			res.setItem(dbdto.getItem());
			res.setTieneMediosProbatorios(dbdto.isTieneMediosProbatorios());
		}
		return res;
	}
	
	public static List<DocumentoAdjuntoDTO> toListDocumentoAdjuntoDto(List<DocumentoConsultaOutRO> lista) {
        DocumentoAdjuntoDTO registroDTO;
        List<DocumentoAdjuntoDTO> retorno = new ArrayList<DocumentoAdjuntoDTO>();
        if (lista != null) {
            for (DocumentoConsultaOutRO documento : lista) {            	
            	ListArchivoOutRO archivosList = documento.getArchivos();
                if (archivosList.getArchivo() != null) {
                	List<ArchivoOutRO> archivos = archivosList.getArchivo();
                    Collections.sort(archivos, new Comparator<ArchivoOutRO>(){
                    	@Override
                    	public int compare(ArchivoOutRO arch1, ArchivoOutRO arch2) {                    		
                    		return arch1.getIdArchivo().compareTo(arch2.getIdArchivo());
                    	}});
                    Collections.reverse(archivos);
                    int maximo= archivos.size()-1;
                    int contador=-1;
                 
                    for (ArchivoOutRO archivo : archivos) {
                    		                 
                    	contador++;
                    	if ((archivo.getVersiones() != null) && (archivo.getVersiones().getVersion() != null))
                            for (VersionArchivoOutRO versionArchivoOutRO : archivo.getVersiones().getVersion()) {
                            	registroDTO = toDocumentoAdjuntoDtoVersiones(archivo, versionArchivoOutRO,documento);
                            	retorno.add(registroDTO);
                        } else {
                        
                        	registroDTO = toDocumentoAdjuntoDto(archivo,documento);
                        	
                        	if(contador == maximo){
                    			registroDTO.getIdTipoDocumento().setDescripcion(registroDTO.getIdTipoDocumento().getDescripcion() + " - Nro. " +documento.getNroDocumento());
                    			registroDTO.getIdTipoDocumento().setCodigo(String.valueOf(documento.getIdTipoDocumento()));
                    			registroDTO.setEnumerado(documento.getEnumerado());
                    			registroDTO.setFirmado(documento.getFirmado());
                        		registroDTO.setAsunto(documento.getAsunto());	                        		
                                registroDTO.setNroDocumento(documento.getNroDocumento());	                               
                        	}else{
                        		registroDTO.getIdTipoDocumento().setDescripcion("");
                        	}
                        	retorno.add(registroDTO);
                        }
                    }                    
                }
            }
        }
        return retorno;
    }
	
	public static DocumentoAdjuntoDTO toDocumentoAdjuntoDtoVersiones(ArchivoOutRO archivo,VersionArchivoOutRO versionArchivo,DocumentoConsultaOutRO documento) {
        DocumentoAdjuntoDTO registroDTO = new DocumentoAdjuntoDTO();
    
        registroDTO.setIdDocumento(new Long(documento.getIdDocumento()));
        MaestroColumnaDTO tipoDoc = new MaestroColumnaDTO();
        tipoDoc.setIdMaestroColumna(new Long(documento.getIdTipoDocumento()));
        tipoDoc.setDescripcion(documento.getNombreTipoDocumento());
        registroDTO.setIdTipoDocumento(tipoDoc);        
        registroDTO.setIdArchivo(new Long(archivo.getIdArchivo()));
        registroDTO.setNombreArchivo(archivo.getNombre());
        registroDTO.setFechaCarga(archivo.getFechaCreacion());
        registroDTO.setVersion(versionArchivo.getLabel());
        registroDTO.setAutor(versionArchivo.getAutor());
        
        return registroDTO;
    }
	
		
	public static DocumentoAdjuntoDTO toDocumentoAdjuntoDto(ArchivoOutRO archivo,DocumentoConsultaOutRO documento) {
        DocumentoAdjuntoDTO registroDTO = new DocumentoAdjuntoDTO();
    
        registroDTO.setIdDocumento(new Long(documento.getIdDocumento()));
        MaestroColumnaDTO tipoDoc = new MaestroColumnaDTO();
        tipoDoc.setCodigo(documento.getIdTipoDocumento().toString());
        tipoDoc.setDescripcion(documento.getNombreTipoDocumento());
        registroDTO.setIdTipoDocumento(tipoDoc);                
        registroDTO.setAsunto(documento.getAsunto());
        registroDTO.setIdArchivo(new Long(archivo.getIdArchivo()));
        registroDTO.setNombreArchivo(archivo.getNombre());
        registroDTO.setFechaCarga(archivo.getFechaCreacion());

        return registroDTO;
    }

}
