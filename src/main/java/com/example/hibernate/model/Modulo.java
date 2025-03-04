package com.example.hibernate.model;
// Generated 30 ene 2025, 17:49:46 by Hibernate Tools 6.6.0.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Modulo generated by hbm2java
 */
@Entity
@Table(name="modulo"
)
public class Modulo  implements java.io.Serializable {


     @Override
    public String toString() {
        return "Modulo [idModulo=" + idModulo + ", nombre=" + nombre + "]";
    }

    private Integer idModulo;
     private String nombre;
     private Set<Profesor> profesors = new HashSet<Profesor>(0);

    public Modulo() {
    }

	
    public Modulo(String nombre) {
        this.nombre = nombre;
    }
    public Modulo(String nombre, Set<Profesor> profesors) {
       this.nombre = nombre;
       this.profesors = profesors;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idModulo", unique=true, nullable=false)
    public Integer getIdModulo() {
        return this.idModulo;
    }
    
    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    
    @Column(name="nombre", nullable=false, length=255)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="profesormodulo", catalog="instituto", joinColumns = { 
        @JoinColumn(name="idModulo", nullable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idProfesor", nullable=false) })
    public Set<Profesor> getProfesors() {
        return this.profesors;
    }
    
    public void setProfesors(Set<Profesor> profesors) {
        this.profesors = profesors;
    }


    public void addProfesor(Profesor profe) {

        getProfesors().add(profe);
        
        //conviene  usar getProfesors() en lugar de this.profesors para forzar las inicializaciones de los objetos proxy en caso de inicialización //lazy
        
        profe.getModulos().add(this);
        
        }

}


