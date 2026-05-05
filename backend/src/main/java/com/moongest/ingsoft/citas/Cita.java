package com.moongest.ingsoft.citas;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcita")
    private Integer idcita;

    @Column(name = "idusuarios")
    private Integer idusuarios;

    @Column(name = "idclientas")
    private Integer idclientas;

    @Column(name = "idservicio")
    private Integer idservicio;

    @Column(name = "fecha_cita")
    private LocalDate fechaCita;

    @Column(name = "hora_cita")
    private LocalTime horaCita;

    @Column(name = "estado_cita")
    private Boolean estadoCita;

    @Column(name = "notas")
    private String notas;

    public Integer getIdcita() { return idcita; }
    public void setIdcita(Integer idcita) { this.idcita = idcita; }

    public Integer getIdusuarios() { return idusuarios; }
    public void setIdusuarios(Integer idusuarios) { this.idusuarios = idusuarios; }

    public Integer getIddientas() { return idclientas; }
    public void setIddientas(Integer iddientas) { this.idclientas = iddientas; }

    public Integer getIdservicio() { return idservicio; }
    public void setIdservicio(Integer idservicio) { this.idservicio = idservicio; }

    public LocalDate getFechaCita() { return fechaCita; }
    public void setFechaCita(LocalDate fechaCita) { this.fechaCita = fechaCita; }

    public LocalTime getHoraCita() { return horaCita; }
    public void setHoraCita(LocalTime horaCita) { this.horaCita = horaCita; }

    public Boolean getEstadoCita() { return estadoCita; }
    public void setEstadoCita(Boolean estadoCita) { this.estadoCita = estadoCita; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}