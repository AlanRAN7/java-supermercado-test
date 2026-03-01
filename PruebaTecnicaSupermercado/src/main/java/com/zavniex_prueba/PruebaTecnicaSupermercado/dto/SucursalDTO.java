package com.zavniex_prueba.PruebaTecnicaSupermercado.dto;


import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

//DTOs are used to a intern communication
public class SucursalDTO {

    private Long id;
    private String nombre;
    private String direccion;
}
