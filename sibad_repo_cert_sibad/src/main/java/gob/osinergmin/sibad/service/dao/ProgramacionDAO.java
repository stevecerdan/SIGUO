package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.ProgramacionVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ProgramacionFilter;
import gob.osinergmin.sibad.service.exception.ProgramacionException;

public interface ProgramacionDAO {

	public ProgramacionDTO create(ProgramacionDTO programacionDTO,UsuarioDTO usuarioDTO)throws ProgramacionException;
	public ProgramacionDTO update(ProgramacionDTO programacionDTO,UsuarioDTO usuarioDTO)throws ProgramacionException;
	public ProgramacionDTO delete(ProgramacionDTO programacionDTO,UsuarioDTO usuarioDTO)throws ProgramacionException;
	public List<ProgramacionVDTO> findV(ProgramacionFilter filtro) throws ProgramacionException;
	public List<ProgramacionVDTO> findProgramacionesVencidas(ProgramacionFilter filtro) throws ProgramacionException;

}
