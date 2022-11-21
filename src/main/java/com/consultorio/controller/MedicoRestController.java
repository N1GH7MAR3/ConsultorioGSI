package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Medico;
import com.consultorio.services.MedicoService;
@RestController
@RequestMapping("/medico")
public class MedicoRestController {
  @Autowired
  private MedicoService medicoService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Medico> medicodb = medicoService.findAll();
    if (medicodb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(medicodb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Medico medico) {
    medicoService.insert(medico);
    return new ResponseEntity<>(medico, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{medicoId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long medicoId, @RequestBody Medico medico) {
    Medico medicodb = medicoService.findById(medicoId);
    if (medicodb != null) {
      medico.setId(medicoId);
      medico.setProcedimientos(medicodb.getProcedimientos());
      medicoService.update(medico);
      return new ResponseEntity<>(medicodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Medico No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{medicoId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long medicoId) {
    Medico medicodb = medicoService.findById(medicoId);
    if (medicodb != null) {
      medicoService.delete(medicoId);
      return new ResponseEntity<>(medicodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Medico No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{medicoId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long medicoId) {
    Medico medicodb = medicoService.findById(medicoId);
    if (medicodb != null) {
      return new ResponseEntity<>(medicodb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Medico No Existe", HttpStatus.NOT_FOUND);
  }
  @GetMapping("/buscarxEspecialidad/{nombre}")
  public ResponseEntity<?> buscarxEspecialidad_GET(@PathVariable String nombre) {
    Collection<Medico> medicodb = medicoService.findByEspecialidad(nombre);
    if (medicodb != null) {
      return new ResponseEntity<>(medicodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Medico No Existe", HttpStatus.NOT_FOUND);
  }
}
