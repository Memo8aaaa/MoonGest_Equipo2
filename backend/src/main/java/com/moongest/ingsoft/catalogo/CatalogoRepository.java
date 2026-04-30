package com.moongest.ingsoft.catalogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
    List<Catalogo> findByActivo(Integer activo);
}