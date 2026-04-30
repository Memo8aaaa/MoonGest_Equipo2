package com.moongest.ingsoft.clientas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientaRepository extends JpaRepository<Clienta, Integer> {
    List<Clienta> findByNombreContainingIgnoreCase(String nombre);
    List<Clienta> findByTelefono(String telefono);
}