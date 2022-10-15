package com.consultorio.entity;
import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "EstadoCivil")
@Table(name = "EstadoCivil")
public class EstadoCivil implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre",nullable = false,unique = true)
  private String nombre;
  @OneToOne(mappedBy = "estadoCivil")
  private Paciente paciente;
  @OneToOne(mappedBy = "estadoCivil")
  private Medico medico ;
  @OneToOne(mappedBy = "estadoCivil")
  private Tecnico tecnico ;
  
}
