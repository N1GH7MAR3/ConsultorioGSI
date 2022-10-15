package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Rol;

public interface RolService {
  public abstract void insert(Rol rol);

  public abstract void edit(Rol rol);

  public abstract void delete(Integer idrol);

  public abstract Rol findById(Integer idrol);

  public abstract Collection<Rol> findAll();
}
