package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.MdiUnidadSupervisada;
import gob.osinergmin.sibad.domain.MdiUnidadSupervisadaV;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;

public class UnidadSupervisadaBuilder {
	
	public static List<UnidadSupervisadaDTO> toListUnidadSupervisadaDto(List<MdiUnidadSupervisada> lista) {
		UnidadSupervisadaDTO registroDTO;
	        List<UnidadSupervisadaDTO> retorno = new ArrayList<UnidadSupervisadaDTO>();
	        if (lista != null) {
	            for (MdiUnidadSupervisada valor : lista) {
	                registroDTO = toUnidadSupervisadaDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static UnidadSupervisadaDTO toUnidadSupervisadaDto(MdiUnidadSupervisada registro) {
	    	
		UnidadSupervisadaDTO registroDTO = new UnidadSupervisadaDTO();
	        
		    registroDTO.setIdUnidadSupervisada(registro.getIdUnidadSupervisada());
		    registroDTO.setEstadoUnidadSupervisada(registro.getEstado());
		    registroDTO.setCodigoOsinergminUnidadSupervisada(registro.getCodigoOsinergmin());
		   
	        return registroDTO;
	}
	
	public static MdiUnidadSupervisada getUnidadSupervisada(UnidadSupervisadaDTO registroDTO) {
    	MdiUnidadSupervisada registro = null;
    	if(registroDTO!=null){
            registro=new MdiUnidadSupervisada();
            registro.setIdUnidadSupervisada(registroDTO.getIdUnidadSupervisada());
		    registro.setEstado(registroDTO.getEstadoUnidadSupervisada());
		    registro.setCodigoOsinergmin(registroDTO.getCodigoOsinergminUnidadSupervisada());
        }
        return registro;
	}
	
	public static List<UnidadSupervisadaVDTO> toListUnidadSupervisadaVDto(List<MdiUnidadSupervisadaV> lista) {
		UnidadSupervisadaVDTO registroDTO;
	        List<UnidadSupervisadaVDTO> retorno = new ArrayList<UnidadSupervisadaVDTO>();
	        if (lista != null) {
	            for (MdiUnidadSupervisadaV valor : lista) {
	                registroDTO = toUnidadSupervisadaVDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static UnidadSupervisadaVDTO toUnidadSupervisadaVDto(MdiUnidadSupervisadaV registro) {
    	
		    UnidadSupervisadaVDTO registroDTO = new UnidadSupervisadaVDTO();
	        
		    registroDTO.setIdUnidadSupervisada(registro.getIdUnidadSupervisada());
		    registroDTO.setNombreUnidad(registro.getNombreUnidad());
		    registroDTO.setDireccion(registro.getDireccion());
		    registroDTO.setIdEmpresaSupervisada(registro.getIdEmpresaSupervisada());
		    registroDTO.setRazonSocial(registro.getRazonSocial());
		    registroDTO.setNumeroIdentificacion(registro.getNumeroIdentificacion());
		   
	        return registroDTO;
	}

}
