package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.DocumentosInscripcion;
import com.example.controlpostulacionbackend.entidades.TipoEstadoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentosInscripcionRepository extends JpaRepository<DocumentosInscripcion, Short> {
    DocumentosInscripcion findBydocumentosInscripcionId(Short id);
    //List<DocumentosInscripcion> findByInscripcionId(Short );
    List<DocumentosInscripcion> findByInscripcion_InscripcionId(Short inscripcionId);
}
