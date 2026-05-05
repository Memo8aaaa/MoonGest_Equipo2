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

    @Column(name = "idcita", nullable = false)
    private Integer idCita;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    @Column(name = "tipo_notificacion", nullable = false)
    private String tipoNotificacion; // "RECORDATORIO", "POLITICAS", "CONFIRMACION"

    @Column(name = "estado", nullable = false)
    private String estado; // "Programada", "Enviada", "Fallida"

    public Integer getIdNotificacion() { return idNotificacion; }
    public void setIdNotificacion(Integer idNotificacion) { this.idNotificacion = idNotificacion; }

    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public String getTipoNotificacion() { return tipoNotificacion; }
    public void setTipoNotificacion(String tipoNotificacion) { this.tipoNotificacion = tipoNotificacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}