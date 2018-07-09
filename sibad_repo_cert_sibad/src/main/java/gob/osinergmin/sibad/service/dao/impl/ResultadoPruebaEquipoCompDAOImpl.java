package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghResultadoPruebaEquipoComp;
import gob.osinergmin.sibad.domain.builder.ResultadoPruebaEquipoCompBuilder;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaEquipoCompDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPruebaEquipoCompFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ResultadoPruebaEquipoCompDAO;

@Repository("ResultadoPruebaEquipoCompDAO")
@Transactional
public class ResultadoPruebaEquipoCompDAOImpl implements ResultadoPruebaEquipoCompDAO{
 private static final Logger LOG = LoggerFactory.getLogger(ResultadoPruebaEquipoCompDAOImpl.class);
	 
	@Inject
	private CrudDAO crud;

	@Override
	public ResultadoPruebaEquipoCompDTO create(ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO, UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando registro de  Resultado ResultadoPruebaEquipoComp");
			
		 ResultadoPruebaEquipoCompDTO retorno=null;
			
			try{
				
				PghResultadoPruebaEquipoComp  pghResultadoPruebaEquipoComp =  new PghResultadoPruebaEquipoComp();
				
				pghResultadoPruebaEquipoComp.setIdEquipoComponente(resultadoPruebaEquipoCompDTO.getIdEquipoComponente());
				pghResultadoPruebaEquipoComp.setIdResultadoPruebaEquipoComp(resultadoPruebaEquipoCompDTO.getIdResultadoPruebaEquipoComp());
				pghResultadoPruebaEquipoComp.setIdResultadoPruebaReprueba(resultadoPruebaEquipoCompDTO.getIdResultadoPruebaReprueba());
				pghResultadoPruebaEquipoComp.setDatosAuditoria(usuarioDTO);
				
				crud. create(pghResultadoPruebaEquipoComp);
		    	
		   		    
			retorno = ResultadoPruebaEquipoCompBuilder.toPghResultadoPruebaEquipoComp(pghResultadoPruebaEquipoComp);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
		
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}
	
	@Override
	public ResultadoPruebaEquipoCompDTO delete(ResultadoPruebaEquipoCompDTO resultadoPruebaEquipoCompDTO,UsuarioDTO usuarioDTO) {
	
		ResultadoPruebaEquipoCompDTO retorno = null;
		
		try {
			
			PghResultadoPruebaEquipoComp registroDTO = crud.find(resultadoPruebaEquipoCompDTO.getIdResultadoPruebaEquipoComp(), PghResultadoPruebaEquipoComp.class);
						
			crud.delete(registroDTO);

			retorno = ResultadoPruebaEquipoCompBuilder.toPghResultadoPruebaEquipoComp(registroDTO);
		
		} catch (Exception ex) {
			 LOG.error("error eliminar = ",ex);
		}
		return retorno;
	} 
	 
	@Override
	public List<ResultadoPruebaEquipoCompDTO> find(ResultadoPruebaEquipoCompFilter filtro) {
		
		List<ResultadoPruebaEquipoCompDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = ResultadoPruebaEquipoCompBuilder.toListResultadoPruebaEquipoCompVDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(ResultadoPruebaEquipoCompFilter filtro) {
        
		Query query=null;
        
        try{
            if(filtro.getIdResultadoPruebaReprueba() !=null ){
            	LOG.info("IdResultadoPruebaReprueba:"+filtro.getIdResultadoPruebaReprueba());
            	query = crud.getEm().createNamedQuery("PghResultadoPruebaEquipoCompV.findByIdResultadoPRE");
            }

            if(filtro.getIdResultadoPruebaReprueba()!=null ){
            	LOG.info("IdResultadoPruebaReprueba:"+filtro.getIdResultadoPruebaReprueba());
                query.setParameter("idResultadoPruebaReprueba",filtro.getIdResultadoPruebaReprueba() );                	                    
            }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    } 

}
