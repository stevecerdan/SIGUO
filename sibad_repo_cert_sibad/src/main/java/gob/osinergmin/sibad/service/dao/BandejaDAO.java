package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.BandejaDTO;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;

import java.util.List;

public interface BandejaDAO {

	List<BandejaDTO> listaSolicitud(BandejaDTO bandejaDTO);
	
	List<TablaDetalleDTO> listaEstados(String tipoEstados);
}
