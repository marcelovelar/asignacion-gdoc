package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class CargoDTO implements Serializable {

    private Short cargoId;
    private String descripcion;
    private String codigo;
    private String estado;
    private SedeDTO sede;
    private DepartamentoDTO departamento;
    private AreaDTO area;
    private SubAreaDTO subArea;
    private CategoriaDTO categoria;
    private Short vacancia;
    private ParametroDTO parametro;
    private String turno;
    private String horario;

    private String cargoSeccion;
    private String cargoCarrera;

    public String getCargoSeccion() {
        return cargoSeccion;
    }

    public void setCargoSeccion(String cargoSeccion) {
        this.cargoSeccion = cargoSeccion;
    }

    public String getCargoCarrera() {
        return cargoCarrera;
    }

    public void setCargoCarrera(String cargoCarrera) {
        this.cargoCarrera = cargoCarrera;
    }

    public CargoDTO() {
    }

    public CargoDTO(Short cargoId, String descripcion, String codigo, String estado, SedeDTO sede, DepartamentoDTO departamento,
                    AreaDTO area, SubAreaDTO subArea, CategoriaDTO categoria, Short vacancia, ParametroDTO parametro, String turno, String horario) {
        this.cargoId = cargoId;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.estado = estado;
        this.sede = sede;
        this.departamento = departamento;
        this.area = area;
        this.subArea = subArea;
        this.categoria = categoria;
        this.vacancia = vacancia;
        this.parametro = parametro;
        this.turno = turno;
        this.horario = horario;
    }

    public Short getCargoId() {
        return cargoId;
    }

    public void setCargoId(Short cargoId) {
        this.cargoId = cargoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public SedeDTO getSede() {
        return sede;
    }

    public void setSede(SedeDTO sede) {
        this.sede = sede;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    public AreaDTO getArea() {
        return area;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
    }

    public SubAreaDTO getSubArea() {
        return subArea;
    }

    public void setSubArea(SubAreaDTO subArea) {
        this.subArea = subArea;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public Short getVacancia() {
        return vacancia;
    }

    public void setVacancia(Short vacancia) {
        this.vacancia = vacancia;
    }

    public ParametroDTO getParametro() {
        return parametro;
    }

    public void setParametro(ParametroDTO parametro) {
        this.parametro = parametro;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

