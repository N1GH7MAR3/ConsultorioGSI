package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.EstadoCivil;
import com.consultorio.repository.EstadoCivilRepository;
import com.consultorio.services.EstadoCivilService;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {
  @Autowired
  private EstadoCivilRepository repository;

  @Override
  @Transactional
  public void insert(EstadoCivil estadoCivil) {
    repository.save(estadoCivil);
  }

  @Override
  @Transactional
  public void update(EstadoCivil estadoCivil) {
    repository.save(estadoCivil);
  }

  @Override
  @Transactional
  public void delete(Long idestadocivil) {
    repository.deleteById(idestadocivil);
  }

  @Override
  @Transactional(readOnly = true)
  public EstadoCivil findById(Long idestadocivil) {
    return repository.findById(idestadocivil).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<EstadoCivil> findAll() {
    return repository.findAll();
  }

}
