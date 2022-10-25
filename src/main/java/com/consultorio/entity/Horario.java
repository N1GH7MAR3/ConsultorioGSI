package com.consultorio.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity(name = "Horario")
@Table(name = "Horario")

public class Horario implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "horaingreso", nullable = false)
  private String horaingreso;
  @Column(name = "horasalida", nullable = false)
  private String horasalida;


  public Horario() {
  }


  public Horario(long id, String horaingreso, String horasalida) {
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


  public String getHoraingreso() {
    return horaingreso;
  }


  public void setHoraingreso(String horaingreso) {
    this.horaingreso = horaingreso;
  }


  public String getHorasalida() {
    return horasalida;
  }


  public void setHorasalida(String horasalida) {
    this.horasalida = horasalida;
  }


  
  
  



}
