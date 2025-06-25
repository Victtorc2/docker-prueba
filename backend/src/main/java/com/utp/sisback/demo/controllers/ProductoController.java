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
import com.utp.sisback.demo.models.entites.Producto;
import com.utp.sisback.demo.services.ICategoriaService;
import com.utp.sisback.demo.services.IProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

      @Autowired
    private ICategoriaService categoriaService;
    @GetMapping("/lista")
    public List<Producto> getList() {
        return productoService.getAll();
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Producto create(@RequestBody Producto producto) {
        return productoService.save((producto));
    }

    @GetMapping("/{id}")
    public Producto getProductobyId(@PathVariable Long id) {
        return productoService.getById(id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteById(id);
    }

    @PutMapping("/actualizar/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto existente = productoService.getById(id);
        if (existente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }

        // Asegurarnos de que la categoría es válida y gestionada por Hibernate
        if (producto.getCategoria() != null) {
            Long categoriaId = producto.getCategoria().getId();
            Categoria categoria = categoriaService.getById(categoriaId);
            if (categoria == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoría no válida");
            }
            producto.setCategoria(categoria); // Aseguramos que la categoria está correctamente asociada
        }

        producto.setId(id); // Mantener el mismo ID
        return productoService.save(producto); // Guardar el producto con la categoría asociada
    }

}