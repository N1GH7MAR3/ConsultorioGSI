package com.consultorio.entity;

import java.io.Serializable;
import java.time.LocalTime;



import javax.persistence.*;



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


  public Horario() {
  }

  public Horario(long id, LocalTime horaingreso, LocalTime horasalida) {
    this.id = id;
    this.horaingreso = horaingreso;
    this.horasalida = horasalida;

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



}
