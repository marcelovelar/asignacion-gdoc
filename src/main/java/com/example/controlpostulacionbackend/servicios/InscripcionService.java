package com.example.controlpostulacionbackend.servicios;

import com.example.controlpostulacionbackend.DTO.InscriptosDTO;
import com.example.controlpostulacionbackend.entidades.Inscripcion;
import com.example.controlpostulacionbackend.repositorio.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface InscripcionService {

    List<Inscripcion> obtenerInscripcionesPorPersonaid(Short personaid);
    Optional<Inscripcion> obtenerInscripcionPorId(Short inscripcionId);
    List<Inscripcion> obtenerInscripcionesPorCargoId(Short cargoId);


}
