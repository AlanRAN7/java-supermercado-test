package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.SucursalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService {
    @Override
    public SucursalDTO updateSucursal(Long id, SucursalDTO sucursalDto) {
        return null;
    }

    @Override
    public List<SucursalDTO> getAllSucursales() {
        return List.of();
    }

    @Override
    public SucursalDTO createSucursal(SucursalDTO sucursalDto) {
        return null;
    }

    @Override
    public void deleteSucursal(Long id) {

    }
}
