package org.iuedesarrollosoftware.example.controladores;

import org.iuedesarrollosoftware.example.requests.EstudianteReq;
import org.iuedesarrollosoftware.example.servicios.ServEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estudiante")
public class ContEstudiante {

    @Autowired
    ServEstudiante servEst;

    @GetMapping("/")
    public ResponseEntity<?> obtenerTodosEstudiantes(){
        return new ResponseEntity<>(servEst.verTodosEstudiantes(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstudiantePorId(@PathVariable(value = "id") String id){
        try {
            return new ResponseEntity<>(servEst.verEstudiantePorId(id),HttpStatus.ACCEPTED);
        }catch(ClassNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> agregarEstudiante(@RequestBody EstudianteReq estudiante){
        return new ResponseEntity<>(servEst.insertarEstudiante(estudiante),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarEstudiante(@RequestBody EstudianteReq estudiante, @RequestParam String id){
        try {
            return new ResponseEntity<>(servEst.actualizarEstudiante(estudiante, id),HttpStatus.ACCEPTED);
        }catch(ClassNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> eliminarEstudiante(@RequestParam String id){
        return new ResponseEntity<>(servEst.eliminarEstudiante(id),HttpStatus.ACCEPTED);
    }

}
