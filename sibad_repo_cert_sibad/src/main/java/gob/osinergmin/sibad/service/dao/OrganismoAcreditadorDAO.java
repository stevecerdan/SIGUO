/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.OrganismoAcreditadorDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.OrganismoAcreditadorFilter;
import gob.osinergmin.sibad.service.exception.OrganismoAcreditadorException;
import java.util.List;

/**
 * @author jpiro
 */
public interface OrganismoAcreditadorDAO {
    public List<OrganismoAcreditadorDTO> find(OrganismoAcreditadorFilter filtro) throws OrganismoAcreditadorException;
}
