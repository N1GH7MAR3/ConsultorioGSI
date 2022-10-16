package com.consultorio.services;

import java.util.Collection;

import com.consultorio.entity.ContactoEmergencia;

public interface ContactoEmergenciaService {
  public abstract void insert(ContactoEmergencia contactoEmergencia);

  public abstract void edit(ContactoEmergencia contactoEmergencia);

  public abstract void delete(Long idcontactoemergencia);

  public abstract ContactoEmergencia findById(Long idcontactoemergencia);

  public abstract Collection<ContactoEmergencia> findAll();
  
}
