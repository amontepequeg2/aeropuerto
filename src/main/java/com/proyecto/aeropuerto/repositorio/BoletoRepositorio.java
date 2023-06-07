package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Boleto;

public interface BoletoRepositorio extends JpaRepository<Boleto,Integer>{
    
}
