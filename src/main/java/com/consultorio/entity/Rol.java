package com.consultorio.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Rol")
@Table(name = "Rol")

public class Rol implements Serializable {

  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  // @JsonBackReference
  // @OneToMany(mappedBy = "rol")
  // private Set<Usuario> itemsUsuario = new HashSet<>();

  public Rol() {
  }

  public Rol(long id, String nombre, Set<Usuario> itemsUsuario) {
    this.id = id;
    this.nombre = nombre;
    //this.itemsUsuario = itemsUsuario;
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

  // public Set<Usuario> getItemsUsuario() {
  //   return itemsUsuario;
  // }

  // public void setItemsUsuario(Set<Usuario> itemsUsuario) {
  //   this.itemsUsuario = itemsUsuario;
  // }

}
