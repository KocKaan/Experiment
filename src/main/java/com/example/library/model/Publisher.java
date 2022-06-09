package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
