package com.example.controlpostulacionbackend.servicios.impl;


import com.example.controlpostulacionbackend.DTO.CargoDTO;
import com.example.controlpostulacionbackend.DTO.InscripcionDTO;
import com.example.controlpostulacionbackend.DTO.PersonaDTO;
import com.example.controlpostulacionbackend.entidades.Inscripcion;
import com.example.controlpostulacionbackend.repositorio.InscripcionRepository;
import com.example.controlpostulacionbackend.servicios.InscripcionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscripcionServiceImpl implements InscripcionService {
    private final InscripcionRepository inscripcionRepository;

    public InscripcionServiceImpl(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public List<Inscripcion> obtenerInscripcionesPorPersonaid(Short personaid) {
        return inscripcionRepository.findByPersonaPersonaId(personaid);
    }

    public Optional<Inscripcion> obtenerInscripcionPorId(Short inscripcionId) {
        return inscripcionRepository.findById(inscripcionId);
    }

    public List<Inscripcion> obtenerInscripcionesPorCargoId(Short cargoId) {
        return inscripcionRepository.findByCargoId_CargoId(cargoId);
    }

    // Método para convertir una lista de entidades Inscripcion a una lista de DTOs InscripcionDTO
    public List<InscripcionDTO> convertirAInscripcionDTO(List<Inscripcion> inscripciones) {
        return inscripciones.stream()
                .map(this::mapToInscripcionDTO)
                .collect(Collectors.toList());
    }

    private InscripcionDTO mapToInscripcionDTO(Inscripcion inscripcion) {
        InscripcionDTO inscripcionDTO = new InscripcionDTO();

        // Asignación de todos los campos del DTO InscripcionDTO
        inscripcionDTO.setInscripcionId(inscripcion.getInscripcionId());
        // Mapeo de persona
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setPersonaId(inscripcion.getPersona().getPersonaId());
        // Asignación de personaDTO al campo persona del DTO InscripcionDTO
        inscripcionDTO.setPersona(personaDTO);

        // Mapeo de cargo
        CargoDTO cargoDTO = new CargoDTO();
        cargoDTO.setCargoId(inscripcion.getCargoId().getCargoId());
        // Asignación de personaDTO al campo persona del DTO InscripcionDTO
        inscripcionDTO.setCargoId(cargoDTO);

        //inscripcionDTO.setCargoId(inscripcion.getCargoId().getCargoId());
        inscripcionDTO.setInscripcionFecha(inscripcion.getInscripcionFecha());
        inscripcionDTO.setInscripcionPreFecha(inscripcion.getInscripcionPreFecha());
        inscripcionDTO.setInscripcionEstado(inscripcion.getInscripcionEstado());
        inscripcionDTO.setInscripcionRespuestaEstado(inscripcion.getInscripcionRespuestaEstado());
        inscripcionDTO.setInscripcionFechaPago(inscripcion.getInscripcionFechaPago());
        inscripcionDTO.setInscripcionPago(inscripcion.getInscripcionPago());
        inscripcionDTO.setInscripcionCV(inscripcion.getInscripcionCV());
        inscripcionDTO.setInscripcionCopiaTituloGrado(inscripcion.getInscripcionCopiaTituloGrado());
        inscripcionDTO.setInscripcionNotaPostulacion(inscripcion.getInscripcionNotaPostulacion());
        inscripcionDTO.setInscripcionFotoCedulaFNew(inscripcion.getInscripcionFotoCedulaFNew());
        inscripcionDTO.setInscripcionDidacticaUniv(inscripcion.getInscripcionDidacticaUniv());
        inscripcionDTO.setInscripcionCertificadosTalleres(inscripcion.getInscripcionCertificadosTalleres());
        inscripcionDTO.setInscripcionFotoCarnet(inscripcion.getInscripcionFotoCarnet());
        inscripcionDTO.setInscripcionExperienciaLaboral(inscripcion.getInscripcionExperienciaLaboral());
        inscripcionDTO.setInscripcionDeclaracionJurada(inscripcion.getInscripcionDeclaracionJurada());
        inscripcionDTO.setInscripcionCertificadoFuncionarioPublico(inscripcion.getInscripcionCertificadoFuncionarioPublico());
        inscripcionDTO.setInscripcionCertificadosTallere(inscripcion.getInscripcionCertificadosTallere());
        inscripcionDTO.setInscripcionCertificadoFunciona(inscripcion.getInscripcionCertificadoFunciona());

        return inscripcionDTO;
    }

}
