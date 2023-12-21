package com.techMall.api.services.review;

import com.techMall.api.models.entities.ReviewEntity;
import com.techMall.api.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexReviewService {

    @Autowired
    private ReviewRepository repository;

    public List<ReviewEntity> index(){

        List<ReviewEntity> reviews = repository.findAll();
        return reviews;
    }
}