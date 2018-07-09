package gob.osinergmin.sibad.domain.builder;


import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.MdiMaestroColumnaTipo;
import gob.osinergmin.sibad.domain.PghResultadoPruebaPersonalV;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;

public class ResultadoPruebaPersonalVBuilder {
	
	public static List<ResultadoPruebaPersonalDTO> toListResultadoPruebaPersonalVDto(List<PghResultadoPruebaPersonalV> lista) {
		    
		    ResultadoPruebaPersonalDTO registroDTO;
		    
	        List<ResultadoPruebaPersonalDTO> retorno = new ArrayList<ResultadoPruebaPersonalDTO>();
	        if (lista != null) {
	            for (PghResultadoPruebaPersonalV maestro : lista) {
	                registroDTO = toPghResultadoPruebaPersonalV(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
    public static ResultadoPruebaPersonalDTO toPghResultadoPruebaPersonalV(PghResultadoPruebaPersonalV registro) {
		
    	ResultadoPruebaPersonalDTO registroDTO = new ResultadoPruebaPersonalDTO();
	    
	    registroDTO.setIdResultadoPruebaPersonal(registro.getIdResultadoPruebaPersonal());
	    registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());
	    registroDTO.setIdSedePersonalAutorizado(registro.getIdSedePersonalAutorizado());
	    registroDTO.setTipoDocumento(registro.getTipoDocumento());
	    registroDTO.setNumeroDocumento(registro.getNumeroDocumento());
	    registroDTO.setNombre(registro.getNombre());
	    registroDTO.setApellidoPaterno(registro.getApellidoPaterno());
	    registroDTO.setApellidoMaterno(registro.getApellidoMaterno());
	    		
		return registroDTO;
	}
    
     public static PghResultadoPruebaPersonalV getResultadoPruebaPersonalV(ResultadoPruebaPersonalDTO registroDTO) {
        PghResultadoPruebaPersonalV registro = null;
        if(registroDTO!=null){
            registro=new PghResultadoPruebaPersonalV();
            registro.setIdResultadoPruebaPersonal(registroDTO.getIdResultadoPruebaPersonal());
            registro.setIdResultadoPruebaReprueba(registroDTO.getIdResultadoPruebaReprueba());
		    registro.setIdSedePersonalAutorizado(registroDTO.getIdSedePersonalAutorizado());
		    registro.setTipoDocumento(registroDTO.getTipoDocumento());
		    registro.setNumeroDocumento(registroDTO.getNumeroDocumento());
		    registro.setNombre(registroDTO.getNombre());
		    registro.setApellidoPaterno(registroDTO.getApellidoPaterno());
		    registro.setApellidoMaterno(registroDTO.getApellidoMaterno());
        }
        return registro;

    }
     
    
    
}
