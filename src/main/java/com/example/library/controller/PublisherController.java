package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.Publisher;
import com.example.library.service.BookService;
import com.example.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> findAll(){
        return publisherService.findAll();
    }

    @PostMapping
    public Publisher add(@RequestBody Publisher publisher){
        return publisherService.add(publisher);
    }
}
