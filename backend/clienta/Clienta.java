package com.moongest.ingsoft.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clientas")
public class Clienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclientas")
    private Integer idClientas;

    @Column(name = "nombre", length = 25)
    private String nombre;

    @Column(name = "paterno", length = 25)
    private String paterno;

    @Column(name = "materno", length = 25)
    private String materno;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "fecha_primeravisita")
    private LocalDate fechaPrimeraVisita;

    @Column(name = "notas_alergia")
    private String notasAlergia;

    @Column(name = "notas_preferencia")
    private String notasPreferencias;

    // Getters y Setters
    public Integer getIdClientas() { return idClientas; }
    public void setIdClientas(Integer idClientas) { this.idClientas = idClientas; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPaterno() { return paterno; }
    public void setPaterno(String paterno) { this.paterno = paterno; }

    public String getMaterno() { return materno; }
    public void setMaterno(String materno) { this.materno = materno; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public LocalDate getFechaPrimeraVisita() { return fechaPrimeraVisita; }
    public void setFechaPrimeraVisita(LocalDate fechaPrimeraVisita) { this.fechaPrimeraVisita = fechaPrimeraVisita; }

    public String getNotasAlergia() { return notasAlergia; }
    public void setNotasAlergia(String notasAlergia) { this.notasAlergia = notasAlergia; }

    public String getNotasPreferencias() { return notasPreferencias; }
    public void setNotasPreferencias(String notasPreferencias) { this.notasPreferencias = notasPreferencias; }
}
