package com.techMall.api.controller.review;

import com.techMall.api.models.entities.ReviewEntity;
import com.techMall.api.services.review.IndexReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/reviews")
public class IndexReviewController {

    @Autowired
    private IndexReviewService service;

    @GetMapping
    public ResponseEntity<List<ReviewEntity>> index(){
        List<ReviewEntity> reviews = service.index();
        return ResponseEntity.ok().body(reviews);
    }
}