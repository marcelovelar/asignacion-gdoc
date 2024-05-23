package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer categoriaId;
    private String descripcion;
    private String siglas;
    private boolean cobroArancel;
    private Long codigo;
    private String exento;
    private String codigoArancel;
    private TipoCategoriaDTO tipoCategoriaDto;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer categoriaId, String descripcion, String siglas, boolean cobroArancel, Long codigo, String exento, String codigoArancel, TipoCategoriaDTO tipoCategoriaDto) {
        this.categoriaId = categoriaId;
        this.descripcion = descripcion;
        this.siglas = siglas;
        this.cobroArancel = cobroArancel;
        this.codigo = codigo;
        this.exento = exento;
        this.codigoArancel = codigoArancel;
        this.tipoCategoriaDto = tipoCategoriaDto;
    }

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

    public boolean isCobroArancel() {
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

    public TipoCategoriaDTO getTipoCategoriaDto() {
        return tipoCategoriaDto;
    }

    public void setTipoCategoriaDto(TipoCategoriaDTO tipoCategoriaDto) {
        this.tipoCategoriaDto = tipoCategoriaDto;
    }
}
