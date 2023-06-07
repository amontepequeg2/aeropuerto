package com.proyecto.aeropuerto.controlador;

import com.proyecto.aeropuerto.tablas.Vuelo;
import com.proyecto.aeropuerto.repositorio.VueloRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Vuelos")
@CrossOrigin(origins = "*")
public class VueloControlador {

    @Autowired
    private VueloRepositorio repositorio;

    @GetMapping("/listarVuelos")
    public List<Vuelo> listarTodosLosVuelos() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarVuelo")
    public Vuelo guardarVuelo(@RequestBody Vuelo vuelo) {
        return repositorio.save(vuelo);
    }

    @PutMapping("/actualizarVuelo/{id}")
    public Vuelo actualizarVuelo(@PathVariable int id, @RequestBody Vuelo vueloActualizado) {
        Vuelo vuelo = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el VUELO con el id: " + id));

        vuelo.setOrigen(vueloActualizado.getOrigen());
        vuelo.setFecha_salida(vueloActualizado.getFecha_salida());
        vuelo.setHora_salida(vueloActualizado.getHora_salida());
        vuelo.setDestino(vueloActualizado.getDestino());
        vuelo.setFecha_llegada(vueloActualizado.getFecha_llegada());
        vuelo.setHora_llegada(vueloActualizado.getHora_llegada());
        vuelo.setHora_revision(vueloActualizado.getHora_revision());
        vuelo.setNumero_puerta(vueloActualizado.getNumero_puerta());
        vuelo.setFk_Id_Avion(vueloActualizado.getFk_Id_Avion());

        Vuelo vueloActual = repositorio.save(vuelo);
        return vueloActual;
    }

    @DeleteMapping("/eliminarVuelo/{id}")
    public String eliminarVuelo(@PathVariable int id) {
        Vuelo vuelo = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el VUELO con el id: " + id));
        repositorio.delete(vuelo);
        return "VUELO eliminado con el id: " + id;
    }
}
