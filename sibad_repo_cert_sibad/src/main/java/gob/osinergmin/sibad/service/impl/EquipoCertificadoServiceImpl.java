/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.EquipoCertificadoDTO;
import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EquipoCertificadoFilter;
import gob.osinergmin.sibad.service.EquipoCertificadoService;
import gob.osinergmin.sibad.service.dao.EquipoCertificadoDAO;
import gob.osinergmin.sibad.service.exception.EmpresaAcreditadaException;
import gob.osinergmin.sibad.service.exception.EquipoCertificadoException;

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
@Service("equipocertificadoService")
public class EquipoCertificadoServiceImpl implements EquipoCertificadoService{
    private static final Logger LOG = LoggerFactory.getLogger(EquipoCertificadoServiceImpl.class);
    
    @Inject
    EquipoCertificadoDAO equipocertificadoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<EquipoCertificadoDTO> listarEquipoCertificado (EquipoCertificadoFilter filtro){
        List<EquipoCertificadoDTO> retorno=null;
        try{
            retorno = equipocertificadoDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarEquipoCertificado",ex);
        }
        return retorno;
    }

	@Override
	public EquipoCertificadoDTO registrarEquipoCertificado(EquipoCertificadoDTO equipoCertificadoDTO,
			UsuarioDTO usuarioDTO) {
		LOG.info("Iniciando envio de datos de EquipoCertificadoDTO al DAO");
		EquipoCertificadoDTO registro = null;
		
		try {
			registro = equipocertificadoDAO.create(equipoCertificadoDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos a equipocertificadoDAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos a equipocertificadoDAO",e);
		}
		
		return registro;
	}
	
	@Override
	public EquipoCertificadoDTO updateEquipoCertificado(EquipoCertificadoDTO equipoCertificadoDTO,
			UsuarioDTO usuarioDTO) {
		LOG.info("Iniciando envio de datos de EquipoCertificadoDTO al DAO");
		EquipoCertificadoDTO registro = null;
		
		try {
			registro = equipocertificadoDAO.updateEstado(equipoCertificadoDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos a equipocertificadoDAO) registro: "+registro.toString());
		} catch (Exception e) {
			LOG.error("error enviar datos a equipocertificadoDAO",e);
		}
		
		return registro;
	}

	@Override
	public EquipoCertificadoDTO eliminarEquipoCertificado(EquipoCertificadoDTO equipoCertificadoDTO)
			throws EquipoCertificadoException {
		EquipoCertificadoDTO eliminar = null;
		try {
			eliminar = equipocertificadoDAO.eliminar(equipoCertificadoDTO);
			LOG.info("(eliminarequipo ServiceNegImpl) registro: "+eliminar.toString());
		} catch (Exception e) {
			LOG.error("Error eliminarConcurso",e);
            throw new EquipoCertificadoException(e.getMessage(),null);
		}
		return eliminar;
	}
}
