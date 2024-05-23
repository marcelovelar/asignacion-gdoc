package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Short> {
    Optional<Usuario> findById(Long usuarioId);
    Usuario findByUsuarioNick(String usuarioNick);
    //Optional<Usuario> findByNombreUsuario(String nombreUsuario);

}
