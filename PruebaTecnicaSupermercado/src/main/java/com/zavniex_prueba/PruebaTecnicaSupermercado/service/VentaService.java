package com.zavniex_prueba.PruebaTecnicaSupermercado.service;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.DetalleVentaDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.VentaDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.exception.NotFoundException;
import com.zavniex_prueba.PruebaTecnicaSupermercado.mapper.Mapper;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.DetalleVenta;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Producto;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Sucursal;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Venta;
import com.zavniex_prueba.PruebaTecnicaSupermercado.repository.ProductoRepository;
import com.zavniex_prueba.PruebaTecnicaSupermercado.repository.SucursalRepository;
import com.zavniex_prueba.PruebaTecnicaSupermercado.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<VentaDTO> getAllVentas() {

        List<Venta> ventas = ventaRepository.findAll();
        List<VentaDTO> ventasDTO = new ArrayList<>();
        VentaDTO dto;
        for (Venta v : ventas) {
            dto = Mapper.toDTO(v);
            ventasDTO.add(dto);
        }

        return ventasDTO;
    }

    @Override
    public VentaDTO createVenta(VentaDTO ventaDTO) {

        // VALIDACIONES
        if (ventaDTO == null) throw new RuntimeException("VentaDTO es null");
        if (ventaDTO.getIdSucursal() == null) throw new RuntimeException("Debe indicar la sucursal");
        if (ventaDTO.getDetalle() == null || ventaDTO.getDetalle().isEmpty())
            throw new RuntimeException("Debe incluir al menos un producto");

        // BUSCAR LA SUCURSAL
        Sucursal suc = sucursalRepository.findById(ventaDTO.getIdSucursal()).orElse(null);
        if (suc == null)
            throw new RuntimeException("Sucursal no encontrado");

        // CREAR LA VENTA
        Venta venta = new Venta();

        venta.setFecha(ventaDTO.getFecha());
        venta.setEstado(ventaDTO.getEstado());
        venta.setSucursal(suc);
        venta.setTotal(ventaDTO.getTotal());

        // LISTADO DE DETALLES
        List<DetalleVenta> detalles = new ArrayList<>();
        for (DetalleVentaDTO detDTO: ventaDTO.getDetalle()){
            // -> Acá están los productos
            // Buscar producto por id (tu detDTO usa id como id de producto)
            Producto p = productoRepository.findBynombre(detDTO.getNombreProd()).orElse(null);
            if (p == null) {
                throw new RuntimeException("Prod no encontrado: " + detDTO.getNombreProd());
            }

            // Crear el detalle
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProd(p);
            detalleVenta.setPrecio(detDTO.getPrecio());
            detalleVenta.setCantProd(detDTO.getCantProd());
            detalleVenta.setVenta(venta);

            detalles.add(detalleVenta);
        }

        venta.setDetalle(detalles);

        ventaRepository.save(venta);

        //Mapeo de salida
        return Mapper.toDTO(venta);
    }

    @Override
    public VentaDTO updateVenta(Long id, VentaDTO ventaDTO) {
         // Buscar si la venta existre para actualizarlo
        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta == null) throw new RuntimeException("Venta no encontrado");
        if (ventaDTO.getFecha() != null){
            venta.setFecha(ventaDTO.getFecha());
        }
        if (ventaDTO.getEstado() != null){
            venta.setEstado(ventaDTO.getEstado());
        }
        if (ventaDTO.getTotal() != null){
            venta.setTotal(ventaDTO.getTotal());
        }
        if (ventaDTO.getIdSucursal() != null){
            Sucursal suc = sucursalRepository.findById(ventaDTO.getIdSucursal()).orElse(null);
            if (suc == null) throw new NotFoundException("Sucursal no encontrado");
            venta.setSucursal(suc);
        }
        ventaRepository.save(venta);

        VentaDTO ventaOut = Mapper.toDTO(venta);
        return ventaOut;
    }

    @Override
    public void deleteVenta(Long id) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta == null) throw new RuntimeException("Venta no encontrada");
        ventaRepository.delete(venta);
    }
}
