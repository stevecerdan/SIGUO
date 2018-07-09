/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghAlmacenaCompartiProdV;
import gob.osinergmin.sibad.domain.dto.AlmacenaCompartiProdDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
 public class AlmacenaCompartiProdBuilder {
	
  public static List<AlmacenaCompartiProdDTO> toListAlmacenaCompartiProdDto(List<PghAlmacenaCompartiProdV> lista) {
	  AlmacenaCompartiProdDTO registroDTO;
        List<AlmacenaCompartiProdDTO> retorno = new ArrayList<AlmacenaCompartiProdDTO>();
        if (lista != null) {
            for (PghAlmacenaCompartiProdV maestro : lista) {
                registroDTO = toAlmacenaCompartiProdDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
  
    public static AlmacenaCompartiProdDTO toAlmacenaCompartiProdDto(PghAlmacenaCompartiProdV registro) {
    	AlmacenaCompartiProdDTO registroDTO = new AlmacenaCompartiProdDTO();
    	    	
        registroDTO.setIdProductoXCompartimiento(registro.getIdProductoXCompartimiento());
        registroDTO.setIdUnidSupervTanque(registro.getIdUnidSupervTanque());
        registroDTO.setIdAlmacenamiento(registro.getIdAlmacenamiento());
        registroDTO.setNumeroTanque(registro.getNumeroTanque());
        registroDTO.setIdCompartimiento(registro.getIdCompartimiento());
        registroDTO.setNumeroCompartimiento(registro.getNumeroCompartimiento());
        registroDTO.setCapacidad(registro.getCapacidad());
        registroDTO.setIdProducto(registro.getIdProducto());
        registroDTO.setNombreLargoProducto(registro.getNombreLargoProducto());
        registroDTO.setFechaProxPrueba(registro.getFechaProxPrueba());
        registroDTO.setIdUnidadMedida(registro.getIdUnidadMedida());
        registroDTO.setDescripcionMedida(registro.getDescripcionMedida());
        registroDTO.setAbreviaturaMedida(registro.getAbreviaturaMedida());
        registroDTO.setNumero(registro.getNumero());
        
        return registroDTO;
    }
    
    public static PghAlmacenaCompartiProdV getAlmacenaCompartiProd(AlmacenaCompartiProdDTO registroDTO) {
        PghAlmacenaCompartiProdV registro = null;
        if(registroDTO!=null){
            registro=new PghAlmacenaCompartiProdV();
            registro.setIdProductoXCompartimiento(registroDTO.getIdProductoXCompartimiento());
            registro.setIdUnidSupervTanque(registroDTO.getIdUnidSupervTanque());
            registro.setIdAlmacenamiento(registroDTO.getIdAlmacenamiento());
            registro.setNumeroTanque(registroDTO.getNumeroTanque());
            registro.setIdCompartimiento(registroDTO.getIdCompartimiento());
            registro.setNumeroCompartimiento(registroDTO.getNumeroCompartimiento());
            registro.setCapacidad(registroDTO.getCapacidad());
            registro.setIdProducto(registroDTO.getIdProducto());
            registro.setNombreLargoProducto(registroDTO.getNombreLargoProducto());
            registro.setFechaProxPrueba(registroDTO.getFechaProxPrueba());
            registro.setIdUnidadMedida(registroDTO.getIdUnidadMedida());
            registro.setDescripcionMedida(registroDTO.getDescripcionMedida());
            registro.setAbreviaturaMedida(registroDTO.getAbreviaturaMedida());
        }
        return registro;

    }
}
