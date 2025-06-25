package com.utp.sisback.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.utp.sisback.demo.models.entites.Categoria;
import com.utp.sisback.demo.services.ICategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/lista")
    public List<Categoria> getList() {
        return categoriaService.getAll();
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save((categoria));
    }

    @GetMapping("/buscar/{id}")
    public Categoria getCategoriabyId(@PathVariable Long id) {
        return categoriaService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
    }

    @PutMapping("/actualizar/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria existente = categoriaService.getById(id);
        if (existente != null) {
            categoria.setId(id); 
            return categoriaService.save(categoria);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada");
    }

}
