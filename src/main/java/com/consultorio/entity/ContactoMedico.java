package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "ContactoMedico")
@Table(name = "ContactoMedico")
public class ContactoMedico implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "descripcion",nullable = true)
  private String descripcion;
  @OneToOne(mappedBy = "contactoMedico")
  private Paciente paciente;
  
}
