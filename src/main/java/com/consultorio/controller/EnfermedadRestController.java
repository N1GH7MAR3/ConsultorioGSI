package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Enfermedad;
import com.consultorio.services.EnfermedadService;
@RestController
@RequestMapping("/enfermedad")
public class EnfermedadRestController {
  @Autowired
  private EnfermedadService enfermedadService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Enfermedad> enfermedaddb = enfermedadService.findAll();
    if (enfermedaddb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(enfermedaddb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Enfermedad enfermedad) {
    enfermedadService.insert(enfermedad);
    return new ResponseEntity<>(enfermedad, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{enfermedadId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long enfermedadId, @RequestBody Enfermedad enfermedad) {
    Enfermedad enfermedaddb = enfermedadService.findById(enfermedadId);
    if (enfermedaddb != null) {
      enfermedad.setId(enfermedadId);
      enfermedadService.update(enfermedad);
      return new ResponseEntity<>("Enfermedad Editada", HttpStatus.OK);
    }
    return new ResponseEntity<>("Enfermedad No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{enfermedadId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long enfermedadId) {
    Enfermedad enfermedaddb = enfermedadService.findById(enfermedadId);
    if (enfermedaddb != null) {
      enfermedadService.delete(enfermedadId);
      return new ResponseEntity<>("Enfermedad Eliminada", HttpStatus.OK);
    }
    return new ResponseEntity<>("Enfermedad No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{enfermedadId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long enfermedadId) {
    Enfermedad enfermedaddb = enfermedadService.findById(enfermedadId);
    if (enfermedaddb != null) {
      return new ResponseEntity<>(enfermedaddb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Enfermedad No Existe", HttpStatus.NOT_FOUND);
  }
  
}
