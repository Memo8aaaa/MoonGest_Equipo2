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
        return notificacionRepository.findByEstado("pendiente");
    }

    public Optional<Notificacion> obtenerPorId(Integer id) {
        return notificacionRepository.findById(id);
    }

    public Notificacion crearNotificacion(Notificacion notificacion) {
        notificacion.setEstado("pendiente");
        return notificacionRepository.save(notificacion);
    }

    public Notificacion marcarComoEnviada(Integer id) {
        Optional<Notificacion> optional = notificacionRepository.findById(id);
        if (optional.isPresent()) {
            Notificacion n = optional.get();
            n.setEstado("enviado");
            n.setFechaEnvio(LocalDateTime.now());
            return notificacionRepository.save(n);
        }
        throw new RuntimeException("Notificación no encontrada con ID: " + id);
    }

    public void eliminarNotificacion(Integer id) {
        notificacionRepository.deleteById(id);
    }

    public List<Notificacion> obtenerPorClienta(String clientaNombre) {
        return notificacionRepository.findByClientaNombre(clientaNombre);
    }

    public String generarMensajeRecordatorio(Notificacion n) {
        String nombre = n.getClientaNombre().split(" ")[0];
        return "Hola " + nombre + "! 🌙 Te recordamos tu cita en Moon Beauty Space:\n\n"
                + "📅 " + n.getFechaCita() + "\n"
                + "⏰ " + n.getHoraCita() + "\n"
                + "✂️ " + n.getServicio() + "\n\n"
                + "Recuerda llegar sin maquillaje en ojos. ¡Te esperamos! 💕";
    }

    public String generarMensajePoliticas(String nombreCliente) {
        String nombre = nombreCliente.split(" ")[0];
        return "Hola " + nombre + "! 🌙 Aquí las políticas de Moon Beauty Space:\n\n"
                + "• Anticipo de $100 requerido para apartar tu cita.\n"
                + "• Puntualidad: tolerancia de 10 minutos.\n"
                + "• Cancelaciones con al menos 2 horas de anticipación.\n"
                + "• Acudir sin maquillaje en ojos, cremas ni aceites.\n"
                + "• El servicio se da por concluido cuando el pago está confirmado.\n\n"
                + "¡Gracias por tu preferencia! 💕";
    }
}