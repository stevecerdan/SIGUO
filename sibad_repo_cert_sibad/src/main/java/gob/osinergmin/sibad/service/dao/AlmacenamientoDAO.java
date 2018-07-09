package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlmacenamientoFilter;
import gob.osinergmin.sibad.service.exception.AlmacenamientoException;

public interface AlmacenamientoDAO {

	 public List<AlmacenamientoDTO> find(AlmacenamientoFilter filtro) throws AlmacenamientoException;

	public AlmacenamientoDTO create(AlmacenamientoDTO almacenamientoDTO, UsuarioDTO usuarioDTO);
}
