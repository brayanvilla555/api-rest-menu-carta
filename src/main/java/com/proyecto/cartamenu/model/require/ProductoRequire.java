package com.proyecto.cartamenu.model.require;

import com.proyecto.cartamenu.model.entity.Categoria;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoRequire {
    private String nombre;

    private Float precio;

    private String descripcion;

    private Float calificacion;

    private FileRequest file;

    private CategoriaRequire categoria;

    private DetalleRequire detalle;

}
