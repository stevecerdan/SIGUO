/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.MdiMaestroColumnaTipo;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class MaestroColumnaTipoBuilder {
	
    public static List<MaestroColumnaTipoDTO> toListMaestroColumnaTipoDto(List<MdiMaestroColumnaTipo> lista) {
    	MaestroColumnaTipoDTO registroDTO;
        List<MaestroColumnaTipoDTO> retorno = new ArrayList<MaestroColumnaTipoDTO>();
        if (lista != null) {
            for (MdiMaestroColumnaTipo maestro : lista) {
                registroDTO = toMaestroColumnaTipoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static MaestroColumnaTipoDTO toMaestroColumnaTipoDto(MdiMaestroColumnaTipo registro) {
    	MaestroColumnaTipoDTO registroDTO = new MaestroColumnaTipoDTO();
        
        registroDTO.setIdMaestroColumna(registro.getIdMaestroColumna());
        registroDTO.setDominio(registro.getDominio());
        registroDTO.setDescripcion(registro.getDescripcion());
        registroDTO.setAplicacion(registro.getAplicacion());
        
        return registroDTO;
    }
    
    public static MdiMaestroColumnaTipo getMaestroColumnaTipo(MaestroColumnaTipoDTO registroDTO) {
        MdiMaestroColumnaTipo registro = null;
        if(registroDTO!=null){
            registro=new MdiMaestroColumnaTipo();
            registro.setIdMaestroColumna(registroDTO.getIdMaestroColumna());
            registro.setDominio(registroDTO.getDominio());
            registro.setDescripcion(registroDTO.getDescripcion());
            registro.setAplicacion(registroDTO.getAplicacion());
        }
        return registro;

    }
}
