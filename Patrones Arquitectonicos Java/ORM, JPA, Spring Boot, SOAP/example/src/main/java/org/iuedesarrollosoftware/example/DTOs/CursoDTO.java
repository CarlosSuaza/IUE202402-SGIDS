package org.iuedesarrollosoftware.example.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iuedesarrollosoftware.example.entidades.Curso;
import org.iuedesarrollosoftware.example.entidades.Estudiante;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoDTO {

    private String id;

    private String titulo;

    private String descripcion;

    private Integer nivel;

    private ProfesorDTO profesor;

    private List<EstudianteDTO> estudiantes;

    public CursoDTO(Curso curso, Boolean verProfesor, Boolean verEstudiantes) {
        this.id = curso.getId();
        this.titulo = curso.getTitulo();
        this.descripcion = curso.getDescripcion();
        this.nivel = curso.getNivel();
        if (verProfesor) {
            this.profesor = new ProfesorDTO(curso.getProfesor(),false);
        }else{
            this.profesor = null;
        }
        if (verEstudiantes) {
            List<EstudianteDTO> estudianteDTOList = new ArrayList<>();
            for (Estudiante estudiante : curso.getEstudiantes()) {
                estudianteDTOList.add(new EstudianteDTO(estudiante,false));
            }
            this.estudiantes = estudianteDTOList;
        }else{
            this.estudiantes = new ArrayList<>();
        }
    }


}
