package com.proyecto.cartamenu.repository;

import com.proyecto.cartamenu.model.dto.ProductoDto;
import com.proyecto.cartamenu.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombreContaining(String nombre);

    List<Producto> findByCategoriaNombre(String categoria);

    @Query("SELECT p FROM Producto p ORDER BY p.precio asc ")
    List<Producto> findAllByPrecioOrdenadoAsc();

    @Query("SELECT p FROM Producto p ORDER BY p.precio desc ")
    List<Producto> findAllByPrecioOrdenadoDesc();

}
