package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gob.osinergmin.sibad.domain.PghRepruebasCilindrosGNVV;
import gob.osinergmin.sibad.domain.PghRepruebasCilindrosV;
import gob.osinergmin.sibad.domain.PghResultadoPersonaNatural;
import gob.osinergmin.sibad.domain.PghSolicitudPruebaReprueba;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosModuloDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;

public class RepruebasCilindrosBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(RepruebasCilindrosBuilder.class);

	public static List<RepruebasCilindrosDTO> toListRepruebasDto(List<PghRepruebasCilindrosGNVV> lista) {
		RepruebasCilindrosDTO registroDTO;
        List<RepruebasCilindrosDTO> retorno = new ArrayList<RepruebasCilindrosDTO>();
        if (lista != null) {
            for (PghRepruebasCilindrosGNVV maestro : lista) {
                registroDTO = toRepruebasDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}
	
	public static RepruebasCilindrosDTO toRepruebasDto(PghRepruebasCilindrosGNVV registro) {
		RepruebasCilindrosDTO registroDTO = new RepruebasCilindrosDTO();
		
        LOG.info("Builder: "+registro.getIdSolicitudPruebaRp());

        registroDTO.setIdEmpresaAcred(registro.getIdEmpresaAcred());
        registroDTO.setIdTipoPrueba(registro.getIdTipoPrueba());
        registroDTO.setIdSolicitudPruebaRp(registro.getIdSolicitudPruebaRp());
        registroDTO.setIdUnidSuperv(registro.getIdUnidSuperv());
        registroDTO.setCilindro(registro.getCilindro());
        registroDTO.setEstado(registro.getEstado());
//        registroDTO.setFechaCertificado(registro.getFechaCertificado());
        registroDTO.setFechaCreacion(registro.getFechaCreacion());
        registroDTO.setFechaProgramada(registro.getFechaProgramada());
        registroDTO.setFechaRegistro(registro.getFechaRegistro());
        registroDTO.setModulo(registro.getModulo());
        registroDTO.setNombreEmpresaAcred(registro.getNombreEmpresaAcred());
        registroDTO.setNumeroReprueba(registro.getNumeroReprueba());
        
        return registroDTO;
    }

	/*public static PghSolicitudPruebaReprueba toPghSolicitudPruebaReprueba(SolicitudPruebaRepruebaDTO solicitudPruebaRpbaDTO) {
		PghSolicitudPruebaReprueba registro = new PghSolicitudPruebaReprueba();
		
		if (solicitudPruebaRpbaDTO != null) {
			registro.setIdCilindroGnv(solicitudPruebaRpbaDTO.getIdCilindroGnv());
			registro.setIdCompartimiento(solicitudPruebaRpbaDTO.getIdCompartimiento());
			registro.setIdEmpresaAcreditada(solicitudPruebaRpbaDTO.getIdEmpresaAcreditada());
			registro.setIdPersonaJuridica(solicitudPruebaRpbaDTO.getIdPersonaJuridica());
			registro.setIdSolicitudPruebaReprueba(solicitudPruebaRpbaDTO.getIdSolicitudPruebaReprueba());
			registro.setIdTanque(solicitudPruebaRpbaDTO.getIdTanque());
			registro.setIdTipoPrueba(solicitudPruebaRpbaDTO.getIdTipoPrueba());
			registro.setEstado(solicitudPruebaRpbaDTO.getEstado());
			registro.setFechaSolicitud(solicitudPruebaRpbaDTO.getFechaSolicitud());
			registro.setFlagInspeccion(solicitudPruebaRpbaDTO.getFlagInspeccion());
			registro.setNumeroReprueba(solicitudPruebaRpbaDTO.getNumeroReprueba());
			
		}
		
		return registro;
	}*/

	public static List<RepruebasCilindrosModuloDTO> toListRepruebasCilindrosModuloDto(List<PghRepruebasCilindrosV> lista) {
		RepruebasCilindrosModuloDTO registroDTO = new RepruebasCilindrosModuloDTO();
        List<RepruebasCilindrosModuloDTO> retorno = new ArrayList<RepruebasCilindrosModuloDTO>();
        if (lista != null) {
            for (PghRepruebasCilindrosV maestro : lista) {
                registroDTO = toRepruebasModuloDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}

	private static RepruebasCilindrosModuloDTO toRepruebasModuloDto(PghRepruebasCilindrosV registro){
		RepruebasCilindrosModuloDTO registroDTO = new RepruebasCilindrosModuloDTO();
		
        //LOG.info("RepruebasCilindrosModuloDTO: "+registro.getCodigoOsinerg() + " - " + registro.getIdModulo());
        
        registroDTO.setIdCilindro(registro.getIdCilindro());
        registroDTO.setIdUnidSuperv(registro.getIdUnidSuperv());
        registroDTO.setIdModulo(registro.getIdModulo());
        registroDTO.setNumeroSerie(registro.getNumeroSerie());
        //registroDTO.setCodigoOsinerg(registro.getCodigoOsinerg());
        registroDTO.setFechaProximaRep(registro.getFechaProximaRep());
        //registroDTO.setNombreUnidad(registro.getNombreUnidad());
        registroDTO.setNroCilindro(registro.getNroCilindro());
        registroDTO.setNroModulo(registro.getNroModulo());
        
        return registroDTO;
	}

}
