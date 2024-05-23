package com.example.controlpostulacionbackend.repositorio;

import com.example.controlpostulacionbackend.entidades.Area;
import com.example.controlpostulacionbackend.entidades.SubArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubAreaRepository extends JpaRepository<SubArea, Integer> {
    SubArea findBySubareaId(Integer subareaId);
}
