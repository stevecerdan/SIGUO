/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EquipoComponenteFilter;
import gob.osinergmin.sibad.service.EquipoComponenteService;
import gob.osinergmin.sibad.service.dao.EquipoComponenteDAO;
import gob.osinergmin.sibad.service.exception.EquipoComponenteException;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service("EquipoComponenteService")
public class EquipoComponenteServiceImpl implements EquipoComponenteService{
    private static final Logger LOG = LoggerFactory.getLogger(EquipoComponenteServiceImpl.class);
    
    @Inject
    EquipoComponenteDAO equipocomponenteDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<EquipoComponenteDTO> listarEquipoComponente (EquipoComponenteFilter filtro){
        List<EquipoComponenteDTO> retorno=null;
        try{
            retorno = equipocomponenteDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarEquipoComponente",ex);
        }
        return retorno;
    }

	@Override
	public EquipoComponenteDTO eliminarComponente(EquipoComponenteDTO equipoComponenteDTO)
			throws EquipoComponenteException {
		EquipoComponenteDTO eliminar = null;
		try {
			//eliminar
			eliminar = equipocomponenteDAO.eliminar(equipoComponenteDTO);
			LOG.info("(eliminarequipo ServiceNegImpl) registro: "+eliminar.toString());
		} catch (Exception e) {
			LOG.error("Error eliminarConcurso",e);
            throw new EquipoComponenteException(e.getMessage(),null);
		}
		return eliminar;
	}

	@Override
	public EquipoComponenteDTO registrarEquipoComponente(EquipoComponenteDTO equipoComponenteDTO,
			UsuarioDTO usuarioDTO) {
		LOG.info("Iniciando envio de datos de EquipoComponenteDTO al DAO");
		EquipoComponenteDTO registro = null;
		
		try {
			registro = equipocomponenteDAO.create(equipoComponenteDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos a equipocomponenteDAO) registro: "+registro.toString());
			
		} catch (Exception e) {
			LOG.error("error enviar datos a equipocomponenteDAO",e);
		}
		
		return registro;
	}
}
