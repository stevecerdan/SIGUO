/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.TipoPruebaOrganismoDTO;
import gob.osinergmin.sibad.filter.TipoPruebaOrganismoFilter;

import java.util.List;

/**
 * @author jpiro
 */
public interface TipoPruebaOrganismoService {
	
    public List<TipoPruebaOrganismoDTO> listarTipoPruebaOrganismo (TipoPruebaOrganismoFilter filtro);
}
