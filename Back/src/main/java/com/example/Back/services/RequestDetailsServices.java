package com.example.Back.services;

import com.example.Back.dto.RequestDetailsDto;
import com.example.Back.entity.RequestDetails;
import com.example.Back.entity.Requests;
import com.example.Back.entity.User;
import com.example.Back.repository.RequestDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDetailsServices {

    @Autowired
    RequestDetailsRepo requestDetailsRepo;
    public RequestDetails save(RequestDetailsDto requestDetailsDto, User user){
        Requests request = new Requests(requestDetailsDto.getRequests().getRequestType(), user);
        RequestDetails requestDetails = new RequestDetails(
                requestDetailsDto.getFromDay(), requestDetailsDto.getToDay(),
                requestDetailsDto.getHalfDayOrFullDay(), requestDetailsDto.getVacationType(),
                request, requestDetailsDto.getDescription(), requestDetailsDto.getStatus());
        return requestDetailsRepo.save(requestDetails);
    }

    public List<RequestDetails> allAccepted(Long user_id)
    {
        return requestDetailsRepo.findByRequestsUserIdAndStatus(user_id, 1);
    }

    public List<RequestDetails> allPending(Long user_id)
    {
        return requestDetailsRepo.findByRequestsUserIdAndStatus(user_id, 0);
    }

    public List<RequestDetails> allRejected(Long user_id)
    {
        return requestDetailsRepo.findByRequestsUserIdAndStatus(user_id, 2);
    }
}
