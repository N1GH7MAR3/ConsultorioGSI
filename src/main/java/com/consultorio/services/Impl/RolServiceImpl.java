package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Rol;
import com.consultorio.repository.RolRepository;
import com.consultorio.services.RolService;

@Service
public class RolServiceImpl implements RolService {
  @Autowired
  private RolRepository repository;

  @Override
  @Transactional
  public void insert(Rol rol) {
    repository.save(rol);
  }

  @Override
  @Transactional
  public void update(Rol rol) {
    repository.save(rol);
  }

  @Override
  @Transactional
  public void delete(Long idrol) {
    repository.deleteById(idrol);
  }

  @Override
  @Transactional(readOnly = true)
  public Rol findById(Long idrol) {

    return repository.findById(idrol).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Rol> findAll() {
    return repository.findAll();
  }

}
