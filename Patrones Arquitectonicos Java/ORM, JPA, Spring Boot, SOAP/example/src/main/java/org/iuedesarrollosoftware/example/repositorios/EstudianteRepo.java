package org.iuedesarrollosoftware.example.repositorios;

import com.iuedesarrollodesoftware.app_spring_soap_orm.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudianteRepo extends JpaRepository<Estudiante, String> {
}
