package gob.osinergmin.sibad.service;

import java.io.File;
import java.util.List;

import gob.osinergmin.mdicommon.domain.dto.DocumentoAdjuntoDTO;
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
import gob.osinergmin.sibad.service.exception.NpsException;

public interface SupervisionService {

	public UnidadSupervisadaDTO obtenerUnidadSupervisada(Long idUnidadSupervisada) throws Exception;
	
	public UnidadSupervisadaDTO obtenerUnidadSupervisadaByRuc(String rucUnidadSupervisada) throws Exception;
	
	public UnidadSupervisadaDTO obtenerUnidadSupervisadaByCodigoOsinergmin(String codigoOsinergminUnidadSupervisada) throws Exception;
	
	public List<CabeceraNpsDsrDshlDTO> listaCabeceraNpsDshl(FiltroNpsDsrDshlDTO filtro) throws NpsException;

	public List<DetalleNpsDshlDTO> listaDetalleNpsDshl(FiltroDetalleNpsDshlDTO filtro) throws NpsException;
	
	public List<CabeceraNpsDsrDshlDTO> listaCabeceraNpsDsr(FiltroNpsDsrDshlDTO filtro) throws NpsException;        

	public List<DetalleNpsDsrDTO> listaDetalleNpsDsr(FiltroDetalleNpsDsrDTO filtro) throws NpsException;                             
	
	public List<ArchivoSupervisionDTO> listaArchivosDetalleSup(Long idDetalleSup) throws NpsException;
	
	public List<ArchivoSupervisionDTO> listaArchivos(FiltroArchivoNpsDTO filtro) throws NpsException;

	public ArchivoSupervisionDTO descargarArchivo(Long idArchivo) throws NpsException;

	public List<DocumentoAdjuntoDTO> listarDocumentosSiged(String numeroExpediente) throws NpsException;

	public File descargarArchivoSiged(DocumentoAdjuntoDTO archivo);
	
	public List<String> obtenerTiposDocumentoSupervisionSigedAdministrado() throws NpsException;

	public List<PersonalSupervisionDTO> listadoPersonalSupervision(FiltroPersonalSupervisionDTO filtroPersonal) throws NpsException;

	public File generarDirectorioDescarga(List<PersonalSupervisionDTO> listado) throws Exception;

	public File generarDirectorioDescargaVacio() throws Exception;

}
