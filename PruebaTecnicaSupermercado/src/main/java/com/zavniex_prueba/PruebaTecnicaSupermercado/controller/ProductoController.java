package com.zavniex_prueba.PruebaTecnicaSupermercado.controller;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.ProductoDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired // -> Igual que el constructor
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO productCreated = productoService.createProducto(productoDTO);
        return ResponseEntity.created(URI.create("/api/productos" + productCreated.getId())).body(productCreated);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
