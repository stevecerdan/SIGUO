/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SedeAcreditacionFilter;
//import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.SedeAcreditacionService;
import gob.osinergmin.sibad.service.dao.SedeAcreditacionDAO;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service("sedeacreditacionService")
public class SedeAcreditacionServiceImpl implements SedeAcreditacionService{
    private static final Logger LOG = LoggerFactory.getLogger(SedeAcreditacionServiceImpl.class);
    
    @Inject
    SedeAcreditacionDAO sedeacreditacionDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<SedeAcreditacionDTO> listarSedeAcreditacion (SedeAcreditacionFilter filtro){
        List<SedeAcreditacionDTO> retorno=null;
        try{
            retorno = sedeacreditacionDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en ListarSedeAcreditacion",ex);
        }
        return retorno;
    }

	@Override
	public SedeAcreditacionDTO RegistrarSedeAcreditacion(SedeAcreditacionDTO sedeAcreditacionDTO,UsuarioDTO usuarioDTO) {
		 
		LOG.info("Iniciando envio de datos de Sede Acreditacion al DAO");
			
		SedeAcreditacionDTO registro=null;
				
			try {
				
				registro = sedeacreditacionDAO.create(sedeAcreditacionDTO,usuarioDTO);
				LOG.info("(Se envio con exito los datos de Sede Acreditacion al DAO) registro: "+registro.getIdSedeAcreditacion());
				 
			} catch (Exception e) {
				
				LOG.error("error al enviar los datos de Sede Acreditacion al DAO",e);
			}
		
			return registro;
	}
    
   /* @Override
    @Transactional
    public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO){
        LOG.info("editarAutoayuda");
        AutoayudaDTO registro=null;
        try{
            registro=autoayudaDAO.update(autoayudaDTO,usuarioDTO);
            LOG.info("(Actualizar Base Legal ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("error editarAutoayuda",ex);
        }
        return registro;
    }*/
}
