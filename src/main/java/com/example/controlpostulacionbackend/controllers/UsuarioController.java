package com.example.controlpostulacionbackend.controllers;

import com.example.controlpostulacionbackend.entidades.Usuario;
import com.example.controlpostulacionbackend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = {"http://localhost:4200", "http://10.13.90.213", "http://10.13.90.213:8080","https://documentos.pol.una.py"})
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{usuarioId}")
    public Usuario obtenerUsuario(@PathVariable("usuarioId") Short usuarioId){
        return usuarioService.obtenerUsuario(usuarioId);
    }

    /*@GetMapping("/buscarPorNombre/{nombreUsuario}")
    public Usuario obtenerUsuarioPorNombre(@PathVariable("nombreUsuario") String nombreUsuario) {
        return usuarioService.obtenerUsuarioPorNombre(nombreUsuario);
    }*/

}
