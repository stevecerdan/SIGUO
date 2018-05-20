/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.EquipoCertificadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EquipoCertificadoFilter;
import gob.osinergmin.sibad.service.exception.EquipoCertificadoException;
import gob.osinergmin.sibad.service.exception.EquipoComponenteException;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface EquipoCertificadoDAO {
    public List<EquipoCertificadoDTO> find(EquipoCertificadoFilter filtro) throws EquipoCertificadoException;
    //public SedePersonalAutorizadoDTO create(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO,UsuarioDTO usuarioDTO)throws SedePersonalAutorizadoException;
	 public EquipoCertificadoDTO create(EquipoCertificadoDTO equipocertificadoDTO, UsuarioDTO usuarioDTO);
	 public EquipoCertificadoDTO updateEstado(EquipoCertificadoDTO equipocertificadoDTO, UsuarioDTO usuarioDTO);
	public EquipoCertificadoDTO eliminar(EquipoCertificadoDTO equipoCertificadoDTO) throws EquipoCertificadoException;

    //public SedePersonalAutorizadoDTO create(SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO,UsuarioDTO usuarioDTO) throws SedePersonalAutorizadoException;
}
