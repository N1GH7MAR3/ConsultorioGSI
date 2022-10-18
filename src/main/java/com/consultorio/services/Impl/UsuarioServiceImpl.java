package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Usuario;
import com.consultorio.repository.UsuarioRepository;
import com.consultorio.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
  @Autowired
  private UsuarioRepository repository;

  @Override
  @Transactional
  public void insert(Usuario usuario) {
    repository.save(usuario);
  }

  @Override
  @Transactional
  public void update(Usuario usuario) {
    repository.save(usuario);
  }

  @Override
  @Transactional
  public void delete(Long idusuario) {
    repository.deleteById(idusuario);
  }

  @Override
  @Transactional(readOnly = true)
  public Usuario findById(Long idusuario) {
    return repository.findById(idusuario).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Usuario> findAll() {
    return repository.findAll();
  }

}
