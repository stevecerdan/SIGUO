package gob.osinergmin.sibad.filter;

public class RepruebasCilindrosFilter {
	
	private Long idSolicitudPruebaRp;
	private Long idUnidSuperv;
	private Long idCilindro;
    private String numeroReprueba;	
    private Long idEmpresaAcred;
    private String nombreEmpresaAcred;
    private String estado;
    private Long idModulo;
    
    public Long getIdSolicitudPruebaRp() {
		return idSolicitudPruebaRp;
	}
    public void setIdSolicitudPruebaRp(Long idSolicitudPruebaRp) {
		this.idSolicitudPruebaRp = idSolicitudPruebaRp;
	}
    public Long getIdEmpresaAcred() {
		return idEmpresaAcred;
	}
    public void setIdEmpresaAcred(Long idEmpresaAcred) {
		this.idEmpresaAcred = idEmpresaAcred;
	}
    public Long getIdCilindro() {
		return idCilindro;
	}
    public void setIdCilindro(Long idCilindro) {
		this.idCilindro = idCilindro;
	}
    public Long getIdUnidSuperv() {
		return idUnidSuperv;
	}
    public void setIdUnidSuperv(Long idUnidSuperv) {
		this.idUnidSuperv = idUnidSuperv;
	}
    public String getNombreEmpresaAcred() {
		return nombreEmpresaAcred;
	}
    public void setNombreEmpresaAcred(String nombreEmpresaAcred) {
		this.nombreEmpresaAcred = nombreEmpresaAcred;
	}
    public String getNumeroReprueba() {
		return numeroReprueba;
	}
    public void setNumeroReprueba(String numeroReprueba) {
		this.numeroReprueba = numeroReprueba;
	}
    public String getEstado() {
		return estado;
	}
    public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
    
}
