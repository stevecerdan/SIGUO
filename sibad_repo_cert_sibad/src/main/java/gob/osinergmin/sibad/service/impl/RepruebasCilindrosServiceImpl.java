package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosDTO;
import gob.osinergmin.sibad.domain.dto.RepruebasCilindrosModuloDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.filter.RepruebasCilindrosFilter;
import gob.osinergmin.sibad.service.RepruebasCilindrosService;
import gob.osinergmin.sibad.service.dao.RepruebasCilindrosDAO;

@Service("RepruebasCilindrosService")
public class RepruebasCilindrosServiceImpl implements RepruebasCilindrosService{
private static final Logger LOG = LoggerFactory.getLogger(RepruebasCilindrosServiceImpl.class);
	
	@Inject
	RepruebasCilindrosDAO repruebasCilindrosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<RepruebasCilindrosDTO> listarRepruebasCilindros(RepruebasCilindrosFilter filtro) {
		List<RepruebasCilindrosDTO> retorno=null;
        try{
            retorno = repruebasCilindrosDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarPersonaNatural",ex);
        }
        return retorno;
	}
	/*
	@Override
	public SolicitudPruebaRepruebaDTO create(SolicitudPruebaRepruebaDTO solicitudPruebaRpbaDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Iniciando envio de datos al DAO");
		
		SolicitudPruebaRepruebaDTO registro = null;
		
		try {	
			registro = repruebasCilindrosDao.create(solicitudPruebaRpbaDTO, usuarioDTO) ;
			LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
			 
		} catch (Exception e){
			LOG.error("error enviar datos al DAO",e);
		}
	
		return registro;
	}*/

	@Override
	public List<RepruebasCilindrosModuloDTO> listarCilindroxModulo(RepruebasCilindrosFilter filtro) {
		List<RepruebasCilindrosModuloDTO> retorno=null;
        try{
            retorno = repruebasCilindrosDao.findCodigoOsinerg(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarPersonaNatural",ex);
        }
        return retorno;
	}

}
