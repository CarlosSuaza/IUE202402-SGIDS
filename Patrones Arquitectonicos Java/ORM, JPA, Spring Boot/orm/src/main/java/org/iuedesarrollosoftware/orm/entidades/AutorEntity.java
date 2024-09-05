package org.iuedesarrollosoftware.orm.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "biografia", nullable = false, length = Integer.MAX_VALUE)
    private String biografia;

    @Column(name = "fechanacimiento", nullable = false)
    private LocalDate fechanacimiento;

    @Column(name = "fechamuerte")
    private LocalDate fechamuerte;

    @ColumnDefault("true")
    @Column(name = "activo", nullable = false)
    private Boolean activo = false;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fechaactualizacion", nullable = false)
    private Instant fechaactualizacion;

}