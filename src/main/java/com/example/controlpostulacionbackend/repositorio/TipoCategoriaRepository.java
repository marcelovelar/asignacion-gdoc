package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.TipoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCategoriaRepository extends JpaRepository<TipoCategoria, Integer> {
    TipoCategoria findBytipoCategoriaId(Integer tipoCategoriaId);
}
