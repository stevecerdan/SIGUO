package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.InformePersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.InformeSolicitudPruebaDTO;
import gob.osinergmin.sibad.filter.InformePersonaNaturalFilter;
import gob.osinergmin.sibad.filter.InformeSolicitudPruebaFilter;
import gob.osinergmin.sibad.service.InformeSolicitudPruebaService;
import gob.osinergmin.sibad.service.dao.InformeSolicitudPruebaDAO;

@Service("InformeSolicitudPruebaService")
public class InformeSolicitudPruebaServiceImpl implements InformeSolicitudPruebaService{
	private static final Logger LOG = LoggerFactory.getLogger(InformeSolicitudPruebaServiceImpl.class);

	@Inject
	InformeSolicitudPruebaDAO informeSolicitudPruebaDAO;

	@Override
	public InformeSolicitudPruebaDTO RegistrarInformeSolicitudPrueba(InformeSolicitudPruebaDTO informeSolicitudPruebaDTO) {
		
		LOG.info("Registro InformeSolicitudPrueba ");
		InformeSolicitudPruebaDTO registro = null;
		
		try {
			registro = informeSolicitudPruebaDAO.create(informeSolicitudPruebaDTO);
			LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos al DAO",e);
		}
		
		return registro;	}

	@Override
	public List<InformeSolicitudPruebaDTO> ListarInformeSolicitudPrueba(InformeSolicitudPruebaFilter filtro) {
		
		List<InformeSolicitudPruebaDTO> retorno=null;
        try{
            retorno = informeSolicitudPruebaDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en Informe Solicitud Prueba",ex);
        }
        return retorno;
	}

}
