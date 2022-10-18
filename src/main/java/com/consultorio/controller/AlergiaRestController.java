package com.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Alergia;
import com.consultorio.services.AlergiaService;

@RestController
@RequestMapping("/alergia")
public class AlergiaRestController {

  public AlergiaRestController() {
  }

  @Autowired
  private AlergiaService alergiaService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Alergia> alergiadb = alergiaService.findAll();
    if (alergiadb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    System.out.println(alergiadb);
    return new ResponseEntity<>(alergiadb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Alergia alergia) {
    alergiaService.insert(alergia);
    return new ResponseEntity<>("Alergia Registrada", HttpStatus.CREATED);
  }

  @PutMapping("/editar/{alergiaId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long alergiaId, @RequestBody Alergia alergia) {
    Alergia alergiadb = alergiaService.findById(alergiaId);
    if (alergiadb != null) {
      alergia.setId(alergiaId);
      alergiaService.update(alergia);
      return new ResponseEntity<>("Alergia Editada", HttpStatus.OK);
    }
    return new ResponseEntity<>("Alergia No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{alergiaId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long alergiaId) {
    Alergia alergiadb = alergiaService.findById(alergiaId);
    if (alergiadb != null) {
      alergiaService.delete(alergiaId);
      return new ResponseEntity<>("Alergia borrada", HttpStatus.OK);
    }
    return new ResponseEntity<>("Alergia No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{alergiaId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long alergiaId) {
    Alergia alergiadb = alergiaService.findById(alergiaId);
    if (alergiadb != null) {
      return new ResponseEntity<>(alergiadb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Alergia No existe", HttpStatus.NOT_FOUND);
  }

}
