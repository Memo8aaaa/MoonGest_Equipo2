package com.moongest.ingsoft.pagos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByIdCita(Integer idCita);
    @Transactional
    void deleteByIdCita(Integer idCita);
}