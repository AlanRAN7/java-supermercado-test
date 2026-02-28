package com.zavniex_prueba.PruebaTecnicaSupermercado.repository;

import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
