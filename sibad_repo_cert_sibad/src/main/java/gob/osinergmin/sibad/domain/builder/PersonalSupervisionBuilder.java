package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.mdicommon.domain.dto.PersonalDTO;
import gob.osinergmin.sibad.domain.dto.PersonalSupervisionDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class PersonalSupervisionBuilder {
	public static List<PersonalSupervisionDTO> toListPersonalSupervisionDTO(List<PersonalDTO> listaPersonal) {
		List<PersonalSupervisionDTO> listaPersonalSupervisionDto = null;
		if(!CollectionUtils.isEmpty(listaPersonal)){
			listaPersonalSupervisionDto = new ArrayList<PersonalSupervisionDTO>();
			PersonalSupervisionDTO personalSupervisionDTO = null;
			for(PersonalDTO personal : listaPersonal){
				personalSupervisionDTO = toPersonalSupervisionDTO(personal);
				listaPersonalSupervisionDto.add(personalSupervisionDTO);
			}
		}
		return listaPersonalSupervisionDto;
	}
	
	public static PersonalSupervisionDTO toPersonalSupervisionDTO(PersonalDTO personal) {
		PersonalSupervisionDTO personalSupervision = null;
		if(personal!=null){
			personalSupervision = new PersonalSupervisionDTO();
			personalSupervision.setIdPersonal(personal.getIdPersonal());
			personalSupervision.setNombreUsuarioSiged(personal.getNombreUsuarioSiged());
			personalSupervision.setNombre(personal.getNombre());
			personalSupervision.setApellidoPaterno(personal.getApellidoPaterno());
			personalSupervision.setApellidoMaterno(personal.getApellidoMaterno());
			personalSupervision.setIdPersonalSiged(personal.getIdPersonalSiged());
			personalSupervision.setNombreCompleto(personal.getNombreCompleto());
			personalSupervision.setCorreoElectronico(personal.getCorreoElectronico());
			personalSupervision.setNumeroDocIdentidad(personal.getNumeroDocIdentidad());
			personalSupervision.setAplicacion(personal.getAplicacion());
		}
		return personalSupervision;
	}
	
}
