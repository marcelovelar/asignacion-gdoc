package com.example.controlpostulacionbackend.DTO;

public class InscriptosDTO {

    private Short inscripcioId;
    private Short personaId;
    private String inscripcionGdoc;
    private Short tipoDocumentoId;
    private String personaNombre;
    private String personaApellido;
    private String personaNroDocumento;

    public InscriptosDTO() {
    }

    public InscriptosDTO(Short inscripcioId, Short personaId, String inscripcionGdoc, Short tipoDocumentoId, String personaNombre, String personaApellido, String personaNroDocumento) {
        this.inscripcioId = inscripcioId;
        this.personaId = personaId;
        this.inscripcionGdoc = inscripcionGdoc;
        this.tipoDocumentoId = tipoDocumentoId;
        this.personaNombre = personaNombre;
        this.personaApellido = personaApellido;
        this.personaNroDocumento = personaNroDocumento;
    }

    // Getters y setters

    public Short getInscripcioId() {
        return inscripcioId;
    }

    public void setInscripcioId(Short inscripcioId) {
        this.inscripcioId = inscripcioId;
    }
    public Short getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Short personaId) {
        this.personaId = personaId;
    }

    public String getInscripcionGdoc() {
        return inscripcionGdoc;
    }

    public void setInscripcionGdoc(String inscripcionGdoc) {
        this.inscripcionGdoc = inscripcionGdoc;
    }

    public Short getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Short tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public String getPersonaApellido() {
        return personaApellido;
    }

    public void setPersonaApellido(String personaApellido) {
        this.personaApellido = personaApellido;
    }

    public String getPersonaNroDocumento() {
        return personaNroDocumento;
    }

    public void setPersonaNroDocumento(String personaNroDocumento) {
        this.personaNroDocumento = personaNroDocumento;
    }
}
