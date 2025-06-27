package com.examen.banco.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.examen.banco.model.Productos;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
    List<Productos> findByNombreContainingIgnoreCase(String nombre);
    List<Productos> findByCategoria(String categoria);
}
