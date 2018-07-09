/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.MdiPersonaNaturalV;
import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
public class PersonaNaturalVBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(PersonaNaturalVBuilder.class);
	
    public static List<PersonaNaturalVDTO> toListPersonaNaturalDto(List<MdiPersonaNaturalV> lista) {
    	PersonaNaturalVDTO registroDTO;
        List<PersonaNaturalVDTO> retorno = new ArrayList<PersonaNaturalVDTO>();
        if (lista != null) {
            for (MdiPersonaNaturalV maestro : lista) {
                registroDTO = toPersonaNaturalDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static PersonaNaturalVDTO toPersonaNaturalDto(MdiPersonaNaturalV registro) {
    	PersonaNaturalVDTO registroDTO = new PersonaNaturalVDTO();
        
        registroDTO.setIdPersonaNatural(registro.getIdPersonaNatural());
        registroDTO.setIdTipoDocumento(registro.getIdTipoDocumento());
        registroDTO.setNumeroDoc(registro.getNumeroDoc());
        registroDTO.setApellidoPaterno(registro.getApellidoPaterno());
        registroDTO.setApellidoMaterno(registro.getApellidoMaterno());
        registroDTO.setNombre(registro.getNombre());
        registroDTO.setCip(registro.getCip());
        registroDTO.setTelefono(registro.getTelefono());
        
        return registroDTO;
    }
    
    public static MdiPersonaNaturalV getPersonaNatural(PersonaNaturalVDTO registroDTO) {
        MdiPersonaNaturalV registro = null;
        if(registroDTO!=null){
            registro=new MdiPersonaNaturalV();
            registro.setIdPersonaNatural(registroDTO.getIdPersonaNatural());
            registro.setIdTipoDocumento(registroDTO.getIdTipoDocumento());
            registro.setNumeroDoc(registroDTO.getNumeroDoc());
            registro.setApellidoPaterno(registroDTO.getApellidoPaterno());
            registro.setApellidoMaterno(registroDTO.getApellidoMaterno());
            registro.setNombre(registroDTO.getNombre());
            registro.setCip(registroDTO.getCip());
            registro.setTelefono(registroDTO.getTelefono());
        }
        return registro;
    }
    
    public static MdiPersonaNaturalV toMdiPersonaNaturalV(PersonaNaturalVDTO personaNaturalDTO){
		LOG.info("Inicio BUILDER PN: " + personaNaturalDTO.getIdPersonaNatural() +" - " + personaNaturalDTO.getIdTipoDocumento() +" - " + personaNaturalDTO.getNumeroDoc());
		MdiPersonaNaturalV mdiPersonaNaturalV = new MdiPersonaNaturalV();
		
		if(personaNaturalDTO!=null){
				LOG.info("ENTRO en if personaNaturalVDTO.idpersonaNatural");
				mdiPersonaNaturalV.setIdTipoDocumento(personaNaturalDTO.getIdTipoDocumento());
				mdiPersonaNaturalV.setNumeroDoc(personaNaturalDTO.getNumeroDoc());
				mdiPersonaNaturalV.setNombre(personaNaturalDTO.getNombre());
				mdiPersonaNaturalV.setApellidoMaterno(personaNaturalDTO.getApellidoMaterno());
				mdiPersonaNaturalV.setApellidoPaterno(personaNaturalDTO.getApellidoPaterno());
				mdiPersonaNaturalV.setCip(personaNaturalDTO.getCip());
				mdiPersonaNaturalV.setTelefono(personaNaturalDTO.getTelefono());
			
		}
		LOG.info("FIN BUILDER PN: " + mdiPersonaNaturalV.getIdPersonaNatural() +" - " + mdiPersonaNaturalV.getIdTipoDocumento() +" - " + mdiPersonaNaturalV.getNumeroDoc());
		return mdiPersonaNaturalV;
	}
    
    public static List<PersonaNaturalVDTO> toListTablaPersonaNaturalDto(Long idPersonaNatural, String numeroDoc, String apellidoPaterno, String apellidoMaterno,String nombre) {
    	
    	PersonaNaturalVDTO registroDTO = new PersonaNaturalVDTO();
        List<PersonaNaturalVDTO> retorno = new ArrayList<PersonaNaturalVDTO>();
        
        registroDTO.setIdPersonaNatural(idPersonaNatural);
        registroDTO.setNumeroDoc(numeroDoc);
        registroDTO.setNombre(nombre);
        registroDTO.setApellidoMaterno(apellidoMaterno);
        registroDTO.setApellidoPaterno(apellidoPaterno);

        retorno.add(registroDTO);
        
        return retorno;
    }
}
