/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;


import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.PersonaNaturalVFilter;
import gob.osinergmin.sibad.service.exception.PersonaNaturalVException;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface PersonaNaturalVDAO {
    public List<PersonaNaturalVDTO> find(PersonaNaturalVFilter filtro) throws PersonaNaturalVException;
    public List<PersonaNaturalVDTO> llenarTablaPersonaNatural(Long idPersonaNatural, String numeroDoc, String apellidoPaterno, String apellidoMaterno,String nombre) throws PersonaNaturalVException;
	public PersonaNaturalVDTO create(PersonaNaturalVDTO personaNaturalDTO, UsuarioDTO usuarioDTO);
	public PersonaNaturalVDTO update(PersonaNaturalVDTO personaNaturalDTO, UsuarioDTO usuarioDTO) throws PersonaNaturalVException;
}
