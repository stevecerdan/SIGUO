package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.BandejaDTO;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;

import java.util.List;

public interface BandejaService {

	List<BandejaDTO> listaSolicitud(BandejaDTO bandejaDTO);
	
	List<TablaDetalleDTO> listaEstados(String tipoEstados);

}
