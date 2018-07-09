package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.ProductoxCompartimientoDTO;
import gob.osinergmin.sibad.filter.ProductoxCompartimientoFilter;

public interface ProductoxCompartimientoService {
    public List<ProductoxCompartimientoDTO> ListarProductoCompartimiento(ProductoxCompartimientoFilter filtro);

}
