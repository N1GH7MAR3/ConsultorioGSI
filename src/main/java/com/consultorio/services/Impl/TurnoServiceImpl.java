package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Turno;
import com.consultorio.repository.TurnoRepository;
import com.consultorio.services.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService {
  @Autowired
  private TurnoRepository repository;

  @Override
  @Transactional
  public void insert(Turno turno) {
    repository.save(turno);
  }

  @Override
  @Transactional
  public void edit(Turno turno) {
    repository.save(turno);
  }

  @Override
  @Transactional
  public void delete(Long idturno) {
    repository.deleteById(idturno);
  }

  @Override
  @Transactional(readOnly = true)
  public Turno findById(Long idturno) {
    return repository.findById(idturno).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Turno> findAll() {
    return repository.findAll();
  }

}
