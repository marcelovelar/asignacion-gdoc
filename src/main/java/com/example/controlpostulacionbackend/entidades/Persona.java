package com.example.controlpostulacionbackend.entidades;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "persona")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaid")
    private Short personaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipodocumentoid", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "personanombre", nullable = false, length = 400)
    private String personaNombre;

    @Column(name = "personaapellido", nullable = false, length = 400)
    private String personaApellido;

    @Column(name = "personanrodocumento", nullable = false, length = 40)
    private String personaNroDocumento;

    @Column(name = "personadireccion", nullable = false, length = 1024)
    private String personaDireccion;

    @Column(name = "personatelefono", nullable = false, length = 20)
    private String personaTelefono;

    @Column(name = "personamail", nullable = false, length = 100)
    private String personaMail;

    @Column(name = "personaestado", nullable = false, length = 40)
    private String personaEstado;

    @Column(name = "personatitulopost", nullable = false, length = 60)
    private String personaTituloPost;

    @Column(name = "personatitulogrado", nullable = false, length = 60)
    private String personaTituloGrado;

    // Getters and setters
    public Short getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Short personaId) {
        this.personaId = personaId;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
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

