package com.consultorio.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Especialidad")
@Table(name = "Especialidad")

public class Especialidad implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  // @JsonBackReference
  // @OneToMany(mappedBy = "especialidad")
  // private Set<Medico> itemsMedico = new HashSet<>();
  // @JsonBackReference
  // @OneToMany(mappedBy = "especialidad")
  // private Set<Tecnico> itemsTecnico = new HashSet<>();
  // @JsonBackReference
  // @OneToMany(mappedBy = "especialidad")
  // private Set<Cita> itemsCita = new HashSet<>();
  // @JsonBackReference
  // @OneToMany(mappedBy = "especialidad")
  // private Set<Procedimiento> itemsProdecimiento = new HashSet<>();

  public Especialidad() {
  }

  public Especialidad(long id, String nombre, Set<Medico> itemsMedico, Set<Tecnico> itemsTecnico, Set<Cita> itemsCita,
      Set<Procedimiento> itemsProdecimiento) {
    this.id = id;
    this.nombre = nombre;
    // this.itemsMedico = itemsMedico;
    // this.itemsTecnico = itemsTecnico;
    // this.itemsCita = itemsCita;
    // this.itemsProdecimiento = itemsProdecimiento;
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

  // public Set<Medico> getItemsMedico() {
  //   return itemsMedico;
  // }

  // public void setItemsMedico(Set<Medico> itemsMedico) {
  //   this.itemsMedico = itemsMedico;
  // }

  // public Set<Tecnico> getItemsTecnico() {
  //   return itemsTecnico;
  // }

  // public void setItemsTecnico(Set<Tecnico> itemsTecnico) {
  //   this.itemsTecnico = itemsTecnico;
  // }

  // public Set<Cita> getItemsCita() {
  //   return itemsCita;
  // }

  // public void setItemsCita(Set<Cita> itemsCita) {
  //   this.itemsCita = itemsCita;
  // }

  // public Set<Procedimiento> getItemsProdecimiento() {
  //   return itemsProdecimiento;
  // }

  // public void setItemsProdecimiento(Set<Procedimiento> itemsProdecimiento) {
  //   this.itemsProdecimiento = itemsProdecimiento;
  // }

}
