package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.CilindroGNVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;

public interface CilindroService {

	public CilindroGNVDTO RegistrarCilindro(CilindroGNVDTO cilindroGnvDTO, UsuarioDTO usuarioDTO);

}
