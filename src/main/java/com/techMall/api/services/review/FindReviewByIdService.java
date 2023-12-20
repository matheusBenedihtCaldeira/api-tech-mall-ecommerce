package com.techMall.api.services.review;

import com.techMall.api.models.entities.ReviewEntity;
import com.techMall.api.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindReviewByIdService {

    @Autowired
    private ReviewRepository repository;

    public ReviewEntity findReviewById(Long id){
        return repository.findById(id).get();
    }
}