package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;
import gob.osinergmin.sibad.filter.InformePersonaNaturalFilter;

public interface InformePersonaNaturalService {

	public InformePersonaNaturalDTO RegistrarInformePersonaNatural(InformePersonaNaturalDTO informePersonaNaturalDTO);
	public List<InformePersonaNaturalDTO> ListarInformePersonaNatural(InformePersonaNaturalFilter filtro);
}
