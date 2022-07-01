package com.sena.spring.model;

import java.util.List;

public interface IGenero {
    public List<Genero> findAll();
    public void save (Genero genero);
    public Genero findOne(Integer id_genero);
    public void delete(Integer id_genero);
}
