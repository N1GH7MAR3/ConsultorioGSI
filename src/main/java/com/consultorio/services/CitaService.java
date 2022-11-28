package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.Cita;

public interface CitaService {
  public abstract void insert(Cita cita);

  public abstract void update(Cita cita);

  public abstract void delete(Long idcita);

  public abstract Cita findById(Long idcita);

  public abstract Collection<Cita> findAll();

  public abstract Collection<Cita> findByDni(Integer dni);
  public abstract Cita findCitas(String fechacita,Long idespecialidad,Long medicoid,Long idprocedimiento);
}
