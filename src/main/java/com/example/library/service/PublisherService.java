package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Publisher;
import com.example.library.repository.BookRepository;
import com.example.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAll(){
        return publisherRepository.findAll();
    }

    public Publisher add(Publisher publisher){
        return publisherRepository.saveAndFlush(publisher);
    }
}
