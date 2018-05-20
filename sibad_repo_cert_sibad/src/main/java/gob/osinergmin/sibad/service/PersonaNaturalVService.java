/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaNaturalVFilter;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface PersonaNaturalVService {
    public List<PersonaNaturalVDTO> listarPersonaNatural(PersonaNaturalVFilter filtro);
	public PersonaNaturalVDTO guardarPersonaNatural(PersonaNaturalVDTO personaNaturalDTO, UsuarioDTO usuarioDTO);
}
