package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghProductoxCompartimientoV;
import gob.osinergmin.sibad.domain.dto.ProductoxCompartimientoDTO;

public class ProductoxCompartimientoBuilder {

	public static List<ProductoxCompartimientoDTO> toListProductoxCompartimientoDto(List<PghProductoxCompartimientoV> lista) {
		ProductoxCompartimientoDTO registroDTO;
        List<ProductoxCompartimientoDTO> retorno = new ArrayList<ProductoxCompartimientoDTO>();
        if (lista != null) {
            for (PghProductoxCompartimientoV maestro : lista) {
                registroDTO = toProductoxCompartimientoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}
	
	
	public static ProductoxCompartimientoDTO toProductoxCompartimientoDto(PghProductoxCompartimientoV registro) {
		ProductoxCompartimientoDTO registroDTO = new ProductoxCompartimientoDTO();
        
		registroDTO.setCapacidad(registro.getCapacidad());
		registroDTO.setIdAlmacenamiento(registro.getIdAlmacenamiento());
		registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
		registroDTO.setIdProgramacion(registro.getIdProgramacion());
		registroDTO.setIdResultadoRevision(registro.getIdResultadoRevision());
		registroDTO.setIdUnidMediCompartimiento(registro.getIdUnidMediCompartimiento());
		registroDTO.setNumero(registro.getNumero());
        
        return registroDTO;
    }
	
}
