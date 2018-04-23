/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.dto.UnidadOperativaDTO;

/**
 *
 * @author DSR
 */
public class UnidadOperativaBuilder {
    
    public static UnidadOperativaDTO obtenerUnidadOperativa(Object[] data){
        UnidadOperativaDTO unidadOperativaDTO = new UnidadOperativaDTO();
        unidadOperativaDTO.setCodigoOsinergmin(data[0].toString());
        unidadOperativaDTO.setIdUnidad(new Long(data[1].toString()));
        unidadOperativaDTO.setRazonSocial(data[2].toString());
        unidadOperativaDTO.setRuc(data[3]!=null?data[3].toString():"");
        unidadOperativaDTO.setDireccion(data[4].toString());
        unidadOperativaDTO.setTelefono(data[5]!=null?data[5].toString():"");
        unidadOperativaDTO.setCorreo(data[6]!=null?data[6].toString():"");
        unidadOperativaDTO.setCodigo(data[7].toString());
        unidadOperativaDTO.setActividad(data[8].toString());        
        unidadOperativaDTO.setIddistrito(data[9].toString());
        unidadOperativaDTO.setIdprovincia(data[10].toString());
        unidadOperativaDTO.setIddepartamento(data[11].toString());
        unidadOperativaDTO.setIdDependencia(data[12].toString());
        unidadOperativaDTO.setDependencia(data[13].toString());
        unidadOperativaDTO.setDepartamento(data[14].toString());
        unidadOperativaDTO.setProvincia(data[15].toString());
        unidadOperativaDTO.setDistrito(data[16].toString());
        return unidadOperativaDTO;
    }
}
