/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.AlmacenaCompartiProdDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlmacenaCompartiProdFilter;
import gob.osinergmin.sibad.service.exception.AlmacenaCompartiProdException;
import java.util.List;

/**
 * @author jpiro
 */
public interface AlmacenaCompartiProdDAO {
	
    public List<AlmacenaCompartiProdDTO> find(AlmacenaCompartiProdFilter filtro) throws AlmacenaCompartiProdException;
}
