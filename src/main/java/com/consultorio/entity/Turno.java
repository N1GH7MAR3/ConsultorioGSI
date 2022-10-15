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
@Entity(name = "Turno")
@Table(name = "Turno")
public class Turno implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "turno", nullable = false)
  private String turno;
  @Builder.Default
  @OneToMany(mappedBy = "turno")
  private Set<Medico>itemsMedico=new HashSet<>();
  @Builder.Default
  @OneToMany(mappedBy = "turno")
  private Set<Tecnico>itemsTecnico=new HashSet<>();
  
}
