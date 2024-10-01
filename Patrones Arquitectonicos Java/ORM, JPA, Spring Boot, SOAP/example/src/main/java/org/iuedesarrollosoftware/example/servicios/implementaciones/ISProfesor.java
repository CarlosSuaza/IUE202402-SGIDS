package org.iuedesarrollosoftware.example.servicios.implementaciones;

import org.iuedesarrollosoftware.example.DTOs.ProfesorDTO;
import org.iuedesarrollosoftware.example.entidades.Profesor;
import org.iuedesarrollosoftware.example.repositorios.ProfesorRepo;
import org.iuedesarrollosoftware.example.requests.ProfesorReq;
import org.iuedesarrollosoftware.example.servicios.ServProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ISProfesor implements ServProfesor {

    @Autowired
    ProfesorRepo profesorRepo;

    @Override
    public List<ProfesorDTO> verTodosProfesores() {
        List<Profesor> profesores = profesorRepo.findAll();
        if (profesores.isEmpty()) {
            return new ArrayList<ProfesorDTO>();
        }
        List<ProfesorDTO> profesorDTOList = new ArrayList<>();
        for (Profesor profesor : profesores) {
            profesorDTOList.add(new ProfesorDTO(profesor,false));
        }
        return profesorDTOList;
    }

    private Optional<Profesor> buscarProfesorPorId(String id) {
        return profesorRepo.findById(id);
    }

    @Override
    public ProfesorDTO verProfesorPorId(String id) throws ClassNotFoundException {
        if (buscarProfesorPorId(id).isEmpty()){
            throw new ClassNotFoundException("Profesor no ha sido encontrado");
        }
        return new ProfesorDTO(buscarProfesorPorId(id).get(),true);
    }

    private boolean validarProfesorInsertar(ProfesorReq profesorReq){
        if (profesorReq.getId() == null || profesorReq.getNombres() == null || profesorReq.getApellidos() == null || profesorReq.getEmail() == null || profesorReq.getTelefono() == null){
            return false;
        }
        return !profesorReq.getId().isBlank() && !profesorReq.getNombres().isBlank() && !profesorReq.getApellidos().isBlank() && !profesorReq.getEmail().isBlank() && !profesorReq.getTelefono().isBlank();
    }

    private boolean validarProfesorActualizar(ProfesorReq profesorReq){
        if (profesorReq.getNombres() == null || profesorReq.getApellidos() == null || profesorReq.getEmail() == null || profesorReq.getTelefono() == null){
            return false;
        }
        return !profesorReq.getId().isBlank() && !profesorReq.getNombres().isBlank() && !profesorReq.getApellidos().isBlank() && !profesorReq.getEmail().isBlank() && !profesorReq.getTelefono().isBlank();
    }

    @Override
    public int insertarProfesor(ProfesorReq profesor) {
        if (buscarProfesorPorId(profesor.getId()).isPresent()){
            return 0;
        }
        if(!validarProfesorInsertar(profesor)){
            return 0;
        }
        Profesor profesorAux = new Profesor();
        profesorAux.setId(profesor.getId());
        profesorAux.setNombres(profesor.getNombres());
        profesorAux.setApellidos(profesor.getApellidos());
        profesorAux.setEmail(profesor.getEmail());
        profesorAux.setTelefono(profesor.getTelefono());
        profesorRepo.save(profesorAux);
        return 1;
    }

    @Override
    public int actualizarProfesor(ProfesorReq profesor, String id) {
        if (buscarProfesorPorId(id).isEmpty()){
            return 0;
        }
        if (validarProfesorActualizar(profesor)){
            return 0;
        }
        Profesor profesorAux = buscarProfesorPorId(id).get();
        profesorAux.setNombres(profesor.getNombres());
        profesorAux.setApellidos(profesor.getApellidos());
        profesorAux.setEmail(profesor.getEmail());
        profesorAux.setTelefono(profesor.getTelefono());
        profesorRepo.save(profesorAux);
        return 1;
    }

    @Override
    public int eliminarProfesor(String id) {
        if (buscarProfesorPorId(id).isEmpty()){
            return 0;
        }
        profesorRepo.deleteById(id);
        return 1;
    }
}
