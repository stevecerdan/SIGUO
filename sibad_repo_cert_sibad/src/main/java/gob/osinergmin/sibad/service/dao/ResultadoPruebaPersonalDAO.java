package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaPersonalFilter;

public interface ResultadoPruebaPersonalDAO {
	
	public ResultadoPruebaPersonalDTO create(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaPersonalDTO update(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaPersonalDTO delete(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO,UsuarioDTO usuarioDTO);
	public List<ResultadoPruebaPersonalDTO> find(ResultadoPruebaPersonalFilter filtro);
	public List<ResultadoPruebaPersonalDTO> find2(ResultadoPruebaPersonalFilter filtro);

}
