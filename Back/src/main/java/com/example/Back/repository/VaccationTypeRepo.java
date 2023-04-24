package com.example.Back.repository;

import com.example.Back.entity.VaccationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccationTypeRepo extends JpaRepository<VaccationType, Long> {
}
