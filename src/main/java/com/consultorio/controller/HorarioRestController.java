package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Horario;
import com.consultorio.services.HorarioService;
@RestController
@RequestMapping("/horario")
public class HorarioRestController {
  @Autowired
  private HorarioService horarioService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Horario> horariodb = horarioService.findAll();
    if (horariodb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(horariodb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Horario horario) {
    horarioService.insert(horario);
    return new ResponseEntity<>(horario, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{horarioId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long horarioId, @RequestBody Horario horario) {
    Horario horariodb = horarioService.findById(horarioId);
    if (horariodb != null) {
      horario.setId(horarioId);
      horarioService.update(horario);
      return new ResponseEntity<>(horariodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Horario No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{horarioId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long horarioId) {
    Horario horariodb = horarioService.findById(horarioId);
    if (horariodb != null) {
      horarioService.delete(horarioId);
      return new ResponseEntity<>(horariodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Horario No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{horarioId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long horarioId) {
    Horario horariodb = horarioService.findById(horarioId);
    if (horariodb != null) {
      return new ResponseEntity<>(horariodb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Horario No Existe", HttpStatus.NOT_FOUND);
  }
}
