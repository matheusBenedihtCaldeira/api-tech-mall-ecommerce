package com.techMall.api.services.review;

import com.techMall.api.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteReviewService {

    @Autowired
    private ReviewRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}