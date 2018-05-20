/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EquipoComponenteFilter;
import gob.osinergmin.sibad.service.exception.EquipoComponenteException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface EquipoComponenteDAO {
    public List<EquipoComponenteDTO> find(EquipoComponenteFilter filtro) throws EquipoComponenteException;
	public EquipoComponenteDTO eliminar(EquipoComponenteDTO equipoComponenteDTO) throws EquipoComponenteException;
	public EquipoComponenteDTO create(EquipoComponenteDTO equipoComponenteDTO, UsuarioDTO usuarioDTO);
	
}
