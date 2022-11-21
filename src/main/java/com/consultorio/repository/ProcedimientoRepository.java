package com.consultorio.repository;



import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.consultorio.entity.Procedimiento;

public interface ProcedimientoRepository extends JpaRepository<Procedimiento,Long>{
  @Query(value="select * from Procedimiento p join Especialidad e on e.id=p.especialidad_id where e.nombre=(:nombre)",nativeQuery =true)
    Collection<Procedimiento> findByEspecialidad(@Param("nombre") String nombre);
    Procedimiento findByNombre(@Param("nombre")String nombre);
}
