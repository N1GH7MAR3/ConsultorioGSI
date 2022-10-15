package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Medicina;

public interface MedicinaRepository extends JpaRepository<Medicina,Integer>{
  
}
