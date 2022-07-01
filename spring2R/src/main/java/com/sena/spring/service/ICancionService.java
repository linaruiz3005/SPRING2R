package com.sena.spring.service;

import java.util.List;
import com.sena.spring.model.Cancion;

public interface ICancionService {
    public List<Cancion> findAll();
    public void save (Cancion cancion);
    public Cancion findOne(Integer id_cancion);
    public void delete(Integer id_cancion);
}
