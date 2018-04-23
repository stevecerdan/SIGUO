package gob.osinergmin.sibad.domain.dto;

import java.io.Serializable;

public class UnidadOperativaDTO implements Serializable {

    private Long idUnidad;
    private String codigoOsinergmin;
    private String registroHidrocarburos;
    private String razonSocial;
    private String ruc;
    private String actividad;
    private String direccion;
    private String telefono;
    private String correo; 
    private String ubigeo;
    private String codigo;    
    private String departamento;
    private String provincia;
    private String distrito;    
    private String iddepartamento;
    private String idprovincia;
    private String iddistrito;
    private String idDependencia;
    private String dependencia;
    
    public Long getIdUnidad() {
        return idUnidad;
    }
    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
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
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getActividad() {
        return actividad;
    }
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getIddepartamento() {
		return iddepartamento;
	}
	public void setIddepartamento(String iddepartamento) {
		this.iddepartamento = iddepartamento;
	}
	public String getIdprovincia() {
		return idprovincia;
	}
	public void setIdprovincia(String idprovincia) {
		this.idprovincia = idprovincia;
	}
	public String getIddistrito() {
		return iddistrito;
	}
	public void setIddistrito(String iddistrito) {
		this.iddistrito = iddistrito;
	}
	@Override
    public String toString() {
        return "UnidadOperativaDTO{" + "idUnidad=" + idUnidad + ", codigoOsinergmin=" + codigoOsinergmin + ", registroHidrocarburos=" + registroHidrocarburos + ", razonSocial=" + razonSocial + ", ruc=" + ruc + ", actividad=" + actividad + ", direccion=" + direccion + ", ubigeo=" + ubigeo + ", codigo=" + codigo + '}';
    }
	public void setIdDependencia(String idDependencia) {
		this.idDependencia = idDependencia;
	}
	public String getIdDependencia() {
		return idDependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public String getDependencia() {
		return dependencia;
	}
    
}
