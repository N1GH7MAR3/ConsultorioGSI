package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.ContactoMedico;

public interface ContactoMedicoRepository extends JpaRepository<ContactoMedico,Long>{
  
}
