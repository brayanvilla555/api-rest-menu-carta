package com.proyecto.cartamenu.business.services;

import com.proyecto.cartamenu.model.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getAllCategorias();

    Categoria findCategoria(Integer id);

    Categoria saveCategorias(Categoria categoria);

    Categoria editarCategorias(Integer id, Categoria categoria);

    Boolean eliminarCategoria(Integer id);
}
