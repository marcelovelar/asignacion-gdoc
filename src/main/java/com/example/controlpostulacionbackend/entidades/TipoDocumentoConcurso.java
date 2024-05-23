package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipodocumentoconcurso")
public class TipoDocumentoConcurso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipodocumentoconcursoid")
    private Short tipoDocumentoConcursoId;

    @Column(name = "tipodocumentoconcurso")
    private String tipoDocumentoConcurso;

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
