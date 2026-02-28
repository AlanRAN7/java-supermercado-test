package com.zavniex_prueba.PruebaTecnicaSupermercado.repository;

import com.zavniex_prueba.PruebaTecnicaSupermercado.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

}
