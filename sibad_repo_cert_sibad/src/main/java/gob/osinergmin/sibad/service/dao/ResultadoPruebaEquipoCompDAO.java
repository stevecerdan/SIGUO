package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaEquipoCompDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaEquipoCompFilter;

public interface ResultadoPruebaEquipoCompDAO {

	public ResultadoPruebaEquipoCompDTO create(ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaEquipoCompDTO delete(ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO,UsuarioDTO usuarioDTO);
	public List<ResultadoPruebaEquipoCompDTO> find(ResultadoPruebaEquipoCompFilter filtro);
	
}
