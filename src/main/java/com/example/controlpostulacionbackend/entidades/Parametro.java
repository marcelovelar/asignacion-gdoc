package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parametro")
public class Parametro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parametroid")
    private Integer parametroId;

    @Column(name = "parametrodescripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "parametroanho", nullable = false)
    private Short anho;

    @Column(name = "parametroconvocatoria", nullable = false)
    private Short convocatoria;

    @Column(name = "parametroestado", length = 40, nullable = false)
    private String estado;

    // Constructor vacío
    public Parametro() {
    }

    // Constructor con parámetros
    public Parametro(String descripcion, Short anho, Short convocatoria, String estado) {
        this.descripcion = descripcion;
        this.anho = anho;
        this.convocatoria = convocatoria;
        this.estado = estado;
    }

    // Getters y setters
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

