/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.DestinatarioCorreoDTO;
import gob.osinergmin.sibad.filter.DestinatarioCorreoFilter;
import java.util.List;

/**
 * @author jpiro
 */
public interface DestinatarioCorreoService {
	
    public List<DestinatarioCorreoDTO> listarDestinatarioCorreo (DestinatarioCorreoFilter filtro);
    
}
