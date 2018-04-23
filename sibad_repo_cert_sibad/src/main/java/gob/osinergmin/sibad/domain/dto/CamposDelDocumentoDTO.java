package gob.osinergmin.sibad.domain.dto;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class CamposDelDocumentoDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	 private byte[] plantilla;
	//DATOS PARA SIGED
    private File archivoAdjunto;
    private Integer usuarioIDDestinatario;
    private String nombreDocumento;
    private String actividadEmpresa;
    private String numeroExpediente;
    private String ruc;
    private List<File> listaArchivosSiged;
    
    //DATOS DE RETORNO
    private String asunto;
    private String autor;
    private String numeroDocumento;
    private String propietario;
    private int idArchivo;
    private String archivo;
    private String descripcion;
    private String version;
    private String author; 
    private Date fecha;    
    private String ubigeo;
    private long idDependencia;
    
	public byte[] getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(byte[] plantilla) {
		this.plantilla = plantilla;
	}
	public File getArchivoAdjunto() {
		return archivoAdjunto;
	}
	public void setArchivoAdjunto(File archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
	public Integer getUsuarioIDDestinatario() {
		return usuarioIDDestinatario;
	}
	public void setUsuarioIDDestinatario(Integer usuarioIDDestinatario) {
		this.usuarioIDDestinatario = usuarioIDDestinatario;
	}
	public String getNombreDocumento() {
		return nombreDocumento;
	}
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}
	public String getActividadEmpresa() {
		return actividadEmpresa;
	}
	public void setActividadEmpresa(String actividadEmpresa) {
		this.actividadEmpresa = actividadEmpresa;
	}
	public String getNumeroExpediente() {
		return numeroExpediente;
	}
	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}
	public List<File> getListaArchivosSiged() {
		return listaArchivosSiged;
	}
	public void setListaArchivosSiged(List<File> listaArchivosSiged) {
		this.listaArchivosSiged = listaArchivosSiged;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	public int getIdArchivo() {
		return idArchivo;
	}
	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public long getIdDependencia() {
		return idDependencia;
	}
	public void setIdDependencia(long idDependencia) {
		this.idDependencia = idDependencia;
	}
		
}
