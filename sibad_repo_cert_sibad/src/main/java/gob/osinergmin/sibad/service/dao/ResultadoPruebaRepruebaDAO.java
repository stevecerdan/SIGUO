package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaRepruebaFilter;


public interface ResultadoPruebaRepruebaDAO {

	public ResultadoPruebaRepruebaDTO create(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaRepruebaDTO update(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaRepruebaDTO updateFechaProxPrueba(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO);
	public List<ResultadoPruebaRepruebaDTO> find(ResultadoPruebaRepruebaFilter filtro);
}
