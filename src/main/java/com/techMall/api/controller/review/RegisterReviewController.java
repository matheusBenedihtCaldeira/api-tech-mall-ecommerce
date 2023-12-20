package com.techMall.api.controller.review;

import com.techMall.api.models.dto.ReviewDTO;
import com.techMall.api.models.entities.ReviewEntity;
import com.techMall.api.services.review.RegisterReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/register")
public class RegisterReviewController {

    @Autowired
    private RegisterReviewService service;

    @PostMapping(value = "/review")
    public ResponseEntity<ReviewEntity> register(@RequestBody ReviewDTO data){
        ReviewEntity review = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromUriString("http://localhost:8080/api/v1/review/").path("{id}").buildAndExpand(review.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
