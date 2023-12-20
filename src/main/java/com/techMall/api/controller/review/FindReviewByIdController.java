package com.techMall.api.controller.review;

import com.techMall.api.models.entities.ReviewEntity;
import com.techMall.api.services.review.FindReviewByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/review")
public class FindReviewByIdController {

    @Autowired
    private FindReviewByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReviewEntity> findReviewById(@PathVariable Long id){
        ReviewEntity review = service.findReviewById(id);
        return ResponseEntity.ok().body(review);
    }
}