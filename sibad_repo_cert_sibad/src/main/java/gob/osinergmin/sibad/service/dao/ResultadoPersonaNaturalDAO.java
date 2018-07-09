package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPersonaNaturalFilter;
import gob.osinergmin.sibad.service.exception.ResultadoPersonaNaturalException;

public interface ResultadoPersonaNaturalDAO {
    public List<ResultadoPersonaNaturalDTO> find(ResultadoPersonaNaturalFilter filtro) throws ResultadoPersonaNaturalException;
	public ResultadoPersonaNaturalDTO create(ResultadoPersonaNaturalDTO resultadoPersonaNaturalDTO, UsuarioDTO usuarioDTO);
	public ResultadoPersonaNaturalDTO eliminarPersonal(ResultadoPersonaNaturalDTO resultadoPersonaDTO);
}
