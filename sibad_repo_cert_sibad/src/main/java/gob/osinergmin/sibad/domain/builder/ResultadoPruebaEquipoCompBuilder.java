package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghResultadoPruebaEquipoComp;
import gob.osinergmin.sibad.domain.PghResultadoPruebaEquipoCompV;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaEquipoCompDTO;

public class ResultadoPruebaEquipoCompBuilder {
	
	
	public static List<ResultadoPruebaEquipoCompDTO> toListResultadoPruebaEquipoCompVDto(List<PghResultadoPruebaEquipoCompV> lista) {
		    
	    ResultadoPruebaEquipoCompDTO registroDTO;
	    
        List<ResultadoPruebaEquipoCompDTO> retorno = new ArrayList<ResultadoPruebaEquipoCompDTO>();
        if (lista != null) {
            for (PghResultadoPruebaEquipoCompV maestro : lista) {
                registroDTO = toPghResultadoPruebaEquipoCompV(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}
	
public static ResultadoPruebaEquipoCompDTO toPghResultadoPruebaEquipoCompV(PghResultadoPruebaEquipoCompV registro) {
		
		ResultadoPruebaEquipoCompDTO registroDTO = new ResultadoPruebaEquipoCompDTO();
	    
		registroDTO.setIdResultadoPruebaEquipoComp(registro.getIdResultadoPruebaEquipoComp());
		registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());
		registroDTO.setIdEquipoComponente(registro.getIdEquipoComponente());
		
        registroDTO.setTipoEquipo(registro.getTipoEquipo());
        registroDTO.setDescripcionEquipo(registro.getDescripcionEquipo());
        registroDTO.setComponenteTanque(registro.getComponenteTanque());
	    		
		return registroDTO;
	}
    
     public static PghResultadoPruebaEquipoCompV getResultadoPruebaEquipoCompV(ResultadoPruebaEquipoCompDTO registroDTO) {
        PghResultadoPruebaEquipoCompV registro = null;
        if(registroDTO!=null){
            registro=new PghResultadoPruebaEquipoCompV();
            registro.setIdResultadoPruebaEquipoComp(registroDTO.getIdResultadoPruebaEquipoComp());
            registro.setIdResultadoPruebaReprueba(registroDTO.getIdResultadoPruebaReprueba());
            registro.setIdEquipoComponente(registroDTO.getIdEquipoComponente());
    		
            registro.setTipoEquipo(registroDTO.getTipoEquipo());
            registro.setDescripcionEquipo(registroDTO.getDescripcionEquipo());
            registro.setComponenteTanque(registroDTO.getComponenteTanque());
        }
        return registro;

    }	 

	public static ResultadoPruebaEquipoCompDTO toPghResultadoPruebaEquipoComp(PghResultadoPruebaEquipoComp registro) {
		
	    ResultadoPruebaEquipoCompDTO registroDTO = new ResultadoPruebaEquipoCompDTO();
	    
	    registroDTO.setIdEquipoComponente(registro.getIdEquipoComponente());
	    registroDTO.setIdResultadoPruebaEquipoComp(registro.getIdResultadoPruebaEquipoComp());
	    registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());

		return registroDTO;
	}
	
	
}
