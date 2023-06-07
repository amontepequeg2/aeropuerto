package com.proyecto.aeropuerto.controlador;

import com.proyecto.aeropuerto.tablas.Empleado;
import com.proyecto.aeropuerto.repositorio.EmpleadoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Empleados")
@CrossOrigin(origins = "*")
public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepositorio repositorio;

    @GetMapping("/listarEmpleados")
    public List<Empleado> listarTodosLosEmpleados() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarEmpleado")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return repositorio.save(empleado);
    }

    @PutMapping("/actualizarEmpleado/{id}")
    public Empleado actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleadoActualizado) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el empleado con el id: " + id));

        empleado.setNombre(empleadoActualizado.getNombre());
        empleado.setFecha_nacimiento(empleadoActualizado.getFecha_nacimiento());
        empleado.setTelefono(empleadoActualizado.getTelefono());
        empleado.setDireccion(empleadoActualizado.getDireccion());
        empleado.setGenero(empleadoActualizado.getGenero());
        empleado.setNacionalidad(empleadoActualizado.getNacionalidad());
        empleado.setCargo(empleadoActualizado.getCargo());

        return repositorio.save(empleado);
    }

    @DeleteMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el empleado con el id: " + id));

        repositorio.delete(empleado);

        return "Empleado eliminado con el id: " + id;
    }
}