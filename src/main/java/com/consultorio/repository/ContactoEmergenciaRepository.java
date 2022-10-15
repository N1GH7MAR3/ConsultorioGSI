package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.ContactoEmergencia;

public interface ContactoEmergenciaRepository extends JpaRepository<ContactoEmergencia,Long>{
  
}
