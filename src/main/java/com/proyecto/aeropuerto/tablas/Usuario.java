package com.proyecto.aeropuerto.tablas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre_usuario;
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "Fk_Id_Rol")
    private Rol Fk_Id_Rol;

    @ManyToOne
    @JoinColumn(name = "Fk_Id_Empleado")
    private Empleado Fk_Id_Empleado;

    // Constructor vacío
    public Usuario() {

    }

    //CONSTRUCTOR
    public Usuario(int id, String nombre_usuario, String password, Rol fk_Id_Rol, Empleado fk_Id_Empleado) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        Fk_Id_Rol = fk_Id_Rol;
        Fk_Id_Empleado = fk_Id_Empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getFk_Id_Rol() {
        return Fk_Id_Rol;
    }

    public void setFk_Id_Rol(Rol fk_Id_Rol) {
        Fk_Id_Rol = fk_Id_Rol;
    }

    public Empleado getFk_Id_Empleado() {
        return Fk_Id_Empleado;
    }

    public void setFk_Id_Empleado(Empleado fk_Id_Empleado) {
        Fk_Id_Empleado = fk_Id_Empleado;
    }


    

    



}