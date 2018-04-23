/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

/**
 *
 * @author DSR
 */
@SuppressWarnings("rawtypes")
public interface CrudDAO {
    EntityManager getEm();

	<T> T create(T t);

	<T> T find(Object id, Class<T> type);

	<T> T update(T t);
        
	void delete(Object t);
	void deleteAll( Object t );

	<T> T deleteCompuesto(Class<T> type, Object o);

	List findByNamedQuery(String queryName);

	List findByNamedQuery(String queryName, int resultLimit);

	List findByNamedQuery(String namedQueryName, Map<String, Object> parameters);

	List findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit);

	List findByNativeQuery(String nativeQuery, Map<String, Object> parameters);

	List<Object> findByNativeQuery(String nativeQuery,
			Map<String, Object> parameters, int resultLimit);

	Integer actualizarByNamedQuery(String namedQueryName,
			Map<String, Object> parameters);
	
	Long findSequence(String sequence);
	
	List findByNamedQuery(String namedQueryName, Map<String, Object> parameters, Integer startIndex, Integer resultsLimit, String sortFieldName, String sortType);
	
}
