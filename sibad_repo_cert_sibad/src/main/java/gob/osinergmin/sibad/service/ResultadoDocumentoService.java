package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoDocumentoFilter;
import gob.osinergmin.sibad.service.exception.ResultadoDocumentoException;

public interface ResultadoDocumentoService {
	public List<ResultadoDocumentoDTO> listarResultadoDocumento(ResultadoDocumentoFilter filtro);
	public ResultadoDocumentoDTO eliminarDocumento(ResultadoDocumentoDTO resultadoDocumentoDTO) throws ResultadoDocumentoException;
	public ResultadoDocumentoDTO RegistrarResultadoDocumento(ResultadoDocumentoDTO resultadoDocDTO, UsuarioDTO usuarioDTO);

}
