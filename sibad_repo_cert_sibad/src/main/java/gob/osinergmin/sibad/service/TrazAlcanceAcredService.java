package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.filter.TrazAlcanceAcredFilter;

public interface TrazAlcanceAcredService {
	
	public List<TrazAlcanceAcredDTO> listarTrazAlcanceAcred(TrazAlcanceAcredFilter filtro);
	public TrazAlcanceAcredDTO RegistrarObservacionTrazAlcanceAcred(TrazAlcanceAcredDTO trazAlcanceAcredDTO);
	public TrazAlcanceAcredDTO RegistrarTrazAlcanceAcred(TrazAlcanceAcredDTO trazAlcanceAcredDTO);


}
