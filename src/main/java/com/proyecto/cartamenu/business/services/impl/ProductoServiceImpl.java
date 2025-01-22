package com.proyecto.cartamenu.business.services.impl;

import com.proyecto.cartamenu.business.services.ProductoService;
import com.proyecto.cartamenu.model.dto.ProductoDto;
import com.proyecto.cartamenu.model.entity.Producto;
import com.proyecto.cartamenu.model.mapper.ProductoMapper;
import com.proyecto.cartamenu.model.require.ProductoRequire;
import com.proyecto.cartamenu.repository.ProductoRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl  implements ProductoService {
    private final ProductoRepository productoRepository;

    public List<ProductoDto> listarProductos(){
        List<ProductoDto> productos = ProductoMapper.toProductoDtoList(productoRepository.findAll());
        return productos;
    }

    @Override
    public ProductoDto buscarProductoPorId(Long id) {
        Optional<Producto> producto = productoRepository.findById(Math.toIntExact(id));
        return ProductoMapper.toProductoDto(producto.get());
    }

    @Override
    public Page<ProductoDto> paginaProducto(Pageable pageable) {
        Page<Producto> productos = productoRepository.findAll(pageable);
        return productos.map(ProductoMapper::toProductoDto);
    }

    @Override
    public ProductoDto guardarProducto(ProductoRequire productoRequire) {
        Producto productoGuardado = productoRepository.save(ProductoMapper.toProducto(productoRequire));
        return ProductoMapper.toProductoDto(productoGuardado);
    }

    @Override
    public Boolean eliminarProducto(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isPresent()) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ProductoDto actualizarProducto(Integer id, ProductoRequire productoRequire) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            Producto productoActual = ProductoMapper.toProducto(productoRequire);
            productoActual.setId(id);
            return  ProductoMapper.toProductoDto(productoRepository.save(productoActual));
        }
        return new ProductoDto();
    }

    @Override
    public List<ProductoDto> buscarProductoPorNombre(String nombreProducto) {
        return ProductoMapper.toProductoDtoList(productoRepository.findByNombreContaining(nombreProducto));
    }

    @Override
    public List<ProductoDto> buscarProductoPorCategoria(String categoriaProducto) {
        return ProductoMapper.toProductoDtoList(productoRepository.findByCategoriaNombre(categoriaProducto));
    }

    @Override
    public List<ProductoDto> ordenarPorPrecio(String orden) {
        if ("desc".equalsIgnoreCase(orden)) {
            return ProductoMapper.toProductoDtoList(productoRepository.findAllByPrecioOrdenadoDesc());
        } else if ("asc".equalsIgnoreCase(orden)) {
            return ProductoMapper.toProductoDtoList(productoRepository.findAllByPrecioOrdenadoAsc());
        }

        return List.of();
    }

    public static String generarUrlImagen(String filename) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        return baseUrl + "/api/archivos/" + filename;
    }
}
