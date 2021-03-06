package com.sena.spring.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GeneroDAO implements IGenero{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Genero> findAll() {
        
        return em.createQuery("from Genero").getResultList();
    }

    @Transactional
    @Override
    public void save(Genero genero) {
        if (genero.getId_genero() != null && genero.getId_genero() > 0) {
			em.merge(genero);
		} else {
			em.persist(genero);
		}
    }

    @Override
    @Transactional(readOnly = true)
    public Genero findOne(Integer id_genero) {
        
        return em.find(Genero.class, id_genero);
    }

    @Override
    @Transactional
    public void delete(Integer id_genero) {
        em.remove(findOne(id_genero));
    }    

    
}
