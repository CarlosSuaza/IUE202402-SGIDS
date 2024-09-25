package org.iuedesarrollosoftware.example.repositorios;

import org.iuedesarrollosoftware.example.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepo extends JpaRepository<Profesor, String> {
}
