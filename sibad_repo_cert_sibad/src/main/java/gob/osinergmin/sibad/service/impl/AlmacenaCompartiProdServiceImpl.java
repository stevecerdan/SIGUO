/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.AlmacenaCompartiProdDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlmacenaCompartiProdFilter;
import gob.osinergmin.sibad.service.AlmacenaCompartiProdService;
import gob.osinergmin.sibad.service.dao.AlmacenaCompartiProdDAO;
import gob.osinergmin.sibad.service.exception.AlmacenaCompartiProdException;

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
@Service("almacenacompartiprodService")
public class AlmacenaCompartiProdServiceImpl implements AlmacenaCompartiProdService{
    private static final Logger LOG = LoggerFactory.getLogger(AlmacenaCompartiProdServiceImpl.class);
    
    @Inject
    AlmacenaCompartiProdDAO almacenacompartiprodDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<AlmacenaCompartiProdDTO> listarAlmacenaCompartiProd(AlmacenaCompartiProdFilter filtro){
        List<AlmacenaCompartiProdDTO> retorno=null;
        try{
            retorno = almacenacompartiprodDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listar Almacenamiento Compartimiento Producto",ex);
        }
        return retorno;
    }
    
}
