/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghTipoEquipoV;
import gob.osinergmin.sibad.domain.dto.TipoEquipoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class TipoEquipoBuilder {
	
    public static List<TipoEquipoDTO> toListTipoEquipoDto(List<PghTipoEquipoV> lista) {
    	TipoEquipoDTO registroDTO;
        List<TipoEquipoDTO> retorno = new ArrayList<TipoEquipoDTO>();
        if (lista != null) {
            for (PghTipoEquipoV maestro : lista) {
                registroDTO = toTipoEquipoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static TipoEquipoDTO toTipoEquipoDto(PghTipoEquipoV registro) {
    	TipoEquipoDTO registroDTO = new TipoEquipoDTO();
        
        registroDTO.setIdTipoEquipo(registro.getIdTipoEquipo());
        registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setTipoEquipo(registro.getTipoEquipo());
        registroDTO.setEstadoAlcance(registro.getEstadoAlcance());
        
        return registroDTO;
    }
    
    public static PghTipoEquipoV getTipoEquipo(TipoEquipoDTO registroDTO) {
    	PghTipoEquipoV registro = null;
        
    	if(registroDTO!=null){
            registro=new PghTipoEquipoV();
            registro.setIdTipoEquipo(registroDTO.getIdTipoEquipo());
            registro.setIdEmpresaAcreditada(registroDTO.getIdEmpresaAcreditada());
            registro.setIdTipoPrueba(registroDTO.getIdTipoPrueba());
            registro.setTipoEquipo(registroDTO.getTipoEquipo());
            registro.setEstadoAlcance(registroDTO.getEstadoAlcance());
        }
        return registro;

    }
}
