package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Medico;
import com.consultorio.repository.MedicoRepository;
import com.consultorio.services.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
  @Autowired
  private MedicoRepository repository;

  @Override
  @Transactional
  public void insert(Medico medico) {
    repository.save(medico);
  }

  @Override
  @Transactional
  public void edit(Medico medico) {
    repository.save(medico);
  }

  @Override
  @Transactional
  public void delete(Long idmedico) {
    repository.deleteById(idmedico);
  }

  @Override
  @Transactional(readOnly = true)
  public Medico findById(Long idmedico) {
    return repository.findById(idmedico).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Medico> findAll() {
    return repository.findAll();
  }

}
