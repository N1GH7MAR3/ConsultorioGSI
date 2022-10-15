package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ContactoEmergencia")
@Table(name = "ContactoEmergencia")
public class ContactoEmergencia implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "descripcion", nullable = true)
  private String descripcion;
  @OneToOne(mappedBy = "contactoEmergencia")
  private Paciente paciente;

}
