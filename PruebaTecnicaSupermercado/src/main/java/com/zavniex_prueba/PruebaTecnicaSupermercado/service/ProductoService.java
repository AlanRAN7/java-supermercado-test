package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.ProductoDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.mapper.Mapper;
import com.zavniex_prueba.PruebaTecnicaSupermercado.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> getAllProductos() {
        return productoRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        return null;
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO) {
        return null;
    }

    @Override
    public void deleteProducto(Long id, ProductoDTO productoDTO) {

    }
}
