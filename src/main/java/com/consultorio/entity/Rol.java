package com.consultorio.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "Rol")
@Table(name = "Rol")
public class Rol implements Serializable {

  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @Builder.Default
  @OneToMany(mappedBy = "rol")
  private Set<Usuario> itemsUsuario = new HashSet<>();

}
