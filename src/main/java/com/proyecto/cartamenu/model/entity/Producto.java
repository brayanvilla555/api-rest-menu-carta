package com.proyecto.cartamenu.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String nombre;

    private Float precio;

    @Column(length = 500)
    private String descripcion;

    private Float calificacion;

    @JoinColumn(name = "id_file")
    @OneToOne(fetch = FetchType.EAGER)
    private File file;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_detalle")
    private Detalle detalle;
}
