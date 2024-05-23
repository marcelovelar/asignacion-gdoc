package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Short> {
    List<Inscripcion> findByPersonaPersonaId(Short personaId);
    List<Inscripcion> findByCargoId_CargoId(Short cargoId);
    List<Inscripcion> findByInscripcionId(Short inscripcionId);

}

