package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Turno;

public interface TurnoService {
  public abstract void insert(Turno turno);

  public abstract void update(Turno turno);

  public abstract void delete(Long idturno);

  public abstract Turno findById(Long idturno);

  public abstract Collection<Turno> findAll();
}
