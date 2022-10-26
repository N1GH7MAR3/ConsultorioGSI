package com.consultorio.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.consultorio.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico,Long>{
  @Query(value="select * from Medico m join Especialidad e on e.id=m.especialidad_id where e.nombre=(:nombre)",nativeQuery =true)
    Collection<Medico> findByEspecialidad(@Param("nombre") String nombre);
}
