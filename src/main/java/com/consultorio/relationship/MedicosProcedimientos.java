package com.consultorio.relationship;

import java.util.Collection;

import com.consultorio.entity.Medico;
import com.consultorio.entity.Procedimiento;

public class MedicosProcedimientos {
  private Medico medico;
  private Collection<Procedimiento> procedimientos;
  public MedicosProcedimientos() {
  }
  public MedicosProcedimientos(Medico medico, Collection<Procedimiento> procedimientos) {
    this.medico = medico;
    this.procedimientos = procedimientos;
  }
  public Medico getMedico() {
    return medico;
  }
  public void setMedico(Medico medico) {
    this.medico = medico;
  }
  public Collection<Procedimiento> getProcedimientos() {
    return procedimientos;
  }
  public void setProcedimientos(Collection<Procedimiento> procedimientos) {
    this.procedimientos = procedimientos;
  }
  
}
