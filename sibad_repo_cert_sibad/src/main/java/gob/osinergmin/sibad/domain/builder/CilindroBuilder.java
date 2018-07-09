package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghCilindroGnv;
import gob.osinergmin.sibad.domain.dto.CilindroGNVDTO;

public class CilindroBuilder {

	public static CilindroGNVDTO toCilindroDTO(PghCilindroGnv pghCilindro) {
		CilindroGNVDTO registroDTO = new CilindroGNVDTO();
		
		registroDTO.setEstado(pghCilindro.getEstado());
		registroDTO.setIdCilindro(pghCilindro.getIdCilindro());
		registroDTO.setIdModulo(pghCilindro.getIdModulo());
		registroDTO.setIdUnidadSupervisada(pghCilindro.getIdUnidadSupervisada());
		registroDTO.setNumero(pghCilindro.getNumero());
		registroDTO.setNumeroSerie(pghCilindro.getNumeroSerie());
		
		return registroDTO;
	}

}
