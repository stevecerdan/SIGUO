package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaRepruebaFilter;

public interface ResultadoPruebaRepruebaService {

	public ResultadoPruebaRepruebaDTO RegistrarResultadoPruebaReprueba(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaRepruebaDTO EditarResultadoPruebaReprueba(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaRepruebaDTO EditarFechaProxPruebaResultadoPruebaReprueba(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO);
	public List<ResultadoPruebaRepruebaDTO> listarResultadoPruebaReprueba(ResultadoPruebaRepruebaFilter filtro);

}
