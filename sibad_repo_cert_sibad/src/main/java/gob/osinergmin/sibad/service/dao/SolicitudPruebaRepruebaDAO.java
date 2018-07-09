/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
//import gob.osinergmin.sibad.domain.dto.BaseLegalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;
import gob.osinergmin.sibad.service.exception.SolicitudPruebaRepruebaException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface SolicitudPruebaRepruebaDAO {
	
    public List<SolicitudPruebaRepruebaDTO> find(SolicitudPruebaRepruebaFilter filtro) throws SolicitudPruebaRepruebaException;
    public SolicitudPruebaRepruebaDTO create(SolicitudPruebaRepruebaDTO solicitudPruebaRepruebaDTO,UsuarioDTO usuarioDTO) throws SolicitudPruebaRepruebaException;
    public SolicitudPruebaRepruebaDTO update(SolicitudPruebaRepruebaDTO SolicitudPruebaRepruebaDTO,UsuarioDTO usuarioDTO) throws SolicitudPruebaRepruebaException;
}
