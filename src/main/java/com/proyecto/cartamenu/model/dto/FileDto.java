package com.proyecto.cartamenu.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDto {
    private Integer id;
    private String nombre;
    private String url;
}
