/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.UbigeodpdDTO;
import gob.osinergmin.sibad.filter.UbigeoDPDFilter;
import gob.osinergmin.sibad.service.exception.UbigeoDPDException;

//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface UbigeodpdDAO {
    public List<UbigeodpdDTO> find(UbigeoDPDFilter filtro) throws UbigeoDPDException;
    //public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException;
}
