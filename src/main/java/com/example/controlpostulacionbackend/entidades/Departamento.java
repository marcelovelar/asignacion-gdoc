package com.example.controlpostulacionbackend.entidades;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departamentoid")
    private Integer departamentoId;

    @Column(name = "departamentodescripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "departamentosiglas", length = 40, nullable = false)
    private String siglas;

    // Constructor vacío
    public Departamento() {
    }

    // Constructor con parámetros
    public Departamento(String descripcion, String siglas) {
        this.descripcion = descripcion;
        this.siglas = siglas;
    }

    // Getters y setters
    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
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
}
