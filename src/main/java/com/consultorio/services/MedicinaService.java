package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Medicina;

public interface MedicinaService {
  public abstract void insert(Medicina medicina);

  public abstract void update(Medicina medicina);

  public abstract void delete(Long idmedicina);

  public abstract Medicina findById(Long idmedicina);

  public abstract Collection<Medicina> findAll();
}
