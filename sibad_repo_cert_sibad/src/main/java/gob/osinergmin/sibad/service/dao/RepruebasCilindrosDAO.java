package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosModuloDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.filter.RepruebasCilindrosFilter;

public interface RepruebasCilindrosDAO{
	public List<RepruebasCilindrosDTO> find(RepruebasCilindrosFilter filtro);
	//public SolicitudPruebaRepruebaDTO create(SolicitudPruebaRepruebaDTO solicitudPruebaRpbaDTO, UsuarioDTO usuarioDTO);
	public List<RepruebasCilindrosModuloDTO> findCodigoOsinerg(RepruebasCilindrosFilter filtro);
}
