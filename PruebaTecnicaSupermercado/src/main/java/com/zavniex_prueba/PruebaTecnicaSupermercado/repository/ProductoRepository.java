package com.zavniex_prueba.PruebaTecnicaSupermercado.repository;

import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Buscar producto por nombre
    Optional<Producto> findBynombre(String nombre);
}
