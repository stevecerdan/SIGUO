package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.SibadNota;
import gob.osinergmin.sibad.domain.dto.SibadNotaDTO;

public class SibadNotaBuilder {
	
	
public static SibadNotaDTO obtenerSibadNotaDTO(SibadNota nota, SibadNotaDTO notaDTO) {
        
	notaDTO.setId(nota.getId());
	notaDTO.setEstdo(nota.getEstdo());
	notaDTO.setFchaCrcion(nota.getFchaCrcion());
	notaDTO.setDetalle(nota.getDetalle());
	notaDTO.setUsrCrdor(nota.getUsrCrdor());
	return notaDTO;
    
   }

}
