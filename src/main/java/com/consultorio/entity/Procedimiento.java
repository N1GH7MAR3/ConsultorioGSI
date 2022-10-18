package com.consultorio.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Procedimiento")
@Table(name = "Procedimiento")

public class Procedimiento implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  //@JsonManagedReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "especialidad_id", nullable = false)
  private Especialidad especialidad;
  // @JsonBackReference
  // @OneToMany(mappedBy = "procedimiento")
  // private Set<Cita> itemsCita = new HashSet<>();

  public Procedimiento() {
  }

  public Procedimiento(long id, String nombre, Especialidad especialidad, Set<Cita> itemsCita) {
    this.id = id;
    this.nombre = nombre;
    this.especialidad = especialidad;
    //this.itemsCita = itemsCita;
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

  public Especialidad getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(Especialidad especialidad) {
    this.especialidad = especialidad;
  }

  // public Set<Cita> getItemsCita() {
  //   return itemsCita;
  // }

  // public void setItemsCita(Set<Cita> itemsCita) {
  //   this.itemsCita = itemsCita;
  // }

}
