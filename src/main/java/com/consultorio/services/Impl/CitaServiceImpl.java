package com.consultorio.services.Impl;

import java.util.Collection;

import com.consultorio.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Cita;

import com.consultorio.services.CitaService;

@Service
public class CitaServiceImpl implements CitaService {
  @Autowired
  private CitaRepository repository;

  @Override
  @Transactional
  public void insert(Cita cita) {
    repository.save(cita);
  }

  @Override
  @Transactional
  public void update(Cita cita) {
    repository.save(cita);
  }

  @Override
  @Transactional
  public void delete(Long idcita) {
    repository.deleteById(idcita);
  }

  @Override
  @Transactional(readOnly = true)
  public Cita findById(Long idcita) {
    return repository.findById(idcita).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Cita> findAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Cita findByDni(Integer dni) {
    return repository.findByDni(dni);
  }
}
