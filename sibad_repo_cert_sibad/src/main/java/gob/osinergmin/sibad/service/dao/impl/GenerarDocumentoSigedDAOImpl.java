package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.SibadDrvcionSged;
import gob.osinergmin.sibad.domain.dto.CamposDelDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDestinatarioDigedDTO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.GenerarDocumentoSigedDAO;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.StringUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("GenerarDocumentoSigedDAO")
@SuppressWarnings({"unchecked","rawtypes"})
public class GenerarDocumentoSigedDAOImpl implements GenerarDocumentoSigedDAO{
	
	private static final Logger LOG = LoggerFactory.getLogger(GenerarDocumentoSigedDAOImpl.class);
	
	@Inject
    private CrudDAO crud;

	@Override
	public Map obtenerCliente(String numIdentificacion) {
		LOG.debug("obtenerCliente - NrhvRegistroCertificadoServiceImpl");
		
		try{
			
			Query query = crud.getEm().createNativeQuery("select TIPOIDENTIFICACION, NROIDENTIFICACION, RAZONSOCIAL, DIRECCIONPRINCIPAL, UBIGEOPRINCIPAL, ESTADO from CLIENTE where nroidentificacion = :numIdentificacion");
			query.setParameter("numIdentificacion", numIdentificacion);
			Object[] objCliente = (Object[])query.getSingleResult();
			
			BigDecimal tipoIdentificacion = (BigDecimal)objCliente[0];
			String nroidentificacion = (String)objCliente[1];
			String razonsocial = (String)objCliente[2];
			String direccionprincipal = (String)objCliente[3];
			BigDecimal ubigeoprincipal = (BigDecimal)objCliente[4];
			Character estado = (Character)objCliente[5];
			
			Map mapCliente = new HashMap();
			mapCliente.put("tipoIdentificacion", new Integer(tipoIdentificacion.intValue()));
			mapCliente.put("nroidentificacion", nroidentificacion);
			mapCliente.put("razonsocial", razonsocial);
			mapCliente.put("direccionprincipal", direccionprincipal);
			mapCliente.put("ubigeoprincipal", new Integer(ubigeoprincipal.intValue()));
			mapCliente.put("estado", estado);
			
			return mapCliente;
			
		}catch(RuntimeException e){
			LOG.error("No se encontró dato en obtener cliente" + e.getMessage());		
			LOG.error(e.getMessage());
			return null;
		} catch (Exception e) {
			LOG.error("No se encontró dato en obtener cliente" + e.getMessage());
			LOG.error(e.getMessage());
			return null;
		}		
		
	}
	
	
    
	@Override
	public List<UsuarioDestinatarioDigedDTO> buscar(String actividad){
		 LOG.info("procesando UsuarioDestinatarioDigedDTO/ buscar");
		List<UsuarioDestinatarioDigedDTO> listDestinatarioDigedDTO=new ArrayList<UsuarioDestinatarioDigedDTO>();
		try {
			Query query = null;
			StringBuilder sbSelect=new StringBuilder();
			sbSelect.append(" SELECT MDF.CODIGO_ACTIVIDAD,MDF.USUARIO_PRINCIPAL, MDF.USUARIO_SECUNDARIO ");
            sbSelect.append(" FROM MEM_DRVCION_FRMT MDF  ");
            sbSelect.append(" where MDF.ESTADO=:codigo and MDF.CODIGO_ACTIVIDAD=:actividad ");
            
			
    		query = crud.getEm().createNativeQuery(sbSelect.toString());
			LOG.info("query buscar: " + sbSelect.toString());
			query.setParameter("codigo", Constantes.ESTADO_ACTIVO);
			query.setParameter("actividad", actividad);			
			List<Object []> lista = query.getResultList();
			 for ( int i = 0 ; i < lista.size() ; i++ ) {
				    Object [] objeto = ( Object [] ) lista.get(i);
				    UsuarioDestinatarioDigedDTO destinatarioDigedDTO=new UsuarioDestinatarioDigedDTO();
				    destinatarioDigedDTO.setCodigoActividad(StringUtil.nullToBlank(objeto[0]));
				    destinatarioDigedDTO.setUsuarioPrincipal(StringUtil.nullToBlank(objeto[1]));
				    destinatarioDigedDTO.setUsuarioSecundario(StringUtil.nullToBlank(objeto[2]));
				    
				    listDestinatarioDigedDTO.add(destinatarioDigedDTO);
	            }
			
		} catch (NoResultException e) {
			listDestinatarioDigedDTO = null;
		} catch (QuerySyntaxException es) {
			LOG.error("No existe sintaxis de error: " + es.getMessage());
		} catch (IllegalArgumentException e) {
			LOG.error("Ha ocurrido un error al obtener IllegalArgumentException: "
					+ e.getMessage());
		}
		
		return listDestinatarioDigedDTO;
	}
	
	
	
