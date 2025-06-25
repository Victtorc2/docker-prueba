package com.utp.sisback.demo.services;

import java.util.List;

import com.utp.sisback.demo.models.entites.Producto;

public interface IProductoService {
    public List<Producto> getAll();

    public Producto save(Producto producto);

    public Producto getById(Long id);

    void deleteById(Long id); // <--- nuevo método

    Producto update(Long id, Producto producto);

}
