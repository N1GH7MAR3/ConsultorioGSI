package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Rol;

public interface RolService {
  public abstract void insert(Rol rol);

  public abstract void update(Rol rol);

  public abstract void delete(Long idrol);

  public abstract Rol findById(Long idrol);

  public abstract Collection<Rol> findAll();
}
