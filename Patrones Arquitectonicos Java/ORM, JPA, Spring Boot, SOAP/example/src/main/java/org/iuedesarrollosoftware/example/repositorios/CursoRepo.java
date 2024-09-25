package org.iuedesarrollosoftware.example.repositorios;

import com.iuedesarrollodesoftware.app_spring_soap_orm.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepo extends JpaRepository<Curso, String> {

}
