package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.VentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Override
    public List<VentaDTO> getAllVentas() {
        return List.of();
    }

    @Override
    public VentaDTO createVenta(VentaDTO ventaDTO) {
        return null;
    }

    @Override
    public VentaDTO updateVenta(Long id, VentaDTO ventaDTO) {
        return null;
    }

    @Override
    public void deleteVenta(Long id) {

    }
}
