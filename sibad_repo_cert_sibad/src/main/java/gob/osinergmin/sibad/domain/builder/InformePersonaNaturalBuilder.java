package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghInformePersonaNatural;
import gob.osinergmin.sibad.domain.PghInformePersonaNaturalV;
import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;

public class InformePersonaNaturalBuilder {

	public static List<InformePersonaNaturalDTO> toListInformePersonaNaturalDto(List<PghInformePersonaNaturalV> lista) {
		InformePersonaNaturalDTO registroDTO;
	        List<InformePersonaNaturalDTO> retorno = new ArrayList<InformePersonaNaturalDTO>();
	        if (lista != null) {
	            for (PghInformePersonaNaturalV maestro : lista) {
	                registroDTO = toPghInformePersonaNaturalV(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static InformePersonaNaturalDTO toPghInformePersonaNaturalV(PghInformePersonaNaturalV registro) {
		
		InformePersonaNaturalDTO registroDTO = new InformePersonaNaturalDTO();
		
		registroDTO.setIdInformePersonaNatural(registro.getIdInformePersonaNatural());
		registroDTO.setIdInformeIndiceRiesgo(registro.getIdInformeIndiceRiesgo());
		registroDTO.setIdPersonaNatural(registro.getIdPersonaNatural());
		registroDTO.setApellidoMaterno(registro.getApellidoMaterno());
		registroDTO.setApellidoPaterno(registro.getApellidoPaterno());
		registroDTO.setCip(registro.getCip());
		registroDTO.setIdTipoDocumentoIdentidad(registro.getIdTipoDocumentoIdentidad());
		registroDTO.setNombre(registro.getNombre());
		registroDTO.setNombreCompleto(registro.getNombreCompleto());
		registroDTO.setNumeroDocumento(registro.getNumeroDocumento());
		registroDTO.setTipoDocumento(registro.getTipoDocumento());
		
		return registroDTO;

	}
	
	public static InformePersonaNaturalDTO toPghInformePersonaNatural(PghInformePersonaNatural registro) {
			
		InformePersonaNaturalDTO registroDTO = new InformePersonaNaturalDTO();
		
		registroDTO.setIdInformePersonaNatural(registro.getIdInformePersonaNatural());
		registroDTO.setIdInformeIndiceRiesgo(registro.getIdInformeIndiceRiesgo());
		registroDTO.setIdPersonaNatural(registro.getIdPersonaNatural());
		
		return registroDTO;

	}
}
