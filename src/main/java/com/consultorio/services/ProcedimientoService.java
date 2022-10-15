package com.consultorio.services;

import java.util.Collection;



import com.consultorio.entity.Procedimiento;

public interface ProcedimientoService {
  public abstract void insert(Procedimiento procedimiento);

  public abstract void edit(Procedimiento procedimiento);

  public abstract void delete(Integer idprocedimiento);

  public abstract Procedimiento findById(Integer idprocedimiento);

  public abstract Collection<Procedimiento> findAll();
}
