package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipocategoria")
public class TipoCategoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipocategoriaid")
    private Integer tipoCategoriaId;

    @Column(name = "tipocategoriadescrip", length = 100, nullable = false)
    private String descripcion;

    // Constructor vacío
    public TipoCategoria() {
    }

    // Constructor con parámetros
    public TipoCategoria(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y setters
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

