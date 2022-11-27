package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Paciente;
import com.consultorio.entity.Usuario;
import com.consultorio.services.PacienteService;
@RestController
@RequestMapping("/paciente")
public class PacienteRestController {
  @Autowired
  private PacienteService pacienteService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Paciente> paceientedb = pacienteService.findAll();
    if (paceientedb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(paceientedb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Paciente paciente) {
    pacienteService.insert(paciente);
    return new ResponseEntity<>(paciente, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{pacienteId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long pacienteId, @RequestBody Paciente paciente) {
    Paciente pacientedb = pacienteService.findById(pacienteId);
    if (pacientedb != null) {
      paciente.setId(pacienteId);
      paciente.setUsuario(pacientedb.getUsuario());
      paciente.setContactoEmergencia(pacientedb.getContactoEmergencia());
      paciente.setContactoMedico(pacientedb.getContactoMedico());
      paciente.setEnfermedad(pacientedb.getEnfermedad());
      paciente.setMedicina(pacientedb.getMedicina());
      paciente.setAlergia(pacientedb.getAlergia());
      pacienteService.update(paciente);
      return new ResponseEntity<>(pacientedb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Paciente No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{pacienteId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long pacienteId) {
    Paciente pacientedb = pacienteService.findById(pacienteId);
    if (pacientedb != null) {
      pacienteService.delete(pacienteId);
      return new ResponseEntity<>(pacientedb, HttpStatus.OK);
    }
    return new ResponseEntity<>("Paciente No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{pacienteId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long pacienteId) {
    Paciente pacientedb = pacienteService.findById(pacienteId);
    if (pacientedb != null) {
      return new ResponseEntity<>(pacientedb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Paciente No existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscardni/{pacienteDni}")
  public ResponseEntity<?> buscarxdni_GET(@PathVariable Integer pacienteDni) {
    Paciente pacientedb = pacienteService.findByDni(pacienteDni);
    if (pacientedb != null) {
      return new ResponseEntity<>(pacientedb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Paciente No existe", HttpStatus.NOT_FOUND);
  }
  @PostMapping("/buscaruser")
  public ResponseEntity<?> verifyuser(@RequestBody Usuario usuario){
    Paciente pacientedb=pacienteService.findByUser(usuario.getUsuario());
    if (pacientedb != null) {
      return new ResponseEntity<>(pacientedb, HttpStatus.OK);
    }
    return new ResponseEntity<>("0", HttpStatus.NOT_FOUND);
  }
  
}
