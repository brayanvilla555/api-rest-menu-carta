package com.proyecto.cartamenu.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDto {
    private String nombre;

    private String descripcion;
}
