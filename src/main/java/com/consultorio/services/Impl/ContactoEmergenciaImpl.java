package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.ContactoEmergencia;
import com.consultorio.repository.ContactoEmergenciaRepository;
import com.consultorio.services.ContactoEmergenciaService;

@Service
public class ContactoEmergenciaImpl implements ContactoEmergenciaService {
  @Autowired
  private ContactoEmergenciaRepository repository;

  @Override
  @Transactional
  public void insert(ContactoEmergencia contactoEmergencia) {
    repository.save(contactoEmergencia);
  }

  @Override
  @Transactional
  public void update(ContactoEmergencia contactoEmergencia) {
    repository.save(contactoEmergencia);
  }

  @Override
  @Transactional
  public void delete(Long idcontactoemergencia) {
    repository.deleteById(idcontactoemergencia);
  }

  @Override
  @Transactional(readOnly = true)
  public ContactoEmergencia findById(Long idcontactoemergencia) {
    return repository.findById(idcontactoemergencia).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<ContactoEmergencia> findAll() {
    return repository.findAll();
  }

}
