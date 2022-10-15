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

@Entity(name = "Procedimiento")
@Table(name = "Procedimiento")
public class Procedimiento implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @ManyToOne
  @JoinColumn(name = "especialidad_id",nullable = false)
  private Especialidad especialidad;
  @Builder.Default
  @OneToMany(mappedBy = "procedimiento")
  private Set<Cita>itemsCita=new HashSet<>();
  
}
