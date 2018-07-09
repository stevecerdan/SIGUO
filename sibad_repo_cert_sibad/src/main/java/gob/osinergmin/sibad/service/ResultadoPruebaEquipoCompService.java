package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaEquipoCompDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaEquipoCompFilter;

public interface ResultadoPruebaEquipoCompService {
	
	public ResultadoPruebaEquipoCompDTO RegistrarResultadoPruebaEquipoComp(ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaEquipoCompDTO EliminarResultadoPruebaEquipoComp(ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO,UsuarioDTO usuarioDTO);
	public List<ResultadoPruebaEquipoCompDTO> consultarResultadoPruebaEquipoComp(ResultadoPruebaEquipoCompFilter filtro);
	
}
