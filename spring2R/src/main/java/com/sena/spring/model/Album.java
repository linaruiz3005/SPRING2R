package com.sena.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="albums")
public class Album {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_album;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_album;
    @NotEmpty
    @Column(length = 50,nullable=false)
    private String ani_publicacion;

    private Boolean estado_album;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genero genero;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cancion> canciones;

    //Constructores
    public Album(){
        canciones = new ArrayList<Cancion>();
    }
    public Album(Integer id_album, String nombre_album,String ani_publicacion, Boolean estado_album, Genero genero){
        this.id_album=id_album;
        this.nombre_album=nombre_album;
        this.ani_publicacion=ani_publicacion;
        this.estado_album=estado_album;
        this.genero=genero;
    }
    public Integer getId_album() {
        return id_album;
    }
    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }
    public String getNombre_album() {
        return nombre_album;
    }
    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }
    public String getAni_publicacion() {
        return ani_publicacion;
    }
    public void setAni_publicacion(String ani_publicacion) {
        this.ani_publicacion = ani_publicacion;
    }
    public Boolean getEstado_album() {
        return estado_album;
    }
    public void setEstado_album(Boolean estado_album) {
        this.estado_album = estado_album;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
}

