package com.moongest.ingsoft.notificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    // GET /api/notificaciones
    @GetMapping
    public List<Notificacion> obtenerTodas() {
        return notificacionService.obtenerTodas();
    }

    // GET /api/notificaciones/pendientes
    @GetMapping("/pendientes")
    public List<Notificacion> obtenerPendientes() {
        return notificacionService.obtenerPendientes();
    }

    // GET /api/notificaciones/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> obtenerPorId(@PathVariable Integer id) {
        Optional<Notificacion> notificacion = notificacionService.obtenerPorId(id);
        return notificacion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/notificaciones
    @PostMapping
    public ResponseEntity<Notificacion> crearNotificacion(@RequestBody Notificacion notificacion) {
        Notificacion nueva = notificacionService.crearNotificacion(notificacion);
        return ResponseEntity.ok(nueva);
    }

    // PUT /api/notificaciones/{id}/enviar
    @PutMapping("/{id}/enviar")
    public ResponseEntity<Notificacion> marcarEnviada(@PathVariable Integer id) {
        try {
            Notificacion actualizada = notificacionService.marcarComoEnviada(id);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/notificaciones/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Integer id) {
        notificacionService.eliminarNotificacion(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/notificaciones/clienta/{nombre}
    @GetMapping("/clienta/{nombre}")
    public List<Notificacion> obtenerPorClienta(@PathVariable String nombre) {
        return notificacionService.obtenerPorClienta(nombre);
    }

    // GET /api/notificaciones/{id}/mensaje
    @GetMapping("/{id}/mensaje")
    public ResponseEntity<String> obtenerMensaje(@PathVariable Integer id) {
        Optional<Notificacion> optional = notificacionService.obtenerPorId(id);
        if (optional.isPresent()) {
            Notificacion n = optional.get();
            String mensaje = n.getTipoMensaje().equals("politicas")
                    ? notificacionService.generarMensajePoliticas(n.getClientaNombre())
                    : notificacionService.generarMensajeRecordatorio(n);
            return ResponseEntity.ok(mensaje);
        }
        return ResponseEntity.notFound().build();
    }
}