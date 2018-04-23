/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface AlcanceAcreditacionService {
    public List<AlcanceAcreditacionDTO> listarAlcanceAcreditacion(AlcanceAcreditacionFilter filtro);
    //public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO);
}
