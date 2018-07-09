package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoRevisionDTO;
import gob.osinergmin.sibad.filter.InformePersonaNaturalFilter;
import gob.osinergmin.sibad.service.InformePersonaNaturalService;
import gob.osinergmin.sibad.service.dao.InformePersonaNaturalDAO;

@Service("InformePersonaNaturalService")
public class InformePersonaNaturalServiceImpl implements InformePersonaNaturalService{
	private static final Logger LOG = LoggerFactory.getLogger(InformePersonaNaturalServiceImpl.class);

	@Inject
	InformePersonaNaturalDAO informePersonaNaturalDAO;
	
	@Override
	public InformePersonaNaturalDTO RegistrarInformePersonaNatural(InformePersonaNaturalDTO informePersonaNaturalDTO) {
		
		LOG.info("Registro InformePersonaNatural ");
		InformePersonaNaturalDTO registro = null;
		
		try {
			registro = informePersonaNaturalDAO.create(informePersonaNaturalDTO);
			LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos al DAO",e);
		}
		
		return registro;	
		
	}

	@Override
	public List<InformePersonaNaturalDTO> ListarInformePersonaNatural(InformePersonaNaturalFilter filtro) {
		
		List<InformePersonaNaturalDTO> retorno=null;
        try{
            retorno = informePersonaNaturalDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en Informe Persona Natural",ex);
        }
        return retorno;
	}

}
