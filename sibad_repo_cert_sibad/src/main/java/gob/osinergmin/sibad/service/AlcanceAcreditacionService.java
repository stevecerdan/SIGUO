package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;

public interface AlcanceAcreditacionService {
	
     public List<AlcanceAcreditacionDTO> listarDatosAlcance(AlcanceAcreditacionFilter filtro);	
	 public AlcanceAcreditacionDTO EditarEstadoAlcanceEmpresa(AlcanceAcreditacionDTO alcanceAcreditacionDTO, UsuarioDTO usuarioDTO);
	 public AlcanceAcreditacionDTO EditarEstadoAlcanceAcreditacion(AlcanceAcreditacionDTO alcanceAcreditacionDTO, UsuarioDTO usuarioDTO);
	 public AlcanceAcreditacionDTO RegistrarAlcanceAcreditacion(AlcanceAcreditacionDTO alcanceAcreditacionDTO, UsuarioDTO usuarioDTO);

}
