package com.consultorio.services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.entity.ContactoMedico;
import com.consultorio.repository.ContactoMedicoRepository;
import com.consultorio.services.ContactoMedicoService;

@Service
public class ContactoMedicoImpl implements ContactoMedicoService {
  @Autowired
  private ContactoMedicoRepository repository;

  @Override
  @Transactional
  public void insert(ContactoMedico contactoMedico) {
    repository.save(contactoMedico);
  }

  @Override
  @Transactional
  public void update(ContactoMedico contactoMedico) {
    repository.save(contactoMedico);
  }

  @Override
  @Transactional
  public void delete(Long idcontactomedico) {
    repository.deleteById(idcontactomedico);
  }

  @Override
  @Transactional(readOnly = true)
  public ContactoMedico findById(Long idcontactomedico) {
    return repository.findById(idcontactomedico).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<ContactoMedico> findAll() {
    return repository.findAll();
  }

}
