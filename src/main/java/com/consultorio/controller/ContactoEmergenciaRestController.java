package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.ContactoEmergencia;
import com.consultorio.services.ContactoEmergenciaService;
@RestController
@RequestMapping("/contactoemergencia")
public class ContactoEmergenciaRestController {
  @Autowired
  private ContactoEmergenciaService contactoEmergenciaService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<ContactoEmergencia> contactoEmergenciadb = contactoEmergenciaService.findAll();
    if (contactoEmergenciadb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(contactoEmergenciadb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody ContactoEmergencia contactoEmergencia) {
    contactoEmergenciaService.insert(contactoEmergencia);
    return new ResponseEntity<>(contactoEmergencia, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{contactoEmergenciaId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long contactoEmergenciaId, @RequestBody ContactoEmergencia contactoEmergencia) {
    ContactoEmergencia contactoEmergenciadb = contactoEmergenciaService.findById(contactoEmergenciaId);
    if (contactoEmergenciadb != null) {
      contactoEmergencia.setId(contactoEmergenciaId);
      contactoEmergenciaService.update(contactoEmergencia);
      return new ResponseEntity<>("Contacto De Emergencia Editado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Contacto De Emergencia No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{contactoEmergenciaId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long contactoEmergenciaId) {
    ContactoEmergencia contactoEmergenciadb = contactoEmergenciaService.findById(contactoEmergenciaId);
    if (contactoEmergenciadb != null) {
      contactoEmergenciaService.delete(contactoEmergenciaId);
      return new ResponseEntity<>("Contacto De Emergencia Eliminado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Contacto De Emergencia No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{contactoEmergenciaId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long contactoEmergenciaId) {
    ContactoEmergencia contactoEmergenciadb = contactoEmergenciaService.findById(contactoEmergenciaId);
    if (contactoEmergenciadb != null) {
      return new ResponseEntity<>(contactoEmergenciadb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Contacto De Emergencia No Existe", HttpStatus.NOT_FOUND);
  }
}
