package com.consultorio.services.Impl;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Paciente;
import com.consultorio.repository.PacienteRepository;
import com.consultorio.services.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
  @Autowired
  private PacienteRepository repository;

  @Override
  @Transactional
  public void insert(Paciente paciente) {
    repository.save(paciente);
  }

  @Override
  @Transactional
  public void update(Paciente paciente) {
    repository.save(paciente);
  }

  @Override
  @Transactional
  public void delete(Long idpaciente) {
    repository.deleteById(idpaciente);
  }

  @Override
  @Transactional(readOnly = true)
  public Paciente findById(Long idpaciente) {
    return repository.findById(idpaciente).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Paciente> findAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Paciente findByDni(Integer dni) {
    return repository.findByDni(dni);
  }

}
