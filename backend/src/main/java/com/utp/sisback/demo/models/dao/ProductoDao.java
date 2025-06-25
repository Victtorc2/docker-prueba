package com.utp.sisback.demo.models.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.utp.sisback.demo.models.entites.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ProductoDao {

    @PersistenceContext
    private EntityManager em;

       @Transactional
    public Producto save(Producto producto) {
        if (producto.getId() == null) {
            em.persist(producto);  
        } else {
            producto = em.merge(producto);  
        }
        return producto;
    }

    public Producto findById(Long id) {
        return em.find(Producto.class, id);
    }

    public List<Producto> findAll() {
        return em.createQuery("SELECT c FROM Producto c", Producto.class).getResultList();

    }

       @Transactional
    public void deleteById(Long id) {
        Producto producto = em.find(Producto.class, id);
        if (producto != null) {
            em.remove(producto);
        }
    }
}