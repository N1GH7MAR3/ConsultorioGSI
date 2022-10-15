package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Procedimiento;

public interface ProcedimientoRepository extends JpaRepository<Procedimiento,Integer>{
  
}
