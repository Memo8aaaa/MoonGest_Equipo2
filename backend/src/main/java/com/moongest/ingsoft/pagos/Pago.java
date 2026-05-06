package com.moongest.ingsoft.pagos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpago")
    private Integer idPago;

    @Column(name = "idcita")
    private Integer idCita;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "tipo_pago")
    private String tipoPago;

    @Column(name = "monto_pagado")
    private BigDecimal montoPagado;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @Column(name = "referencia")
    private String referencia;

    // Getters y Setters
    public Integer getIdPago() { return idPago; }
    public void setIdPago(Integer idPago) { this.idPago = idPago; }

    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }

    public BigDecimal getMontoPagado() { return montoPagado; }
    public void setMontoPagado(BigDecimal montoPagado) { this.montoPagado = montoPagado; }

    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
}