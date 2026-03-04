package com.zavniex_prueba.PruebaTecnicaSupermercado.controller;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.SucursalDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {
    @Autowired
    private ISucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<SucursalDTO>> getSucursales() {
        return ResponseEntity.ok(sucursalService.getAllSucursales());
    }

    @PostMapping
    public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO createdSucursal = sucursalService.createSucursal(sucursalDTO);
        return ResponseEntity.created(URI.create("/api/sucursales/" + createdSucursal.getId())).body(createdSucursal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO) {
        return ResponseEntity.ok(sucursalService.updateSucursal(id, sucursalDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Long id) {
        sucursalService.deleteSucursal(id);
        return ResponseEntity.noContent().build();
    }
}
