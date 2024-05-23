package com.example.controlpostulacionbackend.servicios;

import com.example.controlpostulacionbackend.entidades.Inscripcion;
import com.example.controlpostulacionbackend.entidades.InscripcionPrueba;

import java.util.List;

public interface InscripcionPruebaService {
    List<InscripcionPrueba> obtenerInscripcionesPorPersonaid(Short personaid);
    List<InscripcionPrueba> getAllInscripciones();
}
