package com.techMall.api.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tb_addresses")
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetAddress;
    private String neighborhood;
    private String complement;
    private String city;
    private String uf;
    private String cep;
    private Integer number;
}