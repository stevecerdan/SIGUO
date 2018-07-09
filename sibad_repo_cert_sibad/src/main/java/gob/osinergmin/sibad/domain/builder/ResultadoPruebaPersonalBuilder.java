package gob.osinergmin.sibad.domain.builder;


import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghResultadoPruebaPersonal;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;

public class ResultadoPruebaPersonalBuilder {
	
	public static List<ResultadoPruebaPersonalDTO> toListResultadoPruebaPersonalDto(List<PghResultadoPruebaPersonal> lista) {
		    
		    ResultadoPruebaPersonalDTO registroDTO;
		    
	        List<ResultadoPruebaPersonalDTO> retorno = new ArrayList<ResultadoPruebaPersonalDTO>();
	        if (lista != null) {
	            for (PghResultadoPruebaPersonal maestro : lista) {
	                registroDTO = toPghResultadoPruebaPersonal(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
    public static ResultadoPruebaPersonalDTO toPghResultadoPruebaPersonal(PghResultadoPruebaPersonal registro) {
		
    	ResultadoPruebaPersonalDTO registroDTO = new ResultadoPruebaPersonalDTO();
	    
	    registroDTO.setIdResultadoPruebaPersonal(registro.getIdResultadoPruebaPersonal());
	    registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());
	    registroDTO.setIdSedePersonalAutorizado(registro.getIdSedePersonalAutorizado());
	    		
		return registroDTO;
	}
    
    
}
