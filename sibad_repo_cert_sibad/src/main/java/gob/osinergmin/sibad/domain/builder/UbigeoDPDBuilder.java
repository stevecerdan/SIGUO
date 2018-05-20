/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.MdiUbigeoDPD;
import gob.osinergmin.sibad.domain.dto.UbigeodpdDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class UbigeoDPDBuilder {
	
    public static List<UbigeodpdDTO> toListUbigeoDPDDto(List<MdiUbigeoDPD> lista) {
    	UbigeodpdDTO registroDTO;
        List<UbigeodpdDTO> retorno = new ArrayList<UbigeodpdDTO>();
        if (lista != null) {
            for (MdiUbigeoDPD maestro : lista) {
                registroDTO = toUbigeoDPDDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static UbigeodpdDTO toUbigeoDPDDto(MdiUbigeoDPD registro) {
    	UbigeodpdDTO registroDTO = new UbigeodpdDTO();
        
        registroDTO.setIdDepartamento(registro.getIdDepartamento());
        registroDTO.setIdProvincia(registro.getIdProvincia());
        registroDTO.setIdDistrito(registro.getIdDistrito());
        registroDTO.setNombre(registro.getNombre());
        
        return registroDTO;
    }
    
    public static MdiUbigeoDPD getUbigeoDPD(UbigeodpdDTO registroDTO) {
        MdiUbigeoDPD registro = null;
        if(registroDTO!=null){
            registro=new MdiUbigeoDPD();
            registro.setIdDepartamento(registroDTO.getIdDepartamento());
            registro.setIdProvincia(registroDTO.getIdProvincia());
            registro.setIdDistrito(registroDTO.getIdDistrito());
            registro.setNombre(registroDTO.getNombre());
        }
        return registro;

    }
}
