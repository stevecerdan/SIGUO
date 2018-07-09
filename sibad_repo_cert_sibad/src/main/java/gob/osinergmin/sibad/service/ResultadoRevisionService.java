package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoRevisionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoRevisionFilter;

public interface ResultadoRevisionService {
	public ResultadoRevisionDTO RegistrarResultadoRevision(ResultadoRevisionDTO resultadoRevDTO, UsuarioDTO usuarioDTO);
	public List<ResultadoRevisionDTO> listarResultadoRevision(ResultadoRevisionFilter filtro);

}
