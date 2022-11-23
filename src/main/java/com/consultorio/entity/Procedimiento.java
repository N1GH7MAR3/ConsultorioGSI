package com.consultorio.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;



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
@ManyToMany(mappedBy = "procedimientos",cascade=CascadeType.REMOVE)
@JsonBackReference
private Collection<Medico>medicos;

  public Procedimiento() {
  }

  public Procedimiento(long id, String nombre, Especialidad especialidad) {
    this.id = id;
    this.nombre = nombre;
    this.especialidad = especialidad;

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

  public Collection<Medico> getMedicos() {
    return medicos;
  }

  public void setMedicos(Collection<Medico> medicos) {
    this.medicos = medicos;
  }



}
