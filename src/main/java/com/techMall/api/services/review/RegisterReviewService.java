package com.techMall.api.services.review;

import com.techMall.api.models.dto.ReviewDTO;
import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.models.entities.ReviewEntity;
import com.techMall.api.models.entities.UserEntity;
import com.techMall.api.repositories.ReviewRepository;
import com.techMall.api.services.product.FindProductByIdService;
import com.techMall.api.services.user.FindUserByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private FindUserByIdService findUserByIdService;

    @Autowired
    private FindProductByIdService findProductByIdService;

    public ReviewEntity register(ReviewDTO data){
        UserEntity user = findUserByIdService.findUserById(data.userId());
        ProductEntity product = findProductByIdService.findProductById(data.productId());
        ReviewEntity review = convertDTO(data);
        review.setUser(user);
        review.setProduct(product);
        return repository.save(review);
    }

    private ReviewEntity convertDTO(ReviewDTO data){
        ReviewEntity review = new ReviewEntity();
        review.setReview(data.review());
        review.setNote(data.note());
        return review;
    }
}