package com.utp.sisback.demo.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.utp.sisback.demo.models.entites.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
       public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            em.persist(categoria);  
        } else {
            categoria = em.merge(categoria);  
        }
        return categoria;
    }
    public Categoria findById(Long id) {
        return em.find(Categoria.class, id);
    }

    public List<Categoria> findAll() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();

    }

        @Transactional
    public void deleteById(Long id) {
        Categoria categoria = em.find(Categoria.class, id);
        if (categoria != null) {
            em.remove(categoria);
        }
    }
}