package com.proyecto.aeropuerto.controlador;

import com.proyecto.aeropuerto.tablas.Pasajero;
import com.proyecto.aeropuerto.repositorio.PasajeroRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pasajeros")
@CrossOrigin(origins = "*")
public class PasajeroControlador {

    @Autowired
    private PasajeroRepositorio repositorio;

    @GetMapping("/listarPasajeros")
    public List<Pasajero> listarTodoSlosPasajeros() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarPasajero")
    @ResponseStatus(HttpStatus.CREATED)
    public Pasajero guardarPasajero(@RequestBody Pasajero pasajero) {
        return repositorio.save(pasajero);
    }

    @PutMapping("/actualizarPasajero/{id}")
    public Pasajero actualizarPasajero(@PathVariable int id, @RequestBody Pasajero pasajeroActualizado) {
        Pasajero pasajero = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el pasajero con el ID: " + id));

        pasajero.setNombre(pasajeroActualizado.getNombre());
        pasajero.setFecha_nacimiento(pasajeroActualizado.getFecha_nacimiento());
        pasajero.setTelefono(pasajeroActualizado.getTelefono());
        pasajero.setDireccion(pasajeroActualizado.getDireccion());
        pasajero.setGenero(pasajeroActualizado.getGenero());
        pasajero.setNacionalidad(pasajeroActualizado.getNacionalidad());

        return repositorio.save(pasajero);
    }

    @DeleteMapping("/eliminarPasajero/{id}")
    public String eliminarPasajero(@PathVariable int id) {
        Pasajero pasajero = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el pasajero con el ID: " + id));

        repositorio.delete(pasajero);

        return "Pasajero eliminado con el ID: " + id;
    }
}
