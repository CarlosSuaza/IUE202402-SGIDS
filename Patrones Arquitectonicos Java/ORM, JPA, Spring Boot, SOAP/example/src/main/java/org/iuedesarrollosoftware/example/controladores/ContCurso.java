package org.iuedesarrollosoftware.example.controladores;

import org.iuedesarrollosoftware.example.requests.CursoReq;
import org.iuedesarrollosoftware.example.servicios.ServCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/curso")
public class ContCurso {

    @Autowired
    ServCurso servCurso;

    @GetMapping("/")
    public ResponseEntity<?> verTodosCursos(){
        return new ResponseEntity<>(servCurso.verTodosCursos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> verCursoPorId(@PathVariable("id") String id){
        try{
            return new ResponseEntity<>(servCurso.verCurso(id), HttpStatus.ACCEPTED);
        }catch (ClassNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> agregarCurso(@RequestBody CursoReq curso){
        return new ResponseEntity<>(servCurso.insertarCurso(curso), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCurso(@RequestBody CursoReq curso, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(servCurso.actualizarCurso(curso, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(servCurso.eliminarCurso(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/suscribirEstudiante")
    public ResponseEntity<?> suscribirEstudiante(@RequestParam(value = "id") String id, @RequestParam("idEstudiante") String idEstudiante){
        return new ResponseEntity<>(servCurso.suscribirEstudiante(id, idEstudiante), HttpStatus.ACCEPTED);
    }

}
