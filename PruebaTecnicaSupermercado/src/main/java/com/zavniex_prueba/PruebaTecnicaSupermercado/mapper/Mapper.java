package com.zavniex_prueba.PruebaTecnicaSupermercado.mapper;

import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.DetalleVentaDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.ProductoDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.SucursalDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.dto.VentaDTO;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Producto;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Sucursal;
import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Venta;

import java.util.stream.Collectors;

public class Mapper {

    // MAPEO DE Producto A ProductoDTO
    public static ProductoDTO toDTO (Producto producto){
        if (producto == null) return null;

        return ProductoDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .categoria(producto.getCategoria())
                .precio(producto.getPrecio())
                .build();
    }

    // MAPEO DE Venta A VentaDTO

    public static VentaDTO toDTO (Venta venta) {
        if (venta == null) return null;

        var detalle = venta.getDetalle().stream().map(det ->
                DetalleVentaDTO.builder()
                        .id(det.getProd().getId())
                        .nombreProd(det.getProd().getNombre())
                        .cantProd(det.getCantProd())
                        .precio(det.getPrecio())
                        .subtotal(det.getPrecio() * det.getCantProd())
                        .build()
        ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .idSucursal(venta.getSucursal().getId())
                .estado(venta.getEstado())
                .detalle(detalle)
                .total(total)
                .build();
    }

    // MAPEO DE Sucursal A SucursalDTO

    public static SucursalDTO toDTO (Sucursal sucursal){
        if (sucursal == null) return null;

        return SucursalDTO.builder()
                .id(sucursal.getId())
                .nombre(sucursal.getNombre())
                .direccion(sucursal.getDireccion())
                .build();
    }

}
