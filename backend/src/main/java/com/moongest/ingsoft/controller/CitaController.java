package com.moongest.ingsoft.controller;

import com.moongest.ingsoft.model.Cita;
import com.moongest.ingsoft.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // Listar todas
    @GetMapping
    public List<Cita> listarTodas() {
        return citaService.listarTodas();
    }

    // Listar por fecha
    @GetMapping("/fecha/{fecha}")
    public List<Cita> listarPorFecha(@PathVariable String fecha) {
        return citaService.listarPorFecha(LocalDate.parse(fecha));
    }

    // Crear cita
    @PostMapping
    public ResponseEntity<Cita> crear(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.crear(cita));
    }

    // Editar cita
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody Cita cita) {
        Optional<Cita> actualizada = citaService.editar(id, cita);
        if (actualizada.isPresent()) {
            return ResponseEntity.ok(actualizada.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Cancelar cita
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelar(@PathVariable Integer id) {
        if (citaService.cancelar(id)) {
            return ResponseEntity.ok("Cita cancelada correctamente");
        }
        return ResponseEntity.notFound().build();
    }
}
