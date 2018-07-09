package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.InformeIndiceRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.InformeIndiceRiesgoFilter;
import gob.osinergmin.sibad.service.InformeIndiceRiesgoService;
import gob.osinergmin.sibad.service.dao.InformeIndiceRiesgoDAO;

@Service("InformeIndiceRiesgoService")
public class InformeIndiceRiesgoServiceImpl implements InformeIndiceRiesgoService{
	private static final Logger LOG = LoggerFactory.getLogger(InformeIndiceRiesgoServiceImpl.class);

	@Inject
	InformeIndiceRiesgoDAO informeIndiceRiesgoDAO;

	@Override
	public InformeIndiceRiesgoDTO RegistrarInformeIndiceRiesgo(InformeIndiceRiesgoDTO informeIndiceRiesgoDTO,UsuarioDTO usuarioDTO) {

		LOG.info("Registro InformeIndiceRiesgo ");
		InformeIndiceRiesgoDTO registro = null;
		
		try {
			registro = informeIndiceRiesgoDAO.create(informeIndiceRiesgoDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos al DAO",e);
		}
		
		return registro;	
		
	}

	@Override
	public List<InformeIndiceRiesgoDTO> ListarInformeIndiceRiesgo(InformeIndiceRiesgoFilter filtro) {
		
		List<InformeIndiceRiesgoDTO> retorno = null;
		
		try {
			retorno = informeIndiceRiesgoDAO.find(filtro);
			LOG.info("cuenta -size: "+retorno.size());
		} catch (Exception e) {
			LOG.error("error enviar datos al DAO",e);
		}
		
		return retorno;	
			
	}

}
