package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico,Integer>{
  
}
