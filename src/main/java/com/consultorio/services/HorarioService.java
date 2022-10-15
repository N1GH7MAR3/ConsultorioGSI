package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Horario;

public interface HorarioService {
  public abstract void insert(Horario horario);

  public abstract void edit(Horario horario);

  public abstract void delete(Integer idhorario);

  public abstract Horario findById(Integer idhorario);

  public abstract Collection<Horario> findAll();
}
