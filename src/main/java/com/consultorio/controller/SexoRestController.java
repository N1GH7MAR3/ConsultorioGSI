package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Sexo;
import com.consultorio.services.SexoService;
@RestController
@RequestMapping("/sexo")
public class SexoRestController {
  @Autowired
  private SexoService sexoService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Sexo> sexodb = sexoService.findAll();
    if (sexodb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(sexodb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Sexo sexo) {
    sexoService.insert(sexo);
    return new ResponseEntity<>(sexo, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{sexoId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long sexoId, @RequestBody Sexo sexo) {
    Sexo sexodb = sexoService.findById(sexoId);
    if (sexodb != null) {
      sexo.setId(sexoId);
      sexoService.update(sexo);
      return new ResponseEntity<>(sexodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Sexo No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{sexoId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long sexoId) {
    Sexo sexodb = sexoService.findById(sexoId);
    if (sexodb != null) {
      sexoService.delete(sexoId);
      return new ResponseEntity<>(sexodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Sexo No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{sexoId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long sexoId) {
    Sexo sexodb = sexoService.findById(sexoId);
    if (sexodb != null) {
      return new ResponseEntity<>(sexodb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Sexo No Existe", HttpStatus.NOT_FOUND);
  }
}
