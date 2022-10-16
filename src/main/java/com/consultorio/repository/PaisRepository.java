package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais,Long>{
  
}
