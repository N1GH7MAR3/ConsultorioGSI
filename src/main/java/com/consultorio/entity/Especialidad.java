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
  @Column(name = "image",nullable = true)
  private String image;


  public Especialidad() {
  }


  public Especialidad(long id, String nombre, String image) {
    this.id = id;
    this.nombre = nombre;
    this.image = image;
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


  public String getImage() {
    return image;
  }


  public void setImage(String image) {
    this.image = image;
  }

  



}
