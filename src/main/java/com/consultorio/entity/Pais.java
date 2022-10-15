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
@Entity(name = "Pais")
@Table(name = "Pais")
public class Pais implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @Builder.Default
  @OneToMany(mappedBy = "pais")
  private Set<Paciente> itemspaciente=new HashSet<>();
  @Builder.Default
  @OneToMany(mappedBy = "pais")
  private Set<Medico> itemsmedico=new HashSet<>();
  @Builder.Default
  @OneToMany(mappedBy = "pais")
  private Set<Tecnico> itemstecnico=new HashSet<>();
  
}
