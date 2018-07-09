/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SedeAcreditacionFilter;

//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface SedeAcreditacionService {
    public List<SedeAcreditacionDTO> listarSedeAcreditacion (SedeAcreditacionFilter filtro);
    public SedeAcreditacionDTO RegistrarSedeAcreditacion(SedeAcreditacionDTO sedeAcreditacionDTO,UsuarioDTO usuarioDTO);
    public SedeAcreditacionDTO EditarSedeAcreditacion(SedeAcreditacionDTO sedeAcreditacionDTO,UsuarioDTO usuarioDTO);
}
