package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Alergia;
import com.consultorio.repository.AlergiaRepository;
import com.consultorio.services.AlergiaService;

@Service
public class AlergiaServiceImpl implements AlergiaService {

  @Autowired
  private AlergiaRepository repository;

  @Override
  @Transactional
  public void insert(Alergia alergia) {
    repository.save(alergia);

  }

  @Override
  @Transactional
  public void edit(Alergia alergia) {
    repository.save(alergia);
  }

  @Override
  @Transactional
  public void delete(Long idalergia) {
    repository.deleteById(idalergia);
  }

  @Override
  @Transactional(readOnly = true)
  public Alergia findById(Long idalergia) {
    return repository.findById(idalergia).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Alergia> findAll() {
    return repository.findAll();
  }

}
