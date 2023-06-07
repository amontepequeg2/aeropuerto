package com.proyecto.aeropuerto.controlador;

import com.proyecto.aeropuerto.tablas.Rol;
import com.proyecto.aeropuerto.repositorio.RolRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Roles")
@CrossOrigin(origins = "*")
public class RolControlador {

    @Autowired
    private RolRepositorio repositorio;

    @GetMapping("/listarRoles")
    public List<Rol> listarTodosLosRoles() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarRol")
    public Rol guardarRol(@RequestBody Rol rol) {
        return repositorio.save(rol);
    }

    @PutMapping("/actualizarRol/{id}")
    public Rol actualizarRol(@PathVariable int id, @RequestBody Rol rolActualizado) {
        Rol rol = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el ROL con el id: " + id));

        rol.setNombre_rol(rolActualizado.getNombre_rol());

        Rol rolActual = repositorio.save(rol);
        return rolActual;
    }

    @DeleteMapping("/eliminarRol/{id}")
    public String eliminarRol(@PathVariable int id) {
        Rol rol = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el ROL con el id: " + id));
        repositorio.delete(rol);
        return "ROL eliminado con el id: " + id;
    }
}
