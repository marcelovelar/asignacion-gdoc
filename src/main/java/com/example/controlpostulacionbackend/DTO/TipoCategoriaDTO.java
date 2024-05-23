package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class TipoCategoriaDTO implements Serializable {

    private Integer tipoCategoriaId;
    private String descripcion;

    public TipoCategoriaDTO() {
    }

    public TipoCategoriaDTO(Integer tipoCategoriaId, String descripcion) {
        this.tipoCategoriaId = tipoCategoriaId;
        this.descripcion = descripcion;
    }

    public Integer getTipoCategoriaId() {
        return tipoCategoriaId;
    }

    public void setTipoCategoriaId(Integer tipoCategoriaId) {
        this.tipoCategoriaId = tipoCategoriaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
