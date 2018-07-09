/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.AlmacenaCompartiProdDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlmacenaCompartiProdFilter;

import java.util.List;

/**
 * @author jpiro
 */

public interface AlmacenaCompartiProdService {
	
    public List<AlmacenaCompartiProdDTO> listarAlmacenaCompartiProd(AlmacenaCompartiProdFilter filtro);
}
