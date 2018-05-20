package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.MdiUbigeoDPD;
import gob.osinergmin.sibad.domain.PghCompartimiento;
import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.UbigeodpdDTO;

public class CompartimientoBuilder {
	
	public static List<CompartimientoDTO> toListCompartimientoDto(List<PghCompartimiento> lista) {
		CompartimientoDTO registroDTO;
	        List<CompartimientoDTO> retorno = new ArrayList<CompartimientoDTO>();
	        if (lista != null) {
	            for (PghCompartimiento valor : lista) {
	                registroDTO = toCompartimientoDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static CompartimientoDTO toCompartimientoDto(PghCompartimiento registro) {
	    	
		    CompartimientoDTO registroDTO = new CompartimientoDTO();
	        
		    registroDTO.setCapacidad(registro.getCapacidad());
		    registroDTO.setNumero(registro.getNumero());
		    registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
		    registroDTO.setEstado(registro.getEstado());
		    registroDTO.setIdAlmacenamiento(registro.getIdAlmacenamiento());
		    
		   
		    
	        
	        return registroDTO;
	    }
	
	public static PghCompartimiento getCompartimiento(CompartimientoDTO registroDTO) {
		PghCompartimiento registro = null;
        if(registroDTO!=null){
            registro=new PghCompartimiento();
            registro.setCapacidad(registroDTO.getCapacidad());
            registro.setIdCompartimiento(registroDTO.getIdCompartimiento());
            registro.setEstado(registroDTO.getEstado());
            registro.setIdAlmacenamiento(registroDTO.getIdAlmacenamiento());
        }
        return registro;

    }

}
