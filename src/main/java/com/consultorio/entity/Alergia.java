package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "Alergia")
@Table(name = "Alergia")
public class Alergia implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "descripcion",nullable = true)
  private String descripcion;
  @OneToOne(mappedBy = "alergia")
  private Paciente paciente;
  
}
