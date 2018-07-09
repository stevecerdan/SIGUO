/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.TipoPruebaOrganismoDTO;
import gob.osinergmin.sibad.filter.TipoPruebaOrganismoFilter;
import gob.osinergmin.sibad.service.exception.TipoPruebaOrganismoException;

import java.util.List;

/**
 * @author jpiro
 */
public interface TipoPruebaOrganismoDAO {
	
    public List<TipoPruebaOrganismoDTO> find(TipoPruebaOrganismoFilter filtro) throws TipoPruebaOrganismoException;
}
