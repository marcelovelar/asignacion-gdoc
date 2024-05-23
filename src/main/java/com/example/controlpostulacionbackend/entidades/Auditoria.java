package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auditoria")
    private Long idAuditoria;

    @Column(name = "cedula_auditoria")
    private String cedulaAuditoria;

    @Column(name = "nombre_tabla")
    private String nombreTabla;

    @Column(name = "fecha_hora_registro")
    private LocalDateTime fechaHoraRegistro;

    @Column(name = "operacion_tabla")
    private String operacionTabla;

    @Column(name = "nombre_reporte")
    private String nombreReporte;

    @Column(name = "nuevo_registro", columnDefinition = "TEXT")
    private String nuevoRegistro;

    @Column(name = "viejo_registro", columnDefinition = "TEXT")
    private String viejoRegistro;

    @Column(name = "nombre_auditoria")
    private String nombreAuditoria;

    @Column(name = "apellido_auditoria")
    private String apellidoAuditoria;

    @Column(name = "documento_inscripcion_id")
    private Long documentoInscripcionId;

    // Constructor vacío
    public Auditoria() {
    }

    // Getters y setters
    public Long getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Long idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getCedulaAuditoria() {
        return cedulaAuditoria;
    }

    public void setCedulaAuditoria(String cedulaAuditoria) {
        this.cedulaAuditoria = cedulaAuditoria;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public LocalDateTime getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public String getOperacionTabla() {
        return operacionTabla;
    }

    public void setOperacionTabla(String operacionTabla) {
        this.operacionTabla = operacionTabla;
    }

    public String getNombreReporte() {
        return nombreReporte;
    }

    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    public String getNuevoRegistro() {
        return nuevoRegistro;
    }

    public void setNuevoRegistro(String nuevoRegistro) {
        this.nuevoRegistro = nuevoRegistro;
    }

    public String getViejoRegistro() {
        return viejoRegistro;
    }

    public void setViejoRegistro(String viejoRegistro) {
        this.viejoRegistro = viejoRegistro;
    }

    public String getNombreAuditoria() {
        return nombreAuditoria;
    }

    public void setNombreAuditoria(String nombreAuditoria) {
        this.nombreAuditoria = nombreAuditoria;
    }

    public String getApellidoAuditoria() {
        return apellidoAuditoria;
    }

    public void setApellidoAuditoria(String apellidoAuditoria) {
        this.apellidoAuditoria = apellidoAuditoria;
    }

    public Long getDocumentoInscripcionId() {
        return documentoInscripcionId;
    }

    public void setDocumentoInscripcionId(Long documentoInscripcionId) {
        this.documentoInscripcionId = documentoInscripcionId;
    }
}

