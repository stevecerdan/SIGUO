/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.dto;

import java.io.Serializable;

/**
 *
 * @author DSR
 */
public class UsuarioDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String login;
    private String nombre;
    private String tipo;
    private String terminal;

    public UsuarioDTO() {
            super();
    }

    public UsuarioDTO(String login, String terminal) {
            super();
            this.login = login;
            this.terminal = terminal;
    }

    public String getLogin() {
            return login;
    }

    public void setLogin(String login) {
            this.login = login;
    }

    public String getTerminal() {
            return terminal;
    }

    public void setTerminal(String terminal) {
            this.terminal = terminal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
    
}
