package gob.osinergmin.sibad.domain.dto;

public class PersAutPorTipoPruebaDTO {
    
	private Long idSedePersonalAutorizado;
    private String idTipoPrueba;   
    private String estadoAlcance;  
    private String flagSedePersonalAutoriazado;  
    private Long idEmpresaAcreditada;
    private String nombreCompleto;
	
    public Long getIdSedePersonalAutorizado() {
		return idSedePersonalAutorizado;
	}
	public void setIdSedePersonalAutorizado(Long idSedePersonalAutorizado) {
		this.idSedePersonalAutorizado = idSedePersonalAutorizado;
	}
	public String getIdTipoPrueba() {
		return idTipoPrueba;
	}
	public void setIdTipoPrueba(String idTipoPrueba) {
		this.idTipoPrueba = idTipoPrueba;
	}
	public String getEstadoAlcance() {
		return estadoAlcance;
	}
	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}
	public String getFlagSedePersonalAutoriazado() {
		return flagSedePersonalAutoriazado;
	}
	public void setFlagSedePersonalAutoriazado(String flagSedePersonalAutoriazado) {
		this.flagSedePersonalAutoriazado = flagSedePersonalAutoriazado;
	}
	public Long getIdEmpresaAcreditada() {
		return idEmpresaAcreditada;
	}
	public void setIdEmpresaAcreditada(Long idEmpresaAcreditada) {
		this.idEmpresaAcreditada = idEmpresaAcreditada;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
      
}
