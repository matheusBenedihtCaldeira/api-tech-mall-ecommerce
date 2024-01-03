package com.techMall.api.models.entities;

import com.techMall.api.models.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_orders")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "shipping_address_id")
    private AddressEntity shippingAddress;
    private Double totalPrice;
    private Integer installment;
    private OrderStatus orderStatus = OrderStatus.PENDING;
    @CreationTimestamp
    private LocalDateTime orderDate;
}