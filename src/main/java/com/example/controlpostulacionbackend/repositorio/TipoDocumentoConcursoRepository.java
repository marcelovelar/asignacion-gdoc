package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Departamento;
import com.example.controlpostulacionbackend.entidades.TipoDocumentoConcurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoConcursoRepository extends JpaRepository<TipoDocumentoConcurso, Short> {
    TipoDocumentoConcurso findByTipoDocumentoConcursoId(Short tipoDocumentoConcursoId);
}
