package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico,Integer>{
  
}
