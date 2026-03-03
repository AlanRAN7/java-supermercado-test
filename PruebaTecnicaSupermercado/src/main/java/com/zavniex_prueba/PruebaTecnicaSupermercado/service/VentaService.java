package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.VentaDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.mapper.Mapper;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Venta;
import com.zavniex_prueba.PruebaTecnicaSupermercado.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<VentaDTO> getAllVentas() {
        return ventaRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public VentaDTO createVenta(VentaDTO ventaDTO) {

        var venta = Venta.builder()
                .fecha(ventaDTO.getFecha())
                .estado(ventaDTO.getEstado())
                .total(ventaDTO.getTotal())

    }

    @Override
    public VentaDTO updateVenta(Long id, VentaDTO ventaDTO) {
        return null;
    }

    @Override
    public void deleteVenta(Long id) {

    }
}
