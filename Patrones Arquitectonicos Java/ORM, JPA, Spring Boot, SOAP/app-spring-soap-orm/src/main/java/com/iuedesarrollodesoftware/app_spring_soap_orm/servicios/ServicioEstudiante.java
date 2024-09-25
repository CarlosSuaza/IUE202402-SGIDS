package com.iuedesarrollodesoftware.app_spring_soap_orm.servicios;

import com.iuedesarrollodesoftware.app_spring_soap_orm.DTOs.EstudianteDTO;

import java.util.List;

public interface ServicioEstudiante {

    List<EstudianteDTO> verTodosEstudiantes();
    EstudianteDTO verEstudiantePorId(String id) throws ClassNotFoundException;
    int insertarEstudiante(EstudianteDTO estudiante);
    int actualizarEstudiante(EstudianteDTO estudiante, String id);
    int eliminarEstudiante(String id);

}
