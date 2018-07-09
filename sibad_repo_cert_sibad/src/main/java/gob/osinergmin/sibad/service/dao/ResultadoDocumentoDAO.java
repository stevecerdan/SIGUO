package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoDocumentoFilter;
import gob.osinergmin.sibad.filter.ResultadoPersonaNaturalFilter;
import gob.osinergmin.sibad.service.exception.ResultadoDocumentoException;
import gob.osinergmin.sibad.service.exception.ResultadoPersonaNaturalException;

public interface ResultadoDocumentoDAO {
	public List<ResultadoDocumentoDTO> find(ResultadoDocumentoFilter filtro)throws ResultadoDocumentoException;
	public ResultadoDocumentoDTO eliminarDocumento(ResultadoDocumentoDTO resultadoDocumentoDTO);
	public ResultadoDocumentoDTO create(ResultadoDocumentoDTO resultadoDocDTO, UsuarioDTO usuarioDTO);

}
