package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
  
}
