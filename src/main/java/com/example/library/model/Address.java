package com.example.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String district;

    private String city;

    @OneToOne(mappedBy = "address")
    private User user;
}
