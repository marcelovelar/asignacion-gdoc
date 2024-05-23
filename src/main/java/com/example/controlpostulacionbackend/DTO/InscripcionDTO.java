package com.example.controlpostulacionbackend.DTO;

import com.example.controlpostulacionbackend.entidades.Cargo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class InscripcionDTO implements Serializable {
    private Short inscripcionId;
    private PersonaDTO persona; // Cambiado de Persona a PersonaDTO
    private CargoDTO cargoId;
    private LocalDateTime inscripcionFecha;
    private LocalDateTime inscripcionPreFecha;
    private byte[] inscripcionFotoCedulaF;
    private byte[] inscripcionFotoCedulaA;
    private String inscripcionEstado;
    private String inscripcionRespuestaEstado;
    private Date inscripcionFechaPago;
    private String inscripcionPago;
    private byte[] inscripcionCV;
    private byte[] inscripcionCopiaTituloGrado;
    private byte[] inscripcionNotaPostulacion;
    private byte[] inscripcionFotoCedulaFNew;
    private byte[] inscripcionDidacticaUniv;
    private byte[] inscripcionCertificadosTalleres;
    private byte[] inscripcionFotoCarnet;
    private byte[] inscripcionExperienciaLaboral;
    private byte[] inscripcionDeclaracionJurada;
    private byte[] inscripcionCertificadoFuncionarioPublico;
    private byte[] inscripcionCertificadosTallere;
    private byte[] inscripcionCertificadoFunciona;

    public byte[] getImageSrc2() {
        return imageSrc2;
    }

    public void setImageSrc2(byte[] imageSrc2) {
        this.imageSrc2 = imageSrc2;
    }

    private byte[] imageSrc2;
    private String imageSrcInscripcionFotoCedulaF; // URL de la imagen


    public String getImageSrcInscripcionCv() {
        return imageSrcInscripcionCv;
    }

    public void setImageSrcInscripcionCv(String imageSrcInscripcionCv) {
        this.imageSrcInscripcionCv = imageSrcInscripcionCv;
    }

    public void setImageSrcInscripcionFotoCedulaF(String imageSrcInscripcionFotoCedulaF) {
        this.imageSrcInscripcionFotoCedulaF = imageSrcInscripcionFotoCedulaF;
    }

    private String imageSrcInscripcionCv; // URL de la imagen

    // Getters y setters
    public Short getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(Short inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public CargoDTO getCargoId() {
        return cargoId;
    }

    public void setCargoId(CargoDTO cargoId) {
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

    public String getImageSrcInscripcionFotoCedulaF() {
        return imageSrcInscripcionFotoCedulaF;
    }

    public void setImageSrc(String imageSrcInscripcionFotoCedulaF) {
        this.imageSrcInscripcionFotoCedulaF = imageSrcInscripcionFotoCedulaF;
    }
}
