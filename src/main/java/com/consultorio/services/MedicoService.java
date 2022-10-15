package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Medico;

public interface MedicoService {
  public abstract void insert(Medico medico);

  public abstract void edit(Medico medico);

  public abstract void delete(Integer idmedico);

  public abstract Medico findById(Integer idmedico);

  public abstract Collection<Medico> findAll();
}
