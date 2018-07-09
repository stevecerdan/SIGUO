package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoRevisionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoRevisionFilter;
import gob.osinergmin.sibad.service.ResultadoRevisionService;
import gob.osinergmin.sibad.service.dao.ResultadoRevisionDAO;

@Service("ResultadoRevisionService")
public class ResultadoRevisionServiceImpl implements ResultadoRevisionService{
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoRevisionServiceImpl.class);
	
	@Inject
	ResultadoRevisionDAO resultadoRevDao;

	@Override
	public ResultadoRevisionDTO RegistrarResultadoRevision(ResultadoRevisionDTO resultadoRevDTO,
			UsuarioDTO usuarioDTO) {
		LOG.info("Registro RegistrarResultadoRevision ServiceNegImpl");
		ResultadoRevisionDTO registro = null;
		 //LOG.info(resultadoPersonaNaturalDTO.getApellidoMaterno()+" - "+resultadoPersonaNaturalDTO.getApellidoPaterno() +" - "+resultadoPersonaNaturalDTO.getNombre() +" - "+resultadoPersonaNaturalDTO.getCip());
		
		try {
			registro = resultadoRevDao.create(resultadoRevDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos de ResultadoRevDTO al DAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos de ResultadoRevDTO al DAO",e);
		}
		
		return registro;	
		
	}

	@Override
	public List<ResultadoRevisionDTO> listarResultadoRevision(ResultadoRevisionFilter filtro) {
		
		List<ResultadoRevisionDTO> retorno=null;
        try{
            retorno = resultadoRevDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en Resultado Revision",ex);
        }
        return retorno;
	}

}
