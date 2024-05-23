package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.DocumentosInscripcion;
import com.example.controlpostulacionbackend.entidades.TipoEstadoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEstadoDocumentoRepository extends JpaRepository<TipoEstadoDocumento, Short> {
    TipoEstadoDocumento findByTipoEstadoDocumentoId(Short tipoEstadoDocumentoId);
}
