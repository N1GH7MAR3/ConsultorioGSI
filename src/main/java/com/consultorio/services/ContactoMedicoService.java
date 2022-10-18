package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.ContactoMedico;

public interface ContactoMedicoService {
  public abstract void insert(ContactoMedico contactoMedico);

  public abstract void update(ContactoMedico contactoMedico);

  public abstract void delete(Long idcontactomedico);

  public abstract ContactoMedico findById(Long idcontactomedico);

  public abstract Collection<ContactoMedico> findAll();
}
