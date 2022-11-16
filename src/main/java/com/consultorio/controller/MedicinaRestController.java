package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Medicina;
import com.consultorio.services.MedicinaService;
@RestController
@RequestMapping("/medicina")
public class MedicinaRestController {
  @Autowired
  private MedicinaService medicinaService;
  
  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Medicina> medicinadb = medicinaService.findAll();
    if (medicinadb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(medicinadb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Medicina medicina) {
    medicinaService.insert(medicina);
    return new ResponseEntity<>(medicina, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{medicinaId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long medicinaId, @RequestBody Medicina medicina) {
    Medicina medicinadb = medicinaService.findById(medicinaId);
    if (medicinadb != null) {
      medicina.setId(medicinaId);
      medicinaService.update(medicina);
      return new ResponseEntity<>(medicinadb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Medicina No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{medicinaId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long medicinaId) {
    Medicina medicinadb = medicinaService.findById(medicinaId);
    if (medicinadb != null) {
      medicinaService.delete(medicinaId);
      return new ResponseEntity<>(medicinadb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Medicina No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{medicinaId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long medicinaId) {
    Medicina medicinadb = medicinaService.findById(medicinaId);
    if (medicinadb != null) {
      return new ResponseEntity<>(medicinadb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Medicina No Existe", HttpStatus.NOT_FOUND);
  }
}
