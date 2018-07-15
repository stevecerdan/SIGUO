/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.CorreoDTO;
import gob.osinergmin.sibad.filter.DestinatarioCorreoFilter;
import java.util.List;

/**
 * @author jpiro
 */
public interface CorreoService {
	
    public List<CorreoDTO> listarCorreo (DestinatarioCorreoFilter filtro);
    
}
