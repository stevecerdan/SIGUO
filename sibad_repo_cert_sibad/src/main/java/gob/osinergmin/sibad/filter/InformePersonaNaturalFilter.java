package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class InformePersonaNaturalFilter  extends BasePaginatorFilter{

	    private Long idInformePersonaNatural;
		private Long idInformeIndiceRiesgo;
		private Long idPersonaNatural;
		
		//VIEW
			
		private Long idTipoDocumentoIdentidad;
		private String tipoDocumento;
		private String numeroDocumento;
		private String apellidoPaterno;
		private String apellidoMaterno;
		private String nombre;
		private String nombreCompleto;
		private String cip;
		
		
		public Long getIdInformePersonaNatural() {
			return idInformePersonaNatural;
		}
		public void setIdInformePersonaNatural(Long idInformePersonaNatural) {
			this.idInformePersonaNatural = idInformePersonaNatural;
		}
		public Long getIdInformeIndiceRiesgo() {
			return idInformeIndiceRiesgo;
		}
		public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
			this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
		}
		public Long getIdPersonaNatural() {
			return idPersonaNatural;
		}
		public void setIdPersonaNatural(Long idPersonaNatural) {
			this.idPersonaNatural = idPersonaNatural;
		}
		public Long getIdTipoDocumentoIdentidad() {
			return idTipoDocumentoIdentidad;
		}
		public void setIdTipoDocumentoIdentidad(Long idTipoDocumentoIdentidad) {
			this.idTipoDocumentoIdentidad = idTipoDocumentoIdentidad;
		}
		public String getTipoDocumento() {
			return tipoDocumento;
		}
		public void setTipoDocumento(String tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
		}
		public String getNumeroDocumento() {
			return numeroDocumento;
		}
		public void setNumeroDocumento(String numeroDocumento) {
			this.numeroDocumento = numeroDocumento;
		}
		public String getApellidoPaterno() {
			return apellidoPaterno;
		}
		public void setApellidoPaterno(String apellidoPaterno) {
			this.apellidoPaterno = apellidoPaterno;
		}
		public String getApellidoMaterno() {
			return apellidoMaterno;
		}
		public void setApellidoMaterno(String apellidoMaterno) {
			this.apellidoMaterno = apellidoMaterno;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getNombreCompleto() {
			return nombreCompleto;
		}
		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}
		public String getCip() {
			return cip;
		}
		public void setCip(String cip) {
			this.cip = cip;
		}
		
		
}
