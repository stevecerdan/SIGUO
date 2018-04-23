package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.SibadNota;
import gob.osinergmin.sibad.domain.SibadSlctudEstdoCnta;
import gob.osinergmin.sibad.domain.builder.SibadNotaBuilder;
import gob.osinergmin.sibad.domain.builder.SolicitudEstadoCuentaBuilder;
import gob.osinergmin.sibad.domain.dto.SibadNotaDTO;
import gob.osinergmin.sibad.domain.dto.SolicitudEstadoCuentaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.SolicitudEstadoCuentaDAO;
import gob.osinergmin.sibad.service.exception.BaseException;

import java.util.Date;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("SolicitudEstadoCuentaDAO")
public class SolicitudEstadoCuentaDAOImpl implements SolicitudEstadoCuentaDAO{
	private static final Logger LOG = LoggerFactory.getLogger(SolicitudEstadoCuentaDAOImpl.class);
	@Inject
    private CrudDAO crud;
	
	
	@Override
	public SolicitudEstadoCuentaDTO guardar(SolicitudEstadoCuentaDTO solicitudDTO, UsuarioDTO usuario)
			throws BaseException {
		// TODO Auto-generated method stub
		SibadSlctudEstdoCnta solicitud =  new SibadSlctudEstdoCnta();		
		//solicitudDTO.setNumeroSolicitud(obtenerNroSolicitud());
		solicitud = SolicitudEstadoCuentaBuilder.obtenerSolicitudEECC(solicitudDTO,usuario);
		solicitud=crud.create(solicitud);
		solicitudDTO = SolicitudEstadoCuentaBuilder.obtenerSolicitudDTO(solicitud,solicitudDTO);
		return solicitudDTO;
	}
	
	@Override
	public Long obtenerNroSolicitud(){
		Long nroSolicitud = crud.findSequence("SIBAD_NRO_SLCTUD_SEQ");
		Date date = new java.util.Date();
		java.text.SimpleDateFormat sdfYear = new java.text.SimpleDateFormat("yyyy");
		String nroSolicitudStr = sdfYear.format(date) + Long.toString(nroSolicitud);		
		return Long.parseLong(nroSolicitudStr);
	}
	
	
	@Override
	public SolicitudEstadoCuentaDTO consultarReporte(Long idSolicitud) {	           
        LOG.info("procesando FormatoUnoDAO/consulconsultarReporte");	          

		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT scon ");
		jpql.append(" FROM SibadSlctudEstdoCnta scon ");
		jpql.append(" WHERE scon.nmroSlctud = ").append(idSolicitud);

		LOG.info("jpql = " + jpql.toString());
		Query query = crud.getEm().createQuery(jpql.toString());

		SibadSlctudEstdoCnta uno = (SibadSlctudEstdoCnta)query.getSingleResult();
    
		SolicitudEstadoCuentaDTO formatoUno = new SolicitudEstadoCuentaDTO();
		formatoUno = SolicitudEstadoCuentaBuilder.obtenerSolicitudDTO(uno, formatoUno);
		return formatoUno;
	}

	@Override
	public SolicitudEstadoCuentaDTO obtenerEstadoCuenta(SolicitudEstadoCuentaDTO solicitud){
		try {
			String sql ="SELECT DISTINCT NMBRE DEPENDENCIA, "+
						"	sfh20900('"+solicitud.getIdDistrito()+"',3) DEPARTAMENTO, "+
						"	sfh20900('"+solicitud.getIdDistrito()+"',2) PROVINCIA, "+
						"	sfh20900('"+solicitud.getIdDistrito()+"',1) DISTRITO "+
						"	FROM  SIBAD_DPNDNCIAS "+
						"	WHERE ID = "+solicitud.getDependenciaId() ;
			Query query = this.crud.getEm().createNativeQuery(sql);
			Object[] data = (Object[])query.getSingleResult();
			solicitud = SolicitudEstadoCuentaBuilder.obtenerSolicitudDTOInfadicional(data, solicitud);
          
		} catch (Exception e) {
			return null;
		}
		return solicitud;
	}
	  
	@Override
	public Long obtenerNotaId(){
		Long id=0L;
		try {
			String sql ="SELECT ID,ESTDO " + 
						"FROM SIBAD_NOTA " +
						"WHERE ESTDO='A' " +
						"	AND ROWNUM=1";
			Query query = this.crud.getEm().createNativeQuery(sql);
			Object[] data = (Object[])query.getSingleResult();
			id = Long.parseLong(data[0].toString());
          
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
		return id;
	}
	
	@Override
	public SibadNotaDTO obtenerNota(Long id) {	           
        	          

		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT scon ");
		jpql.append(" FROM SibadNota scon ");
		jpql.append(" WHERE scon.id = ").append(id);
		jpql.append(" AND scon.estdo = 'A' ");

		LOG.info("jpql = " + jpql.toString());
		Query query = crud.getEm().createQuery(jpql.toString());

		SibadNota nota = (SibadNota)query.getSingleResult();
    
		SibadNotaDTO notaObt = new SibadNotaDTO();
		notaObt = SibadNotaBuilder.obtenerSibadNotaDTO(nota, notaObt);
		return notaObt;
	}
}
