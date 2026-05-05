package com.moongest.ingsoft.notificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> obtenerTodas() {
        return notificacionRepository.findAll();
    }

    public List<Notificacion> obtenerPendientes() {
        return notificacionRepository.findByEstado("Programada");
    }

    public Optional<Notificacion> obtenerPorId(Integer id) {
        return notificacionRepository.findById(id);
    }

    public Notificacion crearNotificacion(Notificacion notificacion) {
        notificacion.setEstado("Programada");
        notificacion.setFechaEnvio(LocalDateTime.now());
        return notificacionRepository.save(notificacion);
    }

    public Notificacion marcarComoEnviada(Integer id) {
        Optional<Notificacion> optional = notificacionRepository.findById(id);
        if (optional.isPresent()) {
            Notificacion n = optional.get();
            n.setEstado("Enviada");
            n.setFechaEnvio(LocalDateTime.now());
            return notificacionRepository.save(n);
        }
        throw new RuntimeException("Notificación no encontrada con ID: " + id);
    }

    public void eliminarNotificacion(Integer id) {
        notificacionRepository.deleteById(id);
    }

    public List<Notificacion> obtenerPorCita(Integer idCita) {
        return notificacionRepository.findByIdCita(idCita);
    }
}