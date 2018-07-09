package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.InformeIndiceRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.InformeIndiceRiesgoFilter;

public interface InformeIndiceRiesgoService {
	
	public InformeIndiceRiesgoDTO RegistrarInformeIndiceRiesgo(InformeIndiceRiesgoDTO informeIndiceRiesgoDTO, UsuarioDTO usuarioDTO);
	public List<InformeIndiceRiesgoDTO> ListarInformeIndiceRiesgo(InformeIndiceRiesgoFilter filtro);

}
