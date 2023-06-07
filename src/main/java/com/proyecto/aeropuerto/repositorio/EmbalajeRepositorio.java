package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Embalaje;

public interface EmbalajeRepositorio extends JpaRepository<Embalaje,Integer>{
    
}
