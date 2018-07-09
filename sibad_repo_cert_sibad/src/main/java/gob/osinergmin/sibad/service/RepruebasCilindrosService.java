package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosModuloDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.filter.RepruebasCilindrosFilter;

public interface RepruebasCilindrosService {
	public List<RepruebasCilindrosDTO> listarRepruebasCilindros(RepruebasCilindrosFilter filtro);
	//public SolicitudPruebaRepruebaDTO create(SolicitudPruebaRepruebaDTO solicitudPruebaRpbaDTO, UsuarioDTO usuarioDTO);
	public List<RepruebasCilindrosModuloDTO> listarCilindroxModulo(RepruebasCilindrosFilter filtro);
}
