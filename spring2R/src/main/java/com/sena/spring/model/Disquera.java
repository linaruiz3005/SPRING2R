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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="disqueras")
public class Disquera {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dis;
    @NotEmpty
    @Column
    private String nit_disquera;
    @NotEmpty
    @Column
    private String nom_disquera;
    @NotEmpty
    @Column
    private String tele_disquera;
    @NotEmpty
    @Column
    private String dire_disquera;

    private Boolean estado_disquera;

    @OneToMany(mappedBy = "disquera", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Artista> artista;
    

    public Disquera(){
        artista=new ArrayList<Artista>();
    }

    public Disquera(Integer id_dis, String nit_disquera , String nom_disquera, String tele_disquera, String dire_disquera,
    Boolean estado_disquera) {
    this.id_dis = id_dis;
    this.nit_disquera = nit_disquera;
    this.nom_disquera = nom_disquera;
    this.tele_disquera = tele_disquera;
    this.dire_disquera = dire_disquera;
    this.estado_disquera = estado_disquera;
    }

    public Integer getId_dis() {
        return id_dis;
    }

    public void setId_dis(Integer id_dis) {
        this.id_dis = id_dis;
    }

    public String getNit_disquera() {
        return nit_disquera;
    }

    public void setNit_disquera(String nit_disquera) {
        this.nit_disquera = nit_disquera;
    }

    public String getNom_disquera() {
        return nom_disquera;
    }

    public void setNom_disquera(String nom_disquera) {
        this.nom_disquera = nom_disquera;
    }

    public String getTele_disquera() {
        return tele_disquera;
    }

    public void setTele_disquera(String tele_disquera) {
        this.tele_disquera = tele_disquera;
    }

    public String getDire_disquera() {
        return dire_disquera;
    }

    public void setDire_disquera(String dire_disquera) {
        this.dire_disquera = dire_disquera;
    }

    public Boolean getEstado_disquera() {
        return estado_disquera;
    }

    public void setEstado_disquera(Boolean estado_disquera) {
        this.estado_disquera = estado_disquera;
    }

    

}
 