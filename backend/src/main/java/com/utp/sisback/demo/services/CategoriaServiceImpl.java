package com.utp.sisback.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.sisback.demo.models.dao.CategoriaDao;
import com.utp.sisback.demo.models.entites.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> getAll() {
        return categoriaDao.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    public Categoria getById(Long id) {
        return categoriaDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        categoriaDao.deleteById(id);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        Categoria existente = categoriaDao.findById(id);
        if (existente != null) {
            categoria.setId(id);
            return categoriaDao.save(categoria);
        }
        return null;
    }

}
