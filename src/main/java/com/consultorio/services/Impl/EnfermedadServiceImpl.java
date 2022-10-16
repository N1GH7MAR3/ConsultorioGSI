package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Enfermedad;
import com.consultorio.repository.EnfermedadRepository;
import com.consultorio.services.EnfermedadService;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {
  @Autowired
  private EnfermedadRepository repository;

  @Override
  @Transactional
  public void insert(Enfermedad enfermedad) {
    repository.save(enfermedad);
  }

  @Override
  @Transactional
  public void edit(Enfermedad enfermedad) {
    repository.save(enfermedad);
  }

  @Override
  @Transactional
  public void delete(Long idenfermedad) {
    repository.deleteById(idenfermedad);
  }

  @Override
  @Transactional(readOnly = true)
  public Enfermedad findById(Long idenfermedad) {
    return repository.findById(idenfermedad).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Enfermedad> findAll() {
    return repository.findAll();
  }

}
