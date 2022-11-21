package com.consultorio.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity(name = "Medico")
@Table(name = "Medico")
public class Medico implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @Column(name = "apellido_paterno", nullable = false)
  private String apellido_paterno;
  @Column(name = "apellido_materno", nullable = false)
  private String apellido_materno;
  
  @Column(name = "dni", nullable = false, unique = true, length = 8)
  private String dni;

  @ManyToOne
  @JoinColumn(name = "pais_id", nullable = false)
  private Pais pais;

  @ManyToOne
  @JoinColumn(name = "estadocivil_id", nullable = false)
  private EstadoCivil estadoCivil;

  @ManyToOne
  @JoinColumn(name = "sexo_id", nullable = false)
  private Sexo sexo;

  @ManyToOne
  @JoinColumn(name = "turno_id", nullable = false)
  private Turno turno;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "horario_id", nullable = false)
  private Horario horario;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "especialidad_id", nullable = false)
  private Especialidad especialidad;
  @JsonIgnore
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "medico_procedimientos",joinColumns = @JoinColumn(name="medico_id"),inverseJoinColumns  = @JoinColumn(name="procedimiento_id"))
  private Collection<Procedimiento> procedimientos;

  public Medico() {
  }

  public Medico(long id, String nombre, String apellido_paterno, String apellido_materno, String dni, Pais pais,
      EstadoCivil estadoCivil, Sexo sexo, Turno turno, Horario horario,
      Especialidad especialidad) {
    this.id = id;
    this.nombre = nombre;
    this.apellido_paterno = apellido_paterno;
    this.apellido_materno = apellido_materno;
    this.dni = dni;
    this.pais = pais;
    this.estadoCivil = estadoCivil;
    this.sexo = sexo;
    this.turno = turno;
    this.horario = horario;
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

  public String getApellido_paterno() {
    return apellido_paterno;
  }

  public void setApellido_paterno(String apellido_paterno) {
    this.apellido_paterno = apellido_paterno;
  }

  public String getApellido_materno() {
    return apellido_materno;
  }

  public void setApellido_materno(String apellido_materno) {
    this.apellido_materno = apellido_materno;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public Pais getPais() {
    return pais;
  }

  public void setPais(Pais pais) {
    this.pais = pais;
  }

  public EstadoCivil getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(EstadoCivil estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public Sexo getSexo() {
    return sexo;
  }

  public void setSexo(Sexo sexo) {
    this.sexo = sexo;
  }

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  public Horario getHorario() {
    return horario;
  }

  public void setHorario(Horario horario) {
    this.horario = horario;
  }



  public Especialidad getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(Especialidad especialidad) {
    this.especialidad = especialidad;
  }

  public Collection<Procedimiento> getProcedimientos() {
    return procedimientos;
  }

  public void setProcedimientos(Collection<Procedimiento> procedimientos) {
    this.procedimientos = procedimientos;
  }

}
