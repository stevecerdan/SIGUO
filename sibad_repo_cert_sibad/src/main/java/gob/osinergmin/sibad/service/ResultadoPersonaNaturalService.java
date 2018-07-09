package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPersonaNaturalFilter;
import gob.osinergmin.sibad.service.exception.ResultadoPersonaNaturalException;

public interface ResultadoPersonaNaturalService {
    public List<ResultadoPersonaNaturalDTO> listarResultadoPersonaNatural(ResultadoPersonaNaturalFilter filtro);
	public ResultadoPersonaNaturalDTO guardarResultadoPersonaNatural(ResultadoPersonaNaturalDTO resultadoPersonaNaturalDTO, UsuarioDTO usuarioDTO);
	public ResultadoPersonaNaturalDTO eliminarPersonal(ResultadoPersonaNaturalDTO resultadoPersonaDTO) throws ResultadoPersonaNaturalException;
}
