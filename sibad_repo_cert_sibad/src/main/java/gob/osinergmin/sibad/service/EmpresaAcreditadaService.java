/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface EmpresaAcreditadaService {
    public List<EmpresaAcreditadaDTO> listarEmpAcred(EmpresaAcreditadaFilter filtro);
    //public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO);
}
