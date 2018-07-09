package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.ResultadoPruebaEquipoCompDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaEquipoCompFilter;
import gob.osinergmin.sibad.service.ResultadoPruebaEquipoCompService;
import gob.osinergmin.sibad.service.dao.ResultadoPruebaEquipoCompDAO;

@Service("ResultadoPruebaEquipoCompService")
public class ResultadoPruebaEquipoCompServiceImpl implements ResultadoPruebaEquipoCompService  {
private static final Logger LOG = LoggerFactory.getLogger(ResultadoPruebaEquipoCompServiceImpl.class);
	
	@Inject
	ResultadoPruebaEquipoCompDAO resultadoPruebaEquipoCompDao;

	@Override
	public ResultadoPruebaEquipoCompDTO RegistrarResultadoPruebaEquipoComp(ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Registro ResultadoPruebaEquipoComp ServiceNegImpl");
		ResultadoPruebaEquipoCompDTO registro = null;
		
		try {
			registro = resultadoPruebaEquipoCompDao.create(resultadoPruebaEquipoCompDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de ResultadoPruebaEquipoCompDTO al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos de ResultadoPruebaEquipoCompDTO al DAO",e);
		}
		
		return registro;
	}
	
	@Override
	public List<ResultadoPruebaEquipoCompDTO> consultarResultadoPruebaEquipoComp(ResultadoPruebaEquipoCompFilter filtro) {
		
        List<ResultadoPruebaEquipoCompDTO> retorno=null;
		
        try{
        	
            retorno = resultadoPruebaEquipoCompDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
            
        }catch(Exception ex){
        	
            LOG.error("Error en Resultado Prueba Equipo Compartimiento",ex);
            
        }
        return retorno;
	}
	
	@Override
	public ResultadoPruebaEquipoCompDTO EliminarResultadoPruebaEquipoComp(ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO, UsuarioDTO usuarioDTO) {
	
        ResultadoPruebaEquipoCompDTO registro = null;
		
		try {
			registro = resultadoPruebaEquipoCompDao.delete(resultadoPruebaEquipoCompDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de ResultadoPruebaEquipoCompDTO al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos de ResultadoPruebaEquipoCompDTO al DAO",e);
		}
		
		return registro;
	}

}
