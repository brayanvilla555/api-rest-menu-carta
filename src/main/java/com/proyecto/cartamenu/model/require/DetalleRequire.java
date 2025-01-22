package com.proyecto.cartamenu.model.require;

import com.proyecto.cartamenu.model.entity.Producto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleRequire {
    private Integer id;

    private String detalleCompleto;

    private String procedencia;

    private String video;

    private Float descuento;

}
