/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.MdiPersonaJuridica;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class PersonaJuridicaBuilder {
	
    public static List<PersonaJuridicaDTO> toListPersonaJuridicaDto(List<MdiPersonaJuridica> lista) {
        PersonaJuridicaDTO registroDTO;
        List<PersonaJuridicaDTO> retorno = new ArrayList<PersonaJuridicaDTO>();
        if (lista != null) {
            for (MdiPersonaJuridica maestro : lista) {
                registroDTO = toPersonaJuridicaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static PersonaJuridicaDTO toPersonaJuridicaDto(MdiPersonaJuridica registro) {
        PersonaJuridicaDTO registroDTO = new PersonaJuridicaDTO();
        
        registroDTO.setIdPersonaJuridica(registro.getIdPersonaJuridica());
        registroDTO.setRuc(registro.getRuc());
        registroDTO.setRazonSocial(registro.getRazonSocial());
        registroDTO.setDireccion(registro.getDireccion());
        registroDTO.setDepartamento(registro.getDepartamento());
        registroDTO.setProvincia(registro.getProvincia());
        registroDTO.setDistrito(registro.getDistrito());
        registroDTO.setTelefono(registro.getTelefono());
        registroDTO.setEmail(registro.getEmail());
        registroDTO.setWeb(registro.getWeb());
        
        return registroDTO;
    }
    
    public static MdiPersonaJuridica getPersonaJuridica(PersonaJuridicaDTO registroDTO) {
        MdiPersonaJuridica registro = null;
        if(registroDTO!=null){
            registro=new MdiPersonaJuridica();
            registro.setIdPersonaJuridica(registroDTO.getIdPersonaJuridica());
            registro.setRuc(registroDTO.getRuc());
            registro.setRazonSocial(registroDTO.getRazonSocial());
            registro.setDireccion(registroDTO.getDireccion());
            registro.setDepartamento(registroDTO.getDepartamento());
            registro.setProvincia(registroDTO.getProvincia());
            registro.setDistrito(registroDTO.getDistrito());
            registro.setTelefono(registroDTO.getTelefono());
            registro.setEmail(registroDTO.getEmail());
            registro.setDireccion(registroDTO.getDireccion());
            registro.setWeb(registroDTO.getWeb());
        }
        return registro;

    }
}
