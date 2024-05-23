package com.example.controlpostulacionbackend.entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inscripcionid")
    private Short   inscripcionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaid", nullable = false)
    private Persona persona;

    /*@Column(name = "cargoid", nullable = false)
    private Short cargoId;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargoid", nullable = false)
    private Cargo cargoId;

    @Column(name = "inscripcionfecha", nullable = false)
    private LocalDateTime inscripcionFecha;

    @Column(name = "inscripcionprefecha", nullable = false)
    private LocalDateTime inscripcionPreFecha;

    //@Lob
    @Column(name = "inscripcionfotocedulaf", nullable = false)
    private byte[] inscripcionFotoCedulaF;

    //@Lob
    @Column(name = "inscripcionfotocedulaa", nullable = false)
    private byte[] inscripcionFotoCedulaA;

    @Column(name = "inscripcionestado", nullable = false, length = 40)
    private String inscripcionEstado;

    @Column(name = "inscripcionrespuestaestado", nullable = false, length = 40)
    private String inscripcionRespuestaEstado;

    @Column(name = "inscripcionfechapago")
    private Date inscripcionFechaPago;

    @Column(name = "inscripcionpago", length = 40)
    private String inscripcionPago;

    //@Lob
    @Column(name = "inscripcioncv")
    private byte[] inscripcionCV;

    //@Lob
    @Column(name = "inscripcioncopiatitulogrado", nullable = false)
    private byte[] inscripcionCopiaTituloGrado;

    //@Lob
    @Column(name = "inscripcionnotapostulacion")
    private byte[] inscripcionNotaPostulacion;

    //@Lob
    @Column(name = "inscripcionfotocedulaf_new")
    private byte[] inscripcionFotoCedulaFNew;

    //@Lob
    @Column(name = "inscripciondidacticauniv")
    private byte[] inscripcionDidacticaUniv;

    //@Lob
    @Column(name = "inscripcioncertificadostalleres")
    private byte[] inscripcionCertificadosTalleres;

    //@Lob
    @Column(name = "inscripcionfotocarnet")
    private byte[] inscripcionFotoCarnet;

    //@Lob
    @Column(name = "inscripcionexperiencialaboral")
    private byte[] inscripcionExperienciaLaboral;

    //@Lob
    @Column(name = "inscripciondeclaracionjurada")
    private byte[] inscripcionDeclaracionJurada;

    //@Lob
    @Column(name = "inscripcioncertificadofuncionariopublico")
    private byte[] inscripcionCertificadoFuncionarioPublico;

    //@Lob
    @Column(name = "inscripcioncertificadostallere")
    private byte[] inscripcionCertificadosTallere;

    //@Lob
    @Column(name = "inscripcioncertificadofunciona")
    private byte[] inscripcionCertificadoFunciona;

    // Getters and Setters
    public Short   getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(Short   inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    public LocalDateTime getInscripcionFecha() {
        return inscripcionFecha;
    }

    public void setInscripcionFecha(LocalDateTime inscripcionFecha) {
        this.inscripcionFecha = inscripcionFecha;
    }

    public LocalDateTime getInscripcionPreFecha() {
        return inscripcionPreFecha;
    }

    public void setInscripcionPreFecha(LocalDateTime inscripcionPreFecha) {
        this.inscripcionPreFecha = inscripcionPreFecha;
    }

    public byte[] getInscripcionFotoCedulaF() {
        return inscripcionFotoCedulaF;
    }

    public void setInscripcionFotoCedulaF(byte[] inscripcionFotoCedulaF) {
        this.inscripcionFotoCedulaF = inscripcionFotoCedulaF;
    }

    public byte[] getInscripcionFotoCedulaA() {
        return inscripcionFotoCedulaA;
    }

    public void setInscripcionFotoCedulaA(byte[] inscripcionFotoCedulaA) {
        this.inscripcionFotoCedulaA = inscripcionFotoCedulaA;
    }

    public String getInscripcionEstado() {
        return inscripcionEstado;
    }

    public void setInscripcionEstado(String inscripcionEstado) {
        this.inscripcionEstado = inscripcionEstado;
    }

    public String getInscripcionRespuestaEstado() {
        return inscripcionRespuestaEstado;
    }

    public void setInscripcionRespuestaEstado(String inscripcionRespuestaEstado) {
        this.inscripcionRespuestaEstado = inscripcionRespuestaEstado;
    }

    public Date getInscripcionFechaPago() {
        return inscripcionFechaPago;
    }

    public void setInscripcionFechaPago(Date inscripcionFechaPago) {
        this.inscripcionFechaPago = inscripcionFechaPago;
    }

    public String getInscripcionPago() {
        return inscripcionPago;
    }

    public void setInscripcionPago(String inscripcionPago) {
        this.inscripcionPago = inscripcionPago;
    }

    public byte[] getInscripcionCV() {
        return inscripcionCV;
    }

    public void setInscripcionCV(byte[] inscripcionCV) {
        this.inscripcionCV = inscripcionCV;
    }

    public byte[] getInscripcionCopiaTituloGrado() {
        return inscripcionCopiaTituloGrado;
    }

    public void setInscripcionCopiaTituloGrado(byte[] inscripcionCopiaTituloGrado) {
        this.inscripcionCopiaTituloGrado = inscripcionCopiaTituloGrado;
    }

    public byte[] getInscripcionNotaPostulacion() {
        return inscripcionNotaPostulacion;
    }

    public void setInscripcionNotaPostulacion(byte[] inscripcionNotaPostulacion) {
        this.inscripcionNotaPostulacion = inscripcionNotaPostulacion;
    }

    public byte[] getInscripcionFotoCedulaFNew() {
        return inscripcionFotoCedulaFNew;
    }

    public void setInscripcionFotoCedulaFNew(byte[] inscripcionFotoCedulaFNew) {
        this.inscripcionFotoCedulaFNew = inscripcionFotoCedulaFNew;
    }

    public byte[] getInscripcionDidacticaUniv() {
        return inscripcionDidacticaUniv;
    }

    public void setInscripcionDidacticaUniv(byte[] inscripcionDidacticaUniv) {
        this.inscripcionDidacticaUniv = inscripcionDidacticaUniv;
    }

    public byte[] getInscripcionCertificadosTalleres() {
        return inscripcionCertificadosTalleres;
    }

    public void setInscripcionCertificadosTalleres(byte[] inscripcionCertificadosTalleres) {
        this.inscripcionCertificadosTalleres = inscripcionCertificadosTalleres;
    }

    public byte[] getInscripcionFotoCarnet() {
        return inscripcionFotoCarnet;
    }

    public void setInscripcionFotoCarnet(byte[] inscripcionFotoCarnet) {
        this.inscripcionFotoCarnet = inscripcionFotoCarnet;
    }

    public byte[] getInscripcionExperienciaLaboral() {
        return inscripcionExperienciaLaboral;
    }

    public void setInscripcionExperienciaLaboral(byte[] inscripcionExperienciaLaboral) {
        this.inscripcionExperienciaLaboral = inscripcionExperienciaLaboral;
    }

    public byte[] getInscripcionDeclaracionJurada() {
        return inscripcionDeclaracionJurada;
    }

    public void setInscripcionDeclaracionJurada(byte[] inscripcionDeclaracionJurada) {
        this.inscripcionDeclaracionJurada = inscripcionDeclaracionJurada;
    }

    public byte[] getInscripcionCertificadoFuncionarioPublico() {
        return inscripcionCertificadoFuncionarioPublico;
    }

    public void setInscripcionCertificadoFuncionarioPublico(byte[] inscripcionCertificadoFuncionarioPublico) {
        this.inscripcionCertificadoFuncionarioPublico = inscripcionCertificadoFuncionarioPublico;
    }

    public byte[] getInscripcionCertificadosTallere() {
        return inscripcionCertificadosTallere;
    }

    public void setInscripcionCertificadosTallere(byte[] inscripcionCertificadosTallere) {
        this.inscripcionCertificadosTallere = inscripcionCertificadosTallere;
    }

    public byte[] getInscripcionCertificadoFunciona() {
        return inscripcionCertificadoFunciona;
    }

    public void setInscripcionCertificadoFunciona(byte[] inscripcionCertificadoFunciona) {
        this.inscripcionCertificadoFunciona = inscripcionCertificadoFunciona;
    }
}

