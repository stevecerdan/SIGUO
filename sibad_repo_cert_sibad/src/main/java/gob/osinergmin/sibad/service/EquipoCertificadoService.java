/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.EquipoCertificadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EquipoCertificadoFilter;
import gob.osinergmin.sibad.service.exception.EquipoCertificadoException;

import java.util.List;

/**
 * @author jpiro
 */

public interface EquipoCertificadoService {
    public List<EquipoCertificadoDTO> listarEquipoCertificado(EquipoCertificadoFilter filtro);
    public EquipoCertificadoDTO registrarEquipoCertificado(EquipoCertificadoDTO equipoCertificadoDTO, UsuarioDTO usuarioDTO);
    public EquipoCertificadoDTO updateEquipoCertificado(EquipoCertificadoDTO equipoCertificadoDTO, UsuarioDTO usuarioDTO);
    public EquipoCertificadoDTO eliminarEquipoCertificado(EquipoCertificadoDTO equipoCertificadoDTO) throws EquipoCertificadoException;
    //public SedePersonalAutorizadoDTO RegistrarSedePersonalAutorizado(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO,UsuarioDTO usuarioDTO);
    //public SedePersonalAutorizadoDTO eliminarPersonal(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO) throws SedePersonalAutorizadoException;
		
}
