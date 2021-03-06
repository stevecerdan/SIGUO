/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface PersonaJuridicaService {
    public List<PersonaJuridicaDTO> listarPersonaJuridica(PersonaJuridicaFilter filtro);
    public PersonaJuridicaDTO RegistrarPersonaJuridica(PersonaJuridicaDTO personaJuridicaDTO,UsuarioDTO usuarioDTO);
    public PersonaJuridicaDTO EditarPersonaJuridica(PersonaJuridicaDTO personaJuridicaDTO,UsuarioDTO usuarioDTO);
}
