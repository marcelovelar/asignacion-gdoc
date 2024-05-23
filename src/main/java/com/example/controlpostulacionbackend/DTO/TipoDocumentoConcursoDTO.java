package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class TipoDocumentoConcursoDTO implements Serializable {
    private Short tipoDocumentoConcursoId;
    private String tipoDocumentoConcurso;

    // Constructor
    public TipoDocumentoConcursoDTO() {}

    // Constructor con parámetros
    public TipoDocumentoConcursoDTO(Short tipoDocumentoConcursoId, String tipoDocumentoConcurso) {
        this.tipoDocumentoConcursoId = tipoDocumentoConcursoId;
        this.tipoDocumentoConcurso = tipoDocumentoConcurso;
    }

    // Getters y Setters
    public Short getTipoDocumentoConcursoId() {
        return tipoDocumentoConcursoId;
    }

    public void setTipoDocumentoConcursoId(Short tipoDocumentoConcursoId) {
        this.tipoDocumentoConcursoId = tipoDocumentoConcursoId;
    }

    public String getTipoDocumentoConcurso() {
        return tipoDocumentoConcurso;
    }

    public void setTipoDocumentoConcurso(String tipoDocumentoConcurso) {
        this.tipoDocumentoConcurso = tipoDocumentoConcurso;
    }
}