package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PersonalAutorizadoPorTipoPruebaV;
import gob.osinergmin.sibad.domain.dto.PersAutPorTipoPruebaDTO;

public class PersAutPorTipoPruebaBuilder {

	public static List<PersAutPorTipoPruebaDTO> toListersAutPorTipoPruebaDto(List<PersonalAutorizadoPorTipoPruebaV> lista) {
		PersAutPorTipoPruebaDTO registroDTO;
	        List<PersAutPorTipoPruebaDTO> retorno = new ArrayList<PersAutPorTipoPruebaDTO>();
	        if (lista != null) {
	            for (PersonalAutorizadoPorTipoPruebaV valor : lista) {
	                registroDTO = toPersAutPorTipoPruebaDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static PersAutPorTipoPruebaDTO toPersAutPorTipoPruebaDto(PersonalAutorizadoPorTipoPruebaV registro) {
	    	
		    PersAutPorTipoPruebaDTO registroDTO = new PersAutPorTipoPruebaDTO();
	        
		    registroDTO.setIdSedePersonalAutorizado(registro.getIdSedePersonalAutorizado());
		    registroDTO.setNombreCompleto(registro.getNombreCompleto());
		   
	        return registroDTO;
	}
	
}
