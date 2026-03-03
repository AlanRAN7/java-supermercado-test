package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.ProductoDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.exception.NotFoundException;
import com.zavniex_prueba.PruebaTecnicaSupermercado.mapper.Mapper;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Producto;
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

        var prod = Producto.builder()
                .nombre(productoDTO.getNombre())
                .categoria(productoDTO.getCategoria())
                .precio(productoDTO.getPrecio())
                .cantidad(productoDTO.getCantidad())
                .build();
        return Mapper.toDTO(productoRepository.save(prod));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        // Search the product into database

        Producto prod = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado para actualizar"));

        prod.setNombre(productoDTO.getNombre());
        prod.setCategoria(productoDTO.getCategoria());
        prod.setPrecio(productoDTO.getPrecio());
        prod.setCantidad(productoDTO.getCantidad());

        return Mapper.toDTO(productoRepository.save(prod));
    }

    @Override
    public void deleteProducto(Long id) {
        if(productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new NotFoundException("Producto no encontrado para eliminar");
        }
    }
}
