package gob.osinergmin.sibad.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.CilindroGNVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.CilindroService;
import gob.osinergmin.sibad.service.dao.CilindroDAO;

@Service("CilindroService")
public class CilindroServiceImpl implements CilindroService{
    private static final Logger LOG = LoggerFactory.getLogger(CilindroServiceImpl.class);
    
	@Inject
	CilindroDAO cilindroDAO;
	
	@Override
	public CilindroGNVDTO RegistrarCilindro(CilindroGNVDTO cilindroGnvDTO, UsuarioDTO usuarioDTO) {
		
		CilindroGNVDTO registro=null;
		
		try {
			LOG.info("ServiceImpl: "+ cilindroGnvDTO.getIdCilindro() + " - " + cilindroGnvDTO.getEstado());
			registro = cilindroDAO.create(cilindroGnvDTO,usuarioDTO);
			LOG.info("Se envio con exito los datos de RegistrarCilindro al DAO registro: "+registro.getIdCilindro());
			 
		} catch (Exception e) {
			
			LOG.error("error enviar datos de RegistrarCilindro al DAO",e);
		}
	
		return registro;
	}

}
