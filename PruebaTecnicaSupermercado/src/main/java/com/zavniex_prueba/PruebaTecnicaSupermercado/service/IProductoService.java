package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.ProductoDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Producto;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> getAllProductos();
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO);
    void deleteProducto(Long id);
}
