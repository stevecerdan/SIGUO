package gob.osinergmin.sibad.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class FiltroArchivoPdfNpsDTO {
	
	private List<Long> idArchivo = new ArrayList<Long>();
	private List<Long> idArchivoImagen = new ArrayList<Long>();
	private List<ArchivoSupervisionDTO> archivosSiged = new ArrayList<ArchivoSupervisionDTO>();

	public FiltroArchivoPdfNpsDTO(){
		idArchivo = new ArrayList<Long>();
		idArchivoImagen = new ArrayList<Long>();
		archivosSiged = new ArrayList<ArchivoSupervisionDTO>();
	}
	
	public List<Long> getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(List<Long> idArchivo) {
		this.idArchivo = idArchivo;
	}

	public List<Long> getIdArchivoImagen() {
		return idArchivoImagen;
	}

	public void setIdArchivoImagen(List<Long> idArchivoImagen) {
		this.idArchivoImagen = idArchivoImagen;
	}

	public List<ArchivoSupervisionDTO> getArchivosSiged() {
		return archivosSiged;
	}

	public void setArchivosSiged(List<ArchivoSupervisionDTO> archivosSiged) {
		this.archivosSiged = archivosSiged;
	}	

}
