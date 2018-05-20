/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.service.exception.MaestroColumnaTipoException;

//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface MaestroColumnaTipoDAO {
    public List<MaestroColumnaTipoDTO> find(MaestroColumnaTipoFilter filtro) throws MaestroColumnaTipoException;
    //public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException;
}
