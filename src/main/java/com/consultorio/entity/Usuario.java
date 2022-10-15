package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "Usuario")
@Table(name = "Usuario")
public class Usuario implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "usuario",nullable = false,unique = true)
  private String usuario;
  @Column(name = "contraseña",nullable = false)
  private String constraseña;
  private boolean estado;
  @ManyToOne
  @JoinColumn(name = "id_rol",nullable = true)
  private Rol rol;
  @OneToOne(mappedBy = "usuario")
  private Paciente paciente;


  

  

}
