package com.consultorio.services;

import java.util.Collection;


import com.consultorio.entity.Paciente;

public interface PacienteService {
  public abstract void insert(Paciente paciente);

  public abstract void update(Paciente paciente);

  public abstract void delete(Long idpaciente);

  public abstract Paciente findById(Long idpaciente);

  public abstract Collection<Paciente> findAll();

  public abstract Paciente findByDni(Integer dni);
}
