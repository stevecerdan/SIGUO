/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghEmpresaAcreditada;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
 public class EmpresaAcreditadaBuilder {
	
  public static List<EmpresaAcreditadaDTO> toListEmpresaAcreditadaDto(List<PghEmpresaAcreditada> lista) {
	  EmpresaAcreditadaDTO registroDTO;
        List<EmpresaAcreditadaDTO> retorno = new ArrayList<EmpresaAcreditadaDTO>();
        if (lista != null) {
            for (PghEmpresaAcreditada maestro : lista) {
                registroDTO = toEmpresaAcreditadaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static EmpresaAcreditadaDTO toEmpresaAcreditadaDto(PghEmpresaAcreditada registro) {
    	EmpresaAcreditadaDTO registroDTO = new EmpresaAcreditadaDTO();
        
        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setRuc(registro.getRuc());
        registroDTO.setRazonSocial(registro.getRazonSocial());
        registroDTO.setDireccion(registro.getDireccion());
        registroDTO.setDepartamento(registro.getDepartamento());
        registroDTO.setProvincia(registro.getProvincia());
        registroDTO.setDistrito(registro.getDistrito());
        registroDTO.setTelefono(registro.getTelefono());
        registroDTO.setEmail(registro.getEmail());
        registroDTO.setWeb(registro.getWeb());
        registroDTO.setResolucionCedula(registro.getResolucionCedula());
        registroDTO.setFechaIVigencia(registro.getFechaIVigencia());
        registroDTO.setFechaUActualizacion(registro.getFechaUActualizacion());
        registroDTO.setFechaAcreditacion(registro.getFechaAcreditacion());
        registroDTO.setFechaVencimiento(registro.getFechaVencimiento());
        registroDTO.setTipoOrganismo(registro.getTipoOrganismo());
        registroDTO.setTipoPrueba(registro.getTipoPrueba());
        registroDTO.setRegistro(registro.getRegistro());
        registroDTO.setEstadoEmpresa(registro.getEstadoEmpresa());
        registroDTO.setEstadoAlcance(registro.getEstadoAlcance());
        
        return registroDTO;
    }
    
    public static PghEmpresaAcreditada getPersonaJuridica(EmpresaAcreditadaDTO registroDTO) {
        PghEmpresaAcreditada registro = null;
        if(registroDTO!=null){
            registro=new PghEmpresaAcreditada();
            registro.setIdAlcanceAcreditacion(registroDTO.getIdAlcanceAcreditacion());
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
            registro.setResolucionCedula(registroDTO.getResolucionCedula());
            registro.setFechaIVigencia(registroDTO.getFechaIVigencia());
            registro.setFechaUActualizacion(registroDTO.getFechaUActualizacion());
            registro.setFechaAcreditacion(registroDTO.getFechaAcreditacion());
            registro.setFechaVencimiento(registroDTO.getFechaVencimiento());
            registro.setTipoOrganismo(registroDTO.getTipoOrganismo());
            registro.setTipoPrueba(registroDTO.getTipoPrueba());
            registro.setRegistro(registroDTO.getRegistro());
            registro.setEstadoEmpresa(registroDTO.getEstadoEmpresa());
            registro.setEstadoAlcance(registroDTO.getEstadoAlcance());
        }
        return registro;

    }
}
