package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Pais;

public interface PaisService {
  public abstract void insert(Pais pais);

  public abstract void update(Pais pais);

  public abstract void delete(Long idpais);

  public abstract Pais findById(Long idpais);

  public abstract Collection<Pais> findAll();
}