    @Override
    public UsuarioDestinatarioDigedDTO consultarUsuario(CamposDelDocumentoDTO formatoUnoDTO) {
        LOG.info("procesando UsuarioDestinatarioDigedDTO/consultarUsuario");
        UsuarioDestinatarioDigedDTO usuarioDestinatarioDigedDTO = new UsuarioDestinatarioDigedDTO();
       // List<UsuarioDestinatarioDigedDTO> listaUsuarioDestinatarioDigedDTO = new ArrayList<UsuarioDestinatarioDigedDTO>();
        try {
            
        	StringBuilder jpql = new StringBuilder();
    		jpql.append(" select cm from SibadDrvcionSged cm  where cm.idDpndncia =:dependencia ");
    		jpql.append(" and  cm.estdo = '1' ");
    		
    		if (formatoUnoDTO.getUbigeo()!=null){
    		    jpql.append(" AND cm.idUbigeo =:ubigeo ");
    		}
        	        
            Query query = this.crud.getEm().createQuery(jpql.toString());
            query.setParameter("dependencia", formatoUnoDTO.getIdDependencia());
            if (formatoUnoDTO.getUbigeo()!=null){
            	query.setParameter("ubigeo", formatoUnoDTO.getUbigeo());
    		}            
            List<SibadDrvcionSged> listaSibadDrvcionSged = query.getResultList(); 
            if(!listaSibadDrvcionSged.isEmpty()){
               SibadDrvcionSged sibadDrvcionSged = listaSibadDrvcionSged.get(0);
               usuarioDestinatarioDigedDTO = obtenerUsuarioDestinatarioDigedDTO(sibadDrvcionSged);
            }
        } catch (NoResultException e) {
        	usuarioDestinatarioDigedDTO = null;
        }catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - UsuarioDestinatarioDigedDTO/consultarUsuario ==>" + e.getMessage());
        }
        return usuarioDestinatarioDigedDTO;
    }
	
	
	
	@Override
	public TablaDetalleDTO buscarDatosSiged(String nombreCorto){
		 LOG.info("procesando TablaDetalleDTO/ buscarDatosSiged");
		 TablaDetalleDTO tablaDetalleDTO=null;
		try {
			Query query = null;
			StringBuilder sbSelect=new StringBuilder();
			sbSelect.append(" SELECT MTD.NOMBRE ,MTD.NOMBRE_CORTO ");
            sbSelect.append(" FROM SIBAD_TABLA_DETALLE MTD ");
            sbSelect.append(" WHERE MTD.CODIGO=:codigo AND MTD.NOMBRE_CORTO=:nombreCorto ");
            
			
    		query = crud.getEm().createNativeQuery(sbSelect.toString());
			LOG.info("query buscar: " + sbSelect.toString());
			query.setParameter("codigo", "SIGED");
			query.setParameter("nombreCorto", nombreCorto);
			List<Object []> lista = query.getResultList();
			 for ( int i = 0 ; i < lista.size() ; i++ ) {
				    Object [] objeto = ( Object [] ) lista.get(i);
				    tablaDetalleDTO=new TablaDetalleDTO();
				    tablaDetalleDTO.setNombreLargo(StringUtil.nullToBlank(objeto[0]));
				    tablaDetalleDTO.setNombreCorto(StringUtil.nullToBlank(objeto[1]));
	            }
			
		} catch (NoResultException e) {
			tablaDetalleDTO = null;
		} catch (QuerySyntaxException es) {
			LOG.error("No existe sintaxis de error: " + es.getMessage());
		} catch (IllegalArgumentException e) {
			LOG.error("Ha ocurrido un error al obtener IllegalArgumentException: "
					+ e.getMessage());
		}
		
		return tablaDetalleDTO;
	}
	
	
	
    public static UsuarioDestinatarioDigedDTO obtenerUsuarioDestinatarioDigedDTO(SibadDrvcionSged sibadDrvcionSged) {
    	UsuarioDestinatarioDigedDTO destinatarioDigedDTO = new UsuarioDestinatarioDigedDTO();
    	//destinatarioDigedDTO.setCodigoActividad("021");
    	destinatarioDigedDTO.setUsuarioPrincipal(Long.toString(sibadDrvcionSged.getUsrioDstno()));
    	//destinatarioDigedDTO.setUsuarioSecundario("1901");
        return destinatarioDigedDTO;
    }
	
	
	
}
