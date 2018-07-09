package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoRevisionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoRevisionFilter;

public interface ResultadoRevisionDAO {

	public ResultadoRevisionDTO create(ResultadoRevisionDTO resultadoRevDTO, UsuarioDTO usuarioDTO);
	public List<ResultadoRevisionDTO> find(ResultadoRevisionFilter filtro);

}
