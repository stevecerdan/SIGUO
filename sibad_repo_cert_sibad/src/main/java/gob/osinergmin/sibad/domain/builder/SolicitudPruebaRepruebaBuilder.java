/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghSolicitudPruebaReprueba;
import gob.osinergmin.sibad.domain.PghSolicitudPruebaRepruebaV;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.service.dao.impl.SolicitudPruebaRepruebaDAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
 public class SolicitudPruebaRepruebaBuilder {
	 
	 private static final Logger LOG = LoggerFactory.getLogger(SolicitudPruebaRepruebaBuilder.class);
	
  public static List<SolicitudPruebaRepruebaDTO> toListSolicitudPruebaRepruebaDto(List<PghSolicitudPruebaRepruebaV> lista) {
	  SolicitudPruebaRepruebaDTO registroDTO;
        List<SolicitudPruebaRepruebaDTO> retorno = new ArrayList<SolicitudPruebaRepruebaDTO>();
        if (lista != null) {
            for (PghSolicitudPruebaRepruebaV maestro : lista) {
                registroDTO = toSolicitudPruebaRepruebaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
  
    public static SolicitudPruebaRepruebaDTO toSolicitudPruebaRepruebaDto(PghSolicitudPruebaRepruebaV registro) {
    	SolicitudPruebaRepruebaDTO registroDTO = new SolicitudPruebaRepruebaDTO();
    	
        registroDTO.setIdSolicitudPruebaReprueba(registro.getIdSolicitudPruebaReprueba());
        registroDTO.setNroSolicitudUnidadSupervisa(registro.getNroSolicitudUnidadSupervisa());
        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setTipoPrueba(registro.getTipoPrueba());
        registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
        registroDTO.setEmpresaAcreditada(registro.getEmpresaAcreditada());
        registroDTO.setIdUnidSupervTanque(registro.getIdUnidSupervTanque());
        registroDTO.setIdUnidSupervModulo(registro.getIdUnidSupervModulo());
        registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
        registroDTO.setNumeroCompartimiento(registro.getNumeroCompartimiento());
        registroDTO.setIdAlmacenamiento(registro.getIdAlmacenamiento());
        registroDTO.setNumeroTanque(registro.getNumeroTanque());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setFechaSolicitud(registro.getFechaSolicitud());
        registroDTO.setFechaCreacion(registro.getFechaCreacion());
        registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());
        registroDTO.setFechaInicio(registro.getFechaInicio());
        registroDTO.setResultadoPrueba(registro.getResultadoPrueba());
        registroDTO.setFechaProxPrueba(registro.getFechaProxPrueba());
        registroDTO.setFechaFin(registro.getFechaEmisionCertificado());
        
        registroDTO.setNumeroCertificado(registro.getNumeroCertificado());
        registroDTO.setNumeroInforme(registro.getNumeroInforme());
        registroDTO.setFlagInformeIndiceRiesgo(registro.getFlagInformeIndiceRiesgo());
        registroDTO.setNumeroSerie(registro.getNumeroSerie());
        
        registroDTO.setIdModulo(registro.getIdModulo());
        registroDTO.setIdCilindroGNV(registro.getIdCilindroGNV());
        registroDTO.setModulo(registro.getModulo());
        registroDTO.setCilindro(registro.getCilindro());
        
        return registroDTO;
    }
    
    public static PghSolicitudPruebaRepruebaV getSolicitudPruebaReprueba(SolicitudPruebaRepruebaDTO registroDTO) {
        PghSolicitudPruebaRepruebaV registro = null;
        if(registroDTO!=null){
            registro=new PghSolicitudPruebaRepruebaV();
            registro.setIdSolicitudPruebaReprueba(registroDTO.getIdSolicitudPruebaReprueba());
            registro.setNroSolicitudUnidadSupervisa(registroDTO.getNroSolicitudUnidadSupervisa());
            registro.setIdTipoPrueba(registroDTO.getIdTipoPrueba());
            registro.setTipoPrueba(registroDTO.getTipoPrueba());
            registro.setIdEmpresaAcreditada(registroDTO.getIdEmpresaAcreditada());
            registro.setEmpresaAcreditada(registroDTO.getEmpresaAcreditada());
            registro.setIdUnidSupervTanque(registroDTO.getIdUnidSupervTanque());
            registro.setIdUnidSupervModulo(registroDTO.getIdUnidSupervModulo());
            registro.setIdCompartimiento(registroDTO.getIdCompartimiento());
            registro.setNumeroCompartimiento(registroDTO.getNumeroCompartimiento());
            registro.setIdAlmacenamiento(registroDTO.getIdAlmacenamiento());
            registro.setNumeroTanque(registroDTO.getNumeroTanque());
            registro.setEstado(registroDTO.getEstado());
            registro.setFechaSolicitud(registroDTO.getFechaSolicitud());
            registro.setFechaCreacion(registroDTO.getFechaCreacion());
            registro.setFechaInicio(registroDTO.getFechaInicio());
            registro.setResultadoPrueba(registroDTO.getResultadoPrueba());
            registro.setFechaProxPrueba(registroDTO.getFechaProxPrueba());
            
            registro.setNumeroCertificado(registroDTO.getNumeroCertificado());
            registro.setNumeroInforme(registroDTO.getNumeroInforme());
            registro.setFlagInformeIndiceRiesgo(registroDTO.getFlagInformeIndiceRiesgo());
            
            registro.setIdModulo(registroDTO.getIdModulo());
            registro.setIdCilindroGNV(registroDTO.getIdCilindroGNV());
            registro.setModulo(registroDTO.getModulo());
            registro.setCilindro(registroDTO.getCilindro());
        }
        return registro;

    }
    
  //Utilizado para el Registro
    public static SolicitudPruebaRepruebaDTO toSolicitudPruebaRepruebaDTO(PghSolicitudPruebaReprueba registro) {
    	
    	SolicitudPruebaRepruebaDTO registroDTO = new SolicitudPruebaRepruebaDTO();
    	
        registroDTO.setIdSolicitudPruebaReprueba(registro.getIdSolicitudPruebaReprueba());
        registroDTO.setNroSolicitudUnidadSupervisa(registro.getNroSolicitudUnidadSupervisa());
        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());
        registroDTO.setIdPersonaJuridica(registro.getIdPersonaJuridica());
        registroDTO.setFechaSolicitud(registro.getFechaSolicitud());
        registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
        registroDTO.setIdCilindroGNV(registro.getIdCilindroGNV());
        registroDTO.setIdTanqueGLP(registro.getIdTanqueGLP());
        registroDTO.setFlagInspeccion(registro.getFlagInspeccion());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setFlagInformeIndiceRiesgo(registro.getFlagInformeIndiceRiesgo());
                
        LOG.info(registroDTO.getIdSolicitudPruebaReprueba().toString());
        
        return registroDTO;
    }
  	//--------------------------------------
    
}
