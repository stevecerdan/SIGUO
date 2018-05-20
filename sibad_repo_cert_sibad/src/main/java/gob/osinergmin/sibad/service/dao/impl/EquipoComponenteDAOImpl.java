/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghEquipoComponente;
import gob.osinergmin.sibad.domain.builder.EquipoComponenteBuilder;
import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.EquipoComponenteFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.EquipoComponenteDAO;
import gob.osinergmin.sibad.service.exception.EquipoComponenteException;

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
//@Service("empacredDAO")
@Repository("EquipoComponenteDAO")
@Transactional
public class EquipoComponenteDAOImpl implements EquipoComponenteDAO {
    private static final Logger LOG = LoggerFactory.getLogger(EquipoComponenteDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<EquipoComponenteDTO> find(EquipoComponenteFilter filtro) throws EquipoComponenteException {
        List<EquipoComponenteDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = EquipoComponenteBuilder.toListEquipoComponenteDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(EquipoComponenteFilter filtro) {
        Query query=null;
        try{
        	
        	if(filtro.getIdEquipoComponente()!=null){
            	query = crud.getEm().createNamedQuery("PghEquipoComponenteV.findByComponente");  
        	}else {
        		query = crud.getEm().createNamedQuery("PghEquipoComponenteV.findByFilterC");
            }
            
            if(filtro.getIdEquipoComponente()==null){
            	
                if(filtro.getIdEquipoCertificado()!=null){
                    query.setParameter("idEquipoCertificado",filtro.getIdEquipoCertificado());
                }else{
                    query.setParameter("idEquipoCertificado","");
                }
                
            }else{
                query.setParameter("idEquipoComponente",filtro.getIdEquipoComponente());
            }
            
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

	@Override
	public EquipoComponenteDTO eliminar(EquipoComponenteDTO equipoComponenteDTO) throws EquipoComponenteException {
		LOG.info("changeState PersonalAutorizado DAO Impl");
		EquipoComponenteDTO retorno = null;
		
		try {
			LOG.info("ingreso al try catch- ID = "+ equipoComponenteDTO.getIdEquipoComponente());
			PghEquipoComponente registro = crud.find(equipoComponenteDTO.getIdEquipoComponente(), PghEquipoComponente.class);
			LOG.info("encuentra registro = "+ registro.getIdEquipoComponente());
			crud.delete(registro);
			retorno = EquipoComponenteBuilder.toEquipoComponenteDTO(registro);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return retorno;
	}

	@Override
	public EquipoComponenteDTO create(EquipoComponenteDTO equipoComponenteDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Iniciando registro de EquipoComponente");
		EquipoComponenteDTO retorno = null;
		
		try {
			PghEquipoComponente pghEquipoComponente = new PghEquipoComponente();
			
			pghEquipoComponente.setIdEquipoComponente(equipoComponenteDTO.getIdEquipoComponente());
			pghEquipoComponente.setIdEquipoCertificado(equipoComponenteDTO.getIdEquipoCertificado());
			pghEquipoComponente.setIdEquipoTanque(equipoComponenteDTO.getIdComponenteTanque());
			pghEquipoComponente.setDatosAuditoria(usuarioDTO);
			
			LOG.info("DATOS DAO IMPL: " + pghEquipoComponente.getIdEquipoComponente() + " - " + pghEquipoComponente.getIdEquipoCertificado() + " - " + pghEquipoComponente.getIdEquipoTanque());
			crud.create(pghEquipoComponente);
			LOG.info("DATOS DAO IMPL-CREATE: " + pghEquipoComponente.getIdEquipoComponente() + " - " + pghEquipoComponente.getIdEquipoCertificado() + " - " + pghEquipoComponente.getIdEquipoTanque());
			
			retorno = EquipoComponenteBuilder.toEquipoComponenteDTO(pghEquipoComponente);
			LOG.info("(Operacion exitosa) retorno: "+retorno.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return retorno;
	}
}
