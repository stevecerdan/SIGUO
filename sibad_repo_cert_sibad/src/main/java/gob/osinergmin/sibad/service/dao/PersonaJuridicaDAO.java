/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.service.exception.PersonaJuridicaException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface PersonaJuridicaDAO {
    public List<PersonaJuridicaDTO> find(PersonaJuridicaFilter filtro) throws PersonaJuridicaException;
    public PersonaJuridicaDTO create(PersonaJuridicaDTO personaJuridicaDTO, UsuarioDTO usuarioDTO) throws PersonaJuridicaException;
    //public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException;
}
