package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Pais;
import com.consultorio.services.PaisService;
@RestController
@RequestMapping("/pais")
public class PaisRestController {
  @Autowired
  private PaisService paisService;
  

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Pais> paisdb = paisService.findAll();
    if (paisdb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(paisdb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Pais pais) {
    paisService.insert(pais);
    return new ResponseEntity<>(pais, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{paisId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long paisId, @RequestBody Pais pais) {
    Pais paisdb = paisService.findById(paisId);
    if (paisdb != null) {
      pais.setId(paisId);
      paisService.update(pais);
      return new ResponseEntity<>(paisdb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Pais No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{paisId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long paisId) {
    Pais paisdb = paisService.findById(paisId);
    if (paisdb != null) {
      paisService.delete(paisId);
      return new ResponseEntity<>(paisdb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Pais No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{paisId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long paisId) {
    Pais paisdb = paisService.findById(paisId);
    if (paisdb != null) {
      return new ResponseEntity<>(paisdb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Pais No Existe", HttpStatus.NOT_FOUND);
  }

}
