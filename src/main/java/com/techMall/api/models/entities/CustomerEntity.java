package com.techMall.api.models.entities;

import com.techMall.api.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Role role = Role.CUSTOMER;
}