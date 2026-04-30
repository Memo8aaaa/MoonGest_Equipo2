package com.moongest.ingsoft.citas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    // Listar todas
    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    // Listar por fecha
    public List<Cita> listarPorFecha(LocalDate fecha) {
        return citaRepository.findByFechaCita(fecha);
    }

    // Crear cita
    public Cita crear(Cita cita) {
        return citaRepository.save(cita);
    }

    // Editar cita
    public Optional<Cita> editar(Integer id, Cita datosNuevos) {
        return citaRepository.findById(id).map(c -> {
            c.setClientasIdClientas(datosNuevos.getClientasIdClientas());
            c.setCatalogoServiciosIdServicio(datosNuevos.getCatalogoServiciosIdServicio());
            c.setFechaCita(datosNuevos.getFechaCita());
            c.setHoraCita(datosNuevos.getHoraCita());
            c.setEstadoCita(datosNuevos.getEstadoCita());
            c.setNotas(datosNuevos.getNotas());
            return citaRepository.save(c);
        });
    }

    // Cancelar cita
    public boolean cancelar(Integer id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
