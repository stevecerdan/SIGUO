/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
//import gob.osinergmin.sibad.domain.dto.BaseLegalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SedePersonalAutorizadoFilter;
import gob.osinergmin.sibad.service.exception.SedePersonalAutorizadoException;
import java.util.List;

/**
 *
 */
public interface SedePersonalAutorizadoDAO {
	
    public List<SedePersonalAutorizadoDTO> find(SedePersonalAutorizadoFilter filtro) throws SedePersonalAutorizadoException;
    public SedePersonalAutorizadoDTO create(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO,UsuarioDTO usuarioDTO)throws SedePersonalAutorizadoException;
    public SedePersonalAutorizadoDTO eliminarSedePersonal(SedePersonalAutorizadoDTO personalAutorizadoDTO) throws SedePersonalAutorizadoException;

}
