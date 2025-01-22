package com.proyecto.cartamenu.model.mapper;

import com.proyecto.cartamenu.model.dto.ProductoDto;
import com.proyecto.cartamenu.model.entity.Producto;
import com.proyecto.cartamenu.model.require.ProductoRequire;

import java.util.List;

public class ProductoMapper {
    public static Producto toProducto(ProductoDto productoDto) {
        if(productoDto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setId(productoDto.getId());
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        producto.setDescripcion(productoDto.getDescripcion());
        //producto.setImagen(productoDto.getImagen());
        producto.setCalificacion(productoDto.getCalificacion());
        producto.setCategoria(CategoriaMapper.toCategoria(productoDto.getCategoria()));
        return producto;
    }

    public static ProductoDto toProductoDto(Producto producto) {
        if(producto == null) {
            return null;
        }
        return ProductoDto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .calificacion(producto.getCalificacion())
                .file(FileMapper.toFileDto(producto.getFile()))
                .categoria(CategoriaMapper.toCategoriaDto(producto.getCategoria()))
                .detalle(DetalleMapper.toDetalleDto(producto.getDetalle()))
                .build();
    }

    public static List<ProductoDto> toProductoDtoList(List<Producto> productos) {
        if(productos == null) {
            return null;
        }
        return productos.stream().map(ProductoMapper::toProductoDto)
                .toList();
    }

    public static Producto toProducto(ProductoRequire productoRequire){
        if(productoRequire == null) {
            return null;
        }
        return Producto.builder()
                .nombre(productoRequire.getNombre())
                .descripcion(productoRequire.getDescripcion())
                .precio(productoRequire.getPrecio())
                .calificacion(productoRequire.getCalificacion())
                .file(FileMapper.toFile(productoRequire.getFile()))
                .categoria(CategoriaMapper.toCategoria(productoRequire.getCategoria()))
                .detalle(DetalleMapper.toDetalle(productoRequire.getDetalle()))
                .build();
    }


}
