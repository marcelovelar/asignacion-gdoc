package com.example.controlpostulacionbackend.DTO;

import java.io.Serializable;

public class TipoDocumentoDTO implements Serializable {
    private Short tipoDocumentoId;
    private String tipoDocumentoDescripcion;

    // Getters y setters
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
