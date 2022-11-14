package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.ContactoMedico;
import com.consultorio.services.ContactoMedicoService;
@RestController
@RequestMapping("/contactomedico")
public class ContactoMedicoRestController {
  @Autowired
  private ContactoMedicoService contactoMedicoService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<ContactoMedico> contacoMedicodb = contactoMedicoService.findAll();
    if (contacoMedicodb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(contacoMedicodb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody ContactoMedico contactoMedico) {
    contactoMedicoService.insert(contactoMedico);
    return new ResponseEntity<>(contactoMedico, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{contactoMedicoId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long contactoMedicoId, @RequestBody ContactoMedico contactoMedico) {
    ContactoMedico contactoMedicodb = contactoMedicoService.findById(contactoMedicoId);
    if (contactoMedicodb != null) {
      contactoMedico.setId(contactoMedicoId);
      contactoMedicoService.update(contactoMedico);
      return new ResponseEntity<>("Contaco Medico Editado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Contaco Medico No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{contactoMedicoId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long contactoMedicoId) {
    ContactoMedico contactoMedicodb = contactoMedicoService.findById(contactoMedicoId);
    if (contactoMedicodb != null) {
      contactoMedicoService.delete(contactoMedicoId);
      return new ResponseEntity<>("Contaco Medico Eliminado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Contaco Medico No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{contactoMedicoId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long contactoMedicoId) {
    ContactoMedico contactoMedicodb = contactoMedicoService.findById(contactoMedicoId);
    if (contactoMedicodb != null) {
      return new ResponseEntity<>(contactoMedicodb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Contaco Medico No Existe", HttpStatus.NOT_FOUND);
  }
  
}
