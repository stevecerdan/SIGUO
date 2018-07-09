package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaDocumentoFilter;
import gob.osinergmin.sibad.service.ResultadoPruebaDocumentoService;
import gob.osinergmin.sibad.service.dao.ResultadoPruebaDocumentoDAO;
import gob.osinergmin.sibad.service.exception.ProgramacionException;


@Service("ResultadoPruebaDocumentoService")
public class ResultadoPruebaDocumentoServiceImpl implements ResultadoPruebaDocumentoService{
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoPruebaDocumentoServiceImpl.class);

	@Inject
	ResultadoPruebaDocumentoDAO resultadoPruebaDocumentoDao;

	@Override
	public ResultadoPruebaDocumentoDTO RegistrarResultadoPruebaDocumento(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Registro Resultado Prueba Documento");
		ResultadoPruebaDocumentoDTO registro = null;
		
		try {
			
			registro = resultadoPruebaDocumentoDao.create(resultadoPruebaDocumentoDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de  Resultado Prueba Documento al DAO) registro: "+registro.toString());
		
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Resultado Prueba Documento al DAO",e);
			
		}
		
		return registro;
	}

	@Override
	public ResultadoPruebaDocumentoDTO EditarResultadoPruebaDocumento(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO, UsuarioDTO usuarioDTO) {
		
		LOG.info("Registro Resultado Prueba Documento");
		ResultadoPruebaDocumentoDTO registro = null;
		
		try {
			
			registro = resultadoPruebaDocumentoDao.update(resultadoPruebaDocumentoDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de  Resultado Prueba Documento al DAO) registro: "+registro.toString());
		
		} catch (Exception e) {
			
			LOG.error("error enviar datos de Resultado Prueba Documento al DAO",e);
			
		}
		
		return registro;
	}

	@Override
	public List<ResultadoPruebaDocumentoVDTO> listarResultadoPruebaDocumento(ResultadoPruebaDocumentoFilter filtro) {

       List<ResultadoPruebaDocumentoVDTO> retorno=null;
		
        try{
        	
            retorno = resultadoPruebaDocumentoDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
            
        }catch(Exception ex){
        	
            LOG.error("Error en Resultado Prueba Documento",ex);
            
        }
        return retorno;
	}

	@Override
	public ResultadoPruebaDocumentoDTO EliminarResultadoPruebaDocumento(ResultadoPruebaDocumentoDTO resultadoPruebaDocumentoDTO, UsuarioDTO usuarioDTO) {
		
		    LOG.info("Iniciando envio de datos al DAO");
			
		    ResultadoPruebaDocumentoDTO registro=null;
			
			try {
							
				registro = resultadoPruebaDocumentoDao.delete(resultadoPruebaDocumentoDTO,usuarioDTO);
				LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos al DAO",e);
			}
		
			return registro;
	}
}
