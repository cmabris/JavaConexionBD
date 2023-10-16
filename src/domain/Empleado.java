package domain;

import java.util.Date;

public class Empleado {

    private String idEmpleado;
    private String nombre;
    private char sexo;
    private Date fecNac;
    private Date fecIncorporacion;
    private float salario;
    private float comision;
    private String cargo;
    private String jefeId;
    private String codDept;

    public Empleado()
    {
    }

    public Empleado(String idEmpleado)
    {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String nombre, char sexo, Date fecNac, Date fecIncorporacion, float salario, float comision, String cargo, String jefeId, String codDept) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecNac = fecNac;
        this.fecIncorporacion = fecIncorporacion;
        this.salario = salario;
        this.comision = comision;
        this.cargo = cargo;
        this.jefeId = jefeId;
        this.codDept = codDept;
    }

    public Empleado(String idEmpleado, String nombre, char sexo, Date fecNac, Date fecIncorporacion, float salario, float comision, String cargo, String jefeId, String codDept) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecNac = fecNac;
        this.fecIncorporacion = fecIncorporacion;
        this.salario = salario;
        this.comision = comision;
        this.cargo = cargo;
        this.jefeId = jefeId;
        this.codDept = codDept;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public Date getFecIncorporacion() {
        return fecIncorporacion;
    }

    public void setFecIncorporacion(Date fecIncorporacion) {
        this.fecIncorporacion = fecIncorporacion;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getJefeId() {
        return jefeId;
    }

    public void setJefeId(String jefeId) {
        this.jefeId = jefeId;
    }

    public String getCodDept() {
        return codDept;
    }

    public void setCodDept(String codDept) {
        this.codDept = codDept;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", fecNac=" + fecNac +
                ", fecIncorporacion=" + fecIncorporacion +
                ", salario=" + salario +
                ", comision=" + comision +
                ", cargo='" + cargo + '\'' +
                ", jefeId='" + jefeId + '\'' +
                ", codDept='" + codDept + '\'' +
                '}';
    }
}
