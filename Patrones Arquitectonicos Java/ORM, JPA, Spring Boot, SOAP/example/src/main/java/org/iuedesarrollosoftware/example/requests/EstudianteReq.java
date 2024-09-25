package org.iuedesarrollosoftware.example.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iuedesarrollosoftware.example.DTOs.CursoDTO;
import org.iuedesarrollosoftware.example.entidades.Curso;
import org.iuedesarrollosoftware.example.entidades.Estudiante;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstudianteReq {

    private String id;

    private String nombres;

    private String apellidos;

    private String email;

    private String telefono;

}
