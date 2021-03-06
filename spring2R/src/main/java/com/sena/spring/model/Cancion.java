package com.sena.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="canciones")
public class Cancion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cancion;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_cancion;
    @Column(length = 20)
    private String fecha_grabacion;
    @Column(length = 20)
    private String duracion_cancion;
    private boolean estado_cancion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

        //Constructor
    public Cancion(){

    }

    public Cancion(Integer id_cancion, String nombre_cancion, String fecha_grabacion, String duracion_cancion, boolean estado_cancion){
        this.id_cancion=id_cancion;
        this.nombre_cancion=nombre_cancion;
        this.fecha_grabacion=fecha_grabacion;
        this.duracion_cancion=duracion_cancion;
        this.estado_cancion=estado_cancion;
    }

    public Integer getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(Integer id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getFecha_grabacion() {
        return fecha_grabacion;
    }

    public void setFecha_grabacion(String fecha_grabacion) {
        this.fecha_grabacion = fecha_grabacion;
    }

    public String getDuracion_cancion() {
        return duracion_cancion;
    }

    public void setDuracion_cancion(String duracion_cancion) {
        this.duracion_cancion = duracion_cancion;
    }

    public boolean isEstado_cancion() {
        return estado_cancion;
    }

    public void setEstado_cancion(boolean estado_cancion) {
        this.estado_cancion = estado_cancion;
    }
    
}
