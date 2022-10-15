package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Sexo;
import com.consultorio.repository.SexoRepository;
import com.consultorio.services.SexoService;

@Service
public class SexoServiceImpl implements SexoService {
  @Autowired
  private SexoRepository repository;

  @Override
  @Transactional
  public void insert(Sexo sexo) {
    repository.save(sexo);
  }

  @Override
  @Transactional
  public void edit(Sexo sexo) {
    repository.save(sexo);
  }

  @Override
  @Transactional
  public void delete(Long idsexo) {
    repository.deleteById(idsexo);
  }

  @Override
  @Transactional(readOnly = true)
  public Sexo findById(Long idsexo) {
    return repository.findById(idsexo).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Sexo> findAll() {
    return repository.findAll();
  }

}
