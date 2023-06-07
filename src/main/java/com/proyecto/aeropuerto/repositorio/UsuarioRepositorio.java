package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer>{
    
}
