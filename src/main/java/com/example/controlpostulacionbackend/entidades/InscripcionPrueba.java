package com.example.controlpostulacionbackend.entidades;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscripcion_prueba")
public class InscripcionPrueba implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inscripcionid")
    private Long inscripcionId;

    @Column(name = "personaid")
    private Long personaId;

    //@Lob
    @Column(name = "inscripcionfotocedulaf")
    private byte[] inscripcionFotoCedulaF;

    //@Lob
    @Column(name = "inscripcionfotocedulaa")
    private byte[] inscripcionFotoCedulaA;

    // Constructor vacío
    public InscripcionPrueba() {
    }

    // Getters y setters
    public Long getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(Long inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
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
}
