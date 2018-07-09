/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghTipoPruebaOrganismo;
import gob.osinergmin.sibad.domain.dto.TipoPruebaOrganismoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class TipoPruebaOrganismoBuilder {
	
    public static List<TipoPruebaOrganismoDTO> toListTipoPruebaOrganismoDto(List<PghTipoPruebaOrganismo> lista) {
    	TipoPruebaOrganismoDTO registroDTO;
        List<TipoPruebaOrganismoDTO> retorno = new ArrayList<TipoPruebaOrganismoDTO>();
        if (lista != null) {
            for (PghTipoPruebaOrganismo maestro : lista) {
                registroDTO = toTipoPruebaOrganismoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static TipoPruebaOrganismoDTO toTipoPruebaOrganismoDto(PghTipoPruebaOrganismo registro) {
    	TipoPruebaOrganismoDTO registroDTO = new TipoPruebaOrganismoDTO();
        
        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setDescripcion(registro.getDescripcion());
        registroDTO.setIdOrganismoAcreditador(registro.getIdOrganismoAcreditador());
        registroDTO.setRazonSocial(registro.getRazonSocial());
        
        return registroDTO;
    }
    
    public static PghTipoPruebaOrganismo getTipoPruebaOrganismo(TipoPruebaOrganismoDTO registroDTO) {
        PghTipoPruebaOrganismo registro = null;
        if(registroDTO!=null){
            registro=new PghTipoPruebaOrganismo();
            registro.setIdTipoPrueba(registroDTO.getIdTipoPrueba());
            registro.setDescripcion(registroDTO.getDescripcion());
            registro.setIdOrganismoAcreditador(registroDTO.getIdOrganismoAcreditador());
            registro.setRazonSocial(registroDTO.getRazonSocial());
        }
        return registro;

    }
}
