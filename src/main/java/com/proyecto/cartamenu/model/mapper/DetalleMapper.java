package com.proyecto.cartamenu.model.mapper;

import com.proyecto.cartamenu.model.dto.DetalleDto;
import com.proyecto.cartamenu.model.entity.Detalle;
import com.proyecto.cartamenu.model.require.DetalleRequire;

public class DetalleMapper {
    public static Detalle toDetalle(DetalleDto dto) {
        return Detalle.builder()
                .detalleCompleto(dto.getDetalleCompleto())
                .descuento(dto.getDescuento())
                .procedencia(dto.getProcedencia())
                .video(dto.getVideo())
                .build();
    }
    public static DetalleDto toDetalleDto(Detalle detalle) {
        return DetalleDto.builder()
                .id(detalle.getId())
                .detalleCompleto(detalle.getDetalleCompleto())
                .descuento(detalle.getDescuento())
                .procedencia(detalle.getProcedencia())
                .video(detalle.getVideo())
                .build();
    }

    public static Detalle toDetalle(DetalleRequire detalleRequire) {
        return  Detalle.builder()
                .id(detalleRequire.getId())
                .detalleCompleto(detalleRequire.getDetalleCompleto())
                .descuento(detalleRequire.getDescuento())
                .procedencia(detalleRequire.getProcedencia())
                .video(detalleRequire.getVideo())
                //.producto(detalleRequire.getProducto())
                .build();
    }

    public static DetalleRequire toDetalleRequie(Detalle detalle) {
        return DetalleRequire.builder()
                .id(detalle.getId())
                .detalleCompleto(detalle.getDetalleCompleto())
                .descuento(detalle.getDescuento())
                .procedencia(detalle.getProcedencia())
                .video(detalle.getVideo())
                .build();
    }
}
