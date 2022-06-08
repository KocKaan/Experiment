package com.example.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    /*
    @OneToOne
    private Address address;

    @ManyToMany
    private List<Book> bookList;
*/

}