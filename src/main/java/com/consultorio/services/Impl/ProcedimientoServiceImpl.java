package com.consultorio.services.Impl;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Procedimiento;
import com.consultorio.repository.ProcedimientoRepository;
import com.consultorio.services.ProcedimientoService;

@Service
public class ProcedimientoServiceImpl implements ProcedimientoService {
  @Autowired
  private ProcedimientoRepository repository;

  @Override
  @Transactional
  public void insert(Procedimiento procedimiento) {
    repository.save(procedimiento);
  }

  @Override
  @Transactional
  public void update(Procedimiento procedimiento) {
    repository.save(procedimiento);
  }

  @Override
  @Transactional
  public void delete(Long idprocedimiento) {
    repository.deleteById(idprocedimiento);
  }

  @Override
  @Transactional(readOnly = true)
  public Procedimiento findById(Long idprocedimiento) {
    return repository.findById(idprocedimiento).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Procedimiento> findAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Procedimiento> findByEspecialidad(String nombre) {
    return repository.findByEspecialidad(nombre);
  }

  @Override
  @Transactional(readOnly = true)
  public Procedimiento findByNombre(String nombre) {
    return repository.findByNombre(nombre);
  }

  
  


}
