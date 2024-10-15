package org.iuedesarrollosoftware.example;

import org.iuedesarrollosoftware.example.entidades.Curso;
import org.iuedesarrollosoftware.example.entidades.Estudiante;
import org.iuedesarrollosoftware.example.entidades.Profesor;
import org.iuedesarrollosoftware.example.repositorios.CursoRepo;
import org.iuedesarrollosoftware.example.repositorios.EstudianteRepo;
import org.iuedesarrollosoftware.example.repositorios.ProfesorRepo;
import org.iuedesarrollosoftware.example.requests.EstudianteReq;
import org.iuedesarrollosoftware.example.servicios.ServCurso;
import org.iuedesarrollosoftware.example.servicios.ServEstudiante;
import org.iuedesarrollosoftware.example.servicios.ServProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

}
