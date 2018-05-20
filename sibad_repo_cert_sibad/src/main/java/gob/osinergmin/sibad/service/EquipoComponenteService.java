/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EquipoComponenteFilter;
import gob.osinergmin.sibad.service.exception.EquipoCertificadoException;
import gob.osinergmin.sibad.service.exception.EquipoComponenteException;

import java.util.List;

/**
 * @author jpiro
 */

public interface EquipoComponenteService {
    public List<EquipoComponenteDTO> listarEquipoComponente(EquipoComponenteFilter filtro);
    public EquipoComponenteDTO eliminarComponente(EquipoComponenteDTO equipoComponenteDTO) throws EquipoComponenteException;
	public EquipoComponenteDTO registrarEquipoComponente(EquipoComponenteDTO equipoComponenteDTO,
			UsuarioDTO usuarioDTO);
}
