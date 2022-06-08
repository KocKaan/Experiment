package com.example.library.controller;

import com.example.library.model.Address;
import com.example.library.model.Book;
import com.example.library.service.AddressService;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PostMapping
    public Book add(@RequestBody Book book){
        return bookService.add(book);
    }
