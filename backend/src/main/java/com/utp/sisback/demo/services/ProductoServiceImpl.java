package com.utp.sisback.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.sisback.demo.models.dao.ProductoDao;
import com.utp.sisback.demo.models.entites.Producto;

import jakarta.transaction.Transactional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> getAll() {
        return productoDao.findAll();
    }

    @Transactional
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Producto getById(Long id) {
        return productoDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    public Producto update(Long id, Producto producto) {
        Producto existente = productoDao.findById(id);
        if (existente != null) {
            producto.setId(id);
            return productoDao.save(producto);
        }
        return null;
    }

}
