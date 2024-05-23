package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class TipoEstadoDocumentoDTO implements Serializable {
    private Short tipoEstadoDocumentoId;
    private String tipoEstadoDocumento;

    // Constructor
    public TipoEstadoDocumentoDTO() {}

    // Constructor con parámetros
    public TipoEstadoDocumentoDTO(Short tipoEstadoDocumentoId, String tipoEstadoDocumento) {
        this.tipoEstadoDocumentoId = tipoEstadoDocumentoId;
        this.tipoEstadoDocumento = tipoEstadoDocumento;
    }

    // Getters y Setters
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
}
