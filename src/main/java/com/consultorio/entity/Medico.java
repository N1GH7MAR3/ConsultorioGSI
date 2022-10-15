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

@Entity(name = "Medico")
@Table(name = "Medico")


public class Medico implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @Column(name = "apellido_paterno", nullable = false)
  private String apellido_paterno;
  @Column(name = "apellido_materno", nullable = false)
  private String apellido_materno;
  @Column(name = "dni", nullable = false, unique = true,length = 8)
  private String dni;
  @ManyToOne
  @JoinColumn(name = "pais_id",nullable = false)
  private Pais pais;
  //estado civil por defecto soltero
  @ManyToOne
  @JoinColumn(name = "estadocivil_id", nullable = false)
  private EstadoCivil estadoCivil;
  //sexo
  @ManyToOne
  @JoinColumn(name = "sexo_id", nullable = false)
  private Sexo sexo;
  @ManyToOne
  @JoinColumn(name = "turno_id",nullable = false)
  private Turno turno;
  @ManyToOne
  @JoinColumn(name = "horario_id",nullable = false)
  private Horario horario;
  @Builder.Default
  @OneToMany(mappedBy = "medico")
  private Set<Tecnico>itemsTecnico=new HashSet<>();
  @ManyToOne
  @JoinColumn(name = "especialidad_id",nullable = false)
  private Especialidad especialidad;

  
}
