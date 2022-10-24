package com.consultorio.services;

import java.util.Collection;
import java.util.Optional;

import com.consultorio.entity.Procedimiento;
import com.consultorio.entity.Usuario;

public interface ProcedimientoService {
  public abstract void insert(Procedimiento procedimiento);

  public abstract void update(Procedimiento procedimiento);

  public abstract void delete(Long idprocedimiento);

  public abstract Procedimiento findById(Long idprocedimiento);

  public abstract Collection<Procedimiento> findAll();

  public abstract Procedimiento findByEspecialidad(String nombre);

}
