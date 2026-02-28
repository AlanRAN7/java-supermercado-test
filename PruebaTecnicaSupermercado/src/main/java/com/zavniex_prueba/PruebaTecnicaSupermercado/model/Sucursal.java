package com.zavniex_prueba.PruebaTecnicaSupermercado.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Ya los getters y setters están creados
@Getter @Setter
// Nos agrega el constructor sin argumentos
@NoArgsConstructor
// Nos agrega el constructor con argumentos
@AllArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String direccion;

}