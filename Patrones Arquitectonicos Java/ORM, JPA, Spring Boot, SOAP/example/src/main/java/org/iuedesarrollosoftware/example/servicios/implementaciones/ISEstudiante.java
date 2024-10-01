package org.iuedesarrollosoftware.example.servicios.implementaciones;

import org.iuedesarrollosoftware.example.DTOs.EstudianteDTO;
import org.iuedesarrollosoftware.example.entidades.Estudiante;
import org.iuedesarrollosoftware.example.repositorios.EstudianteRepo;
import org.iuedesarrollosoftware.example.requests.EstudianteReq;
import org.iuedesarrollosoftware.example.servicios.ServEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ISEstudiante implements ServEstudiante {

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

    private Optional<Estudiante> buscarEstudiantePorId(String id) {
        return estudianteRepo.findById(id);
    }

    @Override
    public EstudianteDTO verEstudiantePorId(String id) throws ClassNotFoundException {

        if(buscarEstudiantePorId(id).isPresent()){
            throw new ClassNotFoundException("Estudiante no encontrado");
        }
        return new EstudianteDTO(buscarEstudiantePorId(id).get(),true);

    }

    private boolean validarEstudianteActualizar(EstudianteReq estudiante) {
        if(estudiante == null){
            return false;
        }
        if(estudiante.getNombres() == null || estudiante.getApellidos() == null || estudiante.getEmail() == null || estudiante.getTelefono() == null){
            return false;
        }
        return !estudiante.getNombres().isBlank() && !estudiante.getApellidos().isBlank() && !estudiante.getEmail().isBlank() && !estudiante.getTelefono().isBlank();
    }

    private boolean validarEstudianteInsertar(EstudianteReq estudiante) {
        if(estudiante == null){
            return false;
        }
        if(estudiante.getId() == null || estudiante.getNombres() == null || estudiante.getApellidos() == null || estudiante.getEmail() == null || estudiante.getTelefono() == null){
            return false;
        }
        return !estudiante.getId().isBlank() && !estudiante.getNombres().isBlank() && !estudiante.getApellidos().isBlank() && !estudiante.getEmail().isBlank() && !estudiante.getTelefono().isBlank();
    }

    @Override
    public int insertarEstudiante(EstudianteReq estudiante) {
        if(buscarEstudiantePorId(estudiante.getId()).isPresent()){
            return 0;
        }
        if(!validarEstudianteInsertar(estudiante)){
            return 0;
        }
        estudianteRepo.save(new Estudiante(estudiante.getId(), estudiante.getNombres(), estudiante.getApellidos(), estudiante.getEmail(),estudiante.getTelefono()));
        return 1;
    }

    @Override
    public int actualizarEstudiante(EstudianteReq estudiante, String id) throws ClassNotFoundException {
        if(buscarEstudiantePorId(id).isEmpty()){
            throw new ClassNotFoundException("Estudiante no encontrado");
        }
        if(!validarEstudianteActualizar(estudiante)){
            return 0;
        }
        Estudiante estudianteAux = buscarEstudiantePorId(id).get();
        estudianteAux.setNombres(estudiante.getNombres());
        estudianteAux.setApellidos(estudiante.getApellidos());
        estudianteAux.setEmail(estudiante.getEmail());
        estudianteAux.setTelefono(estudiante.getTelefono());
        estudianteRepo.save(estudianteAux);
        return 1;
    }

    @Override
    public int eliminarEstudiante(String id) {
        if(buscarEstudiantePorId(id).isPresent()){
            estudianteRepo.delete(buscarEstudiantePorId(id).get());
            return 1;
        }
        return 0;
    }
}
