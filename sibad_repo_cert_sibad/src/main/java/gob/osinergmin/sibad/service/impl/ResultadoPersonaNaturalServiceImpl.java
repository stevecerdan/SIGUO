package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPersonaNaturalFilter;
import gob.osinergmin.sibad.service.ResultadoPersonaNaturalService;
import gob.osinergmin.sibad.service.dao.ResultadoPersonaNaturalDAO;
import gob.osinergmin.sibad.service.exception.ResultadoPersonaNaturalException;
import gob.osinergmin.sibad.service.exception.SedePersonalAutorizadoException;

@Service("ResultadoPersonaNaturalService")
public class ResultadoPersonaNaturalServiceImpl implements ResultadoPersonaNaturalService {
	private static final Logger LOG = LoggerFactory.getLogger(PersonaNaturalVServiceImpl.class);
	
	@Inject
	ResultadoPersonaNaturalDAO resultadoPsnaNtalDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ResultadoPersonaNaturalDTO> listarResultadoPersonaNatural(ResultadoPersonaNaturalFilter filtro) {
		List<ResultadoPersonaNaturalDTO> retorno=null;
        try{
            retorno = resultadoPsnaNtalDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarPersonaNatural",ex);
        }
        return retorno;
	}

	@Override
	public ResultadoPersonaNaturalDTO guardarResultadoPersonaNatural(ResultadoPersonaNaturalDTO resultadoPersonaNaturalDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Registro guardarPersonaNatural ServiceNegImpl");
		ResultadoPersonaNaturalDTO registro = null;
		 LOG.info(resultadoPersonaNaturalDTO.getApellidoMaterno()+" - "+resultadoPersonaNaturalDTO.getApellidoPaterno() +" - "+resultadoPersonaNaturalDTO.getNombre() +" - "+resultadoPersonaNaturalDTO.getCip());
		
		try {
			registro = resultadoPsnaNtalDao.create(resultadoPersonaNaturalDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de PersonaNaturalVDTO al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos de PersonaNaturalVDTO al DAO",e);
		}
		
		return registro;
	}

	@Override
	public ResultadoPersonaNaturalDTO eliminarPersonal(ResultadoPersonaNaturalDTO resultadoPersonaDTO) throws ResultadoPersonaNaturalException{
		ResultadoPersonaNaturalDTO eliminar = null;
		
		try {
			eliminar = resultadoPsnaNtalDao.eliminarPersonal(resultadoPersonaDTO);
			//LOG.info("(eliminarSedePersonal) registro: "+eliminar.toString());
		} catch (Exception ex) {
			LOG.error("Error eliminarPersonal",ex);
            throw new ResultadoPersonaNaturalException(ex.getMessage(),null);
		}
		return eliminar;
	}
	
	
}
