package com.iuedesarrollodesoftware.app_spring_soap_orm.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @Column(name = "id", nullable = false, length = 15)
    private String id;

    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @ColumnDefault("true")
    @Column(name = "activo", nullable = false)
    private Boolean activo = false;

    @ManyToMany
    @JoinTable(name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudianteId"),
            inverseJoinColumns = @JoinColumn(name = "cursoId"))
    private Set<Curso> cursos = new LinkedHashSet<>();

}