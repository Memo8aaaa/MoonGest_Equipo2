package com.moongest.ingsoft.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> obtenerTodos() {
        return pagoService.obtenerTodos();
    }

    @GetMapping("/cita/{idCita}")
    public List<Pago> obtenerPorCita(@PathVariable Integer idCita) {
        return pagoService.obtenerPorCita(idCita);
    }

    @PostMapping
    public Pago registrarPago(@RequestBody Pago pago) {
        return pagoService.registrarPago(pago);
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable Integer id) {
        pagoService.eliminarPago(id);
    }
}