package com.example.controlpostulacionbackend.entidades;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipoestadodocumento")
public class TipoEstadoDocumento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipoestadodocumentoid")
    private Short tipoEstadoDocumentoId;

    @Column(name = "tipoestadodocumento")
    private String tipoEstadoDocumento;

    public Short getTipoEstadoDocumentoId() {
        return tipoEstadoDocumentoId;
    }

    public void setTipoEstadoDocumentoId(Short tipoEstadoDocumentoId) {
        this.tipoEstadoDocumentoId = tipoEstadoDocumentoId;
    }

    public String getTipoEstadoDocumento() {
        return tipoEstadoDocumento;
    }

    public void setTipoEstadoDocumento(String tipoEstadoDocumento) {
        this.tipoEstadoDocumento = tipoEstadoDocumento;
    }

    // Constructor si es necesario
}
