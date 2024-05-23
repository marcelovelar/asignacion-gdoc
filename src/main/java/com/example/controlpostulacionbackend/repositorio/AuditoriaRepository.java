package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Area;
import com.example.controlpostulacionbackend.entidades.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findByDocumentoInscripcionId(Long documentoInscripcionId);
}
