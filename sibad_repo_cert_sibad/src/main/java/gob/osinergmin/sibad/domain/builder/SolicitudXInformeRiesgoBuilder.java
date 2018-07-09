package gob.osinergmin.sibad.domain.builder;


import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghSolicitudXInformeRiesgoV;
import gob.osinergmin.sibad.domain.dto.SolicitudXInformeRiesgoDTO;

public class SolicitudXInformeRiesgoBuilder {
	
	public static List<SolicitudXInformeRiesgoDTO> toListSolicitudXInformeRiesgoDto(List<PghSolicitudXInformeRiesgoV> lista) {
		    
			SolicitudXInformeRiesgoDTO registroDTO;
		    
	        List<SolicitudXInformeRiesgoDTO> retorno = new ArrayList<SolicitudXInformeRiesgoDTO>();
	        if (lista != null) {
	            for (PghSolicitudXInformeRiesgoV maestro : lista) {
	                registroDTO = toPghSolicitudXInformeRiesgoV(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
    public static SolicitudXInformeRiesgoDTO toPghSolicitudXInformeRiesgoV(PghSolicitudXInformeRiesgoV registro) {
		
    	SolicitudXInformeRiesgoDTO registroDTO = new SolicitudXInformeRiesgoDTO();
	    
	    registroDTO.setIdInformeIndiceRiesgo(registro.getIdInformeIndiceRiesgo());
	    registroDTO.setNroInformeIndiceRiesgo(registro.getNroInformeIndiceRiesgo());
	    registroDTO.setFechaInformeIndiceRiesgo(registro.getFechaInformeIndiceRiesgo());
	    registroDTO.setListaTanquesCompartimientos(registro.getListaTanquesCompartimientos());
	    		
		return registroDTO;
	}
    
     public static PghSolicitudXInformeRiesgoV getSolicitudXInformeRiesgoV(SolicitudXInformeRiesgoDTO registroDTO) {
        PghSolicitudXInformeRiesgoV registro = null;
        if(registroDTO!=null){
            registro=new PghSolicitudXInformeRiesgoV();
            registro.setIdInformeIndiceRiesgo(registroDTO.getIdInformeIndiceRiesgo());
            registro.setNroInformeIndiceRiesgo(registroDTO.getNroInformeIndiceRiesgo());
    	    registro.setFechaInformeIndiceRiesgo(registroDTO.getFechaInformeIndiceRiesgo());
    	    registro.setListaTanquesCompartimientos(registroDTO.getListaTanquesCompartimientos());
        }
        return registro;

    }
     
    
    
}
