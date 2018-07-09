/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghEmpresaAcreditada;
import gob.osinergmin.sibad.domain.PghEmpresaAcreditadaV;
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
	
  public static List<EmpresaAcreditadaDTO> toListEmpresaAcreditadaDto(List<PghEmpresaAcreditadaV> lista) {
	  EmpresaAcreditadaDTO registroDTO;
        List<EmpresaAcreditadaDTO> retorno = new ArrayList<EmpresaAcreditadaDTO>();
        if (lista != null) {
            for (PghEmpresaAcreditadaV maestro : lista) {
                registroDTO = toEmpresaAcreditadaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
  
  public static List<EmpresaAcreditadaDTO> toListEmpresaAcreditDto(List<PghEmpresaAcreditada> lista) {
	  EmpresaAcreditadaDTO registroDTO;
        List<EmpresaAcreditadaDTO> retorno = new ArrayList<EmpresaAcreditadaDTO>();
        if (lista != null) {
            for (PghEmpresaAcreditada maestro : lista) {
                registroDTO = toEmpresaAcreditadaDTO(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static EmpresaAcreditadaDTO toEmpresaAcreditadaDto(PghEmpresaAcreditadaV registro) {
    	EmpresaAcreditadaDTO registroDTO = new EmpresaAcreditadaDTO();
    	
        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
        registroDTO.setRuc(registro.getRuc());
        registroDTO.setRazonSocial(registro.getRazonSocial());
        registroDTO.setDireccion(registro.getDireccion());
        registroDTO.setDepartamento(registro.getDepartamento());
        registroDTO.setProvincia(registro.getProvincia());
        registroDTO.setDistrito(registro.getDistrito());
        registroDTO.setIdPrimerAlcanceAcreditacion(registro.getIdPrimerAlcanceAcreditacion());
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
        registroDTO.setEstadoAccion(registro.getEstadoAccion());
        registroDTO.setIdOrganismoAcreditador(registro.getIdOrganismoAcreditador());
        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setIdTipoOrganismo(registro.getIdTipoOrganismo());
        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
        registroDTO.setIdDocumentoAlcanceAcredita(registro.getIdDocumentoAlcanceAcredita());
        registroDTO.setNormaEvaluada(registro.getNormaEvaluada());
        
        return registroDTO;
    }
    
    public static PghEmpresaAcreditadaV getPersonaJuridica(EmpresaAcreditadaDTO registroDTO) {
        PghEmpresaAcreditadaV registro = null;
        if(registroDTO!=null){
            registro=new PghEmpresaAcreditadaV();
            registro.setIdAlcanceAcreditacion(registroDTO.getIdAlcanceAcreditacion());
            registro.setIdEmpresaAcreditada(registroDTO.getIdEmpresaAcreditada());
            registro.setRuc(registroDTO.getRuc());
            registro.setRazonSocial(registroDTO.getRazonSocial());
            registro.setDireccion(registroDTO.getDireccion());
            registro.setDepartamento(registroDTO.getDepartamento());
            registro.setProvincia(registroDTO.getProvincia());
            registro.setDistrito(registroDTO.getDistrito());
            registro.setIdPrimerAlcanceAcreditacion(registroDTO.getIdPrimerAlcanceAcreditacion());
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
            registro.setEstadoAccion(registroDTO.getEstadoAccion());
            registro.setIdTipoPrueba(registroDTO.getIdTipoPrueba());
            registro.setIdTipoOrganismo(registroDTO.getIdTipoOrganismo());
            registro.setIdDocumentoAdjunto(registroDTO.getIdDocumentoAdjunto());
            registro.setIdDocumentoAlcanceAcredita(registroDTO.getIdDocumentoAlcanceAcredita());
            registro.setNormaEvaluada(registroDTO.getNormaEvaluada());
            registro.setIdOrganismoAcreditador(registroDTO.getIdOrganismoAcreditador());
        }
        return registro;

    }
    
  //Utilizado para el Registro
  	public static EmpresaAcreditadaDTO toEmpresaAcreditadaDTO(PghEmpresaAcreditada registro){
		
	 EmpresaAcreditadaDTO registroDTO = new EmpresaAcreditadaDTO();
     
     registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
     registroDTO.setIdPersonaJuridica(registro.getIdPersonaJuridica());
     registroDTO.setEstado(registro.getEstado());
     registroDTO.setRegistro(registro.getRegistro());

     return registroDTO;
		
	}
  	//--------------------------------------
    
    public static PghEmpresaAcreditada getEmpAcred(EmpresaAcreditadaDTO registroDTO) {
        PghEmpresaAcreditada registro = null;
        if(registroDTO!=null){
            registro=new PghEmpresaAcreditada();
            registro.setIdEmpresaAcreditada(registroDTO.getIdEmpresaAcreditada());
            registro.setIdPersonaJuridica(registroDTO.getIdPersonaJuridica());
            registro.setEstado(registroDTO.getEstado());
            registro.setRegistro(registroDTO.getRegistro());
        }
        return registro;

    }
    
  //Utilizado para Edicion
  	public static EmpresaAcreditadaDTO toEmpresaAcreditadaRegDTO(PghEmpresaAcreditada registro){
		
	 EmpresaAcreditadaDTO registroDTO = new EmpresaAcreditadaDTO();
     
     registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
     registroDTO.setRegistro(registro.getRegistro());

     return registroDTO;
		
	}
  	//--------------------------------------
}
