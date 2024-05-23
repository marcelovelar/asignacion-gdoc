package com.example.controlpostulacionbackend.servicios.impl;

import com.example.controlpostulacionbackend.entidades.Usuario;
import com.example.controlpostulacionbackend.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscamos al usuario por su usuarioNick
        Usuario usuario = usuarioRepository.findByUsuarioNick(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        // Creamos un objeto UserDetails a partir del usuario encontrado
        return User.withUsername(usuario.getUsuarioNick())
                .password(usuario.getUsuarioContrasenha())
                .roles("USER")
                .build();
    }
}

