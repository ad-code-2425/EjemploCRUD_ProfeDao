package com.example.hibernate.model;
// Generated 30 ene 2025, 17:49:46 by Hibernate Tools 6.6.0.Final

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Comunidadautonoma generated by hbm2java
 */
@Entity
@Table(name = "comunidadautonoma")
public class ComunidadAutonoma implements java.io.Serializable {

    private int idCa;
    private String nombre;
    private Set<Provincia> provincias = new HashSet<Provincia>(0);

    public ComunidadAutonoma() {
    }

    public ComunidadAutonoma(int idCa, String nombre) {
        this.idCa = idCa;
        this.nombre = nombre;
    }

    public ComunidadAutonoma(int idCa, String nombre, Set<Provincia> provincias) {
        this.idCa = idCa;
        this.nombre = nombre;
        this.provincias = provincias;
    }

    @Id

    @Column(name = "idCA", unique = true, nullable = false)
    public int getIdCa() {
        return this.idCa;
    }

    public void setIdCa(int idCa) {
        this.idCa = idCa;
    }

    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comunidadAutonoma",  cascade ={CascadeType.PERSIST, CascadeType.PERSIST}, orphanRemoval = true)
    public Set<Provincia> getProvincias() {
        return this.provincias;
    }

    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
    }

    public void addProvincia(Provincia prov) {

        getProvincias().add(prov); // uso de getProvincias() en lugar de this.provincias para forzar inicialización
                                   // del proxy

        prov.setComunidadAutonoma(this);

    }

    public void removeProvincia(Provincia provincia) {
        this.getProvincias().remove(provincia);
        provincia.setComunidadAutonoma(null);
    }


}
