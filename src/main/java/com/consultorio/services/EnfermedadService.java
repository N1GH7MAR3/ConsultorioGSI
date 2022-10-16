package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Enfermedad;

public interface EnfermedadService {
  public abstract void insert(Enfermedad enfermedad);

  public abstract void edit(Enfermedad enfermedad);

  public abstract void delete(Long idenfermedad);

  public abstract Enfermedad findById(Long idenfermedad);

  public abstract Collection<Enfermedad> findAll();
}
