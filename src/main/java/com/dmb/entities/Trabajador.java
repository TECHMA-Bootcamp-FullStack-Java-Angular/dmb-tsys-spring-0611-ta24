package com.dmb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "trabajador")
public class Trabajador {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer dni;
    @Enumerated(EnumType.STRING)
    @Column(name="trabajo")
    private Trabajo trabajo;
    private Integer salario;

 
    public Trabajador() {
    }

  
    public Trabajador(String nombre, String apellido, Integer dni, Trabajo trabajo ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.trabajo = trabajo;
        this.salario = trabajo.getSalarioCovenio();;
        
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
       this.trabajo = trabajo;
    }

//    public Integer getSalario() {
//        return salario;
//    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    
    public int getSalario() {
		return trabajo.getSalarioCovenio();
    }
}






