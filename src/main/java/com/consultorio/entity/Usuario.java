
package com.consultorio.entity;

import java.io.Serializable;

import javax.persistence.*;



@Entity(name = "Usuario")
@Table(name = "Usuario")

public class Usuario implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "usuario", nullable = false, unique = true)
  private String usuario;
  @Column(name = "contraseña", nullable = false)
  private String contraseña;
  // @JsonManagedReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_rol", nullable = false)
  private Rol rol;


  public Usuario() {
  }

  public Usuario(long id, String usuario, String contraseña, Rol rol) {
    this.id = id;
    this.usuario = usuario;
    this.contraseña = contraseña;
    this.rol = rol;
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

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  

}
