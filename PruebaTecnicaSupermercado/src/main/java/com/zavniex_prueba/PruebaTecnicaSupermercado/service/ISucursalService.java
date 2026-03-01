package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.SucursalDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Sucursal;

import java.util.List;

public interface ISucursalService {

    List<SucursalDTO> getAllSucursales();
    SucursalDTO createSucursal(SucursalDTO sucursalDto);
    SucursalDTO updateSucursal(Long id, SucursalDTO sucursalDto);
    void deleteSucursal(Long id);
}
