package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.Horario;
import com.consultorio.repository.HorarioRepository;
import com.consultorio.services.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {
  @Autowired
  private HorarioRepository repository;

  @Override
  @Transactional
  public void insert(Horario horario) {
    repository.save(horario);
  }

  @Override
  @Transactional
  public void edit(Horario horario) {
    repository.save(horario);
  }

  @Override
  @Transactional
  public void delete(Long idhorario) {
    repository.deleteById(idhorario);
  }

  @Override
  @Transactional(readOnly = true)
  public Horario findById(Long idhorario) {
    return repository.findById(idhorario).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Horario> findAll() {
    return repository.findAll();
  }

}
