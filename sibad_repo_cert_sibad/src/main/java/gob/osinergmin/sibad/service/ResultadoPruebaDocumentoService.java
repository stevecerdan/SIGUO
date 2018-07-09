package gob.osinergmin.sibad.service;

import java.util.List;


import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaDocumentoFilter;

public interface ResultadoPruebaDocumentoService {

	public ResultadoPruebaDocumentoDTO RegistrarResultadoPruebaDocumento(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaDocumentoDTO EditarResultadoPruebaDocumento(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO, UsuarioDTO usuarioDTO);
	public ResultadoPruebaDocumentoDTO EliminarResultadoPruebaDocumento(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO,UsuarioDTO usuarioDTO);
	public List<ResultadoPruebaDocumentoVDTO> listarResultadoPruebaDocumento(ResultadoPruebaDocumentoFilter filtro);
}
