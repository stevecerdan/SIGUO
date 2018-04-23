package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.CamposDelDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDestinatarioDigedDTO;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface GenerarDocumentoSigedDAO{
	
	public Map obtenerCliente(String numIdentificacion);
	public List<UsuarioDestinatarioDigedDTO> buscar(String actividad);
	public TablaDetalleDTO buscarDatosSiged(String nombreCorto);
	public UsuarioDestinatarioDigedDTO consultarUsuario(CamposDelDocumentoDTO camposDTO);

}
