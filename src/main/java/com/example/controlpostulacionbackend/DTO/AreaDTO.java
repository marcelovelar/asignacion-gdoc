package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class AreaDTO implements Serializable {

    private Integer areaId;
    private String descripcion;
    private String siglas;
    private DepartamentoDTO departamento;

    public AreaDTO() {
    }

    public AreaDTO(Integer areaId, String descripcion, String siglas, DepartamentoDTO departamento) {
        this.areaId = areaId;
        this.descripcion = descripcion;
        this.siglas = siglas;
        this.departamento = departamento;
    }

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

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }
}

