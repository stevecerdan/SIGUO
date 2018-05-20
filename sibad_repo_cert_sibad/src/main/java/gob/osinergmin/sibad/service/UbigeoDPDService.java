/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.UbigeodpdDTO;
import gob.osinergmin.sibad.filter.UbigeoDPDFilter;

//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import java.util.List;


public interface UbigeoDPDService {
    public List<UbigeodpdDTO> listarUbigeoDPD (UbigeoDPDFilter filtro);
    //public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO);
}
