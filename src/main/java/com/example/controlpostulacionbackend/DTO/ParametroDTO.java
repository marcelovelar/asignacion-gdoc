package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class ParametroDTO implements Serializable {

    private Integer parametroId;
    private String descripcion;
    private Short anho;
    private Short convocatoria;
    private String estado;

    public ParametroDTO() {
    }

    public ParametroDTO(Integer parametroId, String descripcion, Short anho, Short convocatoria, String estado) {
        this.parametroId = parametroId;
        this.descripcion = descripcion;
        this.anho = anho;
        this.convocatoria = convocatoria;
        this.estado = estado;
    }

    public Integer getParametroId() {
        return parametroId;
    }

    public void setParametroId(Integer parametroId) {
        this.parametroId = parametroId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getAnho() {
        return anho;
    }

    public void setAnho(Short anho) {
        this.anho = anho;
    }

    public Short getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Short convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
