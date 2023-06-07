package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva,Integer>{
    
}
