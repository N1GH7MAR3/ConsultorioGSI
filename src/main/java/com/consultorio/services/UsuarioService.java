package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Usuario;

public interface UsuarioService {
  public abstract void insert(Usuario usuario);

  public abstract void edit(Usuario usuario);

  public abstract void delete(Integer idusuario);

  public abstract Usuario findById(Integer idusuario);

  public abstract Collection<Usuario> findAll();

}
