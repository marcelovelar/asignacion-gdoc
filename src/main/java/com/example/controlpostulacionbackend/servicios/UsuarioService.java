package com.example.controlpostulacionbackend.servicios;

import com.example.controlpostulacionbackend.entidades.Usuario;

public interface UsuarioService {
    public Usuario obtenerUsuario(Short idUsuario);

    //Usuario obtenerUsuarioPorNombre(String nombreUsuario);
}
