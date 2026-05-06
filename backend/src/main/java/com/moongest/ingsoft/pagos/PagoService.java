package com.moongest.ingsoft.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }

    public List<Pago> obtenerPorCita(Integer idCita) {
        return pagoRepository.findByIdCita(idCita);
    }

    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public void eliminarPago(Integer id) {
        pagoRepository.deleteById(id);
    }
}