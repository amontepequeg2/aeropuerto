package com.proyecto.aeropuerto.controlador;

import com.proyecto.aeropuerto.tablas.Usuario;
import com.proyecto.aeropuerto.repositorio.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio repositorio;

    @GetMapping("/listarUsuarios")
    public List<Usuario> listarTodosLosUsuarios() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarUsuario")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return repositorio.save(usuario);
    }

    @PutMapping("/actualizarUsuario/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el USUARIO con el id: " + id));

        usuario.setNombre_usuario(usuarioActualizado.getNombre_usuario());
        usuario.setPassword(usuarioActualizado.getPassword());
        usuario.setFk_Id_Rol(usuarioActualizado.getFk_Id_Rol());
        usuario.setFk_Id_Empleado(usuarioActualizado.getFk_Id_Empleado());

        Usuario usuarioActual = repositorio.save(usuario);
        return usuarioActual;
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el USUARIO con el id: " + id));
        repositorio.delete(usuario);
        return "USUARIO eliminado con el id: " + id;
    }
}
