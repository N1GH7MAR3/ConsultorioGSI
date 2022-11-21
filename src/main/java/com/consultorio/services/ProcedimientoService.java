package com.consultorio.services;

import java.util.Collection;


import com.consultorio.entity.Procedimiento;


public interface ProcedimientoService {
  public abstract void insert(Procedimiento procedimiento);

  public abstract void update(Procedimiento procedimiento);

  public abstract void delete(Long idprocedimiento);

  public abstract Procedimiento findById(Long idprocedimiento);
  public abstract Procedimiento findByNombre(String nombre);


  public abstract Collection<Procedimiento> findAll();

  public abstract Collection<Procedimiento> findByEspecialidad(String nombre);

}
