package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.ResultadoDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoDocumentoFilter;
import gob.osinergmin.sibad.service.ResultadoDocumentoService;
import gob.osinergmin.sibad.service.dao.ResultadoDocumentoDAO;
import gob.osinergmin.sibad.service.exception.ResultadoDocumentoException;
import gob.osinergmin.sibad.service.exception.ResultadoPersonaNaturalException;

@Service("ResultadoDocumentoService")
public class ResultadoDocumentoServiceImpl implements ResultadoDocumentoService{
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoDocumentoServiceImpl.class);
	
	@Inject
	ResultadoDocumentoDAO resultadoDocDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ResultadoDocumentoDTO> listarResultadoDocumento(ResultadoDocumentoFilter filtro) {
		List<ResultadoDocumentoDTO> retorno=null;
        try{
            retorno = resultadoDocDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarPersonaNatural",ex);
        }
        return retorno;
	}

	@Override
	public ResultadoDocumentoDTO eliminarDocumento(ResultadoDocumentoDTO resultadoDocumentoDTO)
			throws ResultadoDocumentoException {
		ResultadoDocumentoDTO eliminar = null;
		
		try {
			eliminar = resultadoDocDao.eliminarDocumento(resultadoDocumentoDTO);
			//LOG.info("(eliminarSedePersonal) registro: "+eliminar.toString());
		} catch (Exception ex) {
			LOG.error("Error eliminarDocumento",ex);
            throw new ResultadoDocumentoException(ex.getMessage(),null);
		}
		return eliminar;
	}

	@Override
	public ResultadoDocumentoDTO RegistrarResultadoDocumento(ResultadoDocumentoDTO resultadoDocDTO,
			UsuarioDTO usuarioDTO) {
		LOG.info("Registro ResultadoDocumento ServiceNegImpl");
		ResultadoDocumentoDTO registro = null;
		 LOG.info(resultadoDocDTO.getIdResultadoDocumento()+" - "+resultadoDocDTO.getIdDocumentoAdjunto() +" - "+resultadoDocDTO.getIdResultadoRevision());
		
		try {
			registro = resultadoDocDao.create(resultadoDocDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de ResultadoDocumentoDTO al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos de ResultadoDocumentoDTO al DAO",e);
		}
		
		return registro;
	}

}
