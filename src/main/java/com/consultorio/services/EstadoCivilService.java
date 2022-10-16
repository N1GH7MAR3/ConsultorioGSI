package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.EstadoCivil;

public interface EstadoCivilService {
  public abstract void insert(EstadoCivil estadoCivil);

  public abstract void edit(EstadoCivil estadoCivil);

  public abstract void delete(Long idestadocivil);

  public abstract EstadoCivil findById(Long idestadocivil);

  public abstract Collection<EstadoCivil> findAll();
}
