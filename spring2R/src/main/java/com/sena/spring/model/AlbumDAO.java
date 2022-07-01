package com.sena.spring.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlbumDAO implements IAlbum{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Album> findAll() {
        
        return em.createQuery("from Album").getResultList();
    }

    @Transactional
    @Override
    public void save(Album album) {
        if (album.getId_album() != null && album.getId_album() > 0) {
			em.merge(album);
		} else {
			em.persist(album);
		}
    }

    @Override
    @Transactional(readOnly = true)
    public Album findOne(Integer id_album) {
        
        return em.find(Album.class, id_album);
    }

    @Override
    @Transactional
    public void delete(Integer id_album) {
        em.remove(findOne(id_album));
    }    

    
}

