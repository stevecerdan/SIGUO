package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.BandejaDTO;
import gob.osinergmin.sibad.domain.dto.TablaDetalleDTO;
import gob.osinergmin.sibad.service.BandejaService;
import gob.osinergmin.sibad.service.dao.BandejaDAO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BandejaService")
public class BandejaServiceImpl implements BandejaService{
    private static final Logger LOG = LoggerFactory.getLogger(BandejaServiceImpl.class);
    
    @Autowired
    BandejaDAO bandejaDAO;
    
    @Override
    @Transactional
    public List<BandejaDTO> listaSolicitud(BandejaDTO bandejaDTO) {
	LOG.info("Bandeja ServiceImpl : Lista de Solicitudes");
	List<BandejaDTO> listaSolicitud =null;
	listaSolicitud=bandejaDAO.listaSolicitud(bandejaDTO);
	return listaSolicitud;
    }
    
    @Override
    @Transactional
    public List<TablaDetalleDTO> listaEstados(String tipoEstados){
    	LOG.info("Bandeja ServiceImpl : Lista de Estados");
    	List<TablaDetalleDTO> listaEstados = null;
    	listaEstados = bandejaDAO.listaEstados(tipoEstados);
    	return listaEstados;
    }
   
    
}
