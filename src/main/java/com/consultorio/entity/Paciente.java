package com.consultorio.entity;

import java.io.Serializable;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Paciente")
@Table(name = "Paciente")
public class Paciente implements Serializable {
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
  private Integer dni;
  @Column(name = "direccion", nullable = false)
  private String direccion;
  @Column(name = "telefono", nullable = false, length = 9)
  private String telefono;
  @Column(name = "correo", nullable = false)
  private String correo;
  //@JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "pais_id", nullable = false)
  private Pais pais;
  //@JsonManagedReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "estadocivil_id", nullable = false)
  private EstadoCivil estadoCivil;
  //@JsonManagedReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "sexo_id", nullable = false)
  private Sexo sexo;
  //@JsonBackReference
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "usuario_id", nullable = false)
  private Usuario usuario;
  // @JsonBackReference
  // @OneToMany(mappedBy = "paciente")
  // private Set<Cita> itemsCita = new HashSet<>();

  // control de salud
  //@JsonManagedReference
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "contactoemergencia_id", nullable = true, unique = true)
  private ContactoEmergencia contactoEmergencia;
  //@JsonManagedReference
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "contactomedico_id", nullable = true, unique = true)
  private ContactoMedico contactoMedico;
  //@JsonManagedReference
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "enfermedad_id", nullable = true, unique = true)
  private Enfermedad enfermedad;
  //@JsonManagedReference
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "medicina_id", nullable = true, unique = true)
  private Medicina medicina;
  //@JsonBackReference
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "alergia_id", nullable = true, unique = true)
  private Alergia alergia;

  public Paciente() {
  }

  public Paciente(long id, String nombre, String apellido_paterno, String apellido_materno, Integer dni,
      String direccion, String telefono, String correo, Pais pais, EstadoCivil estadoCivil, Sexo sexo, Usuario usuario,
      Set<Cita> itemsCita, ContactoEmergencia contactoEmergencia, ContactoMedico contactoMedico, Enfermedad enfermedad,
      Medicina medicina, Alergia alergia) {
    this.id = id;
    this.nombre = nombre;
    this.apellido_paterno = apellido_paterno;
    this.apellido_materno = apellido_materno;
    this.dni = dni;
    this.direccion = direccion;
    this.telefono = telefono;
    this.correo = correo;
    this.pais = pais;
    this.estadoCivil = estadoCivil;
    this.sexo = sexo;
    this.usuario = usuario;
    //this.itemsCita = itemsCita;
    this.contactoEmergencia = contactoEmergencia;
    this.contactoMedico = contactoMedico;
    this.enfermedad = enfermedad;
    this.medicina = medicina;
    this.alergia = alergia;
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

  public Integer getDni() {
    return dni;
  }

  public void setDni(Integer dni) {
    this.dni = dni;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
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

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  // public Set<Cita> getItemsCita() {
  //   return itemsCita;
  // }

  // public void setItemsCita(Set<Cita> itemsCita) {
  //   this.itemsCita = itemsCita;
  // }

  public ContactoEmergencia getContactoEmergencia() {
    return contactoEmergencia;
  }

  public void setContactoEmergencia(ContactoEmergencia contactoEmergencia) {
    this.contactoEmergencia = contactoEmergencia;
  }

  public ContactoMedico getContactoMedico() {
    return contactoMedico;
  }

  public void setContactoMedico(ContactoMedico contactoMedico) {
    this.contactoMedico = contactoMedico;
  }

  public Enfermedad getEnfermedad() {
    return enfermedad;
  }

  public void setEnfermedad(Enfermedad enfermedad) {
    this.enfermedad = enfermedad;
  }

  public Medicina getMedicina() {
    return medicina;
  }

  public void setMedicina(Medicina medicina) {
    this.medicina = medicina;
  }

  public Alergia getAlergia() {
    return alergia;
  }

  public void setAlergia(Alergia alergia) {
    this.alergia = alergia;
  }

}
