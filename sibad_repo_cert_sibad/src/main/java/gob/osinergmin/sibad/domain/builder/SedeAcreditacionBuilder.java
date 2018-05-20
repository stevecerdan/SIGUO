/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghSedeAcreditacion;
import gob.osinergmin.sibad.domain.PghSedeAcreditacionV;
import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class SedeAcreditacionBuilder {
	
    public static List<SedeAcreditacionDTO> toListSedeAcreditacionDto(List<PghSedeAcreditacionV> lista) {
    	SedeAcreditacionDTO registroDTO;
        List<SedeAcreditacionDTO> retorno = new ArrayList<SedeAcreditacionDTO>();
        if (lista != null) {
            for (PghSedeAcreditacionV maestro : lista) {
                registroDTO = toSedeAcreditacionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static SedeAcreditacionDTO toSedeAcreditacionDto(PghSedeAcreditacionV registro) {
    	SedeAcreditacionDTO registroDTO = new SedeAcreditacionDTO();
        
        registroDTO.setIdSedeAcreditacion(registro.getIdSedeAcreditacion());
        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setDireccion(registro.getDireccion());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
    
    public static PghSedeAcreditacionV getSedeAcreditacion(SedeAcreditacionDTO registroDTO) {
        PghSedeAcreditacionV registro = null;
        if(registroDTO!=null){
            registro=new PghSedeAcreditacionV();
            registro.setIdSedeAcreditacion(registroDTO.getIdSedeAcreditacion());
            registro.setIdAlcanceAcreditacion(registroDTO.getIdAlcanceAcreditacion());
            registro.setDireccion(registroDTO.getDireccion());
            registro.setEstado(registroDTO.getEstado());
        }
        return registro;

    }
    
    public static SedeAcreditacionDTO toSedeAcredDto(PghSedeAcreditacion registro) {
    	
    	SedeAcreditacionDTO registroDTO = new SedeAcreditacionDTO();
        
        registroDTO.setIdSedeAcreditacion(registro.getIdSedeAcreditacion());
        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setIdDepartamento(registro.getIdDepartamento());
        registroDTO.setIdProvincia(registro.getIdProvincia());
        registroDTO.setIdDistrito(registro.getIdDistrito());
        registroDTO.setDireccion(registro.getDireccion());
        registroDTO.setEstado(registro.getEstado());

        return registroDTO;
    }
}
