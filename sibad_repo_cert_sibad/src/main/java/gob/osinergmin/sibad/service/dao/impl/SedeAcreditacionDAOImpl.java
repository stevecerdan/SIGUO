/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghSedeAcreditacion;
import gob.osinergmin.sibad.domain.builder.SedeAcreditacionBuilder;
import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SedeAcreditacionFilter;
import gob.osinergmin.sibad.service.dao.SedeAcreditacionDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.SedeAcreditacionException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
//@Service("sedeacreditacionDAO")
@Repository("SedeAcreditacionDAO")
@Transactional
public class SedeAcreditacionDAOImpl implements SedeAcreditacionDAO {
    private static final Logger LOG = LoggerFactory.getLogger(SedeAcreditacionDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<SedeAcreditacionDTO> find(SedeAcreditacionFilter filtro) throws SedeAcreditacionException {
        List<SedeAcreditacionDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = SedeAcreditacionBuilder.toListSedeAcreditacionDto(query.getResultList());

        return listado;
    }
    
    /*@Override
    public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException{
        AutoayudaDTO retorno = null;
        try{
            PghAutoayuda registroDAO = AutoayudaBuilder.getAutoayuda(autoayudaDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=AutoayudaBuilder.toAutoayudaDto(registroDAO);
        }catch(Exception e){
            LOG.error("Error al editar Requisito",e);
            AutoayudaException e2 = new AutoayudaException("Error al editar Requisito",e);
            throw e2;
        }
        return retorno;
    }*/
    
    private Query getFindQuery(SedeAcreditacionFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdSedeAcreditacion()!=null){
                query = crud.getEm().createNamedQuery("PghSedeAcreditacionV.findByIdSede");
            }else{
                query = crud.getEm().createNamedQuery("PghSedeAcreditacionV.findByFilter");
            }
            
            if(filtro.getIdSedeAcreditacion()==null){
            	/*if(filtro.getIdAlcanceAcreditacion()!=null){
                    query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
                }else{
                    query.setParameter("idAlcanceAcreditacion","");
                }
                if(filtro.getEstado()!=null && !filtro.getEstado().equals("")){
                    query.setParameter("estado","%"+filtro.getEstado().toUpperCase()+"%");
                }else{
                    query.setParameter("estado","%");
                }*/
            	if(filtro.getIdAlcanceAcreditacion()!=null && filtro.getEstado()!=null){
                    query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
                    query.setParameter("estado",filtro.getEstado());
                }else{
                    query.setParameter("idAlcanceAcreditacion","");
                    query.setParameter("estado","");
                }
            }else{
                query.setParameter("idSedeAcreditacion",filtro.getIdSedeAcreditacion());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

	@Override
	public SedeAcreditacionDTO create(SedeAcreditacionDTO sedeAcreditacionDTO, UsuarioDTO usuarioDTO)throws SedeAcreditacionException {
		
		LOG.info("Iniciando registro de Sede Acreditacion");
				
		SedeAcreditacionDTO retorno = null;
		
		try {
			
			PghSedeAcreditacion pghSedeAcreditacion = new PghSedeAcreditacion();
			
			pghSedeAcreditacion.setIdSedeAcreditacion(sedeAcreditacionDTO.getIdSedeAcreditacion());
			pghSedeAcreditacion.setIdAlcanceAcreditacion(sedeAcreditacionDTO.getIdAlcanceAcreditacion());
			pghSedeAcreditacion.setIdDepartamento(sedeAcreditacionDTO.getIdDepartamento());
			pghSedeAcreditacion.setIdProvincia(sedeAcreditacionDTO.getIdProvincia());
			pghSedeAcreditacion.setIdDistrito(sedeAcreditacionDTO.getIdDistrito());
			pghSedeAcreditacion.setDireccion(sedeAcreditacionDTO.getDireccion());
			pghSedeAcreditacion.setEstado(sedeAcreditacionDTO.getEstado());
			pghSedeAcreditacion.setDatosAuditoria(usuarioDTO);
			
            LOG.info(" Datos:"+pghSedeAcreditacion.getIdSedeAcreditacion()+" - " +pghSedeAcreditacion.getIdAlcanceAcreditacion()+" - " +pghSedeAcreditacion.getIdDepartamento()+" - " +pghSedeAcreditacion.getIdProvincia()+" - " +pghSedeAcreditacion.getIdDistrito()+" - " +pghSedeAcreditacion.getDireccion()+" - " +pghSedeAcreditacion.getEstado());
			
			crud.create(pghSedeAcreditacion);
			
			retorno = SedeAcreditacionBuilder.toSedeAcredDto(pghSedeAcreditacion);
			 
			LOG.info("(IdPJ) retorno: "+retorno.getIdSedeAcreditacion());
			
		}catch(Exception ex){
            
			LOG.error("",ex);
        }
		
		
		return retorno;
	}
}










