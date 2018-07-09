/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.OrganismoAcreditadorDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.OrganismoAcreditadorFilter;

import java.util.List;

/**
 * @author jpiro
 */

public interface OrganismoAcreditadorService {
	
    public List<OrganismoAcreditadorDTO> listarOrganismoAcreditador(OrganismoAcreditadorFilter filtro);
}
