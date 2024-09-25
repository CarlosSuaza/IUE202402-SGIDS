package com.iuedesarrollodesoftware.app_spring_soap_orm.servicios;

import com.iuedesarrollodesoftware.app_spring_soap_orm.DTOs.CursoDTO;

import java.util.List;

public interface ServicioCurso {

    List<CursoDTO> verTodosCursos();
    CursoDTO verCurso(Integer id);
    int insertarCurso(CursoDTO curso);
    int actualizarCurso(CursoDTO curso, String id);
    int eliminarCurso(String id);

}
