package org.iuedesarrollosoftware.example.servicios;

import org.iuedesarrollosoftware.example.DTOs.CursoDTO;

import java.util.List;

public interface ServCurso {

    List<CursoDTO> verTodosCursos();
    CursoDTO verCurso(Integer id);
    int insertarCurso(CursoDTO curso);
    int actualizarCurso(CursoDTO curso, String id);
    int eliminarCurso(String id);

}
