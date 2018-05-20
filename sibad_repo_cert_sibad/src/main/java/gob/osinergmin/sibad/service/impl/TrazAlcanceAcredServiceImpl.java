package gob.osinergmin.sibad.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.service.TrazAlcanceAcredService;
import gob.osinergmin.sibad.service.dao.TrazAlcanceAcredDAO;

@Service("TrazAlcanceAcredService")
public class TrazAlcanceAcredServiceImpl implements TrazAlcanceAcredService{
	private static final Logger LOG = LoggerFactory.getLogger(TrazAlcanceAcredServiceImpl.class);
    
	@Inject
	TrazAlcanceAcredDAO trazAlcanceAcredDAO;
	
	@Override
	public TrazAlcanceAcredDTO RegistrarObservacionTrazAlcanceAcred(TrazAlcanceAcredDTO trazAlcanceAcredDTO) {
		
		LOG.info("Iniciando envio de datos de Traz Alcance Acred al DAO");
		
		TrazAlcanceAcredDTO registro=null;
			
			try {
				
				
				registro = trazAlcanceAcredDAO.create(trazAlcanceAcredDTO);
				LOG.info("(Se envio con exito los datos de Traz Alcance Acred a al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos de Persona Juridica al DAO",e);
			}
		
			return registro;
	}

	@Override
	public TrazAlcanceAcredDTO RegistrarTrazAlcanceAcred(TrazAlcanceAcredDTO trazAlcanceAcredDTO) {
		
    LOG.info("Iniciando envio de datos de Traz Alcance Acred al DAO");
		
		TrazAlcanceAcredDTO registro=null;
			
			try {
				
				
				registro = trazAlcanceAcredDAO.create(trazAlcanceAcredDTO);
				LOG.info("(Se envio con exito los datos de Traz Alcance Acred a al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos de Persona Juridica al DAO",e);
			}
		
			return registro;
	}	

}
