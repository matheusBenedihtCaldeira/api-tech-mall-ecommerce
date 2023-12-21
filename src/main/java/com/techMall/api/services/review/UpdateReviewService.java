package com.techMall.api.services.review;

import com.techMall.api.models.dto.UpdateReviewRequest;
import com.techMall.api.models.entities.ReviewEntity;
import com.techMall.api.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private FindReviewByIdService findReviewByIdService;


    public ReviewEntity update(UpdateReviewRequest data, Long id){
        ReviewEntity reviewFromDB = findReviewByIdService.findReviewById(id);
        updateData(reviewFromDB, data);
        return repository.save(reviewFromDB);
    }


    private void updateData(ReviewEntity dataFromDB, UpdateReviewRequest reviewToUpdate){
        dataFromDB.setReview(reviewToUpdate.review());
    }

}