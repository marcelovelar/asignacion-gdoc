package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Area;
import com.example.controlpostulacionbackend.entidades.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    Area findByAreaId(Integer areaId);
}
