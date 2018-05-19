/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;

import java.util.List;

/**
 * @author jpiro
 */

public interface EmpresaAcreditadaService {
    public List<EmpresaAcreditadaDTO> listarEmpAcred(EmpresaAcreditadaFilter filtro);
    public List<EmpresaAcreditadaDTO> listarEmpAcred2(EmpresaAcreditadaFilter filtro2);
    public EmpresaAcreditadaDTO RegistrarEmpresaAcreditada(EmpresaAcreditadaDTO EmpresaAcreditadaDTO,UsuarioDTO usuarioDTO);
    //public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO);
}
