/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.service.exception.AlcanceAcreditacionException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface AlcanceAcreditacionDAO {
    public List<AlcanceAcreditacionDTO> find(AlcanceAcreditacionFilter filtro) throws AlcanceAcreditacionException;
    //public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException;
}
