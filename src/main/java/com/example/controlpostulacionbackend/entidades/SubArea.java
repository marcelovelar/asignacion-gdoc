package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subarea")
public class SubArea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subareaid")
    private Integer subareaId;

    @Column(name = "subareadescripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "subareasigla", length = 40, nullable = false)
    private String sigla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "areasubid")
    private Area area;

    // Constructor vacío
    public SubArea() {
    }

    // Constructor con parámetros
    public SubArea(String descripcion, String sigla, Area area) {
        this.descripcion = descripcion;
        this.sigla = sigla;
        this.area = area;
    }

    // Getters y setters
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}

