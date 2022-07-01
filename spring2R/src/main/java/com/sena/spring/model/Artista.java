package com.sena.spring.model;

import java.sql.Date;
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

@Entity
@Table(name="artistas")
public class Artista{
     //atributos
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id_artista;
     @NotEmpty
     @Column
     private String nu_docu;
     @NotEmpty
     @Column
     private String tipo_docu;
     @NotEmpty
     @Column
     private String nom_artista;
     @NotEmpty
     @Column
     private String ape_artista;
     @NotEmpty
     @Column
     private String nom_artistico;
     @NotEmpty
     @Column
     private Date fechaNa_artista;
     @NotEmpty
     @Column
     private String email_artista;

    @ManyToOne(fetch = FetchType.LAZY)
    private Disquera disquera;

    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Album> albums;

     public Artista(){
        albums=new ArrayList<Album>();
     }

     public Artista(Integer id_artista, String nu_docu, String tipo_docu, String nom_artista, String ape_artista, String nom_artistico, Date fechaNa_artista, String email_artista){
        this.id_artista = id_artista;
        this.nu_docu = nu_docu;
        this.tipo_docu = tipo_docu;
        this.nom_artista = nom_artista;
        this.ape_artista = ape_artista;
        this.nom_artistico = nom_artistico;
        this.fechaNa_artista = fechaNa_artista;
        this.email_artista = email_artista;
     }

  

    public Integer getId_artista() {
        return id_artista;
    }

    public void setId_artista(Integer id_artista) {
        this.id_artista = id_artista;
    }

    public String getNu_docu() {
        return nu_docu;
    }

    public void setNu_docu(String nu_docu) {
        this.nu_docu = nu_docu;
    }

    public String getTipo_docu() {
        return tipo_docu;
    }

    public void setTipo_docu(String tipo_docu) {
        this.tipo_docu = tipo_docu;
    }

    public String getNom_artista() {
        return nom_artista;
    }

    public void setNom_artista(String nom_artista) {
        this.nom_artista = nom_artista;
    }

    public String getApe_artista() {
        return ape_artista;
    }

    public void setApe_artista(String ape_artista) {
        this.ape_artista = ape_artista;
    }

    public String getNom_artistico() {
        return nom_artistico;
    }

    public void setNom_artistico(String nom_artistico) {
        this.nom_artistico = nom_artistico;
    }

    public Date getFechaNa_artista() {
        return fechaNa_artista;
    }

    public void setFechaNa_artista(Date fechaNa_artista) {
        this.fechaNa_artista = fechaNa_artista;
    }

    public String getEmail_artista() {
        return email_artista;
    }

    public void setEmail_artista(String email_artista) {
        this.email_artista = email_artista;
    }

     
}

  