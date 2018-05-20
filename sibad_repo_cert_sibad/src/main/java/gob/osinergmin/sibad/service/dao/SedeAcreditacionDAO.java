/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SedeAcreditacionFilter;
import gob.osinergmin.sibad.service.exception.SedeAcreditacionException;

//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface SedeAcreditacionDAO {
    public List<SedeAcreditacionDTO> find(SedeAcreditacionFilter filtro) throws SedeAcreditacionException;
    public SedeAcreditacionDTO create(SedeAcreditacionDTO sedeAcreditacionDTO,UsuarioDTO usuarioDTO)throws SedeAcreditacionException;
    //public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException;
}
