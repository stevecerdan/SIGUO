/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghSedePersonalAutorizado;
import gob.osinergmin.sibad.domain.PghSedePersonalAutorizadoV;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
 public class SedePersonalAutorizadoBuilder {
	
  public static List<SedePersonalAutorizadoDTO> toListSedePersonalAutorizadoDto(List<PghSedePersonalAutorizadoV> lista) {
	  SedePersonalAutorizadoDTO registroDTO;
        List<SedePersonalAutorizadoDTO> retorno = new ArrayList<SedePersonalAutorizadoDTO>();
        if (lista != null) {
            for (PghSedePersonalAutorizadoV maestro : lista) {
                registroDTO = toSedePersonalAutorizadoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
  //Utilizado para el Registro
  	/*public static EmpresaAcreditadaDTO toEmpresaAcreditadaDTO(PghEmpresaAcreditada registro){
		
	   EmpresaAcreditadaDTO registroDTO = new EmpresaAcreditadaDTO();
     
     registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
     registroDTO.setIdPersonaJuridica(registro.getIdPersonaJuridica());
     registroDTO.setEstado(registro.getEstado());


     return registroDTO;
		
		
	}*/
  	//--------------------------------------
  
    public static SedePersonalAutorizadoDTO toSedePersonalAutorizadoDto(PghSedePersonalAutorizadoV registro) {
    	SedePersonalAutorizadoDTO registroDTO = new SedePersonalAutorizadoDTO();
        
        registroDTO.setIdSedePersonalAutorizado(registro.getIdSedePersonalAutorizado());
        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setIdSedeAcreditacion(registro.getIdSedeAcreditacion());
        registroDTO.setDireccion(registro.getDireccion());
        registroDTO.setIdDepartamento(registro.getIdDepartamento());
        registroDTO.setIdProvincia(registro.getIdProvincia());
        registroDTO.setIdDistrito(registro.getIdDistrito());
        registroDTO.setDepartamento(registro.getDepartamento());
        registroDTO.setProvincia(registro.getProvincia());
        registroDTO.setDistrito(registro.getDistrito());
        registroDTO.setFlagPersonalAutorizado(registro.getFlagPersonalAutorizado());
        registroDTO.setIdTipoDocumento(registro.getIdTipoDocumento());
        registroDTO.setTipoDocumento(registro.getTipoDocumento());
        registroDTO.setNumeroDocumento(registro.getNumeroDocumento());
        registroDTO.setNombre(registro.getNombre());
        registroDTO.setApellidoPaterno(registro.getApellidoPaterno());
        registroDTO.setApellidoMaterno(registro.getApellidoMaterno());
        registroDTO.setIdCargo(registro.getIdCargo());
        registroDTO.setIdEspecialidad(registro.getIdEspecialidad());
        registroDTO.setEspecialidadCargo(registro.getEspecialidadCargo());
        registroDTO.setCip(registro.getCip());
        
        return registroDTO;
    }
    
    public static PghSedePersonalAutorizadoV getSedePersonalAutorizado(SedePersonalAutorizadoDTO registroDTO) {
        PghSedePersonalAutorizadoV registro = null;
        if(registroDTO!=null){
            registro=new PghSedePersonalAutorizadoV();
            registro.setIdSedePersonalAutorizado(registroDTO.getIdSedePersonalAutorizado());
            registro.setIdAlcanceAcreditacion(registroDTO.getIdAlcanceAcreditacion());
            registro.setIdSedeAcreditacion(registroDTO.getIdSedeAcreditacion());
            registro.setDireccion(registroDTO.getDireccion());
            registro.setIdDepartamento(registroDTO.getIdDepartamento());
            registro.setIdProvincia(registroDTO.getIdProvincia());
            registro.setIdDistrito(registroDTO.getIdDistrito());
            registro.setDepartamento(registroDTO.getDepartamento());
            registro.setProvincia(registroDTO.getProvincia());
            registro.setDistrito(registroDTO.getDistrito());
            registro.setFlagPersonalAutorizado(registroDTO.getFlagPersonalAutorizado());
            registro.setIdTipoDocumento(registroDTO.getIdTipoDocumento());
            registro.setTipoDocumento(registroDTO.getTipoDocumento());
            registro.setNumeroDocumento(registroDTO.getNumeroDocumento());
            registro.setNombre(registroDTO.getNombre());
            registro.setApellidoPaterno(registroDTO.getApellidoPaterno());
            registro.setApellidoMaterno(registroDTO.getApellidoMaterno());
            registro.setIdCargo(registroDTO.getIdCargo());
            registro.setIdEspecialidad(registroDTO.getIdEspecialidad());
            registro.setEspecialidadCargo(registroDTO.getEspecialidadCargo());
            registro.setCip(registroDTO.getCip());
        }
        return registro;

    }
    
    public static SedePersonalAutorizadoDTO toSedePersonalAutoDto(PghSedePersonalAutorizado registro) {
    	
    	SedePersonalAutorizadoDTO registroDTO = new SedePersonalAutorizadoDTO();
        
        registroDTO.setIdSedePersonalAutorizado(registro.getIdSedePersonalAutorizado());
        registroDTO.setFlagSedePersonalAutorizado(registro.getFlagSedePersonalAutorizado());
        registroDTO.setIdSedeAcreditacion(registro.getIdSedeAcreditacion());
        registroDTO.setIdPersonaNatural(registro.getIdPersonaNatural());
        registroDTO.setIdCargo(registro.getIdCargo());
        registroDTO.setIdEspecialidad(registro.getIdEspecialidad());
        
        return registroDTO;
    }
    
    //Usados para EDITAR
    public static SedePersonalAutorizadoDTO toSedePersonalADTO(PghSedePersonalAutorizado registro) {
    	
    	SedePersonalAutorizadoDTO registroDTO = new SedePersonalAutorizadoDTO();
        
        registroDTO.setIdSedePersonalAutorizado(registro.getIdSedePersonalAutorizado());
        registroDTO.setIdCargo(registro.getIdCargo());
        registroDTO.setIdEspecialidad(registro.getIdEspecialidad());
        
        return registroDTO;
    }
    //-------------------------------------------
}
