package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    Departamento findByDepartamentoId(Integer departamentoId);
}
