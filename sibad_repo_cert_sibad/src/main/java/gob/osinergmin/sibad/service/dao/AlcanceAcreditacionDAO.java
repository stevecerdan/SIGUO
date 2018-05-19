package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.service.exception.AlcanceAcreditacionException;

public interface AlcanceAcreditacionDAO {
	 public List<AlcanceAcreditacionDTO> find(AlcanceAcreditacionFilter filtro) throws AlcanceAcreditacionException;
	 public AlcanceAcreditacionDTO update(AlcanceAcreditacionDTO alcanceAcreditacionDTO , UsuarioDTO usuarioDTO) throws AlcanceAcreditacionException;
	 public AlcanceAcreditacionDTO create(AlcanceAcreditacionDTO alcanceAcreditacionDTO , UsuarioDTO usuarioDTO) throws AlcanceAcreditacionException;
	 AlcanceAcreditacionDTO update2(AlcanceAcreditacionDTO alcanceAcreditacionDTO, UsuarioDTO usuarioDTO) throws AlcanceAcreditacionException;
}
