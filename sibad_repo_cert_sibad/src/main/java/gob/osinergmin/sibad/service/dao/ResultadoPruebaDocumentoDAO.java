package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaDocumentoFilter;

public interface ResultadoPruebaDocumentoDAO {

	public ResultadoPruebaDocumentoDTO create(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaDocumentoDTO update(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaDocumentoDTO delete(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO,UsuarioDTO usuarioDTO);
	public List<ResultadoPruebaDocumentoVDTO> find(ResultadoPruebaDocumentoFilter filtro);

}
