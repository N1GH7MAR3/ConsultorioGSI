package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Rol;

public interface RolRepository extends JpaRepository<Rol,Long>{
  
}
