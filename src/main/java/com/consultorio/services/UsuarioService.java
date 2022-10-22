package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Usuario;

public interface UsuarioService {
  public abstract void insert(Usuario usuario);

  public abstract void update(Usuario usuario);

  public abstract void delete(Long idusuario);

  public abstract Usuario findById(Long idusuario);

  public abstract Collection<Usuario> findAll();

  public abstract Usuario findByUserandPassword(String usuario, String contraseña);
  public abstract Usuario findUsuario(String usuario);
  

}
