package com.techMall.api.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Entity
@Data
@Table(name = "tb_reviews")
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String review;
    private Integer note;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}