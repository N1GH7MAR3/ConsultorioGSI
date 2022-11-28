package com.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;

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
  public ResponseEntity<?> registrar_POST(@RequestBody Cita cita) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    Date sdate = new Date();  
    String fecha =formatter.format(sdate);
    Date date= formatter.parse(fecha);
    cita.setFecharegistro(date);
    citaService.insert(cita);
    return new ResponseEntity<>(cita, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{citaId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long citaId, @RequestBody Cita cita) {
    Cita citadb = citaService.findById(citaId);
    if (citadb != null) {
      cita.setId(citaId);
      cita.setFecharegistro(citadb.getFecharegistro());
      citaService.update(cita);
      return new ResponseEntity<>(citadb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Cita No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{citaId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long citaId) {
    Cita citadb = citaService.findById(citaId);
    if (citadb != null) {
      citaService.delete(citaId);
      return new ResponseEntity<>(citadb, HttpStatus.OK);
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
  @GetMapping("/buscarcita/{fechacita}/{idespecialidad}/{idmedico}/{idprocedimiento}")
  public ResponseEntity<?> buscarcita_GET(@PathVariable String fechacita,@PathVariable Long idespecialidad,@PathVariable Long idmedico,@PathVariable Long idprocedimiento) {
    Cita citadb = citaService.findCitas(fechacita, idespecialidad, idmedico, idprocedimiento);
    if (citadb != null) {
      return new ResponseEntity<>(citadb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Cita No existe", HttpStatus.NOT_FOUND);

  }
}
