package com.consultorio.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Horario")
@Table(name = "Horario")

public class Horario implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "horaingreso", nullable = false)
  private LocalTime horaingreso;
  @Column(name = "horasalida", nullable = false)
  private LocalTime horasalida;
  // @JsonBackReference
  // @OneToMany(mappedBy = "horario")
  // private Set<Medico> itemsMedico = new HashSet<>();
  // @JsonBackReference
  // @OneToMany(mappedBy = "horario")
  // private Set<Tecnico> itemsTecnico = new HashSet<>();

  public Horario() {
  }

  public Horario(long id, LocalTime horaingreso, LocalTime horasalida, Set<Medico> itemsMedico,
      Set<Tecnico> itemsTecnico) {
    this.id = id;
    this.horaingreso = horaingreso;
    this.horasalida = horasalida;
    // this.itemsMedico = itemsMedico;
    // this.itemsTecnico = itemsTecnico;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LocalTime getHoraingreso() {
    return horaingreso;
  }

  public void setHoraingreso(LocalTime horaingreso) {
    this.horaingreso = horaingreso;
  }

  public LocalTime getHorasalida() {
    return horasalida;
  }

  public void setHorasalida(LocalTime horasalida) {
    this.horasalida = horasalida;
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
