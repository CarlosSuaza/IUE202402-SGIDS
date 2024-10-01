package org.iuedesarrollosoftware.example.servicios;

import org.iuedesarrollosoftware.example.DTOs.CursoDTO;
import org.iuedesarrollosoftware.example.requests.CursoReq;

import java.util.List;

public interface ServCurso {

    List<CursoDTO> verTodosCursos();
    CursoDTO verCurso(String id) throws ClassNotFoundException;
    int insertarCurso(CursoReq curso);
    int actualizarCurso(CursoReq curso, String id);
    int eliminarCurso(String id);
    int suscribirEstudiante(String id, String idEstudiante);

}
