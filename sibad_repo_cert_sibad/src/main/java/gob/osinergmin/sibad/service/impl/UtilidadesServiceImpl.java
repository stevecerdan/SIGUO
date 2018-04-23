/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.DependenciaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadOperativaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.UtilidadesService;
import gob.osinergmin.sibad.service.dao.UtilidadesDAO;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author DSR
 */
@Service("UtilidadesSFHService")
public class UtilidadesServiceImpl implements UtilidadesService{
    
    private static final Logger LOG = LoggerFactory.getLogger(UtilidadesServiceImpl.class);
    @Inject
    private UtilidadesDAO utilidadesSFHDAO;
    
    @Override
    public UnidadOperativaDTO obtenerUnidadOperativa(String codigoScop) {
        LOG.info("procesando UtilidadesSFHService/obtenerUnidadOperativa");
        return utilidadesSFHDAO.obtenerUnidadOperativa(codigoScop);
         
    }
    
    
    @Override
    public UnidadOperativaDTO obtenerUnidadOperativaByCodigoOsinerg(String codigoOsinerg) {
        LOG.info("procesando UtilidadesSFHService/obtenerUnidadOperativaByCodigoOsinerg");
        return utilidadesSFHDAO.obtenerUnidadOperativaByCodigoOsinerg(codigoOsinerg);
    }
    
    
    
    @Override
    public String existeUsuario(String usuario) {
        return utilidadesSFHDAO.existeUsuario(usuario);
    }
    
    @Override
    public UsuarioDTO getUsuario(String usuario){
        return utilidadesSFHDAO.getUsuario(usuario);
    }
    
    @Override
    public String validarPrivilegiosUsuario(String usuario,String pagina) {
        return utilidadesSFHDAO.validarPrivilegiosUsuario(usuario,pagina);
    }
    
    
    @Override
    public List<DependenciaDTO> obtenerDependencias(String codigoActividad){
    	return utilidadesSFHDAO.obtenerDependencias(codigoActividad);
    }
    
    public String getKey() {
        return utilidadesSFHDAO.getKey();
    }
    
    @Override
    public String encryptedParameters(String codApp) {
        return utilidadesSFHDAO.encryptedParameters(codApp);
    }
    
    @Override
    public List<String> obtenerCodigosOsinergminPermitidosUsuario(String loginUsuario) {
        return utilidadesSFHDAO.obtenerCodigosOsinergminPermitidosUsuario(loginUsuario);
    }
    
}
