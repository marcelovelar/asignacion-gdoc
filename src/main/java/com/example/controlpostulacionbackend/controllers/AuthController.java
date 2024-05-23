package com.example.controlpostulacionbackend.controllers;

import com.example.controlpostulacionbackend.entidades.JwtResponse;
import com.example.controlpostulacionbackend.entidades.LoginRequest;
import com.example.controlpostulacionbackend.entidades.Usuario;
import com.example.controlpostulacionbackend.repositorio.UsuarioRepository;
import com.example.controlpostulacionbackend.servicios.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://10.13.90.213", "http://10.13.90.213:8080","https://documentos.pol.una.py"})
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private SecretKey secretKey;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("cualquier cosa");
        // Obtener el nombre de usuario y la contraseña del LoginRequest
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        // Buscar el usuario en la base de datos por nombre de usuario
        Usuario usuario = usuarioRepository.findByUsuarioNick(username);

        System.out.println("usuario: " + usuario);

        if (usuario != null) {
            // Comparar la contraseña recibida con la contraseña almacenada
            if (passwordEncoder.matches(password, usuario.getUsuarioContrasenha())) {
                // Contraseña válida, generar token JWT y devolver respuesta exitosa
                String token = generateToken(username);

                // Crear un mapa para almacenar los datos del usuario y el token
                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("token", token);
                responseMap.put("departamentoid", usuario.getDepartamentoCod());
                responseMap.put("usuarionombre", usuario.getPersona().getPersonaNombre());
                responseMap.put("usuarioapellido", usuario.getPersona().getPersonaApellido());
                responseMap.put("usuariocedula", usuario.getPersona().getPersonaNroDocumento());

                // Devolver la respuesta exitosa con el mapa de datos
                return ResponseEntity.ok(responseMap);


                //return ResponseEntity.ok(new JwtResponse(token));
            }
        }

        // Si el usuario no se encuentra o la contraseña es incorrecta, devolver un error de autenticación
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }

   /*private String generateToken(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora de validez
                .signWith(SignatureAlgorithm.HS512, "claveSecreta") // Clave secreta para firmar el token
                .compact();
    }*/

    private String generateToken(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora de validez
                //.signWith(SignatureAlgorithm.HS512, "claveSecreta") // Clave secreta para firmar el token
                .signWith(secretKey)
                .compact();
    }
}
