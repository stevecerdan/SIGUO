/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface MaestroColumnaTipoService {
    public List<MaestroColumnaTipoDTO> listarMaestroColumnaTipo (MaestroColumnaTipoFilter filtro);
    //public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO);
}
