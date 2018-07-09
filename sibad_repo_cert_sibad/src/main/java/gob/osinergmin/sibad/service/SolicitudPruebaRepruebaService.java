/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;

import java.util.List;

/**
 * @author jpiro
 */

public interface SolicitudPruebaRepruebaService {
	
    public List<SolicitudPruebaRepruebaDTO> listarSolicitudPruebaReprueba(SolicitudPruebaRepruebaFilter filtro);
    public SolicitudPruebaRepruebaDTO RegistrarSolicitudPruebaReprueba(SolicitudPruebaRepruebaDTO SolicitudPruebaRepruebaDTO,UsuarioDTO usuarioDTO);
    public SolicitudPruebaRepruebaDTO EditarSolicitudPruebaReprueba(SolicitudPruebaRepruebaDTO SolicitudPruebaRepruebaDTO,UsuarioDTO usuarioDTO);
}
