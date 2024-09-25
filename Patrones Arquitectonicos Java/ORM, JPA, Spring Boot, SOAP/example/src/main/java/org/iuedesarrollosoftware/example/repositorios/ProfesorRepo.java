package org.iuedesarrollosoftware.example.repositorios;

import com.iuedesarrollodesoftware.app_spring_soap_orm.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepo extends JpaRepository<Profesor, String> {
}
