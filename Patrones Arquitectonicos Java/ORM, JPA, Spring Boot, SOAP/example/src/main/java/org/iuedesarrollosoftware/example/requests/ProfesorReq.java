package org.iuedesarrollosoftware.example.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iuedesarrollosoftware.example.DTOs.CursoDTO;
import org.iuedesarrollosoftware.example.entidades.Curso;
import org.iuedesarrollosoftware.example.entidades.Profesor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorReq {

    private String id;

    private String nombres;

    private String apellidos;

    private String email;

    private String telefono;

}
