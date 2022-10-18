package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity(name = "Usuario")
@Table(name = "Usuario")

public class Usuario implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "usuario",nullable = false,unique = true)
  private String usuario;
  @Column(name = "contraseña",nullable = false)
  private String constraseña;
  //@JsonManagedReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_rol",nullable = false)
  private Rol rol;
  // @JsonManagedReference
  // @OneToOne(mappedBy = "usuario")
  // private Paciente paciente;
  public Usuario() {
  }
  public Usuario(long id, String usuario, String constraseña, Rol rol, Paciente paciente) {
    this.id = id;
    this.usuario = usuario;
    this.constraseña = constraseña;
    this.rol = rol;
    // this.paciente = paciente;
  }
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getUsuario() {
    return usuario;
  }
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
  public String getConstraseña() {
    return constraseña;
  }
  public void setConstraseña(String constraseña) {
    this.constraseña = constraseña;
  }
  public Rol getRol() {
    return rol;
  }
  public void setRol(Rol rol) {
    this.rol = rol;
  }
  // public Paciente getPaciente() {
  //   return paciente;
  // }
  // public void setPaciente(Paciente paciente) {
  //   this.paciente = paciente;
  // }


  

  

}
