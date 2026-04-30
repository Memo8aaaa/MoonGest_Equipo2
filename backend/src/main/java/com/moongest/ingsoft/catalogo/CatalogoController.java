package com.moongest.ingsoft.catalogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
@CrossOrigin(origins = "*")
public class CatalogoController {

    @Autowired
    private CatalogoService service;

    // GET todos los servicios
    @GetMapping
    public List<Catalogo> obtenerTodos() {
        return service.obtenerTodos();
    }

    // GET solo activos
    @GetMapping("/activos")
    public List<Catalogo> obtenerActivos() {
        return service.obtenerActivos();
    }

    // POST crear nuevo servicio
    @PostMapping
    public Catalogo crear(@RequestBody Catalogo servicio) {
        return service.crear(servicio);
    }

    // PUT editar servicio
    @PutMapping("/{id}")
    public ResponseEntity<Catalogo> editar(
            @PathVariable Integer id,
            @RequestBody Catalogo datos) {
        Catalogo actualizado = service.editar(id, datos);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // PATCH desactivar
    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<String> desactivar(@PathVariable Integer id) {
        if (service.desactivar(id)) {
            return ResponseEntity.ok("Servicio desactivado");
        }
        return ResponseEntity.notFound().build();
    }

    // PATCH reactivar
    @PatchMapping("/{id}/reactivar")
    public ResponseEntity<String> reactivar(@PathVariable Integer id) {
        if (service.reactivar(id)) {
            return ResponseEntity.ok("Servicio reactivado");
        }
        return ResponseEntity.notFound().build();
    }
}