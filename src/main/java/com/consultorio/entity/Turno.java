package com.consultorio.entity;

import java.io.Serializable;



import javax.persistence.*;



@Entity(name = "Turno")
@Table(name = "Turno")

public class Turno implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "turno", nullable = false)
  private String turno;


  public Turno() {
  }

  public Turno(long id, String turno) {
    this.id = id;
    this.turno = turno;
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


}
