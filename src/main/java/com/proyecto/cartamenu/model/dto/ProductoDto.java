package com.proyecto.cartamenu.model.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDto {
    private Integer id;

    private String nombre;

    private Float precio;

    private String descripcion;

    private Float calificacion;

    private FileDto file;

    private CategoriaDto categoria;

    private DetalleDto detalle;

}
