package com.proyecto.cartamenu.model.dto;

import com.proyecto.cartamenu.model.entity.Producto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleDto {
    private  Integer id;

    private String detalleCompleto;

    private String procedencia;

    private String video;

    private Float descuento;

}
