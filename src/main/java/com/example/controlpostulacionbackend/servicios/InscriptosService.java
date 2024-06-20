package com.example.controlpostulacionbackend.servicios;


import com.example.controlpostulacionbackend.DTO.InscriptosDTO;
import com.example.controlpostulacionbackend.entidades.Inscripcion;
import com.example.controlpostulacionbackend.repositorio.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InscriptosService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<InscriptosDTO> getInscripcionDetails() {
        return inscripcionRepository.findInscripcionDetails();
    }

    public int updateInscripciongdoc(Short id, String inscripciongdoc) {
        return inscripcionRepository.updateInscripciongdoc(id, inscripciongdoc);
    }

    //Que es la propagacion en Transactional?
}
