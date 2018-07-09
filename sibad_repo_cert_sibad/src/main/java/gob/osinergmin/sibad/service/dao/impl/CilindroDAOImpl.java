package gob.osinergmin.sibad.service.dao.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghCilindroGnv;
import gob.osinergmin.sibad.domain.builder.CilindroBuilder;
import gob.osinergmin.sibad.domain.dto.CilindroGNVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.service.dao.CilindroDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;

@Repository("CilindroDAO")
@Transactional
public class CilindroDAOImpl implements CilindroDAO{
	private static final Logger LOG = LoggerFactory.getLogger(CilindroDAOImpl.class);
	
    @Inject
    private CrudDAO crud;

	@Override
	public CilindroGNVDTO create(CilindroGNVDTO cilindroGnvDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Iniciando registro de CilindroGnv");
		LOG.info("ServiceDAOImpl: "+ cilindroGnvDTO.getIdCilindro() + " - " + cilindroGnvDTO.getEstado());
		CilindroGNVDTO retorno=null;
		
		PghCilindroGnv pghCilindro=  new PghCilindroGnv();
		
		try {
			if(cilindroGnvDTO.getIdCilindro() == null) {
				pghCilindro.setEstado(cilindroGnvDTO.getEstado());
				pghCilindro.setIdCilindro(cilindroGnvDTO.getIdCilindro());
				pghCilindro.setIdModulo(cilindroGnvDTO.getIdModulo());
				pghCilindro.setIdUnidadSupervisada(cilindroGnvDTO.getIdUnidadSupervisada());
				pghCilindro.setNumero(cilindroGnvDTO.getNumero());
				pghCilindro.setNumeroSerie(cilindroGnvDTO.getNumeroSerie());
				
				LOG.info("CREATE");
				crud.create(pghCilindro);
			}else {
				LOG.info("UPDATE");
				LOG.info("DAOIMPL: "+ cilindroGnvDTO.getIdCilindro() + " - " + cilindroGnvDTO.getEstado());
				
				pghCilindro =  crud.find(cilindroGnvDTO.getIdCilindro(), PghCilindroGnv.class);

				LOG.info("DAOIMPL: "+ pghCilindro.getIdCilindro() + " - " + pghCilindro.getEstado());
				pghCilindro.setEstado(cilindroGnvDTO.getEstado());
				
				crud.update(pghCilindro);
			}
			retorno = CilindroBuilder.toCilindroDTO(pghCilindro);
			 
			LOG.info("Registro exitoso retorno DAOIMPL: "+retorno.getIdCilindro());
			
		} catch (Exception e) {
            LOG.error("A partir de aqui error: ",e);
		}
		
		
		return retorno;
	}

}
