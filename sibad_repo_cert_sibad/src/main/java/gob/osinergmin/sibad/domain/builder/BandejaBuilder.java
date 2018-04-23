package gob.osinergmin.sibad.domain.builder;


import gob.osinergmin.sibad.domain.SfhUnddesOprtvas;
import gob.osinergmin.sibad.domain.SibadSlctudEstdoCnta;
import gob.osinergmin.sibad.domain.dto.BandejaDTO;
import gob.osinergmin.sibad.util.FechaUtil;

import java.util.ArrayList;
import java.util.List;

public class BandejaBuilder {

	public static List<BandejaDTO> obtenerListaRegistroSolicitudes(List<Object[]> listaSolicitudes){
		List<BandejaDTO> listaSolicitudesDTO =new ArrayList<BandejaDTO>();
		if(listaSolicitudes.size()>0){
		    BandejaDTO registroSolicitud = null;
		    for(Object[] object:listaSolicitudes){
		    	registroSolicitud = new BandejaDTO();
			if(object[0] != null && object[1] != null){
				if(object[0] instanceof SibadSlctudEstdoCnta){
					SibadSlctudEstdoCnta sibadSlctudEstdoCnta = (SibadSlctudEstdoCnta)object[0];
					registroSolicitud = obtenerRegistroSolicitudDTO(sibadSlctudEstdoCnta);
				}
				if(object[1] instanceof SfhUnddesOprtvas){
					SfhUnddesOprtvas unddesOprtvas = (SfhUnddesOprtvas) object[1];
					registroSolicitud.setRazonSocial(unddesOprtvas.getNmbreUndad());
					registroSolicitud.setCodigoOsinergmin(unddesOprtvas.getCodigoOsinerg());
				}		
				
				listaSolicitudesDTO.add(registroSolicitud);
			}
			
		    }
		    
		}
		return listaSolicitudesDTO;
	    }
	

	   public static BandejaDTO obtenerRegistroSolicitudDTO(SibadSlctudEstdoCnta sibadSlctudEstdoCnta){
			BandejaDTO registroSolicitudDTO=null;
			if(sibadSlctudEstdoCnta!=null){
				registroSolicitudDTO = new BandejaDTO();
				registroSolicitudDTO.setIdRegistroSolicitud(sibadSlctudEstdoCnta.getId());
				registroSolicitudDTO.setNumeroSolicitud(sibadSlctudEstdoCnta.getNmroSlctud());
				registroSolicitudDTO.setRuc(sibadSlctudEstdoCnta.getRuc());
				registroSolicitudDTO.setRazonSocial(sibadSlctudEstdoCnta.getRzonScial());
				registroSolicitudDTO.setEstadoSolicitud(sibadSlctudEstdoCnta.getEstdo());	
				registroSolicitudDTO.setNumeroExpediente(sibadSlctudEstdoCnta.getNmroExpdnte());
				if (registroSolicitudDTO.getEstadoSolicitud() == 1) {
					registroSolicitudDTO.setDescEstadoSolicitud("FINALIZADO");
				} else if (registroSolicitudDTO.getEstadoSolicitud() == 0) {
					registroSolicitudDTO.setDescEstadoSolicitud("PENDIENTE");
				}

			    if(sibadSlctudEstdoCnta.getFchaCrcion()!=null){
			    	//registroSolicitudDTO.setFechaCreacion(FechaUtil.DateToString(sibadSlctudEstdoCnta.getFchaCrcion(),FechaUtil.FORMATO_FECHA_CORTA));
			    	registroSolicitudDTO.setFechaCreacion(FechaUtil.DateToString(sibadSlctudEstdoCnta.getFchaCrcion(),FechaUtil.FORMATO_FECHA_LARGE_2));
			    }
			    
			    
			}
			return registroSolicitudDTO;
		    }
	
	
}
