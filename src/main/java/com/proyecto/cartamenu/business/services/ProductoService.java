package com.proyecto.cartamenu.business.services;

import com.proyecto.cartamenu.model.dto.ProductoDto;
import com.proyecto.cartamenu.model.require.ProductoRequire;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductoService {
    List<ProductoDto> listarProductos();

    ProductoDto buscarProductoPorId(Long id);

    Page<ProductoDto> paginaProducto(Pageable pageable);

    ProductoDto guardarProducto(ProductoRequire productoRequire);

    Boolean eliminarProducto(Integer id);

    ProductoDto actualizarProducto(Integer id, ProductoRequire productoRequire);

    List<ProductoDto> buscarProductoPorNombre(String nombreProducto);

    List<ProductoDto> buscarProductoPorCategoria(String categoriaProducto);

    List<ProductoDto> ordenarPorPrecio(String orden);
}
