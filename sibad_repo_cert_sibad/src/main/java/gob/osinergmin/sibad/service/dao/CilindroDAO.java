package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.CilindroGNVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;

public interface CilindroDAO {
	public CilindroGNVDTO create(CilindroGNVDTO cilindroGnvDTO, UsuarioDTO usuarioDTO);
}
