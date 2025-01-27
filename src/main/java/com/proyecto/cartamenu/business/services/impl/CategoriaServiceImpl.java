package com.proyecto.cartamenu.business.services.impl;

import com.proyecto.cartamenu.business.services.CategoriaService;
import com.proyecto.cartamenu.model.entity.Categoria;
import com.proyecto.cartamenu.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findCategoria(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            return categoria.get();
        }
        return new Categoria();
    }

    @Override
    public Categoria saveCategorias(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria editarCategorias(Integer id, Categoria categoria) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isPresent()) {
            categoria.setId(id);
            categoriaRepository.save(categoria);
        }
        return categoria;
    }

    @Override
    public Boolean eliminarCategoria(Integer id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isPresent()) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
