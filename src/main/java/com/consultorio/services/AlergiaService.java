package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Alergia;

public interface AlergiaService {
  public abstract void insert(Alergia alergia);

  public abstract void edit(Alergia alergia);

  public abstract void delete(Long idalergia);

  public abstract Alergia findById(Long idalergia);

  public abstract Collection<Alergia> findAll();
  
}
