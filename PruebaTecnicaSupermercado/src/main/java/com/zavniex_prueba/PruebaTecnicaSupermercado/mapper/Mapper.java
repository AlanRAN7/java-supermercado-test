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
                        .productoId(det.getProd().getId())
                        .productoNombre(det.getProd().getNombre())
                        .cantidad(det.getCantProd())
                        .precioUnitario(det.getPrecio())
                        .subTotal(det.getPrecio().multiply(Double.valueOf(det.getCantProd())))
                        .build()
        ).collect(Collectors.toList());
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
