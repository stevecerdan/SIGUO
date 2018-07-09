package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.CompartimientoFilter;


public interface CompartimientoService {

	public List<CompartimientoDTO> ListarCompartimiento(CompartimientoFilter filtro);
	public List<CompartimientoDTO> ListarCompartimientoPorId(CompartimientoFilter filtro);
	public List<CompartimientoDTO> ListarCompartimientoV(CompartimientoFilter filtro);
	public CompartimientoDTO RegistrarCompartimiento(CompartimientoDTO compartimientoDTO, UsuarioDTO usuarioDTO);
	public CompartimientoDTO EditarCompartimiento(CompartimientoDTO compartimientoDTO,UsuarioDTO usuarioDTO);

}
