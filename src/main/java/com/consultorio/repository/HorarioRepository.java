package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Horario;

public interface HorarioRepository extends JpaRepository<Horario,Integer>{
  
}
