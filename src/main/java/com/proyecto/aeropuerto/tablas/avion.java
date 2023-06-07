package com.proyecto.aeropuerto.tablas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Avion;
    private String nombre_Avion;
    private String nombre_Modelo;
    private int capacidad;
    

    // Constructor vacío
    public avion() {
    }

    // Constructor normal
    public avion(int id_Avion, String nombre_Avion, String nombre_Modelo, int capacidad) {
        this.id_Avion = id_Avion;
        this.nombre_Avion = nombre_Avion;
        this.nombre_Modelo = nombre_Modelo;
        this.capacidad = capacidad;
    }

    // Getter para el atributo "Id_Avion"
    public int getId_Avion() {
        return id_Avion;
    }

    // Setter para el atributo "Id_Avion"
    public void setId_Avion(int id_Avion) {
        this.id_Avion = id_Avion;
    }

    // Getter para el atributo "Nombre_Avion"
    public String getNombre_Avion() {
        return nombre_Avion;
    }

    // Setter para el atributo "Nombre_Avion"
    public void setNombre_Avion(String nombre_Avion) {
        this.nombre_Avion = nombre_Avion;
    }

    // Getter para el atributo "Nombre_Modelo"
    public String getNombre_Modelo() {
        return nombre_Modelo;
    }

    // Setter para el atributo "Nombre_Modelo"
    public void setNombre_Modelo(String nombre_Modelo) {
        this.nombre_Modelo = nombre_Modelo;
    }

    // Getter para el atributo "Capacidad"
    public int getCapacidad() {
        return capacidad;
    }

    // Setter para el atributo "Capacidad"
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}