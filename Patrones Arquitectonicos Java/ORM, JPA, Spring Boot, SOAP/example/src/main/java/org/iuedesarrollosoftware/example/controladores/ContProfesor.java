package org.iuedesarrollosoftware.example.controladores;

import org.iuedesarrollosoftware.example.requests.ProfesorReq;
import org.iuedesarrollosoftware.example.servicios.ServProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profesor")
public class ContProfesor {

    @Autowired
    ServProfesor servProfesor;

    @GetMapping("/")
    public ResponseEntity<?> verTodosProfesores(){
        return new ResponseEntity<>(servProfesor.verTodosProfesores(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> verProfesorPorId(@PathVariable(value = "id") String id){
        try {
            return new ResponseEntity<>(servProfesor.verProfesorPorId(id), HttpStatus.OK);
        }catch (ClassNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> agregarProfrsor(@RequestBody ProfesorReq profesorReq){
        return new ResponseEntity<>(servProfesor.insertarProfesor(profesorReq), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProfesor(@RequestBody ProfesorReq profesorReq, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(servProfesor.actualizarProfesor(profesorReq,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProfesor(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(servProfesor.eliminarProfesor(id), HttpStatus.OK);
    }

}
