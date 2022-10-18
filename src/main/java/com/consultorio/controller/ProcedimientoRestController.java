package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Procedimiento;
import com.consultorio.services.ProcedimientoService;
@RestController
@RequestMapping("/procedimiento")
public class ProcedimientoRestController {
  @Autowired
  private ProcedimientoService procedimientoService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Procedimiento> procedimientodb = procedimientoService.findAll();
    if (procedimientodb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(procedimientodb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Procedimiento procedimiento) {
    procedimientoService.insert(procedimiento);
    return new ResponseEntity<>("Procedimiento Registrado", HttpStatus.CREATED);
  }

  @PutMapping("/editar/{procedimientoId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long procedimientoId, @RequestBody Procedimiento procedimiento) {
    Procedimiento procedimientodb = procedimientoService.findById(procedimientoId);
    if (procedimientodb != null) {
      procedimiento.setId(procedimientoId);
      procedimientoService.update(procedimiento);
      return new ResponseEntity<>("Procedimiento Editado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Procedimiento No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{procedimientoId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long procedimientoId) {
    Procedimiento procedimientodb = procedimientoService.findById(procedimientoId);
    if (procedimientodb != null) {
      procedimientoService.delete(procedimientoId);
      return new ResponseEntity<>("Procedimiento Eliminado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Procedimiento No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{procedimientoId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long procedimientoId) {
    Procedimiento procedimientodb = procedimientoService.findById(procedimientoId);
    if (procedimientodb != null) {
      return new ResponseEntity<>(procedimientodb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Procedimiento No Existe", HttpStatus.NOT_FOUND);
  }
}
