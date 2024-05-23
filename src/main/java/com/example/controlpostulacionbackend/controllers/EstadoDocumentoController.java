package com.example.controlpostulacionbackend.controllers;

import com.example.controlpostulacionbackend.entidades.Inscripcion;
import com.example.controlpostulacionbackend.entidades.TipoEstadoDocumento;
import com.example.controlpostulacionbackend.repositorio.TipoEstadoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadoDocumento")
@CrossOrigin(origins = {"http://localhost:4200", "http://10.13.90.213", "http://10.13.90.213:8080","https://documentos.pol.una.py"})
public class EstadoDocumentoController {
    @Autowired
    private TipoEstadoDocumentoRepository tipoEstadoDocumentoRepository;

    @GetMapping
    public List<TipoEstadoDocumento> obtenerEstadoDocumento() {
        return this.tipoEstadoDocumentoRepository.findAll();
    }
}
