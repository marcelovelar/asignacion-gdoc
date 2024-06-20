package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.DTO.InscripcionDTO;
import com.example.controlpostulacionbackend.DTO.InscriptosDTO;
import com.example.controlpostulacionbackend.entidades.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Short> {
    List<Inscripcion> findByPersonaPersonaId(Short personaId);
    List<Inscripcion> findByCargoId_CargoId(Short cargoId);
    List<Inscripcion> findByInscripcionId(Short inscripcionId);

    @Query("SELECT new com.example.controlpostulacionbackend.DTO.InscriptosDTO(" +
            "i.inscripcionId ,p.personaId, i.inscripciongdoc, p.tipoDocumento.tipoDocumentoId," +
            "p.personaNombre, p.personaApellido, p.personaNroDocumento) " +
            "FROM Inscripcion i JOIN i.persona p")
    List<InscriptosDTO> findInscripcionDetails();

    @Modifying
    @Transactional
    @Query("UPDATE Inscripcion i SET i.inscripciongdoc = :inscripciongdoc WHERE i.inscripcionId = :id")
    int updateInscripciongdoc(@Param("id") Short id, @Param("inscripciongdoc") String inscripciongdoc);
    }



