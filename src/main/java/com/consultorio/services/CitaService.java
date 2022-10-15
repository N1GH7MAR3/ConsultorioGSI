package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Cita;

public interface CitaService {
  public abstract void insert(Cita cita);

  public abstract void edit(Cita cita);

  public abstract void delete(Long idcita);

  public abstract Cita findById(Long idcita);

  public abstract Collection<Cita> findAll();
}
