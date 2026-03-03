package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.SucursalDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.mapper.Mapper;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Sucursal;
import com.zavniex_prueba.PruebaTecnicaSupermercado.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;


    @Override
    public SucursalDTO updateSucursal(Long id, SucursalDTO sucursalDto) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrado para actualizar"));
        sucursal.setNombre(sucursalDto.getNombre());
        sucursal.setDireccion(sucursalDto.getDireccion());

        return Mapper.toDTO(sucursalRepository.save(sucursal));
    }

    @Override
    public List<SucursalDTO> getAllSucursales() {
        return sucursalRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public SucursalDTO createSucursal(SucursalDTO sucursalDto) {

        var sucursal = Sucursal.builder()
                .nombre(sucursalDto.getNombre())
                .direccion(sucursalDto.getDireccion())
                .build();

        return Mapper.toDTO(sucursalRepository.save(sucursal));
    }

    @Override
    public void deleteSucursal(Long id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sucursal no encontrado para eliminar");
        }
    }
}
