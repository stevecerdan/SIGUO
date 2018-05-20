/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghEquipoComponente;
import gob.osinergmin.sibad.domain.PghEquipoComponenteV;
import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
 public class EquipoComponenteBuilder {
	
  public static List<EquipoComponenteDTO> toListEquipoComponenteDto(List<PghEquipoComponenteV> lista) {
	  EquipoComponenteDTO registroDTO;
        List<EquipoComponenteDTO> retorno = new ArrayList<EquipoComponenteDTO>();
        if (lista != null) {
            for (PghEquipoComponenteV maestro : lista) {
                registroDTO = toEquipoComponenteDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
  
    public static EquipoComponenteDTO toEquipoComponenteDto(PghEquipoComponenteV registro) {
    	EquipoComponenteDTO registroDTO = new EquipoComponenteDTO();
        
        registroDTO.setIdEquipoComponente(registro.getIdEquipoComponente());
        registroDTO.setComponenteTanque(registro.getComponenteTanque());
        
        return registroDTO;
    }
    
    public static EquipoComponenteDTO toEquipoComponenteDTO(PghEquipoComponente registro) {
    	EquipoComponenteDTO registroDTO = new EquipoComponenteDTO();
        
        registroDTO.setIdEquipoComponente(registro.getIdEquipoComponente());
        registroDTO.setIdEquipoCertificado(registro.getIdEquipoCertificado());
        registroDTO.setIdComponenteTanque(registro.getIdEquipoTanque());
        
        return registroDTO;
    }
    
    public static PghEquipoComponenteV getEquipoComponente(EquipoComponenteDTO registroDTO) {
        PghEquipoComponenteV registro = null;
        if(registroDTO!=null){
            registro=new PghEquipoComponenteV();
            registro.setIdEquipoComponente(registroDTO.getIdEquipoComponente());
            registro.setComponenteTanque(registroDTO.getComponenteTanque());
        }
        return registro;

    }
}
