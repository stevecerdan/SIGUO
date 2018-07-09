package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gob.osinergmin.sibad.domain.PghResultadoPersonaNatural;
import gob.osinergmin.sibad.domain.PghResultadoPersonaNaturalV;
import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;

public class ResultadoPersonaNaturalBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoPersonaNaturalBuilder.class);
	public static List<ResultadoPersonaNaturalDTO> toListPersonaNaturalDto(List<PghResultadoPersonaNaturalV> lista) {
		ResultadoPersonaNaturalDTO registroDTO;
	        List<ResultadoPersonaNaturalDTO> retorno = new ArrayList<ResultadoPersonaNaturalDTO>();
	        if (lista != null) {
	            for (PghResultadoPersonaNaturalV maestro : lista) {
	                registroDTO = toPersonaNaturalDto(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static ResultadoPersonaNaturalDTO toPersonaNaturalDto(PghResultadoPersonaNaturalV registro) {
		ResultadoPersonaNaturalDTO registroDTO = new ResultadoPersonaNaturalDTO();
        LOG.info("Buider: "+registro.getNumeroDocumento());
        registroDTO.setIdResultadoPersonaNatural(registro.getIdResultadoPersonaNatural());
        registroDTO.setIdResultadoRevision(registro.getIdResultadoRevision());
        registroDTO.setIdPersonaNatural(registro.getIdPersonaNatural());
        registroDTO.setIdTipoDocumento(registro.getIdTipoDocumento());
        registroDTO.setTipoDocumento(registro.getTipoDocumento());
        registroDTO.setNumeroDocumento(registro.getNumeroDocumento());
        registroDTO.setApellidoPaterno(registro.getApellidoPaterno());
        registroDTO.setApellidoMaterno(registro.getApellidoMaterno());
        registroDTO.setNombre(registro.getNombre());
        registroDTO.setNombreCompleto(registro.getNombreCompleto());
        registroDTO.setCip(registro.getCip());
        
        return registroDTO;
    }
	
	public static ResultadoPersonaNaturalDTO toPersonaNaturalDto(PghResultadoPersonaNatural registro) {
		ResultadoPersonaNaturalDTO registroDTO = new ResultadoPersonaNaturalDTO();
        
        registroDTO.setIdResultadoPersonaNatural(registro.getIdResultadoPersonaNatural());
        registroDTO.setIdResultadoRevision(registro.getIdResultadoRevision());
        registroDTO.setIdPersonaNatural(registro.getIdPersonaNatural());
        
        return registroDTO;
    }
	
	public static PghResultadoPersonaNatural toPghResultadoPersonaNatural(ResultadoPersonaNaturalDTO resultadoPersonaNaturalDTO) {
		PghResultadoPersonaNatural registro = new PghResultadoPersonaNatural();
		
		if (resultadoPersonaNaturalDTO != null) {
			registro.setIdResultadoPersonaNatural(resultadoPersonaNaturalDTO.getIdResultadoPersonaNatural());
			registro.setIdResultadoRevision(resultadoPersonaNaturalDTO.getIdResultadoRevision());
			registro.setIdPersonaNatural(resultadoPersonaNaturalDTO.getIdPersonaNatural());
		}
		
		return registro;
	}
}
