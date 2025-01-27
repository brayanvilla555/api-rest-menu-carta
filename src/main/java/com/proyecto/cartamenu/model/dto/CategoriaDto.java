package com.proyecto.cartamenu.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDto {
    private Integer id;
    private String nombre;

    private String descripcion;
}
