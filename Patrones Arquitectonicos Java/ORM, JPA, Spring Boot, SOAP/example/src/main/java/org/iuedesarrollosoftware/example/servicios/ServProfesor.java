package org.iuedesarrollosoftware.example.servicios;

import org.iuedesarrollosoftware.example.DTOs.ProfesorDTO;

import java.util.List;

public interface ServProfesor {

    List<ProfesorDTO> verTodosProfesores();
    ProfesorDTO verProfesorPorId(String id);
    int insertarProfesor(ProfesorDTO profesor);
    int actualizarProfesor(ProfesorDTO profesor, String id);
    int eliminarProfesor(String id);

}
