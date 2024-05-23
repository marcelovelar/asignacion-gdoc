package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class SedeDTO implements Serializable {

    private Integer sedeId;
    private String descripcion;
    private String siglas;
    private String codigo;
    private String estado;

    public SedeDTO() {
    }

    public SedeDTO(Integer sedeId, String descripcion, String siglas, String codigo, String estado) {
        this.sedeId = sedeId;
        this.descripcion = descripcion;
        this.siglas = siglas;
        this.codigo = codigo;
        this.estado = estado;
    }

    public Integer getSedeId() {
        return sedeId;
    }

    public void setSedeId(Integer sedeId) {
        this.sedeId = sedeId;
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
}
