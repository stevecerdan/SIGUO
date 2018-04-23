/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghAlcanceAcreditacion;
import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class AlcanceAcreditacionBuilder {
	
    public static List<AlcanceAcreditacionDTO> toListAlcanceAcreditacionDto(List<PghAlcanceAcreditacion> lista) {
    	AlcanceAcreditacionDTO registroDTO;
        List<AlcanceAcreditacionDTO> retorno = new ArrayList<AlcanceAcreditacionDTO>();
        if (lista != null) {
            for (PghAlcanceAcreditacion maestro : lista) {
                registroDTO = toAlcanceAcreditacionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static AlcanceAcreditacionDTO toAlcanceAcreditacionDto(PghAlcanceAcreditacion registro) {
    	AlcanceAcreditacionDTO registroDTO = new AlcanceAcreditacionDTO();
        
        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setResolucionCedula(registro.getResolucionCedula());
        registroDTO.setRegistro(registro.getRegistro());
        registroDTO.setFechaUActualizacion(registro.getFechaUActualizacion());
        registroDTO.setFechaAcreditacion(registro.getFechaAcreditacion());
        registroDTO.setFechaVencimiento(registro.getFechaVencimiento());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
    
    public static PghAlcanceAcreditacion getAlcanceAcreditacion(AlcanceAcreditacionDTO registroDTO) {
    	PghAlcanceAcreditacion registro = null;
        if(registroDTO!=null){
            registro=new PghAlcanceAcreditacion();
            registro.setIdAlcanceAcreditacion(registroDTO.getIdAlcanceAcreditacion());
            registro.setIdTipoPrueba(registroDTO.getIdTipoPrueba());
            registro.setResolucionCedula(registroDTO.getResolucionCedula());
            registro.setRegistro(registroDTO.getRegistro());
            registro.setFechaUActualizacion(registroDTO.getFechaUActualizacion());
            registro.setFechaAcreditacion(registroDTO.getFechaAcreditacion());
            registro.setFechaVencimiento(registroDTO.getFechaVencimiento());
            registro.setEstado(registroDTO.getEstado());
        }
        return registro;

    }
}
