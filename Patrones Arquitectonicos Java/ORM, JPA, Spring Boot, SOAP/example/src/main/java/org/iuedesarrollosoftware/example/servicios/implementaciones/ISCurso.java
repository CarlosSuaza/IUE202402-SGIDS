package org.iuedesarrollosoftware.example.servicios.implementaciones;

import org.iuedesarrollosoftware.example.DTOs.CursoDTO;
import org.iuedesarrollosoftware.example.entidades.Curso;
import org.iuedesarrollosoftware.example.entidades.Estudiante;
import org.iuedesarrollosoftware.example.entidades.Profesor;
import org.iuedesarrollosoftware.example.repositorios.CursoRepo;
import org.iuedesarrollosoftware.example.repositorios.EstudianteRepo;
import org.iuedesarrollosoftware.example.repositorios.ProfesorRepo;
import org.iuedesarrollosoftware.example.requests.CursoReq;
import org.iuedesarrollosoftware.example.servicios.ServCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ISCurso implements ServCurso {

    @Autowired
    CursoRepo cursoRepo;

    @Autowired
    ProfesorRepo profesorRepo;

    @Autowired
    EstudianteRepo estudianteRepo;

    @Override
    public List<CursoDTO> verTodosCursos() {
        List<Curso> cursos = cursoRepo.findAll();
        if (cursos.isEmpty()){
            return new ArrayList<>();
        }
        List<CursoDTO> cursoDTOs = new ArrayList<>();
        for (Curso curso : cursos){
            CursoDTO cursoDTO = new CursoDTO(curso,false,false);
        }
        return cursoDTOs;
    }

    Optional<Curso> buscarCursoPorId(String id) {
        return cursoRepo.findById(id);
    }

    @Override
    public CursoDTO verCurso(String id) throws ClassNotFoundException {
        if (buscarCursoPorId(id).isEmpty()){
            throw new ClassNotFoundException("Curso no ha sido encontrado");
        }
        return new CursoDTO(buscarCursoPorId(id).get(),true,true);
    }

    private Boolean validarCurso(CursoReq curso){
        if(curso.getTitulo() == null || curso.getDescripcion() == null || curso.getNivel() == null || curso.getIdProfesor() == null){
            return false;
        }
        return !curso.getTitulo().isBlank() && !curso.getDescripcion().isBlank() && curso.getNivel() > 0 && !curso.getIdProfesor().isBlank();
    }

    @Override
    public int insertarCurso(CursoReq curso) {
        if (buscarCursoPorId(curso.getId()).isPresent()){
            return 0;
        }
        if (!validarCurso(curso)){
            return 0;
        }
        Optional<Profesor> findProfesor = profesorRepo.findById(curso.getIdProfesor());
        if(findProfesor.isEmpty()){
            return 0;
        }
        Curso cursoAux = new Curso();
        cursoAux.setTitulo(curso.getTitulo());
        cursoAux.setDescripcion(curso.getDescripcion());
        cursoAux.setNivel(curso.getNivel());
        cursoAux.setProfesor(findProfesor.get());
        cursoAux.setEstudiantes(new HashSet<>());
        cursoRepo.save(cursoAux);
        return 1;
    }

    @Override
    public int actualizarCurso(CursoReq curso, String id) {
        if (buscarCursoPorId(curso.getId()).isEmpty()){
            return 0;
        }
        if (!validarCurso(curso)){
            return 0;
        }
        Optional<Profesor> findProfesor = profesorRepo.findById(curso.getIdProfesor());
        if(findProfesor.isEmpty()){
            return 0;
        }
        Curso cursoAux = buscarCursoPorId(id).get();
        cursoAux.setTitulo(curso.getTitulo());
        cursoAux.setDescripcion(curso.getDescripcion());
        cursoAux.setNivel(curso.getNivel());
        cursoAux.setProfesor(findProfesor.get());
        cursoRepo.save(cursoAux);
        return 1;
    }

    @Override
    public int eliminarCurso(String id) {
        if (buscarCursoPorId(id).isEmpty()){
            return 0;
        }
        cursoRepo.deleteById(id);
        return 1;
    }

    @Override
    public int suscribirEstudiante(String id, String idEstudiante) {
        Optional<Estudiante> findEstudiante = estudianteRepo.findById(id);
        if (buscarCursoPorId(id).isEmpty()){
            return 0;
        }
        if (estudianteRepo.findById(idEstudiante).isEmpty()){
            return 0;
        }
        Curso cursoAux = buscarCursoPorId(id).get();
        Estudiante estudianteAux = findEstudiante.get();
        cursoAux.getEstudiantes().add(estudianteAux);
        estudianteAux.getCursos().add(cursoAux);
        estudianteRepo.save(estudianteAux);
        cursoRepo.save(cursoAux);
        return 1;
    }
}
