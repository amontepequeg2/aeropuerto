package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Integer>{
    
}
