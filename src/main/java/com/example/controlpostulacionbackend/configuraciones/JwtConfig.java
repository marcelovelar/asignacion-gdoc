package com.example.controlpostulacionbackend.configuraciones;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Bean
    public SecretKey secretKey() {
        // Genera una clave segura para HS512
        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }
}