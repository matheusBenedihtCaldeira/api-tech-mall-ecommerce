package com.techMall.api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techMall.api.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_customers")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;
    private String cellPhone;
    private String password;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private CartEntity cart;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntity> orders = new ArrayList<>();
    private Role role = Role.CUSTOMER;
}