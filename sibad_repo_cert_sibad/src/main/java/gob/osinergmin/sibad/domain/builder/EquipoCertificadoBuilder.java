/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghEquipoCertificado;
import gob.osinergmin.sibad.domain.PghEquipoCertificadoV;
import gob.osinergmin.sibad.domain.dto.EquipoCertificadoDTO;
import gob.osinergmin.sibad.service.dao.impl.EquipoCertificadoDAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
 public class EquipoCertificadoBuilder {
	 private static final Logger LOG = LoggerFactory.getLogger(EquipoCertificadoBuilder.class);
	
  public static List<EquipoCertificadoDTO> toListEquipoCertificadoDto(List<PghEquipoCertificadoV> lista) {
	  EquipoCertificadoDTO registroDTO;
        List<EquipoCertificadoDTO> retorno = new ArrayList<EquipoCertificadoDTO>();
        if (lista != null) {
            for (PghEquipoCertificadoV maestro : lista) {
                registroDTO = toEquipoCertificadoDto(maestro);
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
  
    public static EquipoCertificadoDTO toEquipoCertificadoDto(PghEquipoCertificadoV registro) {
    	EquipoCertificadoDTO registroDTO = new EquipoCertificadoDTO();
        
    	registroDTO.setIdEquipoCertificado(registro.getIdEquipoCertificado());
        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setIdTipoEquipo(registro.getIdTipoEquipo());
        registroDTO.setTipoEquipo(registro.getTipoEquipo());
        registroDTO.setDescripcionEquipo(registro.getDescripcionEquipo());
        registroDTO.setMarca(registro.getMarca());
        registroDTO.setModelo(registro.getModelo());
        registroDTO.setSerie(registro.getSerie());
        registroDTO.setOtroDato(registro.getOtroDato());
        registroDTO.setFechaCalibracion(registro.getFechaCalibracion());
        registroDTO.setFechaProximaCalibracion(registro.getFechaProximaCalibracion());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setIdTipoMotivo(registro.getIdTipoMotivo());
        registroDTO.setObservacion(registro.getObservacion());
        
        //LOG.info("Otro DAto: PGHV: " + registro.getOtroDato() + " - DTO: " + registroDTO.getOtroDato());
        
        return registroDTO;
    }
    
    public static EquipoCertificadoDTO toEquipoCertificadoDto(PghEquipoCertificado registro) {
    	EquipoCertificadoDTO registroDTO = new EquipoCertificadoDTO();
        
    	registroDTO.setIdEquipoCertificado(registro.getIdEquipoCertificado());
        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setIdTipoEquipo(registro.getIdTipoEquipo());
        registroDTO.setIdTipoEquipo(registro.getIdTipoEquipo());
        registroDTO.setDescripcionEquipo(registro.getDescripcion());
        registroDTO.setMarca(registro.getMarca());
        registroDTO.setModelo(registro.getModelo());
        registroDTO.setSerie(registro.getSerie());
        registroDTO.setOtroDato(registro.getDatoAdicional());
        registroDTO.setFechaCalibracion(registro.getFechaCalibracion());
        registroDTO.setFechaProximaCalibracion(registro.getFechaProxCalibracion());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
    
    //-------- usado para update estado ---------------------
    public static EquipoCertificadoDTO toEquipoCertificadoDtto(PghEquipoCertificado registro) {
    	EquipoCertificadoDTO registroDTO = new EquipoCertificadoDTO();
        
    	registroDTO.setIdEquipoCertificado(registro.getIdEquipoCertificado());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setIdTipoMotivo(registro.getIdTipoMotivo());
        registroDTO.setObservacion(registro.getObservacion());
        
        return registroDTO;
    }
    //-----------------------------------------------------------
    
    public static PghEquipoCertificadoV getEquipoCertificado(EquipoCertificadoDTO registroDTO) {
        PghEquipoCertificadoV registro = null;
        if(registroDTO!=null){
            registro=new PghEquipoCertificadoV();
            registro.setIdEquipoCertificado(registroDTO.getIdEquipoCertificado());
            registro.setIdAlcanceAcreditacion(registroDTO.getIdAlcanceAcreditacion());
            registro.setIdTipoEquipo(registroDTO.getIdTipoEquipo());
            registro.setTipoEquipo(registroDTO.getTipoEquipo());
            registro.setDescripcionEquipo(registroDTO.getDescripcionEquipo());
            registro.setMarca(registroDTO.getMarca());
            registro.setModelo(registroDTO.getModelo());
            registro.setSerie(registroDTO.getSerie());
            registro.setOtroDato(registroDTO.getOtroDato());
            registro.setFechaCalibracion(registroDTO.getFechaCalibracion());
            registro.setFechaProximaCalibracion(registroDTO.getFechaProximaCalibracion());
            registro.setEstado(registroDTO.getEstado());
            registro.setIdTipoMotivo(registroDTO.getIdTipoMotivo());
            registro.setObservacion(registroDTO.getObservacion());
        }
        return registro;

    }
}
