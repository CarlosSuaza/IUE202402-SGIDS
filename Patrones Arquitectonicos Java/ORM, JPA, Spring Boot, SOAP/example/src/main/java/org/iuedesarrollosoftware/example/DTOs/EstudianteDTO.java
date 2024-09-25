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
public class EstudianteDTO {

    private String id;

    private String nombres;

    private String apellidos;

    private String email;

    private String telefono;

    List<CursoDTO> cursos;

    public EstudianteDTO(Estudiante estudiante, boolean verCursos) {
        this.id = estudiante.getId();
        this.nombres = estudiante.getNombres();
        this.apellidos = estudiante.getApellidos();
        this.email = estudiante.getEmail();
        this.telefono = estudiante.getTelefono();
        if (verCursos) {
            List<CursoDTO> cursoDTOList = new ArrayList<>();
            for (Curso curso : estudiante.getCursos()) {
                cursoDTOList.add(new CursoDTO(curso,true,false));
            }
            this.cursos = cursoDTOList;
        }else {
            this.cursos = new ArrayList<>();
        }
    }

}
