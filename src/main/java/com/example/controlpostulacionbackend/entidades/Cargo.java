package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargoid")
    private Short cargoId;

    @Column(name = "cargodescripcion", length = 3000, nullable = false)
    private String descripcion;

    @Column(name = "cargocodigo", length = 40, nullable = false)
    private String codigo;

    @Column(name = "cargoestado", length = 40, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "sedeid", nullable = false)
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "departamentoid", nullable = false)
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "areaid", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "subareaid", nullable = false)
    private SubArea subArea;

    @ManyToOne
    @JoinColumn(name = "categoriaid", nullable = false)
    private Categoria categoria;

    @Column(name = "cargovacancia", nullable = false)
    private Short vacancia;

    @ManyToOne
    @JoinColumn(name = "parametroid", nullable = false)
    private Parametro parametro;

    @Column(name = "cargoturno", length = 1, nullable = false)
    private String turno;

    @Column(name = "cargohorario", length = 40, nullable = false)
    private String horario;

    @Column(name = "cargoseccion", length = 40, nullable = false)
    private String cargoSeccion;

    @Column(name = "cargocarrera", length = 40, nullable = false)
    private String cargoCarrera;

    public String getCargoSeccion() {
        return cargoSeccion;
    }

    public void setCargoSeccion(String cargoSeccion) {
        this.cargoSeccion = cargoSeccion;
    }

    public String getCargoCarrera() {
        return cargoCarrera;
    }

    public void setCargoCarrera(String cargoCarrera) {
        this.cargoCarrera = cargoCarrera;
    }

    // Constructor vacío
    public Cargo() {
    }

    // Constructor con parámetros
    public Cargo(String descripcion, String codigo, String estado, Sede sede, Departamento departamento, Area area,
                 SubArea subArea, Categoria categoria, Short vacancia, Parametro parametro, String turno, String horario) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.estado = estado;
        this.sede = sede;
        this.departamento = departamento;
        this.area = area;
        this.subArea = subArea;
        this.categoria = categoria;
        this.vacancia = vacancia;
        this.parametro = parametro;
        this.turno = turno;
        this.horario = horario;
    }

    // Getters y setters
    public Short getCargoId() {
        return cargoId;
    }

    public void setCargoId(Short cargoId) {
        this.cargoId = cargoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public SubArea getSubArea() {
        return subArea;
    }

    public void setSubArea(SubArea subArea) {
        this.subArea = subArea;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Short getVacancia() {
        return vacancia;
    }

    public void setVacancia(Short vacancia) {
        this.vacancia = vacancia;
    }

    public Parametro getParametro() {
        return parametro;
    }

    public void setParametro(Parametro parametro) {
        this.parametro = parametro;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

