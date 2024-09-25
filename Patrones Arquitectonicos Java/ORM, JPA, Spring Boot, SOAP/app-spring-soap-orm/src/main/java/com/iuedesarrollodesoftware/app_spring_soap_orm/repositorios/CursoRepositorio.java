package com.iuedesarrollodesoftware.app_spring_soap_orm.repositorios;

import com.iuedesarrollodesoftware.app_spring_soap_orm.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<Curso, String> {

}
