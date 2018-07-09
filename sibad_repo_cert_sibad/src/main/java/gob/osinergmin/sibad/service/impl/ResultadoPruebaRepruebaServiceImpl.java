package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaRepruebaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaRepruebaFilter;
import gob.osinergmin.sibad.service.ResultadoPruebaRepruebaService;
import gob.osinergmin.sibad.service.dao.ResultadoPruebaRepruebaDAO;


@Service("ResultadoPruebaRepruebaService")
public class ResultadoPruebaRepruebaServiceImpl implements ResultadoPruebaRepruebaService  {
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoPruebaRepruebaServiceImpl.class);

	@Inject
	ResultadoPruebaRepruebaDAO resultadoPruebaRepruebaDao;

	@Override
	public ResultadoPruebaRepruebaDTO RegistrarResultadoPruebaReprueba(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Registro Resultado Prueba Reprueba");
		ResultadoPruebaRepruebaDTO registro = null;
		
		try {
			
			registro = resultadoPruebaRepruebaDao.create(resultadoPruebaRepruebaDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de  Resultado Prueba Reprueba al DAO) registro: "+registro.toString());
		
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Resultado Prueba Reprueba al DAO",e);
			
		}
		
		return registro;
	}

	@Override
	public ResultadoPruebaRepruebaDTO EditarResultadoPruebaReprueba(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Registro Resultado Prueba Reprueba");
		ResultadoPruebaRepruebaDTO registro = null;
		
		try {
			
			registro = resultadoPruebaRepruebaDao.update(resultadoPruebaRepruebaDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de  Resultado Prueba Reprueba al DAO) registro: "+registro.toString());
		
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Resultado Prueba Reprueba al DAO",e);
			
		}
		
		return registro;
	}
	
	@Override
	public ResultadoPruebaRepruebaDTO EditarFechaProxPruebaResultadoPruebaReprueba(ResultadoPruebaRepruebaDTO resultadoPruebaRepruebaDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Registro Resultado Prueba Reprueba");
		ResultadoPruebaRepruebaDTO registro = null;
		
		try {
			
			registro = resultadoPruebaRepruebaDao.updateFechaProxPrueba(resultadoPruebaRepruebaDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de  Resultado Prueba Reprueba al DAO) registro: "+registro.toString());
		
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Resultado Prueba Reprueba al DAO",e);
			
		}
		
		return registro;
	}

	@Override
	public List<ResultadoPruebaRepruebaDTO> listarResultadoPruebaReprueba(ResultadoPruebaRepruebaFilter filtro) {
		
		List<ResultadoPruebaRepruebaDTO> retorno=null;
		
        try{
        	
            retorno = resultadoPruebaRepruebaDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
            
        }catch(Exception ex){
        	
            LOG.error("Error en Resultado Prueba Reprueba",ex);
            
        }
        return retorno;
	}
}
