package com.proyecto.cartamenu.model.mapper;

import com.proyecto.cartamenu.model.dto.CategoriaDto;
import com.proyecto.cartamenu.model.entity.Categoria;
import com.proyecto.cartamenu.model.require.CategoriaRequire;

public class CategoriaMapper {
    public static Categoria toCategoria(CategoriaDto categoriaDto){
        return Categoria.builder()
                .id(categoriaDto.getId())
                .nombre(categoriaDto.getNombre())
                .descripcion(categoriaDto.getDescripcion())
                .build();
    }

    public static Categoria toCategoria(CategoriaRequire categoriaRequire){
        return Categoria.builder()
                .id(categoriaRequire.getId())
                .build();
    }

    public static CategoriaDto toCategoriaDto(Categoria categoria){
        return CategoriaDto.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .build();
    }

}
