package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class DocumentosInscripcionDTO implements Serializable {
    private Short documentosInscripcionId;
    private byte[] documentoArchivo;
    private String documentoComentario;
    private Character documentoAceptado;
    private TipoDocumentoConcursoDTO tipoDocumentoConcurso;
    private InscripcionDTO inscripcion;
    private TipoEstadoDocumentoDTO tipoEstadoDocumento;

    // Constructor
    public DocumentosInscripcionDTO() {}

    // Getters y Setters
    public Short getDocumentosInscripcionId() {
        return documentosInscripcionId;
    }

    public void setDocumentosInscripcionId(Short documentosInscripcionId) {
        this.documentosInscripcionId = documentosInscripcionId;
    }

    public byte[] getDocumentoArchivo() {
        return documentoArchivo;
    }

    public void setDocumentoArchivo(byte[] documentoArchivo) {
        this.documentoArchivo = documentoArchivo;
    }

    public String getDocumentoComentario() {
        return documentoComentario;
    }

    public void setDocumentoComentario(String documentoComentario) {
        this.documentoComentario = documentoComentario;
    }

    public Character getDocumentoAceptado() {
        return documentoAceptado;
    }

    public void setDocumentoAceptado(Character documentoAceptado) {
        this.documentoAceptado = documentoAceptado;
    }

    public TipoDocumentoConcursoDTO getTipoDocumentoConcurso() {
        return tipoDocumentoConcurso;
    }

    public void setTipoDocumentoConcurso(TipoDocumentoConcursoDTO tipoDocumentoConcurso) {
        this.tipoDocumentoConcurso = tipoDocumentoConcurso;
    }

    public InscripcionDTO getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionDTO inscripcion) {
        this.inscripcion = inscripcion;
    }

    public TipoEstadoDocumentoDTO getTipoEstadoDocumento() {
        return tipoEstadoDocumento;
    }

    public void setTipoEstadoDocumento(TipoEstadoDocumentoDTO tipoEstadoDocumento) {
        this.tipoEstadoDocumento = tipoEstadoDocumento;
    }
}
