/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghOrganismoAcreditador;
import gob.osinergmin.sibad.domain.dto.OrganismoAcreditadorDTO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
 public class OrganismoAcreditadorBuilder {
	
  public static List<OrganismoAcreditadorDTO> toListOrganismoAcreditadorDto(List<PghOrganismoAcreditador> lista) {
	  OrganismoAcreditadorDTO registroDTO;
        List<OrganismoAcreditadorDTO> retorno = new ArrayList<OrganismoAcreditadorDTO>();
        if (lista != null) {
            for (PghOrganismoAcreditador maestro : lista) {
                registroDTO = toOrganismoAcreditadorDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
  
    public static OrganismoAcreditadorDTO toOrganismoAcreditadorDto(PghOrganismoAcreditador registro) {
    	OrganismoAcreditadorDTO registroDTO = new OrganismoAcreditadorDTO();
    	
        registroDTO.setIdOrganismoAcreditador(registro.getIdOrganismoAcreditador());
        //registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setRuc(registro.getRuc());
        registroDTO.setNombreOrgAcreditador(registro.getNombreOrgAcreditador());
        registroDTO.setDireccion(registro.getDireccion());
        registroDTO.setDepartamento(registro.getDepartamento());
        registroDTO.setProvincia(registro.getProvincia());
        registroDTO.setDistrito(registro.getDistrito());
        registroDTO.setTelefono(registro.getTelefono());
        registroDTO.setEmail(registro.getEmail());
        registroDTO.setWeb(registro.getWeb());
        registroDTO.setIdPersonaJuridica(registro.getIdPersonaJuridica());
        //registroDTO.setTipoPrueba(registro.getTipoPrueba());
        registroDTO.setFechaCreacion(registro.getFechaCreacion());
        registroDTO.setFechaActualizacion(registro.getFechaActualizacion());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
    
    public static PghOrganismoAcreditador getOrganismoAcreditador(OrganismoAcreditadorDTO registroDTO) {
        PghOrganismoAcreditador registro = null;
        if(registroDTO!=null){
            registro=new PghOrganismoAcreditador();
            registro.setIdOrganismoAcreditador(registroDTO.getIdOrganismoAcreditador());
            //registro.setIdTipoPrueba(registroDTO.getIdTipoPrueba());
            registro.setRuc(registroDTO.getRuc());
            registro.setNombreOrgAcreditador(registroDTO.getNombreOrgAcreditador());
            registro.setDireccion(registroDTO.getDireccion());
            registro.setDepartamento(registroDTO.getDepartamento());
            registro.setProvincia(registroDTO.getProvincia());
            registro.setDistrito(registroDTO.getDistrito());
            registro.setTelefono(registroDTO.getTelefono());
            registro.setEmail(registroDTO.getEmail());
            registro.setDireccion(registroDTO.getDireccion());
            registro.setWeb(registroDTO.getWeb());
            registro.setIdPersonaJuridica(registroDTO.getIdPersonaJuridica());
            //registro.setTipoPrueba(registroDTO.getTipoPrueba());
            registro.setFechaCreacion(registroDTO.getFechaCreacion());
            registro.setFechaActualizacion(registroDTO.getFechaActualizacion());
            registro.setEstado(registroDTO.getEstado());
        }
        return registro;

    }
}
