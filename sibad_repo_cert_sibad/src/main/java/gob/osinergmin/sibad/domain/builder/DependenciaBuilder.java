package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.SibadDpndncia;
import gob.osinergmin.sibad.domain.dto.DependenciaDTO;

import java.util.ArrayList;
import java.util.List;

public class DependenciaBuilder {

	   public static DependenciaDTO obtenerDependenciaDTO(SibadDpndncia depen) {
		   DependenciaDTO depenDTO = new DependenciaDTO();
		   depenDTO.setIdDependencia(depen.getId());
		   depenDTO.setNombre(depen.getNmbre());
		   depenDTO.setEstado(depen.getEstdo());
	        return depenDTO;
	    }

	    public static List<DependenciaDTO> obtenerListaDependenciaDTO(List<SibadDpndncia> dependencias) {
	    	DependenciaDTO dependenciaDTO;
	        List<DependenciaDTO> listaDependenciaDTO = new ArrayList<DependenciaDTO>();
	        if (dependencias != null) {
	            for (SibadDpndncia depen : dependencias) {
	            	dependenciaDTO = obtenerDependenciaDTO(depen);
	                listaDependenciaDTO.add(dependenciaDTO);
	            }
	        }
	        return listaDependenciaDTO;
	    }
	
}
