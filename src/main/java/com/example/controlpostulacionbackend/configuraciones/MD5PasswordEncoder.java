package com.example.controlpostulacionbackend.configuraciones;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        // No necesitas implementar la codificación ya que MD5 no es reversible
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Codifica el texto plano utilizando MD5
        String hashedPassword = md5(rawPassword.toString());

        // Compara la contraseña codificada con la contraseña almacenada
        return hashedPassword.equals(encodedPassword);
    }

    private String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al codificar la contraseña en MD5", e);
        }
    }
}

