package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Rol;
import com.consultorio.services.RolService;
@RestController
@RequestMapping("/rol")
public class RolRestController {
  @Autowired
  private RolService rolService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Rol> roldb = rolService.findAll();
    if (roldb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(roldb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Rol rol) {
    rolService.insert(rol);
    return new ResponseEntity<>("Rol Registrado", HttpStatus.CREATED);
  }

  @PutMapping("/editar/{rolId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long rolId, @RequestBody Rol rol) {
    Rol roldb = rolService.findById(rolId);
    if (roldb != null) {
      rol.setId(rolId);
      rolService.update(rol);
      return new ResponseEntity<>("Rol Editado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Rol No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{rolId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long rolId) {
    Rol roldb = rolService.findById(rolId);
    if (roldb != null) {
      rolService.delete(rolId);
      return new ResponseEntity<>("Rol Eliminado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Rol No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{rolId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long rolId) {
    Rol roldb = rolService.findById(rolId);
    if (roldb != null) {
      return new ResponseEntity<>(roldb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Rol No Existe", HttpStatus.NOT_FOUND);
  }
}
