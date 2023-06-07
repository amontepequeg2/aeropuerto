package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Vuelo;

public interface VueloRepositorio extends JpaRepository<Vuelo,Integer>{
    
}
