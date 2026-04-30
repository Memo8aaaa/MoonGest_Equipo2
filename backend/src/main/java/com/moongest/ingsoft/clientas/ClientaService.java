package com.moongest.ingsoft.clientas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientaService {

    @Autowired
    private ClientaRepository clientaRepository;

    // Listar todas
    public List<Clienta> listarTodas() {
        return clientaRepository.findAll();
    }

    // Buscar por nombre
    public List<Clienta> buscarPorNombre(String nombre) {
        return clientaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Buscar por teléfono
    public List<Clienta> buscarPorTelefono(String telefono) {
        return clientaRepository.findByTelefono(telefono);
    }

    // Obtener por id
    public Optional<Clienta> obtenerPorId(Integer id) {
        return clientaRepository.findById(id);
    }

    // Crear clienta
    public Clienta crear(Clienta clienta) {
        return clientaRepository.save(clienta);
    }

    // Editar clienta
    public Optional<Clienta> editar(Integer id, Clienta datosNuevos) {
        return clientaRepository.findById(id).map(c -> {
            c.setNombre(datosNuevos.getNombre());
            c.setPaterno(datosNuevos.getPaterno());
            c.setMaterno(datosNuevos.getMaterno());
            c.setTelefono(datosNuevos.getTelefono());
            c.setFechaPrimeraVisita(datosNuevos.getFechaPrimeraVisita());
            c.setNotasAlergia(datosNuevos.getNotasAlergia());
            c.setNotasPreferencias(datosNuevos.getNotasPreferencias());
            return clientaRepository.save(c);
        });
    }

    // Eliminar clienta
    public boolean eliminar(Integer id) {
        if (clientaRepository.existsById(id)) {
            clientaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
