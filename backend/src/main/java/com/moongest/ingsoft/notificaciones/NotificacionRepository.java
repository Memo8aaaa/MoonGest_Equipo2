package com.moongest.ingsoft.notificaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    List<Notificacion> findByEstado(String estado);
    List<Notificacion> findByTipoNotificacion(String tipoNotificacion);
    List<Notificacion> findByIdCita(Integer idCita);
}