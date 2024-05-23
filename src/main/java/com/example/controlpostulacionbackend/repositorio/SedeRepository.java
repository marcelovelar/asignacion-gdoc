package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SedeRepository extends JpaRepository<Sede, Integer> {
    Sede findBySedeId(Integer sedeId);
}
