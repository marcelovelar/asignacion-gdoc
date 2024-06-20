package com.example.controlpostulacionbackend.DTO;


import java.io.Serializable;

public class InscripcionUpdateDTO {
    private Short id;
    private String inscripciongdoc;

    // Getters y setters
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getInscripciongdoc() {
        return inscripciongdoc;
    }

    public void setInscripciongdoc(String inscripciongdoc) {
        this.inscripciongdoc = inscripciongdoc;
    }
}
