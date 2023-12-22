package com.techMall.api.controller.review;

import com.techMall.api.models.requests.UpdateReviewRequest;
import com.techMall.api.models.entities.ReviewEntity;
import com.techMall.api.services.review.UpdateReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/update")
public class UpdateReviewController {

    @Autowired
    private UpdateReviewService service;

    @PutMapping(value = "/review/{id}")
    public ResponseEntity<ReviewEntity> update(@RequestBody UpdateReviewRequest data, @PathVariable Long id){
        ReviewEntity review = service.update(data, id);
        return ResponseEntity.ok().body(review);
    }
}