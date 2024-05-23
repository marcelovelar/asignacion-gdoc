package com.example.controlpostulacionbackend.servicios.impl;

import com.example.controlpostulacionbackend.entidades.Usuario;
import com.example.controlpostulacionbackend.repositorio.UsuarioRepository;
import com.example.controlpostulacionbackend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario obtenerUsuario(Short usuarioId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        // Manejar el Optional
        if(usuarioOptional.isPresent()) {
            return usuarioOptional.get(); // Devolver el usuario si está presente
        } else {
            // Manejar el caso en que el usuario no existe
            throw new RuntimeException("Usuario no encontrado con el ID: " + usuarioId);
        }
    }

    /*@Override
    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if(usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new RuntimeException("Usuario no encontrado con el nombre: " + nombreUsuario);
        }
    }*/

}
