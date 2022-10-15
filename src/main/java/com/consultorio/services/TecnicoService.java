package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Tecnico;

public interface TecnicoService {
  public abstract void insert(Tecnico tecnico);

  public abstract void edit(Tecnico tecnico);

  public abstract void delete(Integer idtecnico);

  public abstract Tecnico findById(Integer idtecnico);

  public abstract Collection<Tecnico> findAll();
}
