package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Tecnico;
import com.consultorio.services.TecnicoService;
@RestController
@RequestMapping("/tecnico")
public class TecnicoRestController {
  @Autowired
  private TecnicoService tecnicoService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Tecnico> tecnicodb = tecnicoService.findAll();
    if (tecnicodb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(tecnicodb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Tecnico tecnico) {
    tecnicoService.insert(tecnico);
    return new ResponseEntity<>(tecnico, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{tecnicoId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long tecnicoId, @RequestBody Tecnico tecnico) {
    Tecnico tecnicodb = tecnicoService.findById(tecnicoId);
    if (tecnicodb != null) {
      tecnico.setId(tecnicoId);
      tecnicoService.update(tecnico);
      return new ResponseEntity<>(tecnicodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Tecnico No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{tecnicoId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long tecnicoId) {
    Tecnico tecnicodb = tecnicoService.findById(tecnicoId);
    if (tecnicodb != null) {
      tecnicoService.delete(tecnicoId);
      return new ResponseEntity<>(tecnicodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Tecnico No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{tecnicoId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long tecnicoId) {
    Tecnico tecnicodb = tecnicoService.findById(tecnicoId);
    if (tecnicodb != null) {
      return new ResponseEntity<>(tecnicodb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Tecnicoa No Existe", HttpStatus.NOT_FOUND);
  }
}
