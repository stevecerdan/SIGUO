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
        registroDTO.setIdComponenteTanque(registro.getIdComponenteTanque());
        registroDTO.setComponenteTanque(registro.getComponenteTanque());
        
        registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
        registroDTO.setIdEquipoCertificado(registro.getIdEquipoCertificado());
        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setEstadoAlcance(registro.getEstadoAlcance());
        registroDTO.setEstadoEquipo(registro.getEstadoEquipo());
        registroDTO.setTipoEquipo(registro.getTipoEquipo());
        registroDTO.setDescripcionEquipo(registro.getDescripcionEquipo());
        
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
            registro.setIdComponenteTanque(registroDTO.getIdComponenteTanque());
            registro.setComponenteTanque(registroDTO.getComponenteTanque());
            
            registro.setIdEmpresaAcreditada(registroDTO.getIdEmpresaAcreditada());
            registro.setIdEquipoCertificado(registroDTO.getIdEquipoCertificado());
            registro.setIdTipoPrueba(registroDTO.getIdTipoPrueba());
            registro.setEstadoAlcance(registroDTO.getEstadoAlcance());
            registro.setEstadoEquipo(registroDTO.getEstadoEquipo());
            registro.setTipoEquipo(registroDTO.getTipoEquipo());
            registro.setDescripcionEquipo(registroDTO.getDescripcionEquipo());
        }
        return registro;

    }
}
