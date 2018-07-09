package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghAlcanceAcreditacion;
import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;

public class AlcanceAcreditacionBuilder {
	
	public static List<AlcanceAcreditacionDTO> toListAlcanceAcreditacionDto(List<PghAlcanceAcreditacion> lista) {
		AlcanceAcreditacionDTO registroDTO;
	        List<AlcanceAcreditacionDTO> retorno = new ArrayList<AlcanceAcreditacionDTO>();
	        if (lista != null) {
	            for (PghAlcanceAcreditacion maestro : lista) {
	                registroDTO = toRegistrarAlcanceAcreditacion(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
    } 
	
	public static AlcanceAcreditacionDTO toAlcanceAcreditacionDTO(PghAlcanceAcreditacion registro) {
		
		AlcanceAcreditacionDTO registroDTO = new AlcanceAcreditacionDTO();
        
		registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setEstadoAccion(registro.getEstadoAccion());

        return registroDTO;
    }
	
   public static AlcanceAcreditacionDTO toRegistrarAlcanceAcreditacion(PghAlcanceAcreditacion registro) {
		
		AlcanceAcreditacionDTO registroDTO = new AlcanceAcreditacionDTO();
        
		registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion()); 
		registroDTO.setIdEmpresaAcreditada(registro.getIdEmpresaAcreditada());      
		registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
		registroDTO.setIdOrganismoAcreditador(registro.getIdOrganismoAcreditador());
		registroDTO.setResolucionCedula(registro.getResolucionCedula());
		registroDTO.setIdPrimerAlcanceAcreditacion(registro.getIdPrimerAlcanceAcreditacion());
		registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
		registroDTO.setIdDocumentoAlcanceAcreditada(registro.getIdDocumentoAlcanceAcreditada());
		registroDTO.setIdTipoOrganismo(registro.getIdTipoOrganismo());
		registroDTO.setNormaEvualada(registro.getNormaEvualada());
		registroDTO.setFechaAcreditacion(registro.getFechaAcreditacion());
		registroDTO.setFechaUltimaActualizacion(registro.getFechaUltimaActualizacion());
		registroDTO.setFechaInicioVigencia(registro.getFechaInicioVigencia());
		registroDTO.setFechaVencimiento(registro.getFechaVencimiento());
		registroDTO.setEstado(registro.getEstado());
		registroDTO.setEstadoAccion(registro.getEstadoAccion());

        return registroDTO;
    }
   
   public static PghAlcanceAcreditacion getAlcanceAcreditacion(AlcanceAcreditacionDTO registroDTO) {
       PghAlcanceAcreditacion registro = null;
       if(registroDTO!=null){
           registro=new PghAlcanceAcreditacion();
           registro.setIdAlcanceAcreditacion(registroDTO.getIdAlcanceAcreditacion());
           registro.setIdEmpresaAcreditada(registroDTO.getIdEmpresaAcreditada());
           registro.setIdTipoPrueba(registroDTO.getIdTipoPrueba());
           registro.setIdOrganismoAcreditador(registroDTO.getIdOrganismoAcreditador());
           registro.setResolucionCedula(registroDTO.getResolucionCedula());
           registro.setIdPrimerAlcanceAcreditacion(registroDTO.getIdPrimerAlcanceAcreditacion());
           registro.setIdDocumentoAdjunto(registroDTO.getIdDocumentoAdjunto());
           registro.setIdDocumentoAlcanceAcreditada(registroDTO.getIdDocumentoAlcanceAcreditada());
           registro.setIdTipoOrganismo(registroDTO.getIdTipoOrganismo());
           registro.setNormaEvualada(registroDTO.getNormaEvualada());
           registro.setFechaUltimaActualizacion(registroDTO.getFechaUltimaActualizacion());
           registro.setFechaAcreditacion(registroDTO.getFechaAcreditacion());
           registro.setFechaVencimiento(registroDTO.getFechaVencimiento());
           registro.setFechaInicioVigencia(registroDTO.getFechaInicioVigencia());
           registro.setEstado(registroDTO.getEstado());
           registro.setEstadoAccion(registroDTO.getEstadoAccion());
           
       }
       return registro;

   }

}
