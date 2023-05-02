package com.example.Back.repository;

import com.example.Back.entity.RequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestDetailsRepo extends JpaRepository<RequestDetails, Long> {

    public List<RequestDetails> findByRequestsUserIdAndStatus(Long User_id, int status);
}
