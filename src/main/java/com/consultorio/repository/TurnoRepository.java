package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Turno;

public interface TurnoRepository extends JpaRepository<Turno,Long>{
  
}
