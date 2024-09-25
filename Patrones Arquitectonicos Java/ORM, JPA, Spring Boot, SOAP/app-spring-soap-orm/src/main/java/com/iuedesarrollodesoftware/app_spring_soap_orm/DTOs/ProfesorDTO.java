package com.iuedesarrollodesoftware.app_spring_soap_orm.DTOs;

import com.iuedesarrollodesoftware.app_spring_soap_orm.entidades.Curso;
import com.iuedesarrollodesoftware.app_spring_soap_orm.entidades.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorDTO {

    private String id;

    private String nombres;

    private String apellidos;

    private String email;

    private String telefono;

    private List<CursoDTO> curso;

    public ProfesorDTO(Profesor profesor,boolean verCursos) {
        this.id = profesor.getId();
        this.nombres = profesor.getNombres();
        this.apellidos = profesor.getApellidos();
        this.email = profesor.getEmail();
        this.telefono = profesor.getTelefono();
        if(verCursos) {
            List<CursoDTO> cursoDTOList = new ArrayList<>();
            for(Curso curso : profesor.getCursos()) {
                cursoDTOList.add(new CursoDTO(curso,false,true));
            }
            this.curso = cursoDTOList;
        }else{
            this.curso = new ArrayList<>();
        }
    }

}
