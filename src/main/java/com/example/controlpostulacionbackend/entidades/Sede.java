package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sede")
public class Sede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sedeid")
    private Integer sedeId;

    @Column(name = "sededescripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "sedesiglas", length = 40, nullable = false)
    private String siglas;

    @Column(name = "sedecodigo", length = 40, nullable = false)
    private String codigo;

    @Column(name = "sedeestado", length = 40, nullable = false)
    private String estado;

    // Constructor vacío
    public Sede() {
    }

    // Constructor con parámetros
    public Sede(String descripcion, String siglas, String codigo, String estado) {
        this.descripcion = descripcion;
        this.siglas = siglas;
        this.codigo = codigo;
        this.estado = estado;
    }

    // Getters y setters
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

