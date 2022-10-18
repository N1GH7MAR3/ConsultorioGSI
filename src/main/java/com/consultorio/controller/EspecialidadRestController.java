package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Especialidad;
import com.consultorio.services.EspecialidadService;
@RestController
@RequestMapping("/especialidad")
public class EspecialidadRestController {
  @Autowired
  private EspecialidadService especialidadService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Especialidad> especialidaddb = especialidadService.findAll();
    if (especialidaddb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(especialidaddb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Especialidad especialidad) {
    especialidadService.insert(especialidad);
    return new ResponseEntity<>("Especialidad Registrada", HttpStatus.CREATED);
  }

  @PutMapping("/editar/{especialidadId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long especialidadId, @RequestBody Especialidad especialidad) {
    Especialidad especialidaddb = especialidadService.findById(especialidadId);
    if (especialidaddb != null) {
      especialidad.setId(especialidadId);
      especialidadService.update(especialidad);
      return new ResponseEntity<>("Especialidad Editada", HttpStatus.OK);
    }
    return new ResponseEntity<>("Especialidad No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{especialidadId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long especialidadId) {
    Especialidad especialidaddb = especialidadService.findById(especialidadId);
    if (especialidaddb != null) {
      especialidadService.delete(especialidadId);
      return new ResponseEntity<>("Especialidad Eliminada", HttpStatus.OK);
    }
    return new ResponseEntity<>("Especialidad No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{especialidadId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long especialidadId) {
    Especialidad especialidaddb = especialidadService.findById(especialidadId);
    if (especialidaddb != null) {
      return new ResponseEntity<>(especialidaddb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Especialidad No Existe", HttpStatus.NOT_FOUND);
  }
}
