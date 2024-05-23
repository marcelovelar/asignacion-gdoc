package com.example.controlpostulacionbackend.entidades;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipodocumento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoDocumento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipodocumentoid")
    private Short tipoDocumentoId;

    @Column(name = "tipodocumentodescripcion", nullable = false, length = 100)
    private String tipoDocumentoDescripcion;

    // Getters y Setters
    public Short getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Short tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getTipoDocumentoDescripcion() {
        return tipoDocumentoDescripcion;
    }

    public void setTipoDocumentoDescripcion(String tipoDocumentoDescripcion) {
        this.tipoDocumentoDescripcion = tipoDocumentoDescripcion;
    }
}
