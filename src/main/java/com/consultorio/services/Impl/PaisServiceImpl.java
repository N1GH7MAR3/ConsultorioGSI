package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Pais;
import com.consultorio.repository.PaisRepository;
import com.consultorio.services.PaisService;

@Service
public class PaisServiceImpl implements PaisService {
  @Autowired
  private PaisRepository repository;

  @Override
  @Transactional
  public void insert(Pais pais) {
    repository.save(pais);
  }

  @Override
  @Transactional
  public void update(Pais pais) {
    repository.save(pais);
  }

  @Override
  @Transactional
  public void delete(Long idpais) {
    repository.deleteById(idpais);
  }

  @Override
  @Transactional(readOnly = true)
  public Pais findById(Long idpais) {
    return repository.findById(idpais).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Pais> findAll() {
    return repository.findAll();
  }

}
