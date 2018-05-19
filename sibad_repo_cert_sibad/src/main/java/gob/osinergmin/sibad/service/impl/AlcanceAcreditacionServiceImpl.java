package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.service.AlcanceAcreditacionService;
import gob.osinergmin.sibad.service.dao.AlcanceAcreditacionDAO;

@Service("AlcanceAcreditacionService")
public class AlcanceAcreditacionServiceImpl implements AlcanceAcreditacionService {
	 private static final Logger LOG = LoggerFactory.getLogger(AlcanceAcreditacionServiceImpl.class);
	 
	@Inject
	AlcanceAcreditacionDAO alcanceAcreditacionDAO;

	@Override
    @Transactional(readOnly = true)
    public List<AlcanceAcreditacionDTO> listarDatosAlcance(AlcanceAcreditacionFilter filtro){
        List<AlcanceAcreditacionDTO> retorno=null;
        try{
            retorno = alcanceAcreditacionDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarAlcanceAcreditacion",ex);
        }
        return retorno;
    }
	
	@Override
	public AlcanceAcreditacionDTO EditarEstadoAlcanceEmpresa(AlcanceAcreditacionDTO alcanceAcreditacionDTO,UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando envio de datos de Alcance Acreditacion al DAO");
			
		 AlcanceAcreditacionDTO registro=null;
				
			try {
				
				registro = alcanceAcreditacionDAO.update2(alcanceAcreditacionDTO, usuarioDTO);
				LOG.info("(Se envio con exito los datos de Alcance Acreditacion al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos de Alcance Acreditacion al DAO",e);
			}
		
			return registro;
	}
	
	@Override
	public AlcanceAcreditacionDTO EditarEstadoAlcanceAcreditacion(AlcanceAcreditacionDTO alcanceAcreditacionDTO,UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando envio de datos de Alcance Acreditacion al DAO");
			
		 AlcanceAcreditacionDTO registro=null;
				
			try {
				
				registro = alcanceAcreditacionDAO.update(alcanceAcreditacionDTO, usuarioDTO);
				LOG.info("(Se envio con exito los datos de Alcance Acreditacion al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos de Alcance Acreditacion al DAO",e);
			}
		
			return registro;
	}

	@Override
	public AlcanceAcreditacionDTO RegistrarAlcanceAcreditacion(AlcanceAcreditacionDTO alcanceAcreditacionDTO,UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando envio de datos de Alcance Acreditacion al DAO");
			
		 AlcanceAcreditacionDTO registro=null;
				
			try {
				
				registro = alcanceAcreditacionDAO.create(alcanceAcreditacionDTO, usuarioDTO);
				LOG.info("(Se envio con exito los datos de Alcance Acreditacion al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos de Alcance Acreditacion al DAO",e);
			}
		
			return registro;
	}

}
