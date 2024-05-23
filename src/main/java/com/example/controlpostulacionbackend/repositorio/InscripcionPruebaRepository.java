package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Inscripcion;
import com.example.controlpostulacionbackend.entidades.InscripcionPrueba;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionPruebaRepository extends JpaRepository<InscripcionPrueba, Long> {
    //List<InscripcionPrueba> findByPersonaPersonaId(Short personaId);
    //List<InscripcionPrueba> findByPersona(Short personaId);
    List<InscripcionPrueba> findByPersonaId(Short personaId);
    // Método para buscar todos los registros
    List<InscripcionPrueba> findAll();
}
