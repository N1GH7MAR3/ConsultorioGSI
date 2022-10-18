package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Medicina")
@Table(name = "Medicina")

public class Medicina implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "descripcion", nullable = true)
  private String descripcion;
  // @JsonBackReference
  // @OneToOne(mappedBy = "medicina")
  // private Paciente paciente;

  public Medicina() {
  }

  public Medicina(long id, String descripcion, Paciente paciente) {
    this.id = id;
    this.descripcion = descripcion;
    // this.paciente = paciente;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  // public Paciente getPaciente() {
  //   return paciente;
  // }

  // public void setPaciente(Paciente paciente) {
  //   this.paciente = paciente;
  // }

}
