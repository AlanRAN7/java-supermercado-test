package com.zavniex_prueba.PruebaTecnicaSupermercado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    // Datos de la venta
    private Long id;
    private LocalDate fecha;
    private String estado;

    // Datos de la Sucursal
    private Long IdSucursal;

    // Lista de Detalles
    private List<DetalleVentaDTO> detalles;

    //Total de la Venta
    private Double total;
}
