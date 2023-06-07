package com.proyecto.aeropuerto.controlador;

import com.proyecto.aeropuerto.tablas.Embalaje;
import com.proyecto.aeropuerto.repositorio.EmbalajeRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/embalaje")
@CrossOrigin(origins = "*")
public class EmbalajeControlador {
    @Autowired
    private EmbalajeRepositorio repositorio;

    @GetMapping("/listarEmbalajes")
    public List<Embalaje> listarTodosLosEmbalajes() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarEmbalaje")
    @ResponseStatus(HttpStatus.CREATED)
    public Embalaje guardarEmbalaje(@RequestBody Embalaje embalaje) {
        return repositorio.save(embalaje);
    }

    @PutMapping("/actualizarEmbalaje/{id}")
    public Embalaje actualizarEmbalaje(@PathVariable int id, @RequestBody Embalaje embalajeActualizado) {
        Embalaje embalaje = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el embalaje con el id: " + id));

        embalaje.setCantidad_maletas(embalajeActualizado.getCantidad_maletas());
        embalaje.setPeso_maletas(embalajeActualizado.getPeso_maletas());
        embalaje.setPrecio_maletas(embalajeActualizado.getPrecio_maletas());

        return repositorio.save(embalaje);
    }

    @DeleteMapping("/eliminarEmbalaje/{id}")
    public String eliminarEmbalaje(@PathVariable int id) {
        Embalaje embalaje = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el embalaje con el id: " + id));

        repositorio.delete(embalaje);
        return "Embalaje eliminado con el id: " + id;
    }
}