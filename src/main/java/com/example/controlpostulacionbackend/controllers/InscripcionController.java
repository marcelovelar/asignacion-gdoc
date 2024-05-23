package com.example.controlpostulacionbackend.controllers;

import com.example.controlpostulacionbackend.DTO.*;
import com.example.controlpostulacionbackend.entidades.*;
import com.example.controlpostulacionbackend.repositorio.*;
import com.example.controlpostulacionbackend.servicios.InscripcionService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripciones")
@CrossOrigin(origins = {"http://localhost:4200", "http://10.13.90.213", "http://10.13.90.213:8080","https://documentos.pol.una.py"})
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private CargoRepository cargoRepositoryRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private SubAreaRepository subAreaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private TipoCategoriaRepository tipoCategoriaRepository;

    @Autowired
    private ParametroRepository parametroRepository;

    @Autowired
    private DocumentosInscripcionRepository documentosInscripcionRepository;

    @Autowired
    private TipoDocumentoConcursoRepository tipoDocumentoConcursoRepository;

    @Autowired
    private TipoEstadoDocumentoRepository tipoEstadoDocumentoRepository;

    @GetMapping("/persona/{personaid}")
    public List<Inscripcion> obtenerInscripcionesPorPersonaid(@PathVariable("personaid") Short personaid) {
        return inscripcionService.obtenerInscripcionesPorPersonaid(personaid);
    }

    @GetMapping("/inscripciones/{inscripcionId}")
    public ResponseEntity<InscripcionDTO> getInscripcionById(@PathVariable Short inscripcionId) {
        Inscripcion inscripcion = this.inscripcionRepository.getById(inscripcionId);

        InscripcionDTO inscripcionDTO = mapToInscripcionDTO(inscripcion);

        return ResponseEntity.ok(inscripcionDTO);
    }

    /*@GetMapping("/cargo/{cargoId}")
    public ResponseEntity<List<Inscripcion>> obtenerInscripcionesPorCargoId(@PathVariable Short cargoId) {
        List<Inscripcion> inscripciones = inscripcionService.obtenerInscripcionesPorCargoId(cargoId);
        return (ResponseEntity<List<Inscripcion>>) (ResponseEntity<List<Inscripcion>>) ResponseEntity.ok(inscripciones);
    }*/

    @GetMapping("/cargo/{cargoId}")
    public ResponseEntity<List<InscripcionDTO>> obtenerInscripcionesPorCargoId(@PathVariable Short cargoId) {
        Cargo cargo = this.cargoRepositoryRepository.findByCargoId(cargoId);
        System.out.println("cargo id: " + cargo.getCargoId());
        List<Inscripcion> inscripciones = inscripcionService.obtenerInscripcionesPorCargoId(cargoId);
        //List<Inscripcion> inscripciones = inscripcionRepository.findByCargoId_CargoId(cargo.getCargoId());
        List<InscripcionDTO> inscripcionesDTO = new ArrayList<>();

        for (Inscripcion inscripcion : inscripciones) {
            InscripcionDTO inscripcionDTO = mapToInscripcionDTO(inscripcion);
            inscripcionesDTO.add(inscripcionDTO);
        }

        return ResponseEntity.ok(inscripcionesDTO);
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<InscripcionDTO>> obtenerInscripcionesPorDepartamentoId(@PathVariable Integer departamentoId) {

        List<Cargo> cargoList = this.cargoRepositoryRepository.findByDepartamentoId(departamentoId);
        List<InscripcionDTO> inscripcionesDTO = new ArrayList<>();

        for (Cargo cargo : cargoList) {
            List<Inscripcion> inscripciones = inscripcionService.obtenerInscripcionesPorCargoId(cargo.getCargoId());

            for (Inscripcion inscripcion : inscripciones) {
                inscripcionesDTO.add(mapToInscripcionDTO(inscripcion));
            }
        }

        System.out.println("Cantidad de inscripciones: " + inscripcionesDTO.size());
        return ResponseEntity.ok(inscripcionesDTO);
    }

    @GetMapping("/documentosInscripcion/{inscripcionId}")
    public ResponseEntity<List<DocumentosInscripcionDTO>> obtenerDocumentosInscripcionPorInscripcionId(@PathVariable Short inscripcionId) {
        List<DocumentosInscripcion> documentosInscripcionesList = this.documentosInscripcionRepository.findByInscripcion_InscripcionId(inscripcionId);
        //List<Inscripcion> inscripciones = inscripcionRepository.findByCargoId_CargoId(cargo.getCargoId());
        List<DocumentosInscripcionDTO> documentosInscripcionDTO = new ArrayList<>();

        for (DocumentosInscripcion documentosInscripcion : documentosInscripcionesList) {
            DocumentosInscripcionDTO documentosInscripcionDTO2 = mapToDocumentosInscripcionDTO(documentosInscripcion);
            documentosInscripcionDTO.add(documentosInscripcionDTO2);
        }

        return ResponseEntity.ok(documentosInscripcionDTO);
    }



    /*@GetMapping("/inscripcion/{id}/foto-cedula-f")
    public ResponseEntity<Resource> obtenerFotoCedulaF(@PathVariable Short id) {
        Optional<Inscripcion> optionalInscripcion = inscripcionRepository.findById(id);
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
    }*/

    @GetMapping("/inscripcion/{id}/foto-cedula-f")
    public ResponseEntity<Resource> obtenerFotoCedulaF(@PathVariable Short id) {
        Optional<Inscripcion> optionalInscripcion = inscripcionRepository.findById(id);
        if (!optionalInscripcion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        byte[] fotoCedulaF = optionalInscripcion.get().getInscripcionFotoCedulaF();
        if (fotoCedulaF == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String filename = "fotoCedulaF" + id; // Nombre del archivo

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
    }

    /*@GetMapping("/inscripcion/{id}/inscripcioncv")
    public ResponseEntity<Resource> obtenerInscripcionCv(@PathVariable Short id) {
        Optional<Inscripcion> optionalInscripcion = inscripcionRepository.findById(id);
        if (optionalInscripcion.isPresent()) {
            byte[] inscripcionCv = optionalInscripcion.get().getInscripcionCV();
            String filename = "inscripcionCv" + id; // Nombre del archivo

            // Obtener el tipo de contenido (MIME type) basado en los primeros bytes del archivo
            MediaType mediaType = MediaType.IMAGE_JPEG; // Por defecto, asumimos JPEG
            if (isPng(inscripcionCv)) {
                mediaType = MediaType.IMAGE_PNG;
                filename += ".png";
            } else if (isPdf(inscripcionCv)) {
                mediaType = MediaType.APPLICATION_PDF;
                filename += ".pdf";
            } else {
                filename += ".jpg"; // Si no se puede determinar el tipo, se asume JPEG
            }

            // Preparar la respuesta con el archivo adjunto
            ByteArrayResource resource = new ByteArrayResource(inscripcionCv);
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping("/inscripcion/{id}/inscripcioncv")
    public ResponseEntity<Resource> obtenerInscripcionCv(@PathVariable Short id) {
        Optional<Inscripcion> optionalInscripcion = inscripcionRepository.findById(id);
        if (!optionalInscripcion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        byte[] inscripcionCv = optionalInscripcion.get().getInscripcionCV();
        if (inscripcionCv == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String filename = "inscripcionCv" + id; // Nombre del archivo

        // Obtener el tipo de contenido (MIME type) basado en los primeros bytes del archivo
        MediaType mediaType = MediaType.IMAGE_JPEG; // Por defecto, asumimos JPEG
        if (isPng(inscripcionCv)) {
            mediaType = MediaType.IMAGE_PNG;
            filename += ".png";
        } else if (isPdf(inscripcionCv)) {
            mediaType = MediaType.APPLICATION_PDF;
            filename += ".pdf";
        } else {
            filename += ".jpg"; // Si no se puede determinar el tipo, se asume JPEG
        }

        // Preparar la respuesta con el archivo adjunto
        ByteArrayResource resource = new ByteArrayResource(inscripcionCv);
        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }



    //PARA TRAER EL DOCUMENTO A VISUALIZAR
    @GetMapping("/inscripcion/{id}/documentoInscripcion")
    public ResponseEntity<Resource> obtenerDocumentoInscripcion(@PathVariable Short id) {
        Optional<DocumentosInscripcion> optionalInscripcion = documentosInscripcionRepository.findById(id);
        if (!optionalInscripcion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        byte[] archivo = optionalInscripcion.get().getDocumentoArchivo();
        if (archivo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String filename = "documentoArchivo" + id; // Nombre del archivo

        // Obtener el tipo de contenido (MIME type) basado en los primeros bytes del archivo
        MediaType mediaType = MediaType.IMAGE_JPEG; // Por defecto, asumimos JPEG
        if (isPng(archivo)) {
            mediaType = MediaType.IMAGE_PNG;
            filename += ".png";
        } else if (isPdf(archivo)) {
            mediaType = MediaType.APPLICATION_PDF;
            filename += ".pdf";
        } else {
            filename += ".jpg"; // Si no se puede determinar el tipo, se asume JPEG
        }

        // Preparar la respuesta con el archivo adjunto
        ByteArrayResource resource = new ByteArrayResource(archivo);
        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(resource);
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

    private InscripcionDTO mapToInscripcionDTO(Inscripcion inscripcion) {
        InscripcionDTO inscripcionDTO = new InscripcionDTO();

        // Asignación de todos los campos del DTO InscripcionDTO
        inscripcionDTO.setInscripcionId(inscripcion.getInscripcionId());


        // Mapeo de persona
        /*PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setPersonaId(inscripcion.getPersona().getPersonaId());
        // Asignación de personaDTO al campo persona del DTO InscripcionDTO
        inscripcionDTO.setPersona(personaDTO);*/

        // Mapeo de persona
        PersonaDTO personaDTO = new PersonaDTO();
        Persona persona = inscripcion.getPersona();
        personaDTO.setPersonaId(persona.getPersonaId());
        personaDTO.setPersonaNroDocumento(persona.getPersonaNroDocumento());
        personaDTO.setPersonaNombre(persona.getPersonaNombre()); // Suponiendo que tienes un método getNombre en Persona
        personaDTO.setPersonaApellido(persona.getPersonaApellido()); // Suponiendo que tienes un método getApellido en Persona
        // Asignación de personaDTO al campo persona del DTO InscripcionDTO
        inscripcionDTO.setPersona(personaDTO);

        // Aquí puedes agregar más campos de la persona según necesites
        personaDTO.setPersonaMail(persona.getPersonaMail()); // Suponiendo que tienes un método getCorreo en Persona
        personaDTO.setPersonaTelefono(persona.getPersonaTelefono());


        //MApeo sede
        SedeDTO sedeDTO = new SedeDTO();
        Sede sede = this.sedeRepository.findBySedeId(inscripcion.getCargoId().getSede().getSedeId());
        sedeDTO.setSedeId(sede.getSedeId());
        sedeDTO.setCodigo(sede.getCodigo());
        sedeDTO.setDescripcion(sede.getDescripcion());
        sedeDTO.setSiglas(sede.getSiglas());
        sedeDTO.setEstado(sede.getEstado());

        //Mapeo de departamento
        DepartamentoDTO departamentoDTO = new DepartamentoDTO();
        Departamento departamento = this.departamentoRepository.findByDepartamentoId(inscripcion.getCargoId().getDepartamento().getDepartamentoId());
        departamentoDTO.setDepartamentoId(departamento.getDepartamentoId());
        departamentoDTO.setDescripcion(departamento.getDescripcion());
        departamentoDTO.setSiglas(departamento.getSiglas());

        //Mapeo de Area
        AreaDTO areaDTO = new AreaDTO();
        Area area = this.areaRepository.findByAreaId(inscripcion.getCargoId().getArea().getAreaId());
        areaDTO.setAreaId(area.getAreaId());
        areaDTO.setDepartamento(departamentoDTO);
        areaDTO.setDescripcion(area.getDescripcion());
        areaDTO.setSiglas(area.getSiglas());

        //Mapeo de SubArea
        SubAreaDTO subAreaDTO = new SubAreaDTO();
        SubArea subArea = this.subAreaRepository.findBySubareaId(inscripcion.getCargoId().getSubArea().getSubareaId());
        subAreaDTO.setArea(areaDTO);
        subAreaDTO.setDescripcion(subArea.getDescripcion());
        subAreaDTO.setSigla(subArea.getSigla());
        subAreaDTO.setSubareaId(subArea.getSubareaId());

        //Mapeo Tipo categoria
        TipoCategoriaDTO tipoCategoriaDTO = new TipoCategoriaDTO();
        TipoCategoria tipoCategoria = this.tipoCategoriaRepository.findBytipoCategoriaId(inscripcion.getCargoId().getCategoria().getTipoCategoria().getTipoCategoriaId());
        tipoCategoriaDTO.setTipoCategoriaId(tipoCategoria.getTipoCategoriaId());
        tipoCategoriaDTO.setDescripcion(tipoCategoria.getDescripcion());


        //Mapeo de Categoria
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        Categoria categoria = this.categoriaRepository.findByCategoriaId(inscripcion.getCargoId().getCategoria().getCategoriaId());
        categoriaDTO.setCategoriaId(categoria.getCategoriaId());
        categoriaDTO.setCodigo(categoria.getCodigo());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        categoriaDTO.setExento(categoria.getExento());
        categoriaDTO.setCobroArancel(categoria.getCobroArancel());
        categoriaDTO.setCodigoArancel(categoria.getCodigoArancel());
        categoriaDTO.setCodigo(categoria.getCodigo());
        categoriaDTO.setTipoCategoriaDto(tipoCategoriaDTO);


        //Mapeo parametro
        ParametroDTO parametroDTO = new ParametroDTO();
        Parametro parametro = this.parametroRepository.findByparametroId(inscripcion.getCargoId().getParametro().getParametroId());
        parametroDTO.setParametroId(parametro.getParametroId());
        parametroDTO.setAnho(parametro.getAnho());
        parametroDTO.setConvocatoria(parametro.getConvocatoria());
        parametroDTO.setDescripcion(parametro.getDescripcion());
        parametroDTO.setEstado(parametro.getEstado());

        // Mapeo de cargo
        CargoDTO cargoDTO = new CargoDTO();
        cargoDTO.setCargoId(inscripcion.getCargoId().getCargoId());
        cargoDTO.setDescripcion(inscripcion.getCargoId().getDescripcion());
        cargoDTO.setCodigo(inscripcion.getCargoId().getCodigo());
        cargoDTO.setEstado(inscripcion.getCargoId().getEstado());
        cargoDTO.setTurno(inscripcion.getCargoId().getTurno());
        cargoDTO.setHorario(inscripcion.getCargoId().getHorario());
        cargoDTO.setVacancia(inscripcion.getCargoId().getVacancia());

        cargoDTO.setCargoSeccion(inscripcion.getCargoId().getCargoSeccion());
        cargoDTO.setCargoCarrera(inscripcion.getCargoId().getCargoCarrera());

        //seteo de DTO'S a cargo
        cargoDTO.setSede(sedeDTO);
        cargoDTO.setDepartamento(departamentoDTO);
        cargoDTO.setArea(areaDTO);
        cargoDTO.setSubArea(subAreaDTO);
        cargoDTO.setCategoria(categoriaDTO);
        cargoDTO.setParametro(parametroDTO);

        // Asignación de cargoDTO al campo cargoId del DTO CargoDTO
        inscripcionDTO.setCargoId(cargoDTO);

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

        inscripcionDTO.setImageSrc(Base64.encodeBase64String(inscripcion.getInscripcionFotoCedulaF()));
        inscripcionDTO.setImageSrcInscripcionCv(Base64.encodeBase64String(inscripcion.getInscripcionCV()));

        return inscripcionDTO;
    }

    private DocumentosInscripcionDTO mapToDocumentosInscripcionDTO(DocumentosInscripcion documentosInscripcion) {
        DocumentosInscripcionDTO documentosInscripcionDTO = new DocumentosInscripcionDTO();

        // Asignación de todos los campos del DTO InscripcionDTO
        documentosInscripcionDTO.setDocumentosInscripcionId(documentosInscripcion.getDocumentosInscripcionId());


        // Mapeo de Inscripcion
        InscripcionDTO inscripcionDTO = new InscripcionDTO();
        Inscripcion inscripcion = documentosInscripcion.getInscripcion();
        inscripcionDTO.setInscripcionId(inscripcion.getInscripcionId());


        // Mapeo de persona
        PersonaDTO personaDTO = new PersonaDTO();
        Persona persona = inscripcion.getPersona();
        personaDTO.setPersonaId(persona.getPersonaId());
        personaDTO.setPersonaNroDocumento(persona.getPersonaNroDocumento());
        personaDTO.setPersonaNombre(persona.getPersonaNombre()); // Suponiendo que tienes un método getNombre en Persona
        personaDTO.setPersonaApellido(persona.getPersonaApellido()); // Suponiendo que tienes un método getApellido en Persona


        // Aquí puedes agregar más campos de la persona según necesites
        personaDTO.setPersonaMail(persona.getPersonaMail()); // Suponiendo que tienes un método getCorreo en Persona
        personaDTO.setPersonaTelefono(persona.getPersonaTelefono());

        // Asignación de personaDTO al campo persona del DTO InscripcionDTO
        inscripcionDTO.setPersona(personaDTO);


        //MApeo sede
        SedeDTO sedeDTO = new SedeDTO();
        Sede sede = this.sedeRepository.findBySedeId(inscripcion.getCargoId().getSede().getSedeId());
        sedeDTO.setSedeId(sede.getSedeId());
        sedeDTO.setCodigo(sede.getCodigo());
        sedeDTO.setDescripcion(sede.getDescripcion());
        sedeDTO.setSiglas(sede.getSiglas());
        sedeDTO.setEstado(sede.getEstado());

        //Mapeo de departamento
        DepartamentoDTO departamentoDTO = new DepartamentoDTO();
        Departamento departamento = this.departamentoRepository.findByDepartamentoId(inscripcion.getCargoId().getDepartamento().getDepartamentoId());
        departamentoDTO.setDepartamentoId(departamento.getDepartamentoId());
        departamentoDTO.setDescripcion(departamento.getDescripcion());
        departamentoDTO.setSiglas(departamento.getSiglas());

        //Mapeo de Area
        AreaDTO areaDTO = new AreaDTO();
        Area area = this.areaRepository.findByAreaId(inscripcion.getCargoId().getArea().getAreaId());
        areaDTO.setAreaId(area.getAreaId());
        areaDTO.setDepartamento(departamentoDTO);
        areaDTO.setDescripcion(area.getDescripcion());
        areaDTO.setSiglas(area.getSiglas());

        //Mapeo de SubArea
        SubAreaDTO subAreaDTO = new SubAreaDTO();
        SubArea subArea = this.subAreaRepository.findBySubareaId(inscripcion.getCargoId().getSubArea().getSubareaId());
        subAreaDTO.setArea(areaDTO);
        subAreaDTO.setDescripcion(subArea.getDescripcion());
        subAreaDTO.setSigla(subArea.getSigla());
        subAreaDTO.setSubareaId(subArea.getSubareaId());

        //Mapeo Tipo categoria
        TipoCategoriaDTO tipoCategoriaDTO = new TipoCategoriaDTO();
        TipoCategoria tipoCategoria = this.tipoCategoriaRepository.findBytipoCategoriaId(inscripcion.getCargoId().getCategoria().getTipoCategoria().getTipoCategoriaId());
        tipoCategoriaDTO.setTipoCategoriaId(tipoCategoria.getTipoCategoriaId());
        tipoCategoriaDTO.setDescripcion(tipoCategoria.getDescripcion());


        //Mapeo de Categoria
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        Categoria categoria = this.categoriaRepository.findByCategoriaId(inscripcion.getCargoId().getCategoria().getCategoriaId());
        categoriaDTO.setCategoriaId(categoria.getCategoriaId());
        categoriaDTO.setCodigo(categoria.getCodigo());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        categoriaDTO.setExento(categoria.getExento());
        categoriaDTO.setCobroArancel(categoria.getCobroArancel());
        categoriaDTO.setCodigoArancel(categoria.getCodigoArancel());
        categoriaDTO.setCodigo(categoria.getCodigo());
        categoriaDTO.setTipoCategoriaDto(tipoCategoriaDTO);


        //Mapeo parametro
        ParametroDTO parametroDTO = new ParametroDTO();
        Parametro parametro = this.parametroRepository.findByparametroId(inscripcion.getCargoId().getParametro().getParametroId());
        parametroDTO.setParametroId(parametro.getParametroId());
        parametroDTO.setAnho(parametro.getAnho());
        parametroDTO.setConvocatoria(parametro.getConvocatoria());
        parametroDTO.setDescripcion(parametro.getDescripcion());
        parametroDTO.setEstado(parametro.getEstado());

        // Mapeo de cargo
        CargoDTO cargoDTO = new CargoDTO();
        cargoDTO.setCargoId(inscripcion.getCargoId().getCargoId());
        cargoDTO.setDescripcion(inscripcion.getCargoId().getDescripcion());
        cargoDTO.setCodigo(inscripcion.getCargoId().getCodigo());
        cargoDTO.setEstado(inscripcion.getCargoId().getEstado());
        cargoDTO.setTurno(inscripcion.getCargoId().getTurno());
        cargoDTO.setHorario(inscripcion.getCargoId().getHorario());
        cargoDTO.setVacancia(inscripcion.getCargoId().getVacancia());
        //seteo de DTO'S a cargo
        cargoDTO.setSede(sedeDTO);
        cargoDTO.setDepartamento(departamentoDTO);
        cargoDTO.setArea(areaDTO);
        cargoDTO.setSubArea(subAreaDTO);
        cargoDTO.setCategoria(categoriaDTO);
        cargoDTO.setParametro(parametroDTO);

        // Asignación de cargoDTO al campo cargoId del DTO CargoDTO
        inscripcionDTO.setCargoId(cargoDTO);

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

        inscripcionDTO.setImageSrc(Base64.encodeBase64String(inscripcion.getInscripcionFotoCedulaF()));
        inscripcionDTO.setImageSrcInscripcionCv(Base64.encodeBase64String(inscripcion.getInscripcionCV()));

        documentosInscripcionDTO.setInscripcion(inscripcionDTO);
        documentosInscripcionDTO.setDocumentoAceptado(documentosInscripcion.getDocumentoAceptado());
        documentosInscripcionDTO.setDocumentoArchivo(documentosInscripcion.getDocumentoArchivo());
        documentosInscripcionDTO.setDocumentoComentario(documentosInscripcion.getDocumentoComentario());

        TipoDocumentoConcurso tipoDocumentoConcurso = this.tipoDocumentoConcursoRepository.findByTipoDocumentoConcursoId(documentosInscripcion.getTipoDocumentoConcurso().getTipoDocumentoConcursoId());
        TipoDocumentoConcursoDTO tipoDocumentoConcursoDTO = new TipoDocumentoConcursoDTO();
        tipoDocumentoConcursoDTO.setTipoDocumentoConcursoId(tipoDocumentoConcurso.getTipoDocumentoConcursoId());
        tipoDocumentoConcursoDTO.setTipoDocumentoConcurso(tipoDocumentoConcurso.getTipoDocumentoConcurso());
        documentosInscripcionDTO.setTipoDocumentoConcurso(tipoDocumentoConcursoDTO);

        TipoEstadoDocumento tipoEstadoDocumento = this.tipoEstadoDocumentoRepository.findByTipoEstadoDocumentoId(documentosInscripcion.getTipoEstadoDocumento().getTipoEstadoDocumentoId());
        TipoEstadoDocumentoDTO tipoEstadoDocumentoDTO = new TipoEstadoDocumentoDTO();
        tipoEstadoDocumentoDTO.setTipoEstadoDocumentoId(tipoEstadoDocumento.getTipoEstadoDocumentoId());
        tipoEstadoDocumentoDTO.setTipoEstadoDocumento(tipoEstadoDocumento.getTipoEstadoDocumento());
        documentosInscripcionDTO.setTipoEstadoDocumento(tipoEstadoDocumentoDTO);

        return documentosInscripcionDTO;
    }

    //PARA TRAER EL DOCUMENTO A VISUALIZAR
    @GetMapping("/documentoInscripcion/{id}")
    public ResponseEntity<DocumentosInscripcion> obtenerDocumentoInscripcionEntity(@PathVariable Short id) {
        Optional<DocumentosInscripcion> documentosInscripcionOptional = documentosInscripcionRepository.findById(id);

        // Comprobar si el valor está presente y devolverlo, en caso contrario, lanzar una excepción
        DocumentosInscripcion documentosInscripcion = documentosInscripcionOptional.orElseThrow(() -> new RuntimeException("Documento de inscripción no encontrado con ID: " + id));

        return ResponseEntity.ok(documentosInscripcion);
    }

    //PARA ACTUALIZAR EL DOCUMENTO INSCRIPCION
    @PutMapping("/inscripcion/update/{id}")
    public ResponseEntity<?> actualizarDocumentoInscripcionEntity(@PathVariable Short id, @RequestBody DocumentoInscripcionUpdateDTO documentoInscripcionUpdateDTO) {
        // Validar la existencia del tipo de estado de documento
        TipoEstadoDocumento tipoEstadoDocumento = tipoEstadoDocumentoRepository.findByTipoEstadoDocumentoId(documentoInscripcionUpdateDTO.getTipoEstadoDocumentoId());

        if (tipoEstadoDocumento == null) {
            return ResponseEntity.badRequest().body("Tipo de estado de documento no encontrado con ID: " + documentoInscripcionUpdateDTO.getTipoEstadoDocumentoId());
        }

        System.out.println("estado documento id: " + tipoEstadoDocumento.getTipoEstadoDocumentoId());
        System.out.println("estado documento descripcion: " + tipoEstadoDocumento.getTipoEstadoDocumento());

        // Buscar el documento por su ID
        DocumentosInscripcion documentosInscripcion = documentosInscripcionRepository.findById(id).orElse(null);
        if (documentosInscripcion == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar el documento con la información proporcionada
        try {
            documentosInscripcion.setDocumentoComentario(documentoInscripcionUpdateDTO.getComentario());
            documentosInscripcion.setTipoEstadoDocumento(tipoEstadoDocumento); // Actualizar el tipo de estado del documento

            documentosInscripcion.setDocuCedula(documentoInscripcionUpdateDTO.getUsuariocedula());
            documentosInscripcion.setDocuNombre(documentoInscripcionUpdateDTO.getUsuarionombre());
            documentosInscripcion.setDocuApellido(documentoInscripcionUpdateDTO.getUsuarioapellido());

            documentosInscripcionRepository.save(documentosInscripcion);
            return ResponseEntity.ok(documentosInscripcion);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la actualización del documento
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el documento de inscripción: " + e.getMessage());
        }
    }

}
