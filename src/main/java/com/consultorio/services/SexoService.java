package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Sexo;

public interface SexoService {
  public abstract void insert(Sexo sexo);

  public abstract void edit(Sexo sexo);

  public abstract void delete(Integer idsexo);

  public abstract Sexo findById(Integer idsexo);

  public abstract Collection<Sexo> findAll();
}
