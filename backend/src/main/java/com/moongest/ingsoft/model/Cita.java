package com.moongest.ingsoft.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcita")
    private Integer idCita;

    @Column(name = "usuarios_idusuarios")
    private Integer usuariosIdUsuarios;

    @Column(name = "clientas_idclientas")
    private Integer clientasIdClientas;

    @Column(name = "catalogo_servicios_idservicio")
    private Integer catalogoServiciosIdServicio;

    @Column(name = "fecha_cita")
    private LocalDate fechaCita;

    @Column(name = "hora_cita")
    private LocalTime horaCita;

    @Column(name = "estado_cita")
    private Boolean estadoCita;

    @Column(name = "notas")
    private String notas;

    // Getters y Setters
    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }

    public Integer getUsuariosIdUsuarios() { return usuariosIdUsuarios; }
    public void setUsuariosIdUsuarios(Integer usuariosIdUsuarios) { this.usuariosIdUsuarios = usuariosIdUsuarios; }

    public Integer getClientasIdClientas() { return clientasIdClientas; }
    public void setClientasIdClientas(Integer clientasIdClientas) { this.clientasIdClientas = clientasIdClientas; }

    public Integer getCatalogoServiciosIdServicio() { return catalogoServiciosIdServicio; }
    public void setCatalogoServiciosIdServicio(Integer catalogoServiciosIdServicio) { this.catalogoServiciosIdServicio = catalogoServiciosIdServicio; }

    public LocalDate getFechaCita() { return fechaCita; }
    public void setFechaCita(LocalDate fechaCita) { this.fechaCita = fechaCita; }

    public LocalTime getHoraCita() { return horaCita; }
    public void setHoraCita(LocalTime horaCita) { this.horaCita = horaCita; }

    public Boolean getEstadoCita() { return estadoCita; }
    public void setEstadoCita(Boolean estadoCita) { this.estadoCita = estadoCita; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}