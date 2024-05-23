package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParametroRepository extends JpaRepository<Parametro, Integer> {
    Parametro findByparametroId(Integer parametroId);
}
