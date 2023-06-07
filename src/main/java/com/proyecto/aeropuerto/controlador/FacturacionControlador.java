package com.proyecto.aeropuerto.controlador;

import com.proyecto.aeropuerto.tablas.Facturacion;
import com.proyecto.aeropuerto.repositorio.FacturacionRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Facturas")
@CrossOrigin(origins = "*")
public class FacturacionControlador {

    @Autowired
    private FacturacionRepositorio repositorio;

    @GetMapping("/listarFacturas")
    public List<Facturacion> listarTodasLasFacturas() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarFactura")
    @ResponseStatus(HttpStatus.CREATED)
    public Facturacion guardarFactura(@RequestBody Facturacion factura) {
        return repositorio.save(factura);
    }

    @PutMapping("/actualizarFactura/{id}")
    public Facturacion actualizarFactura(@PathVariable int id, @RequestBody Facturacion facturaActualizada) {
        Facturacion factura = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la factura con el número: " + id));

        factura.setFecha_emision(facturaActualizada.getFecha_emision());
        factura.setId_boleto(facturaActualizada.getId_boleto());
        factura.setId_embalaje(facturaActualizada.getId_embalaje());

        return repositorio.save(factura);
    }

    @DeleteMapping("/eliminarFactura/{id}")
    public String eliminarFactura(@PathVariable int id) {
        Facturacion factura = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la factura con el número: " + id));

        repositorio.delete(factura);

        return "Factura eliminada con el número: " + id;
    }
}