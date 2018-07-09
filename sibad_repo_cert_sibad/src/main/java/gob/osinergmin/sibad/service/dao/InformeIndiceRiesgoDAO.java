package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.InformeIndiceRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.InformeIndiceRiesgoFilter;

public interface InformeIndiceRiesgoDAO {

	public InformeIndiceRiesgoDTO create(InformeIndiceRiesgoDTO informeIndiceRiesgoDTO, UsuarioDTO usuarioDTO);
	public List<InformeIndiceRiesgoDTO> find(InformeIndiceRiesgoFilter filtro);

}
