/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.DependenciaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadOperativaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;

import java.util.List;

/**
 *
 * @author DSR
 */
public interface UtilidadesDAO {

    public UnidadOperativaDTO obtenerUnidadOperativa(String codigoScop);
    public UnidadOperativaDTO obtenerUnidadOperativaByCodigoOsinerg(String codigoOsinerg);
    public String existeUsuario(String usuario);
    public UsuarioDTO getUsuario(String usuario); 
    public String validarPrivilegiosUsuario(String usuario,String pagina);
    public List<DependenciaDTO> obtenerDependencias(String codigoActividad);
    public String getKey();
    public String encryptedParameters(String codApp);
    public List<String> obtenerCodigosOsinergminPermitidosUsuario(String loginUsuario);
    
}
