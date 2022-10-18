package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Tecnico;
import com.consultorio.repository.TecnicoRepository;
import com.consultorio.services.TecnicoService;

@Service
public class TecnicoServiceImpl implements TecnicoService {
  @Autowired
  private TecnicoRepository repository;

  @Override
  @Transactional
  public void insert(Tecnico tecnico) {
    repository.save(tecnico);
  }

  @Override
  @Transactional
  public void update(Tecnico tecnico) {
    repository.save(tecnico);
  }

  @Override
  @Transactional
  public void delete(Long idtecnico) {
    repository.deleteById(idtecnico);
  }

  @Override
  @Transactional(readOnly = true)
  public Tecnico findById(Long idtecnico) {
    return repository.findById(idtecnico).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Tecnico> findAll() {
    return repository.findAll();
  }

}
