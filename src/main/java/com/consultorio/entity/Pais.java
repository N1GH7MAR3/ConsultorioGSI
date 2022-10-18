package com.consultorio.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Pais")
@Table(name = "Pais")

public class Pais implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  // @JsonBackReference
  // @OneToMany(mappedBy = "pais")
  // private Set<Paciente> itemspaciente = new HashSet<>();
  // @JsonBackReference
  // @OneToMany(mappedBy = "pais")
  // private Set<Medico> itemsmedico = new HashSet<>();
  // @JsonBackReference
  // @OneToMany(mappedBy = "pais")
  // private Set<Tecnico> itemstecnico = new HashSet<>();

  public Pais() {
  }

  public Pais(long id, String nombre, Set<Paciente> itemspaciente, Set<Medico> itemsmedico, Set<Tecnico> itemstecnico) {
    this.id = id;
    this.nombre = nombre;
    // this.itemspaciente = itemspaciente;
    // this.itemsmedico = itemsmedico;
    // this.itemstecnico = itemstecnico;
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

  // public Set<Paciente> getItemspaciente() {
  //   return itemspaciente;
  // }

  // public void setItemspaciente(Set<Paciente> itemspaciente) {
  //   this.itemspaciente = itemspaciente;
  // }

  // public Set<Medico> getItemsmedico() {
  //   return itemsmedico;
  // }

  // public void setItemsmedico(Set<Medico> itemsmedico) {
  //   this.itemsmedico = itemsmedico;
  // }

  // public Set<Tecnico> getItemstecnico() {
  //   return itemstecnico;
  // }

  // public void setItemstecnico(Set<Tecnico> itemstecnico) {
  //   this.itemstecnico = itemstecnico;
  // }

}
