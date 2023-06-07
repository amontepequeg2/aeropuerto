package com.proyecto.aeropuerto.controlador;

import com.proyecto.aeropuerto.tablas.Reserva;
import com.proyecto.aeropuerto.repositorio.ReservaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservas")
@CrossOrigin(origins = "*")
public class ReservaControlador {

    @Autowired
    private ReservaRepositorio repositorio;

    @GetMapping("/listarReservas")
    public List<Reserva> listarTodasLasReservas() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarReserva")
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return repositorio.save(reserva);
    }

    @PutMapping("/actualizarReserva/{id}")
    public Reserva actualizarReserva(@PathVariable int id, @RequestBody Reserva reservaActualizada) {
        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la RESERVA con el id: " + id));

        reserva.setClase_vuelo(reservaActualizada.getClase_vuelo());
        reserva.setAsiento(reservaActualizada.getAsiento());
        reserva.setFk_id_pasajero(reservaActualizada.getFk_id_pasajero());
        reserva.setFk_id_vuelo(reservaActualizada.getFk_id_vuelo());

        Reserva reservaActual = repositorio.save(reserva);
        return reservaActual;
    }

    @DeleteMapping("/eliminarReserva/{id}")
    public String eliminarReserva(@PathVariable int id) {
        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la RESERVA con el id: " + id));
        repositorio.delete(reserva);
        return "RESERVA eliminada con el id: " + id;
    }
}
