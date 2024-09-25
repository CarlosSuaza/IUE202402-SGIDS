package org.iuedesarrollosoftware.example.servicios.implementaciones;

import com.iuedesarrollodesoftware.app_spring_soap_orm.DTOs.EstudianteDTO;
import com.iuedesarrollodesoftware.app_spring_soap_orm.entidades.Estudiante;
import com.iuedesarrollodesoftware.app_spring_soap_orm.repositorios.EstudianteRepo;
import com.iuedesarrollodesoftware.app_spring_soap_orm.servicios.ServEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SIEstudiante implements ServEstudiante {

    @Autowired
    EstudianteRepo estudianteRepo;

    @Override
    public List<EstudianteDTO> verTodosEstudiantes() {
        if (estudianteRepo.findAll().isEmpty()) {
            return new ArrayList<>();
        }
        List<EstudianteDTO> estudianteDTOS = new ArrayList<>();
        for(Estudiante estudiante: estudianteRepo.findAll()) {
            estudianteDTOS.add(new EstudianteDTO(estudiante,false));
        }
        return estudianteDTOS;
    }

    Optional<Estudiante> buscarEstudiantePorId(String id) {
        return estudianteRepo.findById(id);
    }

    @Override
    public EstudianteDTO verEstudiantePorId(String id) throws ClassNotFoundException {

        if(buscarEstudiantePorId(id).isPresent()){
            throw new ClassNotFoundException("Estudiante no encontrado");
        }
        return new EstudianteDTO(buscarEstudiantePorId(id).get(),true);
    }

    @Override
    public int insertarEstudiante(EstudianteDTO estudiante) {
        return 0;
    }

    @Override
    public int actualizarEstudiante(EstudianteDTO estudiante, String id) {
        return 0;
    }

    @Override
    public int eliminarEstudiante(String id) {
        return 0;
    }
}
