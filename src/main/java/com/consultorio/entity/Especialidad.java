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

@Entity(name = "Especialidad")
@Table(name = "Especialidad")
public class Especialidad implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @Builder.Default
  @OneToMany(mappedBy = "especialidad")
  private Set<Medico>itemsMedico=new HashSet<>();
  @Builder.Default
  @OneToMany(mappedBy = "especialidad")
  private Set<Tecnico>itemsTecnico=new HashSet<>();
  @Builder.Default
  @OneToMany(mappedBy = "especialidad")
  private Set<Cita>itemsCita=new HashSet<>();
  @Builder.Default
  @OneToMany(mappedBy = "especialidad")
  private Set<Procedimiento>itemsProdecimiento=new HashSet<>();

}
