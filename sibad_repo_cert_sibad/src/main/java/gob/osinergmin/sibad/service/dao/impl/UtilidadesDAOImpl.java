/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.SibadDpndncia;
import gob.osinergmin.sibad.domain.builder.DependenciaBuilder;
import gob.osinergmin.sibad.domain.builder.UnidadOperativaBuilder;
import gob.osinergmin.sibad.domain.dto.DependenciaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadOperativaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.UtilidadesDAO;
import gob.osinergmin.sibad.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DSR
 */
@Repository("UtilidadesSFHDAO")
@SuppressWarnings("rawtypes")
public class UtilidadesDAOImpl implements UtilidadesDAO{
    
    private static final Logger LOG = LoggerFactory.getLogger(UtilidadesDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    
    @Override
    public UnidadOperativaDTO obtenerUnidadOperativa(String usuario) {
        LOG.info("procesando UtilidadesSFHDAO/obtenerUnidadOperativa");
        UnidadOperativaDTO unidadOperativaDTO = new UnidadOperativaDTO();
        try {
        	String sql ="SELECT DISTINCT SUO.CODIGO_OSINERG, " +  
			        	"SUO.ID, " +
			        	"SUO.NMBRE_UNDAD, " +   
			        	"NVL(SUO.RUC,'') RUC, " +  
			        	"SUO.DIRECCION DIRECCION, " + 
			        	"NVL(SUO.TELEFONO,'') TELEFONO, " +
			        	"NVL(SUO.EMAIL,'') CORREO, " +
			        	"SA.CODIGO, " +
			        	"SA.DESCRIPCION, " + 
			        	"(SELECT L.IDLUGAR FROM LUGARES L WHERE L.IDLUGAR = NVL(SUO.UBIGEO_ID,0)) AS IDDISTRITO, " + 
			        	"(SELECT L.IDLUGAR FROM LUGARES L WHERE L.IDLUGAR = (SELECT L1.LUGAR_SUP FROM LUGARES L1 WHERE L1.IDLUGAR = NVL(SUO.UBIGEO_ID,0))) AS IDPROVINCIA, " +  
			        	"(SELECT L.IDLUGAR FROM LUGARES L WHERE L.IDLUGAR = (SELECT L1.LUGAR_SUP FROM LUGARES L1 WHERE L1.IDLUGAR = (SELECT L2.LUGAR_SUP FROM LUGARES L2 WHERE L2.IDLUGAR = NVL(SUO.UBIGEO_ID,0)))) AS IDDEPARTAMENTO, " +
			        	"SD.ID IDDEPENDENCIA, " +
			        	"SD.NMBRE DEPENDENCIA, " +
			        	"sfh20900(suo.UBIGEO_ID,3) DEPARTAMENTO, " +
			        	"sfh20900(suo.UBIGEO_ID,2) PROVINCIA, " +
			        	"sfh20900(suo.UBIGEO_ID,1) DISTRITO " +
			        	"FROM SEG_USUARIO SEG " +
			        	"    JOIN USUA_UNOP_UUO UUO ON SEG.CODIGO = UUO.UUO_USUAID " + 
			        	"    JOIN SFH_UNDDES_OPRTVAS SUO ON UUO.UNIOPE_ID = SUO.ID " +
			        	"    JOIN SFH_UNDDES_ACTVDDES SUA ON SUO.ID = SUA.UNIOPE_ID AND SUA.ESTADO = 'HA' " +     
			        	"    JOIN SFH_ACTVDDES SA ON SUA.ACTIVI_ID = SA.ID " +
			        	"    JOIN SIBAD_ACTIVI_DPNDNCIA SAD ON SA.CODIGO = SAD.CDO_ACTVDAD " +
			        	"    JOIN SIBAD_DPNDNCIAS SD ON SAD.DPNDNCIA_ID = SD.ID " +
			        	"WHERE " +
			        	"    SEG.LOGIN = :LOGIN " +
			        	"	 AND ROWNUM = 1";
            Query query = this.crud.getEm().createNativeQuery(sql);
            query.setParameter("LOGIN", usuario.toUpperCase());
            Object[] unidadOperativa = (Object[])query.getSingleResult();            
            unidadOperativaDTO = UnidadOperativaBuilder.obtenerUnidadOperativa(unidadOperativa);
            System.out.println("código osinergmin: " + unidadOperativaDTO.getCodigoOsinergmin());
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
        return unidadOperativaDTO;
    }
    
    
    
    @Override
    public UsuarioDTO getUsuario(String usuario) {
        UsuarioDTO resultado = new UsuarioDTO();
        try {
            String sql = "SELECT TO_CHAR(SU.LOGIN), SU.NOMBRE, UO.UUO_TIPUSU " +
						 "FROM SEG_USUARIO SU " +
						 "JOIN USUA_UNOP_UUO UO ON SU.CODIGO = UO.UUO_USUAID " +
						 "WHERE " +
                         "   UPPER(SU.LOGIN) = :LOGIN";
            Query query = this.crud.getEm().createNativeQuery(sql);
            query.setParameter("LOGIN", usuario.toUpperCase());
			Object[] user = (Object[])query.getSingleResult();
			resultado.setLogin(user[0].toString());
        	resultado.setNombre(user[1].toString());
        	resultado.setTipo(user[2].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    public String existeUsuario(String usuario) {
        String resultado = "";
        try {
            String sql = "SELECT TO_CHAR(SU.LOGIN) " +
						 "FROM SEG_USUARIO SU " +
						 "JOIN USUA_UNOP_UUO UO ON SU.CODIGO = UO.UUO_USUAID " +
						 "WHERE " +
                         "   UPPER(SU.LOGIN) = :LOGIN";
            Query query = this.crud.getEm().createNativeQuery(sql);
            query.setParameter("LOGIN", usuario.toUpperCase());
			List resultados = query.getResultList();
            if(resultados.size()>0){
            	resultado = (String)resultados.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - UtilidadesDAO/existeUsuario ==>" + e.getMessage());
        }
        return resultado;
    }
    
    @Override
    public String validarPrivilegiosUsuario(String usuario,String pagina) {
        String resultado = "";
        try {
                      
            String sql = " SELECT DISTINCT P.CODIGO "+
                         " FROM SEG_PRIVXROLXPAG PRI, "+
			             " SEG_PRIVILEGIO P, "+
			             " SEG_ROL R    "+
			             " WHERE 1 = 1 "+
			             " AND R.ESTADO       = 'A' "+
			             " AND PRI.ROL        = R.CODIGO "+
			             " AND PRI.PRIVILEGIO = P.CODIGO "+
			             " AND PRI.PAGINA     = ( SELECT DISTINCT CODIGO "+ 
			             "                       FROM SEG_PAGINA PG  "+
			             "                       WHERE PG.ESTADO = 'A'  "+
			             "                       AND PG.ALIAS     = '"+pagina+"' ) "+
			             " AND PRI.ROL     IN (SELECT DISTINCT UR.ROL "+
			             "                       FROM SEG_USUARIO SU,  "+
			             "                           USUA_UNOP_UUO UO, "+
			             "                           seg_usuxrol   UR "+
			             "                      WHERE SU.CODIGO  = UO.UUO_USUAID "+ 
			             "                      AND SU.CODIGO    = UR.USUARIO "+
			             "                      AND UPPER(SU.LOGIN) = '"+usuario.toUpperCase()+"') ";  
            
            Query query = this.crud.getEm().createNativeQuery(sql);            
			List resultados = query.getResultList();
            if(resultados.size()>0){
            	resultado = String.valueOf(resultados.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - UtilidadesDAO/validarPrivilegiosUsuario ==>" + e.getMessage());
        }
        return resultado;
    }
    
    @Override
    public List<DependenciaDTO> obtenerDependencias(String codigoActividad) {        
        List<DependenciaDTO> listaDependenciaDTO = new ArrayList<DependenciaDTO>();
        try {
        	
        	StringBuilder jpql = new StringBuilder();
    		jpql.append(" select DISTINCT l from SibadDpndncia l, SibadActiviDpndncia a  where l.id = a.dpndnciaId ");
    		jpql.append(" and l.estdo = 1  and a.estdo = 1 ");
    		
    		if (!StringUtil.isEmpty(codigoActividad)){
    		    jpql.append(" AND a.cdoActvdad = :pcodigoActividad ");
    		}
    		
    		jpql.append(" order by l.nmbre DESC");
    		
            Query query = this.crud.getEm().createQuery(jpql.toString());
            if (!StringUtil.isEmpty(codigoActividad)){
    			query.setParameter("pcodigoActividad", codigoActividad);
    		}
            
            List<SibadDpndncia> listaDependencias = query.getResultList();
            listaDependenciaDTO = DependenciaBuilder.obtenerListaDependenciaDTO(listaDependencias);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - UtilidadesDAO/DependenciaDTO ==>" + e.getMessage());
        }
        return listaDependenciaDTO;
    }
           	
    @Override
    public UnidadOperativaDTO obtenerUnidadOperativaByCodigoOsinerg(String codigoOsinerg) {
        LOG.info("procesando UtilidadesSFHDAO/obtenerUnidadOperativaByCodigoOsinerg");
        UnidadOperativaDTO unidadOperativaDTO = new UnidadOperativaDTO();
        try {
            String sql = "SELECT DISTINCT SUO.CODIGO_OSINERG, " +
                        " SUO.ID, " +
                        " SUO.NMBRE_UNDAD, " +
                        " SUO.RUC, " +
                        " SUO.DIRECCION DIRECCION, " +
                        " NVL(SUO.TELEFONO,'') TELEFONO, " +
                        " NVL(SUO.EMAIL,'') CORREO, " +
                        " SA.CODIGO, " +
                        " SA.DESCRIPCION, " +
                        "  (SELECT L.IDLUGAR FROM LUGARES L WHERE L.IDLUGAR = NVL(SUO.UBIGEO_ID,0)) AS IDDISTRITO, " +
                        "  (SELECT L.IDLUGAR FROM LUGARES L WHERE L.IDLUGAR = (SELECT L1.LUGAR_SUP FROM LUGARES L1 WHERE L1.IDLUGAR = NVL(SUO.UBIGEO_ID,0))) AS IDPROVINCIA, " +
                        "  (SELECT L.IDLUGAR FROM LUGARES L WHERE L.IDLUGAR = (SELECT L1.LUGAR_SUP FROM LUGARES L1 WHERE L1.IDLUGAR = (SELECT L2.LUGAR_SUP FROM LUGARES L2 WHERE L2.IDLUGAR = NVL(SUO.UBIGEO_ID,0)))) AS IDDEPARTAMENTO, " +
                        " SD.ID IDDEPENDENCIA, " +
                    	" SD.NMBRE DEPENDENCIA, " +
                    	" sfh20900(suo.UBIGEO_ID,3) DEPARTAMENTO, " +
                    	" sfh20900(suo.UBIGEO_ID,2) PROVINCIA, " +
                    	" sfh20900(suo.UBIGEO_ID,1) DISTRITO " +
                        "  FROM SFH_UNDDES_ACTVDDES SUA, " +
                        "       SFH_ACTVDDES SA, " +
                        "       SFH_UNDDES_OPRTVAS SUO, " +
                        "       SFH_CDGOS_DGH DGH, " +
                        "       USUA_UNOP_UUO UUO, " +
                        "       SEG_USUARIO SEG," +
                        "       SIBAD_ACTIVI_DPNDNCIA SAD," +
                        "       SIBAD_DPNDNCIAS SD   " +
                        " WHERE SUA.ACTIVI_ID = SA.ID   " +
                        "   AND SUA.UNIOPE_ID = SUO.ID " +
                        "   AND SUA.ID = DGH.UNIACT_ID " +
                        "   AND SUA.ESTADO = 'HA' " +
                        "   AND DGH.ESTADO = 'RV' " +
                        "   AND seg.codigo = uuo.uuo_usuaid " +
                        "   AND suo.ID = uuo.uniope_id " +
                        "   AND SA.CODIGO = SAD.CDO_ACTVDAD " +
                        "   AND SAD.DPNDNCIA_ID = SD.ID " +
                        "   AND SUO.CODIGO_OSINERG = '"+codigoOsinerg+"'" +
                        "   AND ROWNUM = 1 ";
            Query query = this.crud.getEm().createNativeQuery(sql);
            Object[] unidadOperativa = (Object[])query.getSingleResult();
            unidadOperativaDTO = UnidadOperativaBuilder.obtenerUnidadOperativa(unidadOperativa);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - UtilidadesDAO/obtenerUnidadOperativa ==>" + e.getMessage());
        }
        return unidadOperativaDTO;
    }
    
    @Override
    public String getKey() {
        String resultado = "";
        try {
            String sql = "SELECT DES_COLUMNA " + 
						 "FROM MAESTRO_COLUMNA " +
						 "WHERE COD_TABLA='PVO_ENCRIPTAR_DATOS'" + 
						 "   AND COD_COLUMNA='KEY'";
            Query query = this.crud.getEm().createNativeQuery(sql);            
			List resultados = query.getResultList();
            if(resultados.size()>0){
            	resultado = (String)resultados.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - UtilidadesDAO/getKey ==>" + e.getMessage());
        }
        return resultado;
    }
    
    @Override
    public String encryptedParameters(String codApp) {
        String resultado = "N";
        try {
            String sql = "SELECT NVL(ENCRPTA_PRMTROS,'N') FROM SEG_APLICACION " + 
                     	 "WHERE CODIGO = :COD_APP";
            Query query = this.crud.getEm().createNativeQuery(sql);
            query.setParameter("COD_APP", Long.parseLong(codApp));
			List resultados = query.getResultList();
            if(resultados.size()>0){
            	resultado = (String)resultados.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - UtilidadesDAO/encryptedParameters ==>" + e.getMessage());
        }
        return resultado;
    }
    
    @Override
    public List<String> obtenerCodigosOsinergminPermitidosUsuario(String loginUsuario) {
        List<String> codigosOsinergminPermitidos = null;
        try {
            String sql = "SELECT UO.CODIGO_OSINERG " +
            			 "FROM SEG_USUXUNIOPE UU " +
            			 "INNER JOIN SEG_USUARIO U ON U.CODIGO = UU.USUARIO " +
            			 "INNER JOIN SFH_UNDDES_OPRTVAS UO ON UO.ID = UU.UNIOPE_ID " +
            			 "WHERE U.LOGIN = :loginUsuario " +
            			 "AND U.ESTADO = 'A' " +
            			 "AND UO.CODIGO_OSINERG IS NOT NULL";
            Query query = this.crud.getEm().createNativeQuery(sql);
            query.setParameter("loginUsuario", loginUsuario);
            List<String> resultados = query.getResultList();
            if(resultados != null && resultados.size() > 0){
            	codigosOsinergminPermitidos = new ArrayList<String>();
            	for(String resultado : resultados){
            		codigosOsinergminPermitidos.add(resultado);
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR - UtilidadesDAO/obtenerCodigosOsinergminPermitidosUsuario ==>" + e.getMessage());
        }
        return codigosOsinergminPermitidos;
    }

}
