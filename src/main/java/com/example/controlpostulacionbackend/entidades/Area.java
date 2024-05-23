package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "area")
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "areaid")
    private Integer areaId;

    @Column(name = "areadescripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "areasiglas", length = 40, nullable = false)
    private String siglas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamentoareaid")
    private Departamento departamento;

    // Constructor vacío
    public Area() {
    }

    // Constructor con parámetros
    public Area(String descripcion, String siglas, Departamento departamento) {
        this.descripcion = descripcion;
        this.siglas = siglas;
        this.departamento = departamento;
    }

    // Getters y setters
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}

