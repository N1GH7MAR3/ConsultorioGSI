package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Medicina;

public interface MedicinaService {
  public abstract void insert(Medicina medicina);

  public abstract void edit(Medicina medicina);

  public abstract void delete(Integer idmedicina);

  public abstract Medicina findById(Integer idmedicina);

  public abstract Collection<Medicina> findAll();
}
