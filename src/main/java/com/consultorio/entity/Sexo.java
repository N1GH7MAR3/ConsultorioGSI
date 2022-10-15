package com.consultorio.entity;
import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Sexo")
@Table(name = "Sexo")
public class Sexo implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @OneToOne(mappedBy = "sexo")
  private Paciente paciente;
  @OneToOne(mappedBy = "sexo")
  private Medico medico;
  @OneToOne(mappedBy = "sexo")
  private Tecnico tecnico;


  
}
