package com.zavniex_prueba.PruebaTecnicaSupermercado.controller;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.VentaDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDTO>> getVentas() {
        return ResponseEntity.ok(ventaService.getAllVentas());
    }

    /**
     * Creo una venta usando directamente VentaDTO en la request (opción
     * simple, sin request esperado)
     * Se espera que el DTO traiga la información
     */

    @PostMapping
    public ResponseEntity<VentaDTO> createVenta(@RequestBody VentaDTO ventaDTO) {
        VentaDTO createdVenta = ventaService.createVenta(ventaDTO);
        return ResponseEntity.created(URI.create("/api/ventas/" + createdVenta.getId())).body(createdVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDTO> updateVenta(@PathVariable Long id, @RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.ok(ventaService.updateVenta(id, ventaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VentaDTO> deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }
}
