package com.moongest.ingsoft.controller;

import com.moongest.ingsoft.model.Clienta;
import com.moongest.ingsoft.service.ClientaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientas")
@CrossOrigin(origins = "*")
public class ClientaController {

    @Autowired
    private ClientaService clientaService;

    // Listar todas
    @GetMapping
    public List<Clienta> listarTodas() {
        return clientaService.listarTodas();
    }

    // Buscar por nombre
    @GetMapping("/buscar")
    public List<Clienta> buscar(@RequestParam(required = false) String nombre,
                                @RequestParam(required = false) String telefono) {
        if (nombre != null) return clientaService.buscarPorNombre(nombre);
        if (telefono != null) return clientaService.buscarPorTelefono(telefono);
        return clientaService.listarTodas();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Clienta> obtenerPorId(@PathVariable Integer id) {
        Optional<Clienta> clienta = clientaService.obtenerPorId(id);
        if (clienta.isPresent()) return ResponseEntity.ok(clienta.get());
        return ResponseEntity.notFound().build();
    }

    // Crear clienta
    @PostMapping
    public ResponseEntity<Clienta> crear(@RequestBody Clienta clienta) {
        return ResponseEntity.ok(clientaService.crear(clienta));
    }

    // Editar clienta
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody Clienta clienta) {
        Optional<Clienta> actualizada = clientaService.editar(id, clienta);
        if (actualizada.isPresent()) return ResponseEntity.ok(actualizada.get());
        return ResponseEntity.notFound().build();
    }

    // Eliminar clienta
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (clientaService.eliminar(id)) {
            return ResponseEntity.ok("Clienta eliminada correctamente");
        }
        return ResponseEntity.notFound().build();
    }
}