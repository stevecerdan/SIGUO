package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ProductoxCompartimientoDTO;
import gob.osinergmin.sibad.filter.ProductoxCompartimientoFilter;
import gob.osinergmin.sibad.service.exception.ProductoxCompartimientoException;

public interface ProductoxCompartimientoDAO {
    public List<ProductoxCompartimientoDTO> find(ProductoxCompartimientoFilter filtro) throws ProductoxCompartimientoException;

}
