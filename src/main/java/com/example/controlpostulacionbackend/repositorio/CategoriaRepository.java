package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Area;
import com.example.controlpostulacionbackend.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Categoria findByCategoriaId(Integer categoriaId);
}
