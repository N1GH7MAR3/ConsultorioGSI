package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Pais;

public interface PaisService {
  public abstract void insert(Pais pais);

  public abstract void edit(Pais pais);

  public abstract void delete(Integer idpais);

  public abstract Pais findById(Integer idpais);

  public abstract Collection<Pais> findAll();
}
