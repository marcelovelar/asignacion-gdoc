package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoriaid")
    private Integer categoriaId;

    @Column(name = "categoriadescripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "categoriasiglas", length = 40, nullable = false)
    private String siglas;

    @Column(name = "categoriacobroarancel", nullable = false)
    private boolean cobroArancel;

    @Column(name = "categoriacodigo", nullable = false)
    private Long codigo;

    @Column(name = "categoriaexento", length = 40, nullable = false)
    private String exento;

    @Column(name = "categoriacodarancel", length = 40, nullable = false)
    private String codigoArancel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipocategoriaid", nullable = false)
    private TipoCategoria tipoCategoria;

    // Constructor vacío
    public Categoria() {
    }

    // Constructor con parámetros
    public Categoria(String descripcion, String siglas, boolean cobroArancel, Long codigo, String exento, String codigoArancel, TipoCategoria tipoCategoria) {
        this.descripcion = descripcion;
        this.siglas = siglas;
        this.cobroArancel = cobroArancel;
        this.codigo = codigo;
        this.exento = exento;
        this.codigoArancel = codigoArancel;
        this.tipoCategoria = tipoCategoria;
    }

    // Getters y setters
    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
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

    public boolean getCobroArancel() {
        return cobroArancel;
    }

    public void setCobroArancel(boolean cobroArancel) {
        this.cobroArancel = cobroArancel;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getExento() {
        return exento;
    }

    public void setExento(String exento) {
        this.exento = exento;
    }

    public String getCodigoArancel() {
        return codigoArancel;
    }

    public void setCodigoArancel(String codigoArancel) {
        this.codigoArancel = codigoArancel;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
}

