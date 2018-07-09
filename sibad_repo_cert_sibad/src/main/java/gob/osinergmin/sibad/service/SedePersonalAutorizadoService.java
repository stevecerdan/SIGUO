/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SedePersonalAutorizadoFilter;
import gob.osinergmin.sibad.service.exception.SedePersonalAutorizadoException;

import java.util.List;

/**
 * @author jpiro
 */

public interface SedePersonalAutorizadoService {
    public List<SedePersonalAutorizadoDTO> listarSedePersonalAutorizado(SedePersonalAutorizadoFilter filtro);
    public SedePersonalAutorizadoDTO RegistrarSedePersonalAutorizado(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO,UsuarioDTO usuarioDTO);
    public SedePersonalAutorizadoDTO eliminarPersonal(SedePersonalAutorizadoDTO personalAutorizadoDTO) throws SedePersonalAutorizadoException;
    public SedePersonalAutorizadoDTO EditarSedePersonalAutorizado(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO,UsuarioDTO usuarioDTO);
}
