package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.VentaDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Venta;

import java.util.List;

public interface IVentaService {
    List<VentaDTO> getAllVentas();
    VentaDTO createVenta(VentaDTO ventaDTO);
    VentaDTO updateVenta(Long id, VentaDTO ventaDTO);
    void deleteVenta(Long id);
}
