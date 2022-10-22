package com.consultorio.entity;

import java.io.Serializable;



import javax.persistence.*;



@Entity(name = "Especialidad")
@Table(name = "Especialidad")

public class Especialidad implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;


  public Especialidad() {
  }

  public Especialidad(long id, String nombre) {
    this.id = id;
    this.nombre = nombre;

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



}
