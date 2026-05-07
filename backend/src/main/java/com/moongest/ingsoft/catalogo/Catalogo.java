package com.moongest.ingsoft.catalogo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "catalogo_servicios")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservicio")
    private Integer idservicio;

    @Column(name = "nombre_servicio", nullable = false, length = 50)
    private String nombreServicio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "duracion_estimada", nullable = false)
    private String duracionEstimada;

    @Column(name = "precio_estandar", nullable = false)
    private BigDecimal precioEstandar;

    @Column(name = "activo", nullable = false)
    private Integer activo = 1;

    // Getters y Setters
    public Integer getIdservicio() { return idservicio; }
    public void setIdservicio(Integer idservicio) { this.idservicio = idservicio; }

    public String getNombreServicio() { return nombreServicio; }
    public void setNombreServicio(String nombreServicio) { this.nombreServicio = nombreServicio; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDuracionEstimada() { return duracionEstimada; }
    public void setDuracionEstimada(String duracionEstimada) { this.duracionEstimada = duracionEstimada; }

    public BigDecimal getPrecioEstandar() { return precioEstandar; }
    public void setPrecioEstandar(BigDecimal precioEstandar) { this.precioEstandar = precioEstandar; }

    public Integer getActivo() { return activo; }
    public void setActivo(Integer activo) { this.activo = activo; }
}