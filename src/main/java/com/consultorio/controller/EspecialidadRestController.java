package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Especialidad;
import com.consultorio.entity.Medico;
import com.consultorio.entity.Procedimiento;
import com.consultorio.services.EspecialidadService;
import com.consultorio.services.MedicoService;
import com.consultorio.services.ProcedimientoService;
@RestController
@RequestMapping("/especialidad")
public class EspecialidadRestController {
  @Autowired
  private EspecialidadService especialidadService;
  @Autowired
  private ProcedimientoService procedimientoService;
  @Autowired
  private MedicoService medicoService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Especialidad> especialidaddb = especialidadService.findAll();
    if (especialidaddb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(especialidaddb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Especialidad especialidad) {
    especialidadService.insert(especialidad);
    return new ResponseEntity<>(especialidad, HttpStatus.CREATED);
  }

  @PutMapping("/editar/{especialidadId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long especialidadId, @RequestBody Especialidad especialidad) {
    Especialidad especialidaddb = especialidadService.findById(especialidadId);
    if (especialidaddb != null) {
      especialidad.setId(especialidadId);
      especialidadService.update(especialidad);
      return new ResponseEntity<>(especialidad, HttpStatus.OK);
    }
    return new ResponseEntity<>("Especialidad No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{especialidadId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long especialidadId) {
    Especialidad especialidaddb = especialidadService.findById(especialidadId);
    if (especialidaddb != null) {
      Collection<Procedimiento> procedimientodb=procedimientoService.findByEspecialidad(especialidaddb.getNombre());
      Collection<Medico>medicodb=medicoService.findByEspecialidad(especialidaddb.getNombre());
      if(procedimientodb.isEmpty()){
        if(medicodb.isEmpty()){
          especialidadService.delete(especialidadId);
          return new ResponseEntity<>(especialidaddb, HttpStatus.OK);
        }
        return new ResponseEntity<>("Debe eliminar los medicos asociados", HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>("Debe eliminar los procedimientos asociados", HttpStatus.NOT_FOUND);
      
    }
    return new ResponseEntity<>("Especialidad No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{especialidadId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long especialidadId) {
    Especialidad especialidaddb = especialidadService.findById(especialidadId);
    if (especialidaddb != null) {
      return new ResponseEntity<>(especialidaddb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Especialidad No Existe", HttpStatus.NOT_FOUND);
  }
}
