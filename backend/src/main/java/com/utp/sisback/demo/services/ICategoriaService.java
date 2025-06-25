package com.utp.sisback.demo.services;
import java.util.List;

import com.utp.sisback.demo.models.entites.Categoria;

public interface ICategoriaService {
    public List<Categoria> getAll();
    public Categoria save(Categoria categoria);
    public Categoria getById(Long id);
    void deleteById(Long id);  
    Categoria update(Long id, Categoria categoria);


    
}
