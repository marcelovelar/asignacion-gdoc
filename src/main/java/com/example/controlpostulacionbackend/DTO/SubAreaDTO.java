package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class SubAreaDTO implements Serializable {

    private Integer subareaId;
    private String descripcion;
    private String sigla;
    private AreaDTO area;

    public SubAreaDTO() {
    }

    public SubAreaDTO(Integer subareaId, String descripcion, String sigla, AreaDTO area) {
        this.subareaId = subareaId;
        this.descripcion = descripcion;
        this.sigla = sigla;
        this.area = area;
    }

    public Integer getSubareaId() {
        return subareaId;
    }

    public void setSubareaId(Integer subareaId) {
        this.subareaId = subareaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public AreaDTO getArea() {
        return area;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
    }
}

