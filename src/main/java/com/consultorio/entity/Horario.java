package com.consultorio.entity;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Horario")
@Table(name = "Horario")
public class Horario implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "horaingreso",nullable = false)
  private LocalTime horaingreso;
  @Column(name = "horasalida",nullable = false)
  private LocalTime horasalida;
  @Builder.Default
  @OneToMany(mappedBy = "horario")
  private Set<Medico>itemsMedico=new HashSet<>();
  @Builder.Default
  @OneToMany(mappedBy = "horario")
  private Set<Tecnico>itemsTecnico=new HashSet<>();
  
}
