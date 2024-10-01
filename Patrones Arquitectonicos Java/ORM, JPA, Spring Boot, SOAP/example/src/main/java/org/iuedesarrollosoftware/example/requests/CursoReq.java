package org.iuedesarrollosoftware.example.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoReq {

    private String id;

    private String titulo;

    private String descripcion;

    private Integer nivel;

    private String idProfesor;

}
