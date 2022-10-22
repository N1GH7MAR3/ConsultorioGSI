package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;



// @JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Alergia")
@Table(name = "Alergia")

public class Alergia implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "descripcion", nullable = true)
  private String descripcion;


  public Alergia() {
  }

  public Alergia(long id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
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



}
