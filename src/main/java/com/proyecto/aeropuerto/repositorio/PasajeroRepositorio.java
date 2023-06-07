package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Pasajero;

public interface PasajeroRepositorio extends JpaRepository<Pasajero,Integer>{
    
}
