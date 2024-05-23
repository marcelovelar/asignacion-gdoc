package com.example.controlpostulacionbackend.servicios.impl;

import com.example.controlpostulacionbackend.DTO.InscripcionDTO;
import com.example.controlpostulacionbackend.DTO.PersonaDTO;
import com.example.controlpostulacionbackend.entidades.Inscripcion;
import com.example.controlpostulacionbackend.entidades.InscripcionPrueba;
import com.example.controlpostulacionbackend.repositorio.InscripcionPruebaRepository;
import com.example.controlpostulacionbackend.repositorio.InscripcionRepository;
import com.example.controlpostulacionbackend.servicios.InscripcionPruebaService;
import com.example.controlpostulacionbackend.servicios.InscripcionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionPruebaServiceImpl implements InscripcionPruebaService {
    private final InscripcionPruebaRepository inscripcionPruebaRepository;

    public InscripcionPruebaServiceImpl(InscripcionPruebaRepository inscripcionPruebaRepository) {
        this.inscripcionPruebaRepository = inscripcionPruebaRepository;
    }

    /*@Override
    public List<InscripcionPrueba> obtenerInscripcionesPorPersonaid(Short personaid) {
        //return inscripcionPruebaRepository.findByPersonaPersonaId(personaid);
        return inscripcionPruebaRepository.findByPersona(personaid);
    }*/

    @Override
    public List<InscripcionPrueba> obtenerInscripcionesPorPersonaid(Short personaid) {
        return inscripcionPruebaRepository.findByPersonaId(personaid);
    }


    @Override
    public List<InscripcionPrueba> getAllInscripciones() {
        return inscripcionPruebaRepository.findAll();
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
        //inscripcionDTO.setCargoId(inscripcion.getCargoId());
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
