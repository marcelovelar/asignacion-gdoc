package com.example.controlpostulacionbackend.servicios;

import com.example.controlpostulacionbackend.entidades.Inscripcion;

import java.util.List;
import java.util.Optional;

public interface InscripcionService {
    List<Inscripcion> obtenerInscripcionesPorPersonaid(Short personaid);
    Optional<Inscripcion> obtenerInscripcionPorId(Short inscripcionId);
    List<Inscripcion> obtenerInscripcionesPorCargoId(Short cargoId);
}
