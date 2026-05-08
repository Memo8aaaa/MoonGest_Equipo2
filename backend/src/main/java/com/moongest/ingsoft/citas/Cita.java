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

    @Column(name = "idusuario")
    private Integer idusuario;

    @Column(name = "idclienta")
    private Integer idclienta;

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

    public Integer getIdusuario() { return idusuario; }
    public void setIdusuario(Integer idusuario) { this.idusuario = idusuario; }

    public Integer getIdclienta() { return idclienta; }
    public void setIdclienta(Integer idclienta) { this.idclienta = idclienta; }

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