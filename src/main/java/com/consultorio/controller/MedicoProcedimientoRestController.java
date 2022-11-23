package com.consultorio.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.entity.Medico;
import com.consultorio.entity.Procedimiento;
import com.consultorio.relationship.MedicosProcedimientos;
import com.consultorio.services.MedicoService;
import com.consultorio.services.ProcedimientoService;

@RestController
@RequestMapping("/medico_procedimiento")
public class MedicoProcedimientoRestController {
  @Autowired
  private MedicoService medicoService;
  @Autowired
  private ProcedimientoService procedimientoService;
  
  @GetMapping("/listarpxm/{id}")
  public ResponseEntity<?> listar_GET(@PathVariable Long id) {
    Medico mediodb = medicoService.findById(id);
    if (mediodb != null) {
      Collection<Procedimiento>procedimientos=mediodb.getProcedimientos();
      return new ResponseEntity<>(procedimientos, HttpStatus.OK);
    }
    return new ResponseEntity<>("No existe el medico", HttpStatus.NOT_FOUND);
  }
  @GetMapping("/listarmxp/{idp}")
  public ResponseEntity<?> listar_GET_Pro(@PathVariable Long idp) {

    Procedimiento procedimientodb=procedimientoService.findById(idp);
    if(procedimientodb!=null){
      Collection<Medico>medicos=procedimientodb.getMedicos();
      return new ResponseEntity<>(medicos, HttpStatus.OK);
    }
    return new ResponseEntity<>("No existe el Procedimiento", HttpStatus.NOT_FOUND);
  }
  
}
