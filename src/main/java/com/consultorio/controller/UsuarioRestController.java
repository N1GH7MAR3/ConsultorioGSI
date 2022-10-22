package com.consultorio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.consultorio.entity.Paciente;

import com.consultorio.entity.Usuario;
import com.consultorio.services.PacienteService;
import com.consultorio.services.UsuarioService;
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("/listar")
  public ResponseEntity<?> listar_GET() {
    Collection<Usuario> usuariodb = usuarioService.findAll();
    if (usuariodb.isEmpty()) {
      return new ResponseEntity<>("Lista Vacia", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(usuariodb, HttpStatus.OK);
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrar_POST(@RequestBody Usuario usuario) {
    usuarioService.insert(usuario);
    return new ResponseEntity<>("Usuario Registrado", HttpStatus.CREATED);
  }

  @PutMapping("/editar/{usuarioId}")
  public ResponseEntity<?> editar_PUT(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {
    Usuario usuariodb = usuarioService.findById(usuarioId);
    if (usuariodb != null) {
      usuario.setId(usuarioId);
      usuarioService.update(usuario);
      return new ResponseEntity<>("Usuario Editado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Usuario No Existe", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/borrar/{usuarioId}")
  public ResponseEntity<?> borrar_DELETE(@PathVariable Long usuarioId) {
    Usuario usuariodb = usuarioService.findById(usuarioId);
    if (usuariodb != null) {
      usuarioService.delete(usuarioId);
      return new ResponseEntity<>("Usuario Eliminado", HttpStatus.OK);
    }
    return new ResponseEntity<>("Usuario No Existe", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/buscar/{usuarioId}")
  public ResponseEntity<?> buscar_GET(@PathVariable Long usuarioId) {
    Usuario usuariodb = usuarioService.findById(usuarioId);
    if (usuariodb != null) {
      return new ResponseEntity<>(usuariodb, HttpStatus.FOUND);
    }
    return new ResponseEntity<>("Usuario No Existe", HttpStatus.NOT_FOUND);
  }

  @PostMapping("/buscaruser")
  public ResponseEntity<?> buscaruser(@RequestBody Usuario usuario){
    Usuario usuariodb=usuarioService.findByUserandPassword(usuario.getUsuario(), usuario.getContraseña());
    if (usuariodb != null) {
      return new ResponseEntity<>(usuariodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("0", HttpStatus.NOT_FOUND);
  }

  @PostMapping("/verifyuser")
  public ResponseEntity<?> verifyuser(@RequestBody Usuario usuario){
    
    Usuario usuariodb=usuarioService.findUsuario(usuario.getUsuario());
    if (usuariodb != null) {
      return new ResponseEntity<>(usuariodb, HttpStatus.OK);
    }
    return new ResponseEntity<>("0", HttpStatus.NOT_FOUND);
  }
}
