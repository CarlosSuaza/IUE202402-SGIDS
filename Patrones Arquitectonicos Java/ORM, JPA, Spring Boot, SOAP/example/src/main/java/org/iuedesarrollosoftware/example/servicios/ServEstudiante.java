package org.iuedesarrollosoftware.example.servicios;

import org.iuedesarrollosoftware.example.DTOs.EstudianteDTO;
import org.iuedesarrollosoftware.example.requests.EstudianteReq;

import java.util.List;

public interface ServEstudiante {

    List<EstudianteDTO> verTodosEstudiantes();
    EstudianteDTO verEstudiantePorId(String id) throws ClassNotFoundException;
    int insertarEstudiante(EstudianteReq estudiante);
    int actualizarEstudiante(EstudianteReq estudiante, String id) throws ClassNotFoundException;
    int eliminarEstudiante(String id);

}
