package com.example.controlpostulacionbackend.servicios;

import com.example.controlpostulacionbackend.entidades.Cargo;

import java.util.Optional;

public interface CargoService {
    Optional<Cargo> obtenerCargoPorId(Short cargoId);
}
