package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.ContactoMedico;

public interface ContactoMedicoService {
  public abstract void insert(ContactoMedico contactoMedico);

  public abstract void edit(ContactoMedico contactoMedico);

  public abstract void delete(Integer idcontactomedico);

  public abstract ContactoMedico findById(Integer idcontactomedico);

  public abstract Collection<ContactoMedico> findAll();
}
