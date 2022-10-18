package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Sexo")
@Table(name = "Sexo")

public class Sexo implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  // @JsonBackReference
  // @OneToOne(mappedBy = "sexo")
  // private Paciente paciente;
  // @JsonBackReference
  // @OneToOne(mappedBy = "sexo")
  // private Medico medico;
  // @JsonBackReference
  // @OneToOne(mappedBy = "sexo")
  // private Tecnico tecnico;

  public Sexo() {
  }

  public Sexo(long id, String nombre, Paciente paciente, Medico medico, Tecnico tecnico) {
    this.id = id;
    this.nombre = nombre;
    // this.paciente = paciente;
    // this.medico = medico;
    // this.tecnico = tecnico;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  // public Paciente getPaciente() {
  //   return paciente;
  // }

  // public void setPaciente(Paciente paciente) {
  //   this.paciente = paciente;
  // }

  // public Medico getMedico() {
  //   return medico;
  // }

  // public void setMedico(Medico medico) {
  //   this.medico = medico;
  // }

  // public Tecnico getTecnico() {
  //   return tecnico;
  // }

  // public void setTecnico(Tecnico tecnico) {
  //   this.tecnico = tecnico;
  // }

}
