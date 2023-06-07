package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.avion;

public interface AvionRepositorio extends JpaRepository<avion,Integer>{
    
}
