package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghCompartAlmacenamiento;
import gob.osinergmin.sibad.domain.dto.CompartAlmacenamientoDTO;

public class CompartAlmacenamientoBuilder {

	public static List<CompartAlmacenamientoDTO> toListCompartAlmDto(List<PghCompartAlmacenamiento> lista) {
		CompartAlmacenamientoDTO registroDTO;
        List<CompartAlmacenamientoDTO> retorno = new ArrayList<CompartAlmacenamientoDTO>();
        if (lista != null) {
            for (PghCompartAlmacenamiento valor : lista) {
                registroDTO = toCompartAlmDto(valor);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}
	
	public static CompartAlmacenamientoDTO toCompartAlmDto(PghCompartAlmacenamiento registro) {
    	
		CompartAlmacenamientoDTO registroDTO = new CompartAlmacenamientoDTO();
        
		registroDTO.setIdP(registro.getIdp());
	    registroDTO.setNumero(registro.getNumero());
	    registroDTO.setCapacidad(registro.getCapacidad());
	    registroDTO.setNombreProd(registro.getNombreProd());
	    registroDTO.setTanque(registro.getTanque());
	    registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
	    registroDTO.setIdAlmacenamiento(registro.getIdAlmacenamiento());
	    registroDTO.setIdUnidadSupervisada(registro.getIdUnidadSupervisada());
	    registroDTO.setNumeroSerie(registro.getNumeroSerie());	    
        
        return registroDTO;
}

}
