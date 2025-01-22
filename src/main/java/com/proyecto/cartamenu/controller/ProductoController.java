package com.proyecto.cartamenu.controller;

import com.proyecto.cartamenu.business.services.ProductoService;
import com.proyecto.cartamenu.model.dto.ProductoDto;
import com.proyecto.cartamenu.model.require.ProductoRequire;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productos")
@Validated
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/paginas")
    public ResponseEntity<Page<ProductoDto>> paginaProducto(Pageable pageable) {
        Page<ProductoDto> productos = productoService.paginaProducto(pageable);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> buscarProductoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.buscarProductoPorId(id));
    }

    //lista de productos relacionados con el nombre
    @GetMapping("/buscar-nombre/{nombreProducto}")
    public ResponseEntity<List<ProductoDto>> buscarProductoPorNombre(@PathVariable String nombreProducto) {
        return ResponseEntity.ok(productoService.buscarProductoPorNombre(nombreProducto));
    }

    //listar productos por categorias
    @GetMapping("/buscar-categoria/{categoriaProducto}")
    public ResponseEntity<List<ProductoDto>> buscarProductoPorCategoria(@PathVariable String categoriaProducto) {
        return ResponseEntity.ok(productoService.buscarProductoPorCategoria(categoriaProducto));
    }

    //listarar de forma acendente o decendente segun el precio
    @GetMapping("/ordenarPrecio")
    public ResponseEntity<List<ProductoDto>> ordenarPorPrecio(@RequestParam(required = false, defaultValue = "asc") String orden) {
        return ResponseEntity.ok(productoService.ordenarPorPrecio(orden));
    }

    @PostMapping
    public ResponseEntity<ProductoDto> guardarProducto(@RequestBody ProductoRequire productoRequire) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardarProducto(productoRequire));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable Integer id, @RequestBody ProductoRequire productoRequire) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoRequire));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable Integer id) {
        return ResponseEntity.ok(productoService.eliminarProducto(id));
    }
}
