package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.consultorio.entity.Paciente;
import com.consultorio.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
  @Query(value="select * from Usuario u where u.usuario=(:usuario) and u.contraseña=(:contraseña)",nativeQuery = true)
    Usuario findByUserandPassword(@Param("usuario") String usuario,@Param("contraseña")String contraseña);

    @Query(value="select * from Usuario u where u.usuario=(:usuario)",nativeQuery = true)
    Usuario findUsuario(@Param("usuario") String usuario);
    
    @Query(value="select * from Paciente p join Usuario u on u.id=p.usuario_id where u.usuario=(:usuario)",nativeQuery = true)
    Paciente findByUser(@Param("usuario") String usuario);

}
