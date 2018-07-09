/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.TipoEquipoDTO;
import gob.osinergmin.sibad.filter.TipoEquipoFilter;
import gob.osinergmin.sibad.service.exception.TipoEquipoException;

//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import java.util.List;

/*
 * @author jpiro
 */

public interface TipoEquipoDAO {
	
    public List<TipoEquipoDTO> find(TipoEquipoFilter filtro) throws TipoEquipoException;
    
}
