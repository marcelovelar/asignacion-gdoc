package com.example.controlpostulacionbackend.controllers;

import com.example.controlpostulacionbackend.entidades.Inscripcion;
import com.example.controlpostulacionbackend.entidades.InscripcionPrueba;
import com.example.controlpostulacionbackend.repositorio.InscripcionPruebaRepository;
import com.example.controlpostulacionbackend.servicios.InscripcionPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripcionesPrueba")
@CrossOrigin(origins = {"http://localhost:4200", "http://10.13.90.213", "http://10.13.90.213:8080","https://documentos.pol.una.py"})
public class InscripcionPruebaController {
    @Autowired
    private InscripcionPruebaService inscripcionPruebaService;

    @Autowired
    private InscripcionPruebaRepository inscripcionPruebaRepository;

    @GetMapping("/persona/{personaid}")
    public List<InscripcionPrueba> obtenerInscripcionesPorPersonaid(@PathVariable("personaid") Short personaid) {
        return inscripcionPruebaService.obtenerInscripcionesPorPersonaid(personaid);
    }

    @GetMapping
    public List<InscripcionPrueba> getAllInscripciones() {
        return inscripcionPruebaService.getAllInscripciones();
    }

    @GetMapping("/inscripcion/{id}/foto-cedula-f")
    public ResponseEntity<Resource> obtenerFotoCedulaF(@PathVariable Long id) {
        Optional<InscripcionPrueba> optionalInscripcion = inscripcionPruebaRepository.findById(id);
        if (optionalInscripcion.isPresent()) {
            byte[] fotoCedulaF = optionalInscripcion.get().getInscripcionFotoCedulaF();
            String filename = "foto-cedula-f" + id; // Nombre del archivo

            // Obtener el tipo de contenido (MIME type) basado en los primeros bytes del archivo
            MediaType mediaType = MediaType.IMAGE_JPEG; // Por defecto, asumimos JPEG
            if (isPng(fotoCedulaF)) {
                mediaType = MediaType.IMAGE_PNG;
                filename += ".png";
            } else if (isPdf(fotoCedulaF)) {
                mediaType = MediaType.APPLICATION_PDF;
                filename += ".pdf";
            } else {
                filename += ".jpg"; // Si no se puede determinar el tipo, se asume JPEG
            }

            // Preparar la respuesta con el archivo adjunto
            ByteArrayResource resource = new ByteArrayResource(fotoCedulaF);
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para verificar si los primeros bytes corresponden a un archivo PNG
    private boolean isPng(byte[] bytes) {
        return (bytes.length > 4 &&
                bytes[0] == (byte) 0x89 &&
                bytes[1] == (byte) 0x50 &&
                bytes[2] == (byte) 0x4E &&
                bytes[3] == (byte) 0x47);
    }

    // Método para verificar si los primeros bytes corresponden a un archivo PDF
    private boolean isPdf(byte[] bytes) {
        return (bytes.length > 3 &&
                bytes[0] == (byte) 0x25 &&
                bytes[1] == (byte) 0x50 &&
                bytes[2] == (byte) 0x44 &&
                bytes[3] == (byte) 0x46);
    }
}
