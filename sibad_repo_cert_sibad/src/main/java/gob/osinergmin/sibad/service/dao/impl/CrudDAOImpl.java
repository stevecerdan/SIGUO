package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.service.dao.CrudDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Julio Piro
 */
@Repository("crudDAO")
public class CrudDAOImpl implements CrudDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CrudDAOImpl.class);
    @PersistenceContext(unitName = "gob.osinergmin.sibad:default")
    private EntityManager em;

    @Override
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public <T> T create(T t) {
        LOG.info("inserting " + t.getClass().getName());
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    @Override
    public <T> T find(Object id, Class<T> type) {
        LOG.info("finding " + type.getName() + " by id=" + id.toString());
        return (T) this.em.find(type, id);
    }

    @Override
    public void delete(Object t) {
        LOG.info("deleting " + t.getClass().getName());
//        Object ref = this.em.getReference(t.getClass(), t);
        this.em.remove(t);
    }

    @Transactional
    public void deleteAll(Object t) {
        LOG.info("deleting " + t.getClass().getName());
        this.em.remove(em.merge(t));
    }

    @Override
    public <T> T deleteCompuesto(Class<T> type, Object o) {
        LOG.info("deleting clave compuesta" + type.getClass().getName());
        Object ref = this.em.find(type, o);
        this.em.remove(ref);
        //this.em.flush();
        return null;
    }

    @Override
    public <T> T update(T t) {
        LOG.info("updating " + t.getClass().getName());
        return (T) this.em.merge(t);

    }

    @Override
    public List<Object> findByNamedQuery(String namedQueryName) {
        LOG.info("finding by named query :" + namedQueryName);
        return this.em.createNamedQuery(namedQueryName).getResultList();
    }

    @Override
    public List<Object> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters) {

        return findByNamedQuery(namedQueryName, parameters, 0);
    }

    @Override
    public List<Object> findByNamedQuery(String namedQueryName, int resultLimit) {
        LOG.info("finding by named query :" + namedQueryName);
        return this.em.createNamedQuery(namedQueryName).
                setMaxResults(resultLimit).
                getResultList();
    }

    @Override
    public List<Object> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, int resultLimit) {
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        LOG.info("finding by named query :" + namedQueryName);
        Query query = this.em.createNamedQuery(namedQueryName);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    @Override
    public List<Object> findByNativeQuery(String nativeQuery, Map<String, Object> parameters) {
        return findByNativeQuery(nativeQuery, parameters, 0);
    }

    @Override
    public List<Object> findByNativeQuery(String nativeQuery, Map<String, Object> parameters, int resultLimit) {
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        LOG.info("finding by natived query :" + nativeQuery);
        Query query = this.em.createNativeQuery(nativeQuery);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    @Override
    public Integer actualizarByNamedQuery(String namedQueryName,
            Map<String, Object> parameters) {
        Integer registrosActualizados = new Integer(0);
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        LOG.info("actualizando by named query :" + namedQueryName);
        Query query = this.em.createNamedQuery(namedQueryName);
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        registrosActualizados = query.executeUpdate();
        return registrosActualizados;
    }

    @Override
    public Long findSequence(String sequence) {
        Long resultado = new Long(0);
        BigDecimal consulta;
        Query query = this.em.createNativeQuery("select " + sequence + ".NEXTVAL from dual");
        consulta = (BigDecimal) query.getSingleResult();
        resultado = consulta.longValue();
        LOG.info("Seq: " + resultado);
        return resultado;

    }
    
    @Override
    public List<Object> findByNamedQuery(String namedQueryName, Map<String, Object> parameters, Integer startIndex, Integer resultsLimit, String sortFieldName, String sortType) {
    	LOG.info("finding by named query :" + namedQueryName);
        Session session = ((Session)em.getDelegate());
        //para colocar los criterios para mostrar en un determinado orden los resultados
        String stringQuery = session.getNamedQuery(namedQueryName).getQueryString();
        if(sortFieldName != null && !sortFieldName.equals("")){
        	stringQuery = stringQuery + " ORDER BY ";
        	if(sortType != null && !sortType.equals("")){
        		Pattern pattern = Pattern.compile(",");
        		String[] fields = pattern.split(sortFieldName);
        		for(int i=0; i<fields.length; i++){
        			stringQuery = stringQuery + fields[i].trim() + " " + sortType + ", ";
        		}
        		stringQuery = stringQuery.substring(0, stringQuery.length() - 2);
        	}else{
        		stringQuery = stringQuery + sortFieldName;
        	}
        }
        LOG.info("stringQuery :" + stringQuery);
        //para indicar el óndice del primer registro que se mostrar y el máximo de estos
        Query query = this.em.createQuery(stringQuery);
        if(startIndex != null && startIndex.intValue() >= 0){
        	query.setFirstResult(startIndex.intValue());
        }
        if(resultsLimit != null && resultsLimit.intValue() > 0){
            query.setMaxResults(resultsLimit.intValue());
        }
        //para colocar los parámetros de ejecución del query
        if(parameters != null){
	        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
	        for (Entry<String, Object> entry : rawParameters) {
	        	query.setParameter(entry.getKey(), entry.getValue());
	        }
        }
        return query.getResultList(); 
    }
    
}
