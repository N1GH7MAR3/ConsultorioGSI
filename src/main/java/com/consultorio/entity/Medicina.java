package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;



@Entity(name = "Medicina")
@Table(name = "Medicina")

public class Medicina implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "descripcion", nullable = true)
  private String descripcion;


  public Medicina() {
  }

  public Medicina(long id, String descripcion) {
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
