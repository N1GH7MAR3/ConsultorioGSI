package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Turno;

public interface TurnoService {
  public abstract void insert(Turno turno);

  public abstract void edit(Turno turno);

  public abstract void delete(Integer idturno);

  public abstract Turno findById(Integer idturno);

  public abstract Collection<Turno> findAll();
}
