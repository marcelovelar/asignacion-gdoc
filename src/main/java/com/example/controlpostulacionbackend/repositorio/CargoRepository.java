package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, Short> {
    Cargo findByCargoId(Short cargoId);

    @Query("SELECT c FROM Cargo c WHERE c.departamento.departamentoId = :departamentoId")
    List<Cargo> findByDepartamentoId(Integer departamentoId);
}
