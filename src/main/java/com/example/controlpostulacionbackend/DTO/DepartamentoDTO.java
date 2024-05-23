package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class DepartamentoDTO implements Serializable {

    private Integer departamentoId;
    private String descripcion;
    private String siglas;

    public DepartamentoDTO() {
    }

    public DepartamentoDTO(Integer departamentoId, String descripcion, String siglas) {
        this.departamentoId = departamentoId;
        this.descripcion = descripcion;
        this.siglas = siglas;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
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
}

