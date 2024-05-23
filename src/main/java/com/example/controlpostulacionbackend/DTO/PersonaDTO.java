package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    private Short personaId;
    private TipoDocumentoDTO tipoDocumento;
    private String personaNombre;
    private String personaApellido;
    private String personaNroDocumento;
    private String personaDireccion;
    private String personaTelefono;
    private String personaMail;
    private String personaEstado;
    private String personaTituloPost;
    private String personaTituloGrado;

    // Getters y setters
    public Short getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Short personaId) {
        this.personaId = personaId;
    }

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public String getPersonaDireccion() {
        return personaDireccion;
    }

    public void setPersonaDireccion(String personaDireccion) {
        this.personaDireccion = personaDireccion;
    }

    public String getPersonaTelefono() {
        return personaTelefono;
    }

    public void setPersonaTelefono(String personaTelefono) {
        this.personaTelefono = personaTelefono;
    }

    public String getPersonaMail() {
        return personaMail;
    }

    public void setPersonaMail(String personaMail) {
        this.personaMail = personaMail;
    }

    public String getPersonaEstado() {
        return personaEstado;
    }

    public void setPersonaEstado(String personaEstado) {
        this.personaEstado = personaEstado;
    }

    public String getPersonaTituloPost() {
        return personaTituloPost;
    }

    public void setPersonaTituloPost(String personaTituloPost) {
        this.personaTituloPost = personaTituloPost;
    }

    public String getPersonaTituloGrado() {
        return personaTituloGrado;
    }

    public void setPersonaTituloGrado(String personaTituloGrado) {
        this.personaTituloGrado = personaTituloGrado;
    }
}
