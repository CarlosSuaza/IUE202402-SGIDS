package org.iuedesarrollosoftware.example.servicios;

import org.iuedesarrollosoftware.example.DTOs.ProfesorDTO;
import org.iuedesarrollosoftware.example.requests.ProfesorReq;

import java.util.List;

public interface ServProfesor {

    List<ProfesorDTO> verTodosProfesores();
    ProfesorDTO verProfesorPorId(String id) throws ClassNotFoundException;
    int insertarProfesor(ProfesorReq profesor);
    int actualizarProfesor(ProfesorReq profesor, String id);
    int eliminarProfesor(String id);

}
