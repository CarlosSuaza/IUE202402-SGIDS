package org.iuedesarrollosoftware.example.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @ColumnDefault("(uuid())")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false, columnDefinition = "text")
    private String descripcion;

    @Column(name = "nivel", nullable = false)
    private Integer nivel;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumns(@JoinColumn(name = "profesorId"))
    private Profesor profesor;

    @ColumnDefault("true")
    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @ManyToMany(mappedBy = "cursos")
    private Set<Estudiante> estudiantes;

}