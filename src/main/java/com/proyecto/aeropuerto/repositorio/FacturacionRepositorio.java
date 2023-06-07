package com.proyecto.aeropuerto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aeropuerto.tablas.Facturacion;

public interface FacturacionRepositorio extends JpaRepository<Facturacion,Integer>{
    
}
