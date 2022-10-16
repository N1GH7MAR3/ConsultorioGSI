package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Especialidad;
import com.consultorio.repository.EspecialidadRepository;
import com.consultorio.services.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
  @Autowired
  private EspecialidadRepository repository;

  @Override
  @Transactional
  public void insert(Especialidad especialidad) {
    repository.save(especialidad);
  }

  @Override
  @Transactional
  public void edit(Especialidad especialidad) {
    repository.save(especialidad);
  }

  @Override
  @Transactional
  public void delete(Long idespecialidad) {
    repository.deleteById(idespecialidad);
  }

  @Override
  @Transactional(readOnly = true)
  public Especialidad findById(Long idespecialidad) {
    return repository.findById(idespecialidad).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Especialidad> findAll() {
    return repository.findAll();
  }

}
