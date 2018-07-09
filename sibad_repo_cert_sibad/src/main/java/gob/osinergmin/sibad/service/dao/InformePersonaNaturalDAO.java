package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;
import gob.osinergmin.sibad.filter.InformePersonaNaturalFilter;

public interface InformePersonaNaturalDAO {
	
	public InformePersonaNaturalDTO create(InformePersonaNaturalDTO informePersonaNaturalDTO);
	public List<InformePersonaNaturalDTO> find(InformePersonaNaturalFilter filtro);

}
