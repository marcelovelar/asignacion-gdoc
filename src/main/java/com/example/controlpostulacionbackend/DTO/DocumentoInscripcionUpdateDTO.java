package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class DocumentoInscripcionUpdateDTO implements Serializable {
    private String comentario;

    public Short getTipoEstadoDocumentoId() {
        return tipoEstadoDocumentoId;
    }

    public void setTipoEstadoDocumentoId(Short tipoEstadoDocumentoId) {
        this.tipoEstadoDocumentoId = tipoEstadoDocumentoId;
    }

    private Short tipoEstadoDocumentoId;

    // Getters y setters
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    private String usuarionombre;

    private String usuarioapellido;

    private String usuariocedula;

    public String getUsuarionombre() {
        return usuarionombre;
    }

    public void setUsuarionombre(String usuarionombre) {
        this.usuarionombre = usuarionombre;
    }

    public String getUsuarioapellido() {
        return usuarioapellido;
    }

    public void setUsuarioapellido(String usuarioapellido) {
        this.usuarioapellido = usuarioapellido;
    }

    public String getUsuariocedula() {
        return usuariocedula;
    }

    public void setUsuariocedula(String usuariocedula) {
        this.usuariocedula = usuariocedula;
    }
}
