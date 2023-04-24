package com.example.Back.repository;

import com.example.Back.entity.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestTypesRepo extends JpaRepository<RequestType, Long> {
}
