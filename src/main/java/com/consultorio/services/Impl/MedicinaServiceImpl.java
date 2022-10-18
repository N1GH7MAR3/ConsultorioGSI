package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Medicina;
import com.consultorio.repository.MedicinaRepository;
import com.consultorio.services.MedicinaService;

@Service
public class MedicinaServiceImpl implements MedicinaService {
  @Autowired
  private MedicinaRepository repository;

  @Override
  @Transactional
  public void insert(Medicina medicina) {
    repository.save(medicina);
  }

  @Override
  @Transactional
  public void update(Medicina medicina) {
    repository.save(medicina);
  }

  @Override
  @Transactional
  public void delete(Long idmedicina) {
    repository.deleteById(idmedicina);
  }

  @Override
  @Transactional(readOnly = true)
  public Medicina findById(Long idmedicina) {
    return repository.findById(idmedicina).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Medicina> findAll() {
    return repository.findAll();
  }

}
