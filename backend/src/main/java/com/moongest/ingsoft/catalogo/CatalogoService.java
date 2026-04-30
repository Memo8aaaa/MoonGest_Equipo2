package com.moongest.ingsoft.catalogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository repository;

    // Obtener todos los servicios
    public List<Catalogo> obtenerTodos() {
        return repository.findAll();
    }

    // Obtener solo activos
    public List<Catalogo> obtenerActivos() {
        return repository.findByActivo(1);
    }

    // Crear nuevo servicio
    public Catalogo crear(Catalogo servicio) {
        servicio.setActivo(1);
        return repository.save(servicio);
    }

    // Editar servicio existente
    public Catalogo editar(Integer id, Catalogo datos) {
        Optional<Catalogo> existente = repository.findById(id);
        if (existente.isPresent()) {
            Catalogo s = existente.get();
            s.setNombreServicio(datos.getNombreServicio());
            s.setDescripcion(datos.getDescripcion());
            s.setDuracionEstimada(datos.getDuracionEstimada());
            s.setPrecioEstandar(datos.getPrecioEstandar());
            return repository.save(s);
        }
        return null;
    }

    // Desactivar servicio
    public boolean desactivar(Integer id) {
        Optional<Catalogo> existente = repository.findById(id);
        if (existente.isPresent()) {
            Catalogo s = existente.get();
            s.setActivo(0);
            repository.save(s);
            return true;
        }
        return false;
    }

    // Reactivar servicio
    public boolean reactivar(Integer id) {
        Optional<Catalogo> existente = repository.findById(id);
        if (existente.isPresent()) {
            Catalogo s = existente.get();
            s.setActivo(1);
            repository.save(s);
            return true;
        }
        return false;
    }
}