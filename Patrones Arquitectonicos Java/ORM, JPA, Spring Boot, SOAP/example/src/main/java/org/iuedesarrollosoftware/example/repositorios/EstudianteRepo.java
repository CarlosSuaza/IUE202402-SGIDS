package org.iuedesarrollosoftware.example.repositorios;


import org.iuedesarrollosoftware.example.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EstudianteRepo extends JpaRepository<Estudiante, String> {


}
