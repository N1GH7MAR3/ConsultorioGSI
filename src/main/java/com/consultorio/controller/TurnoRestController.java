package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Turno;
import com.consultorio.services.TurnoService;
@RestController
@RequestMapping("/turno")
public class TurnoRestController {
  @Autowired
  private TurnoService turnoService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Turno> turnodb = turnoService.findAll();
    if (turnodb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(turnodb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Turno turno) {
    turnoService.insert(turno);
    return new ResponseEntity<>(turno, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{turnoId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long turnoId, @RequestBody Turno turno) {
    Turno turnodb = turnoService.findById(turnoId);
    if (turnodb != null) {
      turno.setId(turnoId);
      turnoService.update(turno);
      return new ResponseEntity<>(turnodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Turno No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{turnoId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long turnoId) {
    Turno turnodb = turnoService.findById(turnoId);
    if (turnodb != null) {
      turnoService.delete(turnoId);
      return new ResponseEntity<>(turnodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Turno No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{turnoId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long turnoId) {
    Turno turnodb = turnoService.findById(turnoId);
    if (turnodb != null) {
      return new ResponseEntity<>(turnodb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Turno No Existe", HttpStatus.NOT_FOUND);
  }
}
