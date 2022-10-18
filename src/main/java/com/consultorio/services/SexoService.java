package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Sexo;

public interface SexoService {
  public abstract void insert(Sexo sexo);

  public abstract void update(Sexo sexo);

  public abstract void delete(Long idsexo);

  public abstract Sexo findById(Long idsexo);

  public abstract Collection<Sexo> findAll();
}
