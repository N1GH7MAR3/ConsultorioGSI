package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.EstadoCivil;
import com.consultorio.services.EstadoCivilService;
@RestController
@RequestMapping("/estadocivil")
public class EstadoCivilRestController {
  @Autowired
  private EstadoCivilService estadoCivilService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<EstadoCivil> estadoCivildb = estadoCivilService.findAll();
    if (estadoCivildb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(estadoCivildb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody EstadoCivil estadoCivil) {
    estadoCivilService.insert(estadoCivil);
    return new ResponseEntity<>("Estado Civil Registrado", HttpStatus.CREATED);
  }

  @PutMapping("/editar/{estadoCivilID}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long estadoCivilID, @RequestBody EstadoCivil estadoCivil) {
     EstadoCivil estadoCivildb = estadoCivilService.findById(estadoCivilID);
    if (estadoCivildb != null) {
      estadoCivil.setId(estadoCivilID);
      estadoCivilService.update(estadoCivil);
      return new ResponseEntity<>("Estado Civil Editado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Estado Civil No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{estadoCivilID}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long estadoCivilID) {
     EstadoCivil estadoCivildb = estadoCivilService.findById(estadoCivilID);
    if (estadoCivildb != null) {
      estadoCivilService.delete(estadoCivilID);
      return new ResponseEntity<>("Estado Civil Eliminado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Estado Civil No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{estadoCivilID}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long estadoCivilID) {
    EstadoCivil estadoCivildb = estadoCivilService.findById(estadoCivilID);
    if (estadoCivildb != null) {
      return new ResponseEntity<>(estadoCivildb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Estado Civil No Existe", HttpStatus.NOT_FOUND);
  }
}
