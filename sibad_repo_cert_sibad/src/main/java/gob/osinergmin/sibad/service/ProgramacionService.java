package gob.osinergmin.sibad.service;


import java.util.List;

import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ProgramacionFilter;


public interface ProgramacionService {
	
	 public ProgramacionDTO RegistrarProgramacion(ProgramacionDTO programacionDTO,UsuarioDTO usuarioDTO);
	 public List<ProgramacionDTO> ListarUltimoIdCompartimiento(ProgramacionFilter filtro);

}
