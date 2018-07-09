package gob.osinergmin.sibad.filter;

import java.util.Date;

import gob.osinergmin.sibad.filter.base.BasePaginatorFilter;

public class InformeSolicitudPruebaFilter extends BasePaginatorFilter{

	    private Long idInformeSolicitudPrueba;
		private Long idSolicitudPruebaReprueba;
		private Long idInformeIndiceRiesgo;
		private Date FechaProximaPrueba;
		
		
		public Long getIdInformeSolicitudPrueba() {
			return idInformeSolicitudPrueba;
		}
		public void setIdInformeSolicitudPrueba(Long idInformeSolicitudPrueba) {
			this.idInformeSolicitudPrueba = idInformeSolicitudPrueba;
		}
		public Long getIdSolicitudPruebaReprueba() {
			return idSolicitudPruebaReprueba;
		}
		public void setIdSolicitudPruebaReprueba(Long idSolicitudPruebaReprueba) {
			this.idSolicitudPruebaReprueba = idSolicitudPruebaReprueba;
		}
		public Long getIdInformeIndiceRiesgo() {
			return idInformeIndiceRiesgo;
		}
		public void setIdInformeIndiceRiesgo(Long idInformeIndiceRiesgo) {
			this.idInformeIndiceRiesgo = idInformeIndiceRiesgo;
		}
		public Date getFechaProximaPrueba() {
			return FechaProximaPrueba;
		}
		public void setFechaProximaPrueba(Date fechaProximaPrueba) {
			FechaProximaPrueba = fechaProximaPrueba;
		}
		
}
