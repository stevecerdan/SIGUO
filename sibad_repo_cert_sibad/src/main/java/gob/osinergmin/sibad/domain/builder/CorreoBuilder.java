package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghCorreo;
import gob.osinergmin.sibad.domain.dto.CorreoDTO;

public class CorreoBuilder {
	
	public static List<CorreoDTO> toListCorreoDto(List<PghCorreo> lista) {
		    
			CorreoDTO registroDTO;
		    
	        List<CorreoDTO> retorno = new ArrayList<CorreoDTO>();
	        if (lista != null) {
	            for (PghCorreo maestro : lista) {
	                registroDTO = toPghCorreo(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
    public static CorreoDTO toPghCorreo(PghCorreo registro) {
		
    	CorreoDTO registroDTO = new CorreoDTO();
	    
	    registroDTO.setIdCorreo(registro.getIdCorreo());
	    registroDTO.setCodigoFuncionalidad(registro.getCodigoFuncionalidad());
	    registroDTO.setAsunto(registro.getAsunto());
	    registroDTO.setMensaje(registro.getMensaje());
	    		
		return registroDTO;
	}
    
     public static PghCorreo getCorreo(CorreoDTO registroDTO) {
        PghCorreo registro = null;
        if(registroDTO!=null){
            registro=new PghCorreo();
            registro.setIdCorreo(registroDTO.getIdCorreo());
            registro.setCodigoFuncionalidad(registroDTO.getCodigoFuncionalidad());
		    registro.setAsunto(registroDTO.getAsunto());
		    registro.setMensaje(registroDTO.getMensaje());
        }
        return registro;

    }
     
}
