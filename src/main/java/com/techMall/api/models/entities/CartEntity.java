package com.techMall.api.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_carts")
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItems = new ArrayList<>();
    private Double totalPrice;

    public void calculateTotalPrice(){
        double total = 0.0;

        for(CartItemEntity cartItem : cartItems){
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        this.totalPrice = total;
    }
}