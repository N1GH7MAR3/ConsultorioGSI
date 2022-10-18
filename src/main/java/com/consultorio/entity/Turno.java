package com.consultorio.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Turno")
@Table(name = "Turno")

public class Turno implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "turno", nullable = false)
  private String turno;
  // @JsonBackReference
  // @OneToMany(mappedBy = "turno")
  // private Set<Medico> itemsMedico = new HashSet<>();
  // @JsonBackReference
  // @OneToMany(mappedBy = "turno")
  // private Set<Tecnico> itemsTecnico = new HashSet<>();

  public Turno() {
  }

  public Turno(long id, String turno, Set<Medico> itemsMedico, Set<Tecnico> itemsTecnico) {
    this.id = id;
    this.turno = turno;
    // this.itemsMedico = itemsMedico;
    // this.itemsTecnico = itemsTecnico;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
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

}
