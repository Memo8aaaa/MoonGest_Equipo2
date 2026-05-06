package com.moongest.ingsoft.pagos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByIdCita(Integer idCita);
}