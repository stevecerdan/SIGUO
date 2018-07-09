package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;
import gob.osinergmin.sibad.service.SolicitudxEmpresaService;
import gob.osinergmin.sibad.service.dao.SolicitudxEmpresaDAO;

@Service("SolicitudxEmpresaService")
public class SolicitudxEmpresaServiceImpl implements SolicitudxEmpresaService{
    private static final Logger LOG = LoggerFactory.getLogger(SolicitudxEmpresaServiceImpl.class);
    
    @Inject
    SolicitudxEmpresaDAO solicitudxEmpresaDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<SolicitudPruebaRepruebaDTO> listarSolicitudes(SolicitudPruebaRepruebaFilter filtro){
        List<SolicitudPruebaRepruebaDTO> retorno=null;
        try{
            retorno = solicitudxEmpresaDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarSolicitudPruebaReprueba",ex);
        }
        return retorno;
    }

}
