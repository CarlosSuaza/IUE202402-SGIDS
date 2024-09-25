package com.iuedesarrollodesoftware.app_spring_soap_orm.servicios;

import com.iuedesarrollodesoftware.app_spring_soap_orm.DTOs.ProfesorDTO;

import java.util.List;

public interface ServicioProfesor {

    List<ProfesorDTO> verTodosProfesores();
    ProfesorDTO verProfesorPorId(String id);
    int insertarProfesor(ProfesorDTO profesor);
    int actualizarProfesor(ProfesorDTO profesor, String id);
    int eliminarProfesor(String id);

}
