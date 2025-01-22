package com.proyecto.cartamenu.model.mapper;

import com.proyecto.cartamenu.model.dto.CategoriaDto;
import com.proyecto.cartamenu.model.entity.Categoria;
import com.proyecto.cartamenu.model.require.CategoriaRequire;

public class CategoriaMapper {
    public static Categoria toCategoria(CategoriaDto categoriaDto){
        return Categoria.builder()
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
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .build();
    }

}
