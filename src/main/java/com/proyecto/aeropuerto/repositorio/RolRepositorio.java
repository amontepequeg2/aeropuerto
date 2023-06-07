package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Rol;

public interface RolRepositorio extends JpaRepository<Rol,Integer>{
    
}
