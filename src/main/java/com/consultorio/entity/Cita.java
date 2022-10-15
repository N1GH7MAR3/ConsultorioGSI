package com.consultorio.entity;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "Cita")
@Table(name = "Cita")
public class Cita implements Serializable {
  private static final long serialVersion = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)
  @Column(name = "fecharegistro",nullable = false)
  private LocalDate fecharegistro;
  @DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)
  @Column(name = "fechacita",nullable = false)
  private LocalDate fechacita;
  @ManyToOne
  @JoinColumn(name = "medido_id",nullable = false)
  private Medico medico;
  @ManyToOne
  @JoinColumn(name = "paciente_id",nullable = false)
  private Paciente paciente;
  @ManyToOne
  @JoinColumn(name = "especialidad_id",nullable = false)
  private Especialidad especialidad;
  @ManyToOne
  @JoinColumn(name = "procedimiento_id",nullable = false)
  private Procedimiento procedimiento;
  
  
}
