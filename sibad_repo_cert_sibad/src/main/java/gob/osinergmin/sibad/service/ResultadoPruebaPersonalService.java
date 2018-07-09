package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaPersonalFilter;

public interface ResultadoPruebaPersonalService {

	public ResultadoPruebaPersonalDTO RegistrarResultadoPruebaPersonal(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaPersonalDTO EditarResultadoPruebaPersonal(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaPersonalDTO EliminarResultadoPruebaPersonal(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO,UsuarioDTO usuarioDTO);
	public List<ResultadoPruebaPersonalDTO> consultarResultadoPruebaPersonal(ResultadoPruebaPersonalFilter filtro);
	public List<ResultadoPruebaPersonalDTO> consultarResultadoPruebaPersonalV(ResultadoPruebaPersonalFilter filtro);

}
