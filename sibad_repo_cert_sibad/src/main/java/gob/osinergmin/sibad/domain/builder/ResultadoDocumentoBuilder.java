package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gob.osinergmin.sibad.domain.PghResultadoDocumento;
import gob.osinergmin.sibad.domain.PghResultadoDocumentoV;
import gob.osinergmin.sibad.domain.dto.ResultadoDocumentoDTO;

public class ResultadoDocumentoBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoDocumentoBuilder.class);
	
	
	public static List<ResultadoDocumentoDTO> toListDocumentoDto(List<PghResultadoDocumentoV> lista) {
		ResultadoDocumentoDTO registroDTO;
	        List<ResultadoDocumentoDTO> retorno = new ArrayList<ResultadoDocumentoDTO>();
	        if (lista != null) {
	            for (PghResultadoDocumentoV maestro : lista) {
	                registroDTO = toResultadoDocDto(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	}
	
	
	public static ResultadoDocumentoDTO toResultadoDocDto(PghResultadoDocumentoV registro) {
		ResultadoDocumentoDTO registroDTO = new ResultadoDocumentoDTO();
        LOG.info("Buider: "+registro.getIdResultadoDocumento());

        registroDTO.setIdResultadoDocumento(registro.getIdResultadoDocumento());
        registroDTO.setIdResultadoRevision(registro.getIdResultadoRevision());
        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
        registroDTO.setNombreDocumento(registro.getNombreDocumento());
        registroDTO.setArchivoAdjunto(registro.getArchivoAdjunto());
        
        return registroDTO;
    }
	
	public static ResultadoDocumentoDTO toResultadoDocDto(PghResultadoDocumento registro) {
		ResultadoDocumentoDTO registroDTO = new ResultadoDocumentoDTO();
        LOG.info("Buider: "+registro.getIdResultadoDocumento());

        registroDTO.setIdResultadoDocumento(registro.getIdResultadoDocumento());
        registroDTO.setIdResultadoRevision(registro.getIdResultadoRevision());
        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
        
        return registroDTO;
    }


	public static PghResultadoDocumento toPghResultadoDocumento(ResultadoDocumentoDTO resultadoDocDTO) {
		PghResultadoDocumento registro = new PghResultadoDocumento();
		
		registro.setIdResultadoDocumento(resultadoDocDTO.getIdResultadoDocumento());
		registro.setIdDocumentoAdjunto(resultadoDocDTO.getIdDocumentoAdjunto());
		registro.setIdResultadoRevision(resultadoDocDTO.getIdResultadoRevision());
		
		return registro;
	}
	
}
