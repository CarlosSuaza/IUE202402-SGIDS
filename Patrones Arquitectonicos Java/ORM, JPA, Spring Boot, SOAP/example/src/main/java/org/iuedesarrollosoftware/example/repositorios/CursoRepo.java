package org.iuedesarrollosoftware.example.repositorios;

import org.iuedesarrollosoftware.example.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepo extends JpaRepository<Curso, String> {

}
