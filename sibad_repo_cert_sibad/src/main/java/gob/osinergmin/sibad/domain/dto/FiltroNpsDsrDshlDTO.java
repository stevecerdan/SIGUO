package gob.osinergmin.sibad.domain.dto;

import java.util.List;

public class FiltroNpsDsrDshlDTO {
	
	private List<String> codigosOsinergminPermitidos;
	private String codigoOsinergmin;
	private String registroHidrocarburos;
	private String periodoSupervision;
	private String numeroExpediente;
	private String numeroOrdenServicio;
	
	public List<String> getCodigosOsinergminPermitidos() {
		return codigosOsinergminPermitidos;
	}

	public void setCodigosOsinergminPermitidos(
			List<String> codigosOsinergminPermitidos) {
		this.codigosOsinergminPermitidos = codigosOsinergminPermitidos;
	}

	public String getCodigoOsinergmin() {
		return codigoOsinergmin;
	}
	
	public void setCodigoOsinergmin(String codigoOsinergmin) {
		this.codigoOsinergmin = codigoOsinergmin;
	}
	
	public String getRegistroHidrocarburos() {
		return registroHidrocarburos;
	}
	
	public void setRegistroHidrocarburos(String registroHidrocarburos) {
		this.registroHidrocarburos = registroHidrocarburos;
	}
	
	public String getPeriodoSupervision() {
		return periodoSupervision;
	}
	
	public void setPeriodoSupervision(String periodoSupervision) {
		this.periodoSupervision = periodoSupervision;
	}
	
	public String getNumeroExpediente() {
		return numeroExpediente;
	}
	
	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}
	
	public String getNumeroOrdenServicio() {
		return numeroOrdenServicio;
	}
	
	public void setNumeroOrdenServicio(String numeroOrdenServicio) {
		this.numeroOrdenServicio = numeroOrdenServicio;
	}
	
}
