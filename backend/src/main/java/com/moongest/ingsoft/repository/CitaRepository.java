package com.moongest.ingsoft.repository;

import com.moongest.ingsoft.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findByFechaCita(LocalDate fechaCita);
}