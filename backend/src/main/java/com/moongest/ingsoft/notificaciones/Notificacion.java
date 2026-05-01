package com.moongest.ingsoft.notificaciones;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotificacion")
    private Integer idNotificacion;

    @Column(name = "clienta_nombre", nullable = false)
    private String clientaNombre;

    @Column(name = "clienta_telefono", nullable = false)
    private String clientaTelefono;

    @Column(name = "servicio", nullable = false)
    private String servicio;

    @Column(name = "fecha_cita", nullable = false)
    private String fechaCita;

    @Column(name = "hora_cita", nullable = false)
    private String horaCita;

    @Column(name = "tipo_mensaje", nullable = false)
    private String tipoMensaje; // "recordatorio" o "politicas"

    @Column(name = "mensaje_personalizado", length = 1000)
    private String mensajePersonalizado;

    @Column(name = "estado", nullable = false)
    private String estado; // "pendiente" o "enviado"

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    public Notificacion() {}

    public Notificacion(String clientaNombre, String clientaTelefono,
                        String servicio, String fechaCita, String horaCita,
                        String tipoMensaje, String mensajePersonalizado) {
        this.clientaNombre        = clientaNombre;
        this.clientaTelefono      = clientaTelefono;
        this.servicio             = servicio;
        this.fechaCita            = fechaCita;
        this.horaCita             = horaCita;
        this.tipoMensaje          = tipoMensaje;
        this.mensajePersonalizado = mensajePersonalizado;
        this.estado               = "pendiente";
    }

    public Integer getIdNotificacion() { return idNotificacion; }
    public void setIdNotificacion(Integer idNotificacion) { this.idNotificacion = idNotificacion; }

    public String getClientaNombre() { return clientaNombre; }
    public void setClientaNombre(String clientaNombre) { this.clientaNombre = clientaNombre; }

    public String getClientaTelefono() { return clientaTelefono; }
    public void setClientaTelefono(String clientaTelefono) { this.clientaTelefono = clientaTelefono; }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

    public String getFechaCita() { return fechaCita; }
    public void setFechaCita(String fechaCita) { this.fechaCita = fechaCita; }

    public String getHoraCita() { return horaCita; }
    public void setHoraCita(String horaCita) { this.horaCita = horaCita; }

    public String getTipoMensaje() { return tipoMensaje; }
    public void setTipoMensaje(String tipoMensaje) { this.tipoMensaje = tipoMensaje; }

    public String getMensajePersonalizado() { return mensajePersonalizado; }
    public void setMensajePersonalizado(String m) { this.mensajePersonalizado = m; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}