package com.example.Back.repository;

import com.example.Back.entity.VacationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccationTypeRepo extends JpaRepository<VacationType, Long> {
}
