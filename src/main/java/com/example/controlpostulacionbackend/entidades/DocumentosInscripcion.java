package com.example.controlpostulacionbackend.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "documentos_inscripcion")
public class DocumentosInscripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentos_inscripcion_id")
    private Short   documentosInscripcionId;

    public Short getDocumentosInscripcionId() {
        return documentosInscripcionId;
    }

    public void setDocumentosInscripcionId(Short documentosInscripcionId) {
        this.documentosInscripcionId = documentosInscripcionId;
    }

    //@Lob
    @Column(name = "documento_archivo")
    private byte[] documentoArchivo;

    @Column(name = "documento_comentario", length = 200)
    private String documentoComentario;

    @Column(name = "documento_aceptado", length = 1)
    private Character documentoAceptado;

    @ManyToOne
    @JoinColumn(name = "tipodocumentoconcursoid", referencedColumnName = "tipodocumentoconcursoid", insertable = false, updatable = false)
    private TipoDocumentoConcurso tipoDocumentoConcurso;

    @ManyToOne
    @JoinColumn(name = "inscripcionid", referencedColumnName = "inscripcionid", insertable = false, updatable = false)
    private Inscripcion inscripcion;

    @ManyToOne
    @JoinColumn(name = "tipoestadodocumentoid", referencedColumnName = "tipoestadodocumentoid", insertable = false, updatable = true)
    private TipoEstadoDocumento tipoEstadoDocumento;


    @Column(name = "docu_apellido", length = 50)
    private String docuApellido;

    @Column(name = "docu_nombre", length = 50)
    private String docuNombre;

    @Column(name = "docu_cedula", length = 12)
    private String docuCedula;

    public String getDocuApellido() {
        return docuApellido;
    }

    public void setDocuApellido(String docuApellido) {
        this.docuApellido = docuApellido;
    }

    public String getDocuNombre() {
        return docuNombre;
    }

    public void setDocuNombre(String docuNombre) {
        this.docuNombre = docuNombre;
    }

    public String getDocuCedula() {
        return docuCedula;
    }

    public void setDocuCedula(String docuCedula) {
        this.docuCedula = docuCedula;
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

    public TipoDocumentoConcurso getTipoDocumentoConcurso() {
        return tipoDocumentoConcurso;
    }

    public void setTipoDocumentoConcurso(TipoDocumentoConcurso tipoDocumentoConcurso) {
        this.tipoDocumentoConcurso = tipoDocumentoConcurso;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public TipoEstadoDocumento getTipoEstadoDocumento() {
        return tipoEstadoDocumento;
    }

    public void setTipoEstadoDocumento(TipoEstadoDocumento tipoEstadoDocumento) {
        this.tipoEstadoDocumento = tipoEstadoDocumento;
    }
}
