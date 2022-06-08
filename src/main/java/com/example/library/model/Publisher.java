package com.example.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "publishers")
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //Many side of the relationship
    @OneToMany
    @JoinTable(
            name="book_publishers",
            joinColumns = @JoinColumn(name= "publisher_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )
    private Set<Book> bookList;

}
