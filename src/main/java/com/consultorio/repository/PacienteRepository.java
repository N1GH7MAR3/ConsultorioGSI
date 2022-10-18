package com.consultorio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.consultorio.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long>{
  @Query(value="select * from Paciente p where p.dni=(:dni)",nativeQuery = true)
    Paciente findByDni(@Param("dni") int dni);
}
