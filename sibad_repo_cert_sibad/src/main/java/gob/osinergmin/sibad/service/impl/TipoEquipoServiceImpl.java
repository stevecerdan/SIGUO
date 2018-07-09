/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.TipoEquipoDTO;
import gob.osinergmin.sibad.filter.TipoEquipoFilter;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.TipoEquipoService;
import gob.osinergmin.sibad.service.dao.TipoEquipoDAO;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * @author jpiro
 */

@Service("tipoequipoService")
public class TipoEquipoServiceImpl implements TipoEquipoService{
    private static final Logger LOG = LoggerFactory.getLogger(TipoEquipoServiceImpl.class);
    
    @Inject
    TipoEquipoDAO tipoequipoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoEquipoDTO> listarTipoEquipo (TipoEquipoFilter filtro){
        List<TipoEquipoDTO> retorno=null;
        try{
            retorno = tipoequipoDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en ListarTipoEquipo",ex);
        }
        return retorno;
    }
}
