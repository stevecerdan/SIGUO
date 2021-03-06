/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
//import gob.osinergmin.sibad.domain.dto.BaseLegalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.service.exception.EmpresaAcreditadaException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface EmpresaAcreditadaDAO {
    public List<EmpresaAcreditadaDTO> find(EmpresaAcreditadaFilter filtro) throws EmpresaAcreditadaException;
    public List<EmpresaAcreditadaDTO> find2(EmpresaAcreditadaFilter filtro2) throws EmpresaAcreditadaException;
    public EmpresaAcreditadaDTO create(EmpresaAcreditadaDTO empresaAcreditadaDTO,UsuarioDTO usuarioDTO) throws EmpresaAcreditadaException;
    public EmpresaAcreditadaDTO update(EmpresaAcreditadaDTO empresaAcreditadaDTO,UsuarioDTO usuarioDTO) throws EmpresaAcreditadaException;
}
