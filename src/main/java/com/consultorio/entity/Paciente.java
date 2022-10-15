package com.consultorio.entity;

import java.io.Serializable;

import java.util.*;


import javax.persistence.*;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "Paciente")
@Table(name = "Paciente")
public class Paciente implements Serializable {
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
  @Column(name = "direccion",nullable = false)
  private String direccion;
  @Column(name = "telefono",nullable = false,length = 9)
  private String telefono;
  @Column(name = "correo",nullable = false)
  private String correo;
  @ManyToOne
  @JoinColumn(name = "pais_id",nullable = false)
  private Pais pais;

  @ManyToOne
  @JoinColumn(name = "estadocivil_id", nullable = false)
  private EstadoCivil estadoCivil;
  //sexo
  @ManyToOne
  @JoinColumn(name = "sexo_id", nullable = false)
  private Sexo sexo;
  //usuario
  @OneToOne
  @JoinColumn(name = "usuario_id", nullable = false)
  private Usuario usuario;
  //citas
  @Builder.Default
  @OneToMany(mappedBy = "paciente")
  private Set<Cita> itemsCita=new HashSet<>();


  //control de salud
  @OneToOne
  @JoinColumn(name = "contactoemergencia_id", nullable = true, unique = true)
  private ContactoEmergencia contactoEmergencia;
  @OneToOne
  @JoinColumn(name = "contactomedico_id", nullable = true, unique = true)
  private ContactoMedico contactoMedico;
  @OneToOne
  @JoinColumn(name = "enfermedad_id", nullable = true, unique = true)
  private Enfermedad enfermedad;
  @OneToOne
  @JoinColumn(name = "medicina_id", nullable = true, unique = true)
  private Medicina medicina;
  @OneToOne
  @JoinColumn(name = "alergia_id", nullable = true, unique = true)
  private Alergia alergia;
}
