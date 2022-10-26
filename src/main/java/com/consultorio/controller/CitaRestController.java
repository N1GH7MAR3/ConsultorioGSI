package com.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Cita;
import com.consultorio.services.CitaService;

@RestController
@RequestMapping("/cita")
public class CitaRestController {
  @Autowired
  private CitaService citaService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Cita> citadb = citaService.findAll();
    if (citadb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(citadb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Cita cita) {
    citaService.insert(cita);
    return new ResponseEntity<>("Cita Registrada", HttpStatus.CREATED);
  }

  @PutMapping("/editar/{citaId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long citaId, @RequestBody Cita cita) {
    Cita citadb = citaService.findById(citaId);
    if (citadb != null) {
      cita.setId(citaId);
      citaService.update(cita);
      return new ResponseEntity<>("Cita Editada", HttpStatus.OK);
    }
    return new ResponseEntity<>("Cita No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{citaId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long citaId) {
    Cita citadb = citaService.findById(citaId);
    if (citadb != null) {
      citaService.delete(citaId);
      return new ResponseEntity<>("Cita borrada", HttpStatus.OK);
    }
    return new ResponseEntity<>("Cita No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{citaId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long citaId) {
    Cita citadb = citaService.findById(citaId);
    if (citadb != null) {
      return new ResponseEntity<>(citadb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Cita No existe", HttpStatus.NOT_FOUND);

  }

  @GetMapping("/buscardni/{dni}")
  public ResponseEntity<?> buscarxdni_GET(@PathVariable Integer dni) {
    Collection<Cita> citadb = citaService.findByDni(dni);
    if (citadb != null) {
      return new ResponseEntity<>(citadb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Cita No existe", HttpStatus.NOT_FOUND);

  }
}
