package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaPersonalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaPersonalFilter;
import gob.osinergmin.sibad.service.ResultadoPruebaPersonalService;
import gob.osinergmin.sibad.service.dao.ResultadoPruebaPersonalDAO;

@Service("ResultadoPruebaPersonalService")
public class ResultadoPruebaPersonalServiceImpl implements ResultadoPruebaPersonalService{
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoPruebaPersonalServiceImpl.class);

	@Inject
	ResultadoPruebaPersonalDAO resultadoPruebaPersonalDao;

	@Override
	public ResultadoPruebaPersonalDTO RegistrarResultadoPruebaPersonal(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Registro Resultado Prueba Personal");
		ResultadoPruebaPersonalDTO registro = null;
		
		try {
			
			registro = resultadoPruebaPersonalDao.create(resultadoPruebaPersonalDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de  Resultado Prueba Personal al DAO) registro: "+registro.toString());
		
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Resultado Prueba Personal al DAO",e);
			
		}
		
		return registro;
	}

	@Override
	public ResultadoPruebaPersonalDTO EditarResultadoPruebaPersonal(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Registro Resultado Prueba Personal");
		ResultadoPruebaPersonalDTO registro = null;
		
		try {
			
			registro = resultadoPruebaPersonalDao.update(resultadoPruebaPersonalDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de  Resultado Prueba Personal al DAO) registro: "+registro.toString());
		
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Resultado Prueba Personal al DAO",e);
			
		}
		
		return registro;
	}

	@Override
	public List<ResultadoPruebaPersonalDTO> consultarResultadoPruebaPersonal(ResultadoPruebaPersonalFilter filtro) {
		
        List<ResultadoPruebaPersonalDTO> retorno=null;
		
        try{
        	
            retorno = resultadoPruebaPersonalDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
            
        }catch(Exception ex){
        	
            LOG.error("Error en Resultado Prueba Personal",ex);
            
        }
        return retorno;
	}
	
	@Override
	public List<ResultadoPruebaPersonalDTO> consultarResultadoPruebaPersonalV(ResultadoPruebaPersonalFilter filtro) {
		
        List<ResultadoPruebaPersonalDTO> retorno=null;
		
        try{
        	
            retorno = resultadoPruebaPersonalDao.find2(filtro);
            LOG.info("cuenta -size: "+retorno.size());
            
        }catch(Exception ex){
        	
            LOG.error("Error en Resultado Prueba Personal",ex);
            
        }
        return retorno;
	}
	
	@Override
	public ResultadoPruebaPersonalDTO EliminarResultadoPruebaPersonal(ResultadoPruebaPersonalDTO resultadoPruebaPersonalDTO, UsuarioDTO usuarioDTO) {
	
		  LOG.info("Iniciando envio de datos al DAO");
			
		  ResultadoPruebaPersonalDTO registro=null;
			
			try {
							
				registro = resultadoPruebaPersonalDao.delete(resultadoPruebaPersonalDTO,usuarioDTO);
				LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos al DAO",e);
			}
		
			return registro;
	}
	
}
