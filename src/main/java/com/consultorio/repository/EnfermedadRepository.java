package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Enfermedad;

public interface EnfermedadRepository extends JpaRepository<Enfermedad,Long>{
  
}
