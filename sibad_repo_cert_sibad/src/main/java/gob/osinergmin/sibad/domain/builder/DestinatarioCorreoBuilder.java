package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghDestinatarioCorreoV;
import gob.osinergmin.sibad.domain.dto.DestinatarioCorreoDTO;

public class DestinatarioCorreoBuilder {
	
	public static List<DestinatarioCorreoDTO> toListDestinatarioCorreoDto(List<PghDestinatarioCorreoV> lista) {
		    
			DestinatarioCorreoDTO registroDTO;
		    
	        List<DestinatarioCorreoDTO> retorno = new ArrayList<DestinatarioCorreoDTO>();
	        if (lista != null) {
	            for (PghDestinatarioCorreoV maestro : lista) {
	                registroDTO = toPghDestinatarioCorreoV(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
    public static DestinatarioCorreoDTO toPghDestinatarioCorreoV(PghDestinatarioCorreoV registro) {
		
    	DestinatarioCorreoDTO registroDTO = new DestinatarioCorreoDTO();
	    
	    registroDTO.setIdDestinatarioCorreo(registro.getIdDestinatarioCorreo());
	    registroDTO.setIdCorreo(registro.getIdCorreo());
	    registroDTO.setAsunto(registro.getAsunto());
	    registroDTO.setMensaje(registro.getMensaje());
	    registroDTO.setIdPersonal(registro.getIdPersonal());
	    registroDTO.setNombre(registro.getNombre());
	    registroDTO.setApellidoPaterno(registro.getApellidoPaterno());
	    registroDTO.setApellidoMaterno(registro.getApellidoMaterno());
	    registroDTO.setCorreoElectronico(registro.getCorreoElectronico());
	    registroDTO.setNombreCompleto(registro.getNombreCompleto());
	    registroDTO.setIdRegion(registro.getIdRegion());
	    registroDTO.setNombreRegion(registro.getNombreRegion());
	    		
		return registroDTO;
	}
    
     public static PghDestinatarioCorreoV getDestinatarioCorreoV(DestinatarioCorreoDTO registroDTO) {
        PghDestinatarioCorreoV registro = null;
        if(registroDTO!=null){
            registro=new PghDestinatarioCorreoV();
            registro.setIdDestinatarioCorreo(registroDTO.getIdDestinatarioCorreo());
            registro.setIdCorreo(registroDTO.getIdCorreo());
		    registro.setAsunto(registroDTO.getAsunto());
		    registro.setMensaje(registroDTO.getMensaje());
		    registro.setIdPersonal(registroDTO.getIdPersonal());
		    registro.setNombre(registroDTO.getNombre());
		    registro.setApellidoPaterno(registroDTO.getApellidoPaterno());
		    registro.setApellidoMaterno(registroDTO.getApellidoMaterno());
		    registro.setCorreoElectronico(registroDTO.getCorreoElectronico());
		    registro.setNombreCompleto(registroDTO.getNombreCompleto());
		    registro.setIdRegion(registroDTO.getIdRegion());
		    registro.setNombreRegion(registroDTO.getNombreRegion());
        }
        return registro;

    }
     
    
    
}
