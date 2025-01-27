package com.proyecto.cartamenu.controller;

import com.proyecto.cartamenu.business.services.CategoriaService;
import com.proyecto.cartamenu.model.entity.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findCategoria(@PathVariable Integer id){
        return ResponseEntity.ok(categoriaService.findCategoria(id));
    }


    @PostMapping
    public ResponseEntity<Categoria> saveCategorias(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.saveCategorias(categoria));
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Categoria> updateCategorias(@PathVariable Integer id,@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.editarCategorias(id,categoria));
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Boolean> deleteCategorias(@PathVariable Integer id){
        return ResponseEntity.ok(categoriaService.eliminarCategoria(id));
    }

}